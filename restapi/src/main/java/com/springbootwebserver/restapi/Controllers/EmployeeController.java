package com.springbootwebserver.restapi.Controllers;

import com.springbootwebserver.restapi.dto.EmployeeDTO;
import com.springbootwebserver.restapi.entity.EmployeeEntity;
import com.springbootwebserver.restapi.repository.EmployeeRepository;
import com.springbootwebserver.restapi.service.EmployeeService;
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
    final EmployeeService employeeService;
    public EmployeeController (EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
//        return new EmployeeDTO(employeeId,"Umang Kumar", "umang@gmail.com", 25, LocalDate.of(2024,03, 20),true);
        return employeeService.findById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){  //in requestParam if mark required as false it so if user willl not pass that field in request still it will work
        return employeeService.getAllEmployee();
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(101L);
        return employeeService.save(inputEmployee);
    }

    @PutMapping
    public String updateEmployee(){
        return "Hello from Put";
    }
}
