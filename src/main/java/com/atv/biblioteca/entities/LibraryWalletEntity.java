package com.atv.biblioteca.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="library_wallet")
public class LibraryWalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long libraryWalletNumber;
    private LocalDateTime emissionDate;
    private boolean isValid = false;

    @OneToOne(mappedBy = "libraryWallet")
    private UserEntity user;

}
