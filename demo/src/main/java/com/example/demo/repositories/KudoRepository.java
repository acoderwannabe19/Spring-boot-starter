package com.example.demo.repositories;

import com.example.demo.classes.Kudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KudoRepository extends JpaRepository<Kudo, Long> {
    @Query("SELECT k FROM Kudo k WHERE  k.recipient.username = ?1")
    List<Kudo> findReceivedKudoByUsername(String username);

}
