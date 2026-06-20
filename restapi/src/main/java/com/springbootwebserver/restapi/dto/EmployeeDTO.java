package com.springbootwebserver.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootwebserver.restapi.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private Long id;

//    @NotNull(message = "Field should not be null")
//    @NotEmpty(message = "Name of the employee can not be empty") // if user pass name as "", meas is not null, but it is empty so it should not take the value
    @NotBlank(message = "Name can not be blank") // if user pass "    " value so it is empty if we trim the space, so it name should not be blank.
    @Size(min = 3, max = 10, message = "name character should be in range: [3, 10] ")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Max(value = 80, message = "age can not be greater than 80")
    @Min(value = 18, message = "age can not be less than 18")
    private Integer age;

    @NotBlank
//    @Pattern(regexp = "^(ADMIN|USER|)$", message = "Role of the employee can be user or admin")
    @EmployeeRoleValidation
    private String role;

    @PastOrPresent(message = "Joining date can not be future date")
    private LocalDate dateOfJoining;

    @Digits(integer = 6, fraction = 2, message = "Salary should be in XXXXXX.YY format")
    private double salary;

    @JsonProperty("isActive")
    private Boolean isActive;
}
