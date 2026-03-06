package com.atv.biblioteca.services;

import com.atv.biblioteca.entities.LoanEntity;
import com.atv.biblioteca.entities.UserEntity;
import com.atv.biblioteca.repositories.LoanRepository;
import com.atv.biblioteca.repositories.UserRepository;
import com.atv.biblioteca.responses.LoanResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    public LoanService(UserRepository userRepository, LoanRepository loanRepository){
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    public LoanResponseDTO createLoan(Long userId){
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("usuário não encontrado"));

        LoanEntity loan = new LoanEntity();
        loan.setLoanDate(LocalDate.now());
        loan.setReturnDate(null);
        loan.setUser(user);

        LoanEntity newLoan = loanRepository.save(loan);
        return new LoanResponseDTO(newLoan);
    }

    public List<LoanResponseDTO> listLoanByUser(Long userId){
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("o usuário não foi encontrado"));

        return user.getLoans().stream().map(LoanResponseDTO::new).toList();
    }

    public LoanResponseDTO returnLoan(Long userId, Long loanId){
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("usuário não encontrado"));
        LoanEntity loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("o emprestimo não existe"));

        if(!loan.getUser().equals(user)){
            throw new IllegalStateException("esse emprestimo não pertence a esse usuário");
        }

        loan.setReturnDate(LocalDate.now());
        LoanEntity updateLoan = loanRepository.save(loan);

        return new LoanResponseDTO(updateLoan);

    }

}
