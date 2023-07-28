package com.example.imageuploading.controller;

import com.example.imageuploading.dto.UserDto;
import com.example.imageuploading.entity.User;
import com.example.imageuploading.repo.UserRepo;
import com.example.imageuploading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userrepo;

    @PostMapping("/addUser")
    public ResponseEntity<String> newUserWithImage(@RequestParam("image") MultipartFile file,@RequestParam("name") String name,@RequestParam("email") String email) throws IOException {
        return ResponseEntity.ok(userService.addNewUser(file,name,email));
    }

    @GetMapping("/usersList")
    public List<User> getAll(){
        return userrepo.findAll();
    }

}
