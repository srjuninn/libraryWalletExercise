package com.atv.biblioteca.responses;

import com.atv.biblioteca.entities.LibraryWalletEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class LibraryWalletResponseDTO {
    private long libraryWalletNumber;
    private LocalDateTime emissionDate;
    private boolean isValid;

    public LibraryWalletResponseDTO(LibraryWalletEntity newLibraryWallet) {
        this.libraryWalletNumber = newLibraryWallet.getLibraryWalletNumber();
        this.emissionDate = newLibraryWallet.getEmissionDate();
        this.isValid = newLibraryWallet.isValid();
    }
}
