package com.atv.biblioteca.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class LibraryWalletResponseDTO {
    private long libraryWalletNumber;
    private LocalDateTime emissionDate;
    private boolean isValid;

    public LibraryWalletResponseDTO(long libraryWalletNumber, long libraryWalletNumber1) {
        this.libraryWalletNumber = libraryWalletNumber;

    }
}
