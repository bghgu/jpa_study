package com.example.study.repository;

import com.example.study.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ds on 2017-11-21.
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
