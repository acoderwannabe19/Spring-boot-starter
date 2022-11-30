package com.example.demo.repositories;

import com.example.demo.classes.Roomie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomieRepository extends JpaRepository<Roomie, Long> {
    @Query("SELECT r FROM Roomie r WHERE r.username = ?1 ")
    Optional<Roomie> findRoomieByUsername(String username);
}
