package com.example.test.controllers.api;

import com.example.test.models.MyResponse;
import com.example.test.models.User;
import com.example.test.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
    @Autowired
    private UserRepository repository;

    @GetMapping("")
    public List<User> getAll() {
        return repository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<MyResponse> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(
                new MyResponse(true, "Create user successfully", repository.save(user))
        );
    }

    @PostMapping("/login")
    public ResponseEntity<MyResponse> auth(@RequestBody User user) {
        user.setFullname("");
        Optional<User> userFound = repository.findById(user.getUsername());
        if (userFound.isPresent() && userFound.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(true, "Login successfully", "")
            );
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(false, "Login failed", "")
            );
        }


//        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
//                new MyResponse(true, "Login successfully", repository.findby(user))
//        );
    }
}
