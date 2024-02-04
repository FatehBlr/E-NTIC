package com.elearning.backend.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.elearning.backend.model.dal.entities.Speciality;
import com.elearning.backend.model.dal.entities.UserRole;
import com.elearning.backend.model.dal.entities.Enumerated.SpecialityEnum;
import com.elearning.backend.model.dal.entities.Enumerated.UserRoleEnum;
import com.elearning.backend.model.dal.repositories.SpecialityRepository;
import com.elearning.backend.model.dal.repositories.UserRoleRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public void run(String... args) throws Exception {
        // Check if roles are already initialized
        if (userRoleRepository.findAll().isEmpty()) {
            userRoleRepository.save(new UserRole(UserRoleEnum.ADMIN));
            userRoleRepository.save(new UserRole(UserRoleEnum.TEACHER));
            userRoleRepository.save(new UserRole(UserRoleEnum.STUDENT));
        }
        if (specialityRepository.findAll().isEmpty()) {
            specialityRepository.save(new Speciality(SpecialityEnum.MI1));
            specialityRepository.save(new Speciality(SpecialityEnum.MI2));
            specialityRepository.save(new Speciality(SpecialityEnum.GL));
            specialityRepository.save(new Speciality(SpecialityEnum.TI));
            specialityRepository.save(new Speciality(SpecialityEnum.SI));
            specialityRepository.save(new Speciality(SpecialityEnum.SCI));
            specialityRepository.save(new Speciality(SpecialityEnum.AI1));
            specialityRepository.save(new Speciality(SpecialityEnum.STIC1));
            specialityRepository.save(new Speciality(SpecialityEnum.STIW1));
            specialityRepository.save(new Speciality(SpecialityEnum.GLM1));
            specialityRepository.save(new Speciality(SpecialityEnum.AI2));
            specialityRepository.save(new Speciality(SpecialityEnum.STIC2));
            specialityRepository.save(new Speciality(SpecialityEnum.STIW2));
            specialityRepository.save(new Speciality(SpecialityEnum.GLM2));
        }
    }
}
