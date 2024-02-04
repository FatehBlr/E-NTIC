package com.elearning.backend.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.backend.model.dal.entities.Course;
import com.elearning.backend.model.dal.entities.Speciality;
import com.elearning.backend.model.dal.entities.Teacher;
import com.elearning.backend.model.dal.entities.Enumerated.SpecialityEnum;
import com.elearning.backend.model.dal.repositories.CourseRepository;
import com.elearning.backend.model.dal.repositories.SpecialityRepository;
import com.elearning.backend.model.dal.repositories.TeacherRepository;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    public Course addCourse(String teacherUsername, String courseName, SpecialityEnum specialityEnum) {
        Teacher teacher = teacherRepository.getTeacherByUsername(teacherUsername);
        Speciality speciality = specialityRepository.findById(specialityEnum)
                .orElseThrow(() -> new RuntimeException("Speciality not found"));

        Course course = new Course();
        course.setName(courseName);
        course.setSpeciality(speciality);
        course.setTeacher(teacher);

        return courseRepository.save(course);

    }

}
