package com.sports.academyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprorts.academyproject.entity.Student;

/*@Repository
public interface AcademyRepository extends JpaRepository<Student, Integer>{

}*/

@Repository
public interface AcademyRepository extends JpaRepository<Student, Integer> {

}
