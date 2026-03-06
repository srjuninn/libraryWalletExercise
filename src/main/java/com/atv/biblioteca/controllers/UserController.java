package com.atv.biblioteca.controllers;

import com.atv.biblioteca.requests.UserRequestDTO;
import com.atv.biblioteca.responses.UserResponseDTO;
import com.atv.biblioteca.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @PostMapping("create")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userReq){
        UserResponseDTO userRes = userService.createUser(userReq);
        return ResponseEntity.ok(userRes);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<UserResponseDTO> showUser(@PathVariable Long id){
        UserResponseDTO userRes = userService.findUserById(id);
        return ResponseEntity.ok(userRes);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userReq){
        UserResponseDTO userRes = userService.updateUser(id,userReq);
        return ResponseEntity.ok(userRes);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteuser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("usuário deletado com sucesso");
    }
}
