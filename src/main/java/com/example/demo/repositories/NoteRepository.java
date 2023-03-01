package com.example.demo.repositories;

import com.example.demo.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    @Query(value = "select * from note where app_id = ?1", nativeQuery = true)
    List<Note> findByAppointment(int appId);
}
