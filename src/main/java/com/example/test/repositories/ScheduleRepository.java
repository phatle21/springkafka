package com.example.test.repositories;

import com.example.test.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByOwner(String username);

    @Query(value = "SELECT s.*, u.* from schedule s join user u on s.owner = u.username", nativeQuery = true)
    List<Object[]> getAllByUserId();

    @Query(value = "SELECT s.*, r.* from register r join schedule s on s.id = r.id_schedule and r.user = :username order by s.id", nativeQuery = true)
    List<Object[]> getAllByRegisteredUserId(String username);

    @Query(value = "select s.id, s.name, s.owner, r.id, r.notification from schedule s left join register r on s.id = r.id_schedule and r.user = :username order by s.id", nativeQuery = true)
    List<Object[]> getAllScheduleRegister(String username);
}
