package com.example.study.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ds on 2017-11-21.
 */

@Entity
@Data
//다른 테이블과의 관계를 구현한 필드와 일치하지 않는 것들은 멤버변수에서 제외
@ToString(exclude = {"students", "courses", "professors"})
@EqualsAndHashCode(exclude = {"students", "courses", "professors"})
public class Department {

    public static int count = 0;
    public Department() { ++count; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //원 컬럼명 : departmentName, 바뀐 컬럼명 : name
    @Column(name = "departmentName")
    String name;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Employee> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    List<Professor> professors;
}
