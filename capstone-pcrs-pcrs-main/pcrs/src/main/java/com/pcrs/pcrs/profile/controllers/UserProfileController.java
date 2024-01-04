package com.pcrs.pcrs.profile.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.pcrs.pcrs.profile.dto.UserProfileDto;
import com.pcrs.pcrs.profile.models.UserProfileModel;
import com.pcrs.pcrs.profile.services.UserProfileService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users/profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProfile(@RequestBody UserProfileModel profile) {
        UserProfileDto newUser = userProfileService.createProfile(profile);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProfiles(HttpServletRequest request) {
        try {
            List<UserProfileDto> allUsers = userProfileService.getAllProfiles();
            return ResponseEntity.ok(allUsers);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search/{username}")
    public ResponseEntity<?> findUser(@PathVariable String username, HttpServletRequest request) {
        try {
            UserProfileDto user = userProfileService.getProfileByUsername(username);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

}
