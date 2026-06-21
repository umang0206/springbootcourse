package com.springbootwebserver.restapi.service;

import com.springbootwebserver.restapi.dto.EmployeeDTO;
import com.springbootwebserver.restapi.entity.EmployeeEntity;
import com.springbootwebserver.restapi.exceptions.ResourceNotFoundException;
import com.springbootwebserver.restapi.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO>findById(Long employeeId) {
//        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElse(null);
//        return modelMapper.map(employeeEntity, EmployeeDTO.class);

        return employeeRepository.findById(employeeId)
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO save(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);

    }

    public EmployeeDTO updateEmployeeByID(Long employeeId, EmployeeDTO employeeDTO) {
        isEmployeeExist(employeeId);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
//        employeeEntity.setIsActive(employeeDTO.getActive());
        EmployeeEntity saveEmployeeEntity =  employeeRepository.save(employeeEntity);
        return modelMapper.map(saveEmployeeEntity, EmployeeDTO.class);
    }


    public void isEmployeeExist(Long employeeId) {
        boolean exist = employeeRepository.existsById(employeeId);
        if(!exist) throw new ResourceNotFoundException("Employee id " + employeeId + " not found");
    }
    public Boolean deleteEmployeeById(Long employeeId) {

             isEmployeeExist(employeeId);
             employeeRepository.deleteById(employeeId);
             return true;
    }

    public EmployeeDTO updatePartialEmployeeByID(Long employeeId, Map<String, Object> updates) {
        isEmployeeExist(employeeId);
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field, value) ->{
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated,employeeEntity,value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
