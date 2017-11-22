package com.example.study.controller;

import com.example.study.domain.*;

import com.example.study.repository.DepartmentRepository;
import com.example.study.repository.EmployeeRepository;

import com.example.study.repository.ProfessorRepository;
import com.example.study.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds on 2017-11-21.
 */

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    JpaContext jpaContext;

    @RequestMapping("employees")
    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    @RequestMapping("employee/{id}")
    public Employee student(@PathVariable("id") int id) {
        return employeeRepository.findOne(id);
    }

    @RequestMapping("departments")
    public List<Department> departments() {
        return departmentRepository.findAll();
    }

    @RequestMapping("department/{id}/employees")
    public List<Employee> departmentEmployees(@PathVariable("id") int id) {
        Department department = departmentRepository.findOne(id);
        return department.getEmployees();
    }

    @RequestMapping("students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

    @RequestMapping("department/{id}/students")
    public List<Student> departmentStudents(@PathVariable("id") int id) {
        return departmentRepository.findOne(id).getStudents();
    }

    @RequestMapping("department/{id}/professors")
    public List<Professor> departmentProfessors(@PathVariable("id") int id) {
        return departmentRepository.findOne(id).getProfessors();
    }

    @RequestMapping("student/{id}/registrations")
    public List<Registration> studentRegistrations(@PathVariable("id") int id) {
        return studentRepository.findOne(id).getRegistrations();
    }

    @RequestMapping("student/{id}/courses")
    public List<Course> studentCourses(@PathVariable("id") int id) {
        Student student = studentRepository.findOne(id);
        List<Course> list = new ArrayList<Course>();
        for(Registration r : student.getRegistrations()) {
            list.add(r.getCourse());
        }
        return list;
    }

    @RequestMapping("test/{n}")
    public List<Student> test(@PathVariable("n") int n) {
        List<Student> list = null;
        switch (n) {
            case 1: {
                list = studentRepository.findByName("고은");
                System.out.println("이름으로 검색");
                break;
            }
            case 2: {
                list = studentRepository.findByNameStartsWith("김");
                System.out.println("이름 앞 글자로 검색");
                break;
            }
            case 3: {
                list = studentRepository.findByDepartmentName("수학과");
                System.out.println("학과이름으로 검색");
                break;
            }
            case 4: {
                list = studentRepository.findByDepartmentNameStartsWith("수");
                System.out.println("학과 이름 앞 글자로 검색");
                break;
            }
            case 5: {
                list = studentRepository.findAllByOrderByName();
                System.out.println("학생 전체 이름 오름 차순 검색");
                break;
            }
            case 6: {
                list = studentRepository.findAllByOrderByNameDesc();
                System.out.println("학생 전체 이름 내림 차순");
                break;
            }
            case 7: {
                list = studentRepository.findByDepartmentIdOrderByNameDesc(1);
                System.out.println("학과 id 검색 후 이름 내림 차순");
                break;
            }
        }
        return list;
    }

    //쿼리를 파라미터로 받아서 쿼리문을 생성
    @RequestMapping("jpql")
    public Object jpql (@RequestParam("s") String s) {
        //학생에 관한 엔티티 매니저 생성
        EntityManager manager = jpaContext.getEntityManagerByManagedType(Student.class);
        //쿼리문을 생성
        Query query = manager.createQuery(s);
        //쿼리문 실행
        Object r = query.getResultList();
        return r;
    }
}
