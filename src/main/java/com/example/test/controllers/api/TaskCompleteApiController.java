package com.example.test.controllers.api;

import com.example.test.models.MyResponse;
import com.example.test.models.Register;
import com.example.test.models.Schedule;
import com.example.test.models.TaskComplete;
import com.example.test.models.api.Task;
import com.example.test.repositories.RegisterRepository;
import com.example.test.repositories.TaskCompleteRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/taskcomplete")
public class TaskCompleteApiController {
    @Autowired
    private TaskCompleteRepository repository;

    @GetMapping("/complete/{user}")
    public List<Task> getAll(@PathVariable String user) throws JSONException {
        List<Object[]> query = repository.getAllTask(user);
        List<Task> res = new ArrayList<>();
        for (Object[] row : query) {
            System.out.println(Arrays.toString(row));
            Byte valRow7 = 0;
            if (row[7] == null) valRow7 = 0;
            else valRow7 = ((Byte) row[7]).byteValue();
            boolean complete = false;
            if (valRow7 == 1) complete = true;
            Task task = new Task((Integer) row[0],
                    (Integer) row[1],
                    row[2].toString(),
                    row[3].toString(),
                    (Date) row[4],
                    row[5].toString(),
                    row[6].toString(),
                    complete);
            res.add(task);
        }
        return res;
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyResponse> upsert(@PathVariable String id, @RequestBody TaskComplete tc) {
        Optional<TaskComplete> found = repository.findByUserAndTask(Integer.parseInt(id), tc.getUser());
        if (found.isPresent()) {
            found.get().setComplete(tc.isComplete());
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(true, "Update task successfully", repository.save(found.get()))
            );
        } else {
            tc.setId_task(Integer.parseInt(id));
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(
                    new MyResponse(true, "Create status successfully", repository.save(tc))
            );
        }
    }
}
