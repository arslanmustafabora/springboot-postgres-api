package com.example.backendapi.controller;

import com.example.backendapi.exception.ResourceNotFoundException;
import com.example.backendapi.model.User;
import com.example.backendapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("users")
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Validated @RequestBody User userDetails) throws ResourceNotFoundException {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id ::" + userId));

        if (userDetails.getFirstName() != null)
            user.setFirstName(userDetails.getFirstName());

        if (userDetails.getLastName() != null)
            user.setLastName(userDetails.getLastName());

        if (userDetails.getEmail() != null)
            user.setEmail(userDetails.getEmail());

        return ResponseEntity.ok(this.userRepository.save(user));
    }

    @DeleteMapping("users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id ::" + userId));

        this.userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }


}
