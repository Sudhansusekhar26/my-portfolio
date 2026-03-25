package com.portfolio.controller;

import com.portfolio.model.ContactMessage;
import com.portfolio.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // Allows your frontend to connect easily
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @PostMapping("/submit")
    public ResponseEntity<?> submitMessage(@RequestBody ContactMessage message) {
        try {
            ContactMessage savedMessage = repository.save(message);
            return ResponseEntity.ok(savedMessage);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
