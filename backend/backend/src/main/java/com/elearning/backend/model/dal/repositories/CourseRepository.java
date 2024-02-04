package com.elearning.backend.model.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.backend.model.dal.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
