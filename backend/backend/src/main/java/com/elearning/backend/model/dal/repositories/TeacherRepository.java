package com.elearning.backend.model.dal.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearning.backend.model.dal.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    public Teacher getTeacherByUsername(@Param("searched") String searched);

    @Query("SELECT a FROM Teacher a WHERE " +
            "LOWER(a.username) LIKE LOWER(CONCAT('%', :searched, '%'))")
    List<Teacher> search(@Param("searched") String searched);
}
