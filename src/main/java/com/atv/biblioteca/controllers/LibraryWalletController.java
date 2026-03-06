package com.atv.biblioteca.controllers;

import com.atv.biblioteca.responses.LibraryWalletResponseDTO;
import com.atv.biblioteca.services.LibraryWalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wallet")
public class LibraryWalletController {
    private final LibraryWalletService libraryWalletService;

    public LibraryWalletController(LibraryWalletService libraryWalletService){
        this.libraryWalletService = libraryWalletService;
    }

    @PostMapping("create/{userId}")
    public ResponseEntity<LibraryWalletResponseDTO> createWallet(@PathVariable Long userId){
        LibraryWalletResponseDTO libraryRes = libraryWalletService.createLibraryWallet(userId);
        return ResponseEntity.ok(libraryRes);
    }
}
