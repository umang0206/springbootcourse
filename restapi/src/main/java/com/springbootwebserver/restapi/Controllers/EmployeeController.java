package com.springbootwebserver.restapi.Controllers;

import com.springbootwebserver.restapi.dto.EmployeeDTO;
import com.springbootwebserver.restapi.entity.EmployeeEntity;
import com.springbootwebserver.restapi.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @GetMapping(path = "/getMySecretData")
//    public String getMySecretMessage(){
//        return "secret data is: 427569$^&^%$#$";
//    }
    final EmployeeRepository employeeRepository;

    public EmployeeController (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
//        return new EmployeeDTO(employeeId,"Umang Kumar", "umang@gmail.com", 25, LocalDate.of(2024,03, 20),true);
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){  //in requestParam if mark required as false it so if user willl not pass that field in request still it will work
//        return "Hi My age is " + age + " sort by " + sortBy;

        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmployee){
//        inputEmployee.setId(101L);
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    public String updateEmployee(){
        return "Hello from Put";
    }
}
