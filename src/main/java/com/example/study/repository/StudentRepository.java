package com.example.study.repository;

import com.example.study.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ds on 2017-11-22.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //이름으로 검색
    List<Student> findByName(String name);
    //이름 앞 글자로 검색
    List<Student> findByNameStartsWith(String name);
    //학과 검색
    List<Student> findByDepartmentName(String name);
    //학과이름 앞 글자로 검색
    List<Student> findByDepartmentNameStartsWith(String name);
    //이름으로 검색, 오름차순정렬
    List<Student> findAllByOrderByName();
    //학생 전체 테이블을 이름 내림차순
    List<Student> findAllByOrderByNameDesc();
    //학과id로 검색, 이름 내림차순
    List<Student> findByDepartmentIdOrderByNameDesc(int id);
}
