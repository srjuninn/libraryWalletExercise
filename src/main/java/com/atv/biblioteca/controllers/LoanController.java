package com.atv.biblioteca.controllers;

import com.atv.biblioteca.requests.LoanRequestDTO;
import com.atv.biblioteca.responses.LoanResponseDTO;
import com.atv.biblioteca.services.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loan")
public class LoanController {

    private final LoanService loanService;

    LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @PostMapping("create/{userId}")
    public ResponseEntity<LoanResponseDTO> createLoan(@PathVariable Long userId, @Valid @RequestBody LoanRequestDTO loanReq){
        LoanResponseDTO loanRes = loanService.createLoan(userId);
        return ResponseEntity.ok(loanRes);
    }

    @GetMapping("list/{userId}")
    public ResponseEntity<List<LoanResponseDTO>> listLoansByUser(@PathVariable Long userId){
        List<LoanResponseDTO> loanRes = loanService.listLoanByUser(userId);
        return ResponseEntity.ok(loanRes);
    }

    @PutMapping("return/{userId}/{loanId}")
    public ResponseEntity<LoanResponseDTO> returnLoan(@PathVariable Long userId, @PathVariable Long loanId){
        LoanResponseDTO loanRes = loanService.returnLoan(userId, loanId);
        return ResponseEntity.ok(loanRes);
    }
}
