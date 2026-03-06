package com.atv.biblioteca.services;

import com.atv.biblioteca.entities.LibraryWalletEntity;
import com.atv.biblioteca.entities.UserEntity;
import com.atv.biblioteca.repositories.LibraryWalletRepository;
import com.atv.biblioteca.repositories.UserRepository;
import com.atv.biblioteca.requests.LibraryWalletRequestDTO;
import com.atv.biblioteca.responses.LibraryWalletResponseDTO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LibraryWalletService {
    private final LibraryWalletRepository libraryWalletRepository;
    private final UserRepository userRepository;

    public LibraryWalletService(LibraryWalletRepository libraryWalletRepository, UserRepository userRepository){
        this.libraryWalletRepository = libraryWalletRepository;
        this.userRepository = userRepository;
    }

    public LibraryWalletResponseDTO createLibraryWallet(Long userId){
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("usuário não encontrado"));
        if(user.getLibraryWallet() != null){
            throw new IllegalStateException("esse usuário já possui uma carteirinha");
        }
        LibraryWalletEntity libraryWallet = new LibraryWalletEntity();
        libraryWallet.setEmissionDate(LocalDateTime.now());
        libraryWallet.setValid(true);
        user.setLibraryWallet(libraryWallet);
        libraryWallet.setUser(user);
        LibraryWalletEntity newLibraryWallet = libraryWalletRepository.save(libraryWallet);
        return new LibraryWalletResponseDTO(newLibraryWallet);
    }
}
