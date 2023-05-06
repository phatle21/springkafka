package com.example.test.repositories;

import com.example.test.models.Register;
import com.example.test.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByName(String name);
    List<Task> findAllByIdSchedule(int id_schedule);

    @Query(value = "SELECT t.id, t.id_schedule, t.name, t.description, t.date_created, s.name, s.owner from task t join schedule s on s.id = t.id_schedule and s.owner = :username", nativeQuery = true)
    List<Object[]> getAllTaskSchedule(String username);

    @Query(value = "SELECT t.id, t.id_schedule, t.name, t.description, t.date_created, s.name, s.owner from task t, schedule s, register r where s.id = r.id_schedule and s.id = t.id_schedule and r.user = :username", nativeQuery = true)
    List<Object[]> getAllTaskScheduleRegistered(String username);
}
