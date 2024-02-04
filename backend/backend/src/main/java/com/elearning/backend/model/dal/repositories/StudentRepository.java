package com.elearning.backend.model.dal.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearning.backend.model.dal.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student getStudentByUsername(@Param("searched") String searched);

    @Query("SELECT a FROM Student a WHERE " +
            "LOWER(a.username) LIKE LOWER(CONCAT('%', :searched, '%'))")
    List<Student> search(@Param("searched") String searched);

}
