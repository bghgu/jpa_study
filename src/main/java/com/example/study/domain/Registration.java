package com.example.study.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ds on 2017-11-21.
 */
@Data
@ToString(exclude = {"student", "course"})
@EqualsAndHashCode(exclude = {"student", "course"})
@Entity
//테이블 이름과 엔터티 클래스 이름이 일치하지 않기 때문에 어노테이션이 필요하다.
@Table(name = "register")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //nullable 필드, null값이 가능하다. null값이 가능한 필드는 Integer 클래스 타입으로 선언
    Integer grade;
    Date createDate;

    @ManyToOne
    @JoinColumn(name = "studentId")
    Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;
}
