package com.stu.repository;

import org.springframework.data.repository.CrudRepository;

import com.stu.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
