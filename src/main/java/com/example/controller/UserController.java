package com.example.controller;

import com.example.dto.CreateUserRequest;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("")
    public ResponseEntity<?> saveUser(@RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok().body(userService.saveUser(createUserRequest));
    }



    @GetMapping
    public ResponseEntity<?> searchUser(@RequestParam String name, @RequestParam Integer minAge) {
        return ResponseEntity.ok().body(userService.findUserByNameAndMinAge(name, minAge));
    }

    @GetMapping("/adults")
    public ResponseEntity<?> getAdults() {
        return ResponseEntity.ok().body(userService.findAdults());
    }

    @GetMapping("/name")
    public ResponseEntity<?> getByName(@RequestParam String name) {
        return ResponseEntity.ok().body(userService.findByName(name));
    }


}
