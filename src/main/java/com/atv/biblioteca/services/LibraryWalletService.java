package com.atv.biblioteca.services;

import com.atv.biblioteca.entities.LibraryWalletEntity;
import com.atv.biblioteca.repositories.LibraryWalletRepository;
import com.atv.biblioteca.requests.LibraryWalletRequestDTO;
import com.atv.biblioteca.responses.LibraryWalletResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LibraryWalletService {
    private final LibraryWalletRepository libraryWalletRepository;

    public LibraryWalletService(LibraryWalletRepository libraryWalletRepository){
        this.libraryWalletRepository = libraryWalletRepository;
    }

    public ResponseEntity<LibraryWalletResponseDTO> createLibraryWallet(LibraryWalletRequestDTO lwreqdto){
        if(lwreqdto == null){
            throw new IllegalArgumentException("os dados estão inválidos");
        }
        LibraryWalletEntity libraryWallet = new LibraryWalletEntity(lwreqdto.getLibraryWalletNumber(), LocalDateTime.now());
        LibraryWalletEntity newLibraryWallet = libraryWalletRepository.save(libraryWallet);
        return new LibraryWalletResponseDTO();
    }
}
