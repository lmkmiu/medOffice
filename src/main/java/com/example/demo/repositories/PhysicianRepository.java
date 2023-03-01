package com.example.demo.repositories;

import com.example.demo.entities.Physician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository extends JpaRepository<Physician, Integer> {


}
