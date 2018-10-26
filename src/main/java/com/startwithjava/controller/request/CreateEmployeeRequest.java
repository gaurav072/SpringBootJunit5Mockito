package com.startwithjava.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class CreateEmployeeRequest {
    @NotNull
    private String name;
    @NotNull
    private String email;

    @NotNull
    private LocalDate joiningDate;
}
