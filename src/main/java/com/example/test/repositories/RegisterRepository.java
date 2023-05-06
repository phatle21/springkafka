package com.example.test.repositories;

import com.example.test.models.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
    @Query(value = "select * from register where user = :username and id_schedule = :id_schedule", nativeQuery = true)
    Optional<Register> findByScheduleAndUser(int id_schedule, String username);
}
