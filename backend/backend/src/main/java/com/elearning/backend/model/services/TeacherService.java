package com.elearning.backend.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.backend.model.dal.entities.Teacher;
import com.elearning.backend.model.dal.entities.UserRole;
import com.elearning.backend.model.dal.entities.Enumerated.UserRoleEnum;
import com.elearning.backend.model.dal.repositories.TeacherRepository;
import com.elearning.backend.model.dal.repositories.UserRoleRepository;

import jakarta.transaction.Transactional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Transactional
    public Teacher addTeacher(Teacher teacher) {
        UserRole teacherRole = userRoleRepository.findByRole(UserRoleEnum.TEACHER)
                .orElseThrow(() -> new RuntimeException("Teacher role not found"));
        teacher.setRole(teacherRole);
        return teacherRepository.save(teacher);
    }

    public String deleteTeacher(String username) {
        Teacher teacher = teacherRepository.getTeacherByUsername(username);
        if (teacher != null) {
            teacherRepository.delete(teacher);
            return "teacher " + username + " deleted successfully!";
        } else {
            return "teacher with this username not found!";
        }
    }

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacher(String username) {
        return teacherRepository.getTeacherByUsername(username);
    }

    public Teacher updateTeacher(String Username, Teacher newTeacher) {
        Teacher oldTeacher = teacherRepository.getTeacherByUsername(Username);
        oldTeacher.setUsername(newTeacher.getUsername());
        oldTeacher.setPassword(newTeacher.getPassword());
        return teacherRepository.save(oldTeacher);
    }

    public List<Teacher> search(String searched) {
        return teacherRepository.search(searched);
    }
}
