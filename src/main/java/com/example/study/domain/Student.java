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
@Data
@ToString(exclude = {"department", "registrations"})
@EqualsAndHashCode(exclude = {"department", "registrations"})
@Entity
public class Student {
    public static int count = 0;
    public Student() {
        ++count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @Column(name = "studentNumber")
    String studentNo;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    List<Registration> registrations;

}
