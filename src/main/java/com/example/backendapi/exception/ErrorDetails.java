package com.example.backendapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    @Getter
    @Setter
    private Date timestamp;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter

    private String details;
}
