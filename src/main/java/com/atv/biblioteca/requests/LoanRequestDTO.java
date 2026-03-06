package com.atv.biblioteca.requests;

import jakarta.validation.constraints.Future;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class LoanRequestDTO {
    @Future
    private LocalDate returnDate;

}
