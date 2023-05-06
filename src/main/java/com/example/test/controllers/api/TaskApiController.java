package com.example.test.controllers.api;

import com.example.test.kafka.KafkaProducer;
import com.example.test.models.MyResponse;
import com.example.test.models.Schedule;
import com.example.test.models.Task;
import com.example.test.models.TaskSchedule;
import com.example.test.repositories.TaskRepository;
import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.standard.processor.StandardAssertTagProcessor;

import java.util.*;

@RestController
@RequestMapping("/api/task")
public class TaskApiController {
    @Autowired
    private TaskRepository repository;
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("")
    public List<Task> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public List<TaskSchedule> findOne(@PathVariable String username) {
        List<Object[]> query = repository.getAllTaskSchedule(username);
        List<TaskSchedule> res = new ArrayList<>();
        for (Object[] row : query) {
            TaskSchedule obj = new TaskSchedule((Integer) row[0],
                    (Integer) row[1],
                    row[2].toString(),
                    row[3].toString(),
                    (Date) row[4],
                    row[5].toString(),
                    row[6].toString());
            res.add(obj);
        }
        query = repository.getAllTaskScheduleRegistered(username);
        for (Object[] row : query) {
            TaskSchedule obj = new TaskSchedule((Integer) row[0],
                    (Integer) row[1],
                    row[2].toString(),
                    row[3].toString(),
                    (Date) row[4],
                    row[5].toString(),
                    row[6].toString());
            res.add(obj);
        }
        return res;
    }

    @PostMapping("")
    public ResponseEntity<MyResponse> create(@RequestBody Task task) {
        task.setDateCreated(new Date());
        kafkaProducer.sendMessage(String.valueOf(task.getIdSchedule()));
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(
                new MyResponse(true, "Create task successfully", repository.save(task))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyResponse> update(@PathVariable int id, @RequestBody Task task) {
        Optional<Task> taskFound = repository.findById(id);
        if (taskFound.isPresent()) {
            taskFound.get().setName(task.getName());
            taskFound.get().setDescription(task.getDescription());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(true, "Update task successfully", repository.save(taskFound.get()))
            );
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(false, "Task not found", "")
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyResponse> delete(@PathVariable int id) {
        Optional<Task> taskFound = repository.findById(id);
        if (taskFound.isPresent()) {
            repository.delete(taskFound.get());
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
