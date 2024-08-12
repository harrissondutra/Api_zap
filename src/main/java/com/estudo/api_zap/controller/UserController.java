package com.estudo.api_zap.controller;

import com.estudo.api_zap.DTO.UserDto;
import com.estudo.api_zap.model.User;
import com.estudo.api_zap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id){
        User user = service.findById(id);
        return ResponseEntity.ok(user.toDto(user));
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
        User user = service.findByEmail(email);
        return ResponseEntity.ok(user.toDto(user));
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable String name){
        User user = service.findByName(name);
        return ResponseEntity.ok(user.toDto(user));
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User user){
        User userToUpdate = service.findById(id);
        if(userToUpdate != null){
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            return ResponseEntity.ok(service.save(userToUpdate));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable UUID id){
        User user = service.findById(id);
        if(user != null){
            service.delete(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


}
