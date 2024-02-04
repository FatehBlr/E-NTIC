package com.elearning.backend.model.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.elearning.backend.model.dal.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin getAdminByUsername(@Param("searched") String searched);

    @Query("SELECT a FROM Admin a WHERE " +
            "LOWER(a.username) LIKE LOWER(CONCAT('%', :searched, '%'))")
    List<Admin> search(@Param("searched") String searched);

}
