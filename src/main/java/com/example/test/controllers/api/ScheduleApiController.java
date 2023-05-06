package com.example.test.controllers.api;

import com.example.test.models.MyResponse;
import com.example.test.models.Schedule;
import com.example.test.models.ScheduleRegister;
import com.example.test.models.User;
import com.example.test.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleApiController {
    @Autowired
    private ScheduleRepository repository;

    @GetMapping("")
    public List<Schedule> getAll() {
        return repository.findAll();
    }

    @GetMapping("/registered/{username}")
    public List<Schedule> findRegisteredByOwner(@PathVariable String username) {
        List<Object[]> query = repository.getAllByRegisteredUserId(username);
        List<Schedule> res = new ArrayList<>();
        for (Object[] row : query) {
            Schedule obj = new Schedule(row[1].toString(), row[2].toString());
            obj.setId((Integer) row[0]);
            res.add(obj);
        }
        return res;
    }

    @GetMapping("/{user}")
    public List<Schedule> findByOwner(@PathVariable String user) {
        return repository.findAllByOwner(user);
    }

    @GetMapping("/register/{user}")
    public List<ScheduleRegister> findScheduleRegister(@PathVariable String user) {
        List<Object[]> query = repository.getAllScheduleRegister(user);
        List<ScheduleRegister> res = new ArrayList<>();
        for (Object[] row : query) {
            if (row[3] == null) row[3] = -1;
            if (row[4] == null) row[4] = false;
            ScheduleRegister obj = new ScheduleRegister((Integer) row[0],
                    row[1].toString(),
                    row[2].toString(),
                    (Integer) row[3],
                    (Boolean) row[4]);
            res.add(obj);
        }
        return res;
    }

    @PostMapping("")
    public ResponseEntity<MyResponse> create(@RequestBody Schedule schedule) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(
                new MyResponse(true, "Create schedule successfully", repository.save(schedule))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyResponse> update(@PathVariable int id, @RequestBody Schedule schedule) {
        Optional<Schedule> scheduleFound = repository.findById(id);
        if (scheduleFound.isPresent()) {
            scheduleFound.get().setName(schedule.getName());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(true, "Update schedule successfully", repository.save(scheduleFound.get()))
            );
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(false, "Schedule not found", "")
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyResponse> delete(@PathVariable int id) {
        Optional<Schedule> scheduleFound = repository.findById(id);
        if (scheduleFound.isPresent()) {
            repository.delete(scheduleFound.get());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(true, "Delete schedule successfully", "")
            );
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(false, "Schedule not found", "")
            );
        }
    }
}
