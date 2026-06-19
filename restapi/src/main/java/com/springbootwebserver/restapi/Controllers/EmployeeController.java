package com.springbootwebserver.restapi.Controllers;

import com.springbootwebserver.restapi.dto.EmployeeDTO;
import com.springbootwebserver.restapi.entity.EmployeeEntity;
import com.springbootwebserver.restapi.repository.EmployeeRepository;
import com.springbootwebserver.restapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @GetMapping(path = "/getMySecretData")
//    public String getMySecretMessage(){
//        return "secret data is: 427569$^&^%$#$";
//    }
    final EmployeeService employeeService;
    public EmployeeController (EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
//        return new EmployeeDTO(employeeId,"Umang Kumar", "umang@gmail.com", 25, LocalDate.of(2024,03, 20),true);
        Optional<EmployeeDTO> employeeDTO = employeeService.findById(employeeId);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                 .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){  //in requestParam if mark required as false it so if user willl not pass that field in request still it will work
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(101L);
        EmployeeDTO savedEmployee  =  employeeService.save(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeByID(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeByID(employeeId, employeeDTO));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
       boolean isDeleted =  employeeService.deleteEmployeeById(employeeId);
       if( isDeleted) return ResponseEntity.ok(true);
       return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity <EmployeeDTO> updatePartialEmployeeByID(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeByID(employeeId, updates);
        if(employeeDTO == null)  return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
