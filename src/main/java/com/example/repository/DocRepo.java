package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Doctor;

@Repository
public interface DocRepo extends JpaRepository<Doctor, Long> {

}
