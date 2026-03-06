package com.atv.biblioteca.responses;

import com.atv.biblioteca.entities.LoanEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class LoanResponseDTO {
    private long id;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanResponseDTO(LoanEntity newLoan) {
        this.id = newLoan.getId();
        this.loanDate = newLoan.getLoanDate();
        this.returnDate = newLoan.getReturnDate();
    }
}
