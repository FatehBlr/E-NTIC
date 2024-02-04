package com.elearning.backend.model.dal.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.backend.model.dal.entities.UserRole;
import com.elearning.backend.model.dal.entities.Enumerated.UserRoleEnum;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleEnum> {

    Optional<UserRole> findByRole(UserRoleEnum role);

}
