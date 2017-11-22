package com.example.study.domain;

import javax.persistence.*;

import lombok.Data;

/**
 * Created by ds on 2017-11-21.
 */
@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departmentId")
	Department department;

	@OneToOne(mappedBy = "employee", fetch = FetchType.EAGER)
    Address address;
}
