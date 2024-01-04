package com.pcrs.pcrs.profile.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pcrs.pcrs.profile.models.UserModel;
import com.pcrs.pcrs.profile.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers(HttpServletRequest request) {
        try {
            return ResponseEntity.ok(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<?> findUser(@PathVariable String username, HttpServletRequest request) {

        try {
            return ResponseEntity.ok(userService.getUserByName(username));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

    }

}
