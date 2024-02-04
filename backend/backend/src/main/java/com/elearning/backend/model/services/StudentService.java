package com.elearning.backend.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.backend.model.dal.entities.Student;
import com.elearning.backend.model.dal.entities.UserRole;
import com.elearning.backend.model.dal.entities.Enumerated.UserRoleEnum;
import com.elearning.backend.model.dal.repositories.StudentRepository;
import com.elearning.backend.model.dal.repositories.UserRoleRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Transactional
    public Student addStudent(Student student) {
        UserRole studentRole = userRoleRepository.findByRole(UserRoleEnum.STUDENT)
                .orElseThrow(() -> new RuntimeException("Student role not found"));
        student.setRole(studentRole);
        return studentRepository.save(student);
    }

    public String deleteStudent(String username) {
        Student student = studentRepository.getStudentByUsername(username);
        if (student != null) {
            studentRepository.delete(student);
            return "student " + username + " deleted successfully!";
        } else {
            return "student with this username not found!";
        }
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(String username) {
        return studentRepository.getStudentByUsername(username);
    }

    public Student updateStudent(String Username, Student newStudent) {
        Student oldStudent = studentRepository.getStudentByUsername(Username);
        oldStudent.setUsername(newStudent.getUsername());
        oldStudent.setPassword(newStudent.getPassword());
        oldStudent.setSpeciality(newStudent.getSpeciality());
        return studentRepository.save(oldStudent);
    }

    public List<Student> search(String searched) {
        return studentRepository.search(searched);
    }
}
