package com.example.test.repositories;

import com.example.test.models.Register;
import com.example.test.models.TaskComplete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskCompleteRepository extends JpaRepository<TaskComplete, Integer> {
    @Query(value = "( SELECT t1.*, tc.complete FROM ( SELECT t.id AS tid, s.id AS sid, t.name AS tname, t.description, t.date_created, s.name, s.owner FROM task t, SCHEDULE s WHERE t.id_schedule = s.id ) AS t1 LEFT JOIN register r ON t1.sid = r.id_schedule LEFT JOIN task_complete tc ON t1.tid = tc.id_task AND tc.user = :user WHERE ( r.user = :user OR t1.owner = :user ) UNION SELECT t1.*, tc.complete FROM ( SELECT t.id AS tid, s.id AS sid, t.name AS tname, t.description, t.date_created, s.name, s.owner FROM task t, SCHEDULE s WHERE t.id_schedule = s.id ) AS t1 LEFT JOIN register r ON t1.sid = r.id_schedule RIGHT JOIN task_complete tc ON t1.tid = tc.id_task AND tc.user = :user WHERE ( r.user = :user OR t1.owner = :user ) ) ORDER BY complete, tid",nativeQuery = true)
    List<Object[]> getAllTask(String user);

    @Query(value = "select * from task_complete where user = :username and id_task = :id_task", nativeQuery = true)
    Optional<TaskComplete> findByUserAndTask(int id_task, String username);
}
