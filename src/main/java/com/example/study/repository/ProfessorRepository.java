package com.example.study.repository;

import com.example.study.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ds on 2017-11-22.
 */

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
}
