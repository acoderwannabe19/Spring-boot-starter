package com.example.demo.repositories;

import com.example.demo.classes.Kudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KudoRepository extends JpaRepository<Kudo, Long> {

}
