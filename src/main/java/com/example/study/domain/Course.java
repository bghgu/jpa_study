package com.example.study.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by ds on 2017-11-21.
 */
@Data
@Entity
@ToString(exclude = {"department", "professor", "registrations"})
@EqualsAndHashCode(exclude = {"department", "professor", "registrations"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int unit;

    Date startDate;

    @Column(name = "courseName")
    String name;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    Department department;

    @ManyToOne
    @JoinColumn(name = "professorId")
    Professor professor;

    @JsonIgnore
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    List<Registration> registrations;
}
