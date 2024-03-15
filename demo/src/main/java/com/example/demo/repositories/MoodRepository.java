package com.example.demo.repositories;

import com.example.demo.classes.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
    @Query("SELECT m FROM Mood m WHERE m.roomie.username = ?1")
    List<Mood> getMoodsByRoomieUsername(String username);

}
