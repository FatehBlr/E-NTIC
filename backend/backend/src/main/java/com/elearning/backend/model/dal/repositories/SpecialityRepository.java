package com.elearning.backend.model.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.backend.model.dal.entities.Speciality;
import com.elearning.backend.model.dal.entities.Enumerated.SpecialityEnum;

public interface SpecialityRepository extends JpaRepository<Speciality, SpecialityEnum> {

}
