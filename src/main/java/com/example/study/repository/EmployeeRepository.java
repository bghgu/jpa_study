package com.example.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.study.domain.Employee;

/**
 * Created by ds on 2017-11-21.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
