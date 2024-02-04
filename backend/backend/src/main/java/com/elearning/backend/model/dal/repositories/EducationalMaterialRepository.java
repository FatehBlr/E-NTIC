package com.elearning.backend.model.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.backend.model.dal.entities.EducationalMaterial;

public interface EducationalMaterialRepository extends JpaRepository<EducationalMaterial, Long> {

}
