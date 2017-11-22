package com.example.study.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ds on 2017-11-21.
 */
@Data
@ToString(exclude = {"department", "courses"})
@EqualsAndHashCode(exclude = {"department", "courses"})
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "professorName")
    String name;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
    List<Course> courses;
}
