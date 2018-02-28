package com.tmbl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmbl.request.StudentDetailsRequest;

@Repository
public interface StudentDetailsRepository extends CrudRepository<StudentDetailsRequest, Integer> {

}
