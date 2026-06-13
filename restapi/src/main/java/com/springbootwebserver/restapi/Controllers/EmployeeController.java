package com.springbootwebserver.restapi.Controllers;

import com.springbootwebserver.restapi.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @GetMapping(path = "/getMySecretData")
//    public String getMySecretMessage(){
//        return "secret data is: 427569$^&^%$#$";
//    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"Umang Kumar", "umang@gmail.com", 25, LocalDate.of(2024,03, 20),true);
    }

    @GetMapping
    public String getAllEmployee(@RequestParam Integer age, @RequestParam(required = false) String sortBy){  //in requestParam if mark required as false it so if user willl not pass that field in request still it will work
        return "Hi My age is " + age + " sort by " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(101L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployee(){
        return "Hello from Put";
    }
}
