package com.springbootwebserver.restapi.advices;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;

    public HttpStatusCode getStatus() {
        return status;
    }
}
