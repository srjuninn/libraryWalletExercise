package com.atv.biblioteca.services;

import com.atv.biblioteca.entities.UserEntity;
import com.atv.biblioteca.repositories.UserRepository;
import com.atv.biblioteca.requests.UserRequestDTO;
import com.atv.biblioteca.responses.UserResponseDTO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public UserResponseDTO createUser(UserRequestDTO userReq){
        if(userReq == null){
            throw new IllegalArgumentException("os dados inbseridos estão inválidos");
        }
        if(userRepository.findByEmail(userReq.getEmail()).isPresent()){
            throw new DuplicateKeyException("já existe um usuário cadastrado");
        }

        UserEntity newUser = new UserEntity(userReq.getName(), userReq.getEmail(), userReq.getPassword());
        userRepository.save(newUser);
        return new UserResponseDTO(newUser.getId(), newUser.getName(), newUser.getEmail());
    }

    public UserResponseDTO findUserById(Long id){
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("esse usuário não existe"));
        return new UserResponseDTO(user.getId(),user.getName(), user.getEmail());
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userReq){
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("esse usuário não existe"));
        user.setName(userReq.getName());
        user.setEmail(userReq.getEmail());
        user.setPassword(userReq.getPassword());

        UserEntity updatedUser = userRepository.save(user);
        return new UserResponseDTO(updatedUser.getId(),updatedUser.getName(), updatedUser.getEmail());
    }

    public void deleteUserById(Long id){
        if(!userRepository.findById(id).isPresent()){
            throw new IllegalArgumentException("esse usuário não existe");
        }
        userRepository.deleteById(id);
    }
}
