package com.elearning.backend.model.dal.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.elearning.backend.model.dal.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("SELECT a FROM AppUser a WHERE " +
            "LOWER(a.username) LIKE LOWER(CONCAT('%', :searched, '%'))")
    List<AppUser> search(@Param("searched") String searched);

}
