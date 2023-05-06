package com.example.test.controllers.api;

import com.example.test.models.MyResponse;
import com.example.test.models.Register;
import com.example.test.models.Schedule;
import com.example.test.repositories.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/register")
public class RegisterApiController {
    @Autowired
    private RegisterRepository repository;

    @GetMapping("")
    public List<Register> getAll() {
        return repository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<MyResponse> create(@RequestBody Register register) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(
                new MyResponse(true, "Create register successfully", repository.save(register))
        );
    }

    @PutMapping("/notification")
    public ResponseEntity<MyResponse> update(@RequestBody Register register) {
        Optional<Register> registerFound = repository.findByScheduleAndUser(register.getId_schedule(), register.getUser());
        if (registerFound.isPresent()) {
            registerFound.get().setNotification(register.isNotification());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(true, "Update register successfully", repository.save(registerFound.get()))
            );
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(false, "Register not found", "")
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyResponse> delete(@PathVariable int id, @RequestBody Register register) {
        Optional<Register> registerFound = repository.findByScheduleAndUser(id, register.getUser());
        if (registerFound.isPresent()) {
            repository.delete(registerFound.get());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(true, "Delete register successfully", "")
            );
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(false, "Register not found", "")
            );
        }
    }
}
