package com.atv.biblioteca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="library_wallet")
public class LibraryWalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long libraryWalletNumber;
    private LocalDateTime emissionDate;
    private boolean isValid;

    public LibraryWalletEntity(Long libraryWalletNumber, LocalDateTime emissionDate) {
        this.libraryWalletNumber = libraryWalletNumber;
        this.emissionDate = emissionDate;
    }
}
