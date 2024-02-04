package com.elearning.backend.controlers;

import org.springframework.web.bind.annotation.RestController;

import com.elearning.backend.model.dal.entities.Course;
import com.elearning.backend.model.dal.entities.Teacher;
import com.elearning.backend.model.dal.entities.Enumerated.SpecialityEnum;
import com.elearning.backend.model.services.CourseService;
import com.elearning.backend.model.services.TeacherService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/teacher")

public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    CourseService courseService;

    @GetMapping("/me")
    public Teacher me(@RequestParam String username) {
        return teacherService.getTeacher(username);
    }

    @PutMapping("/me")
    public Teacher updateMe(@RequestParam String username, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(username, teacher);

    }

    @PostMapping("/course")
    public Course addCourse(@RequestParam String teacherUsername,
            @RequestParam String courseName,
            @RequestParam SpecialityEnum speciality) {
        return courseService.addCourse(teacherUsername, courseName, speciality);
    }

    // After implimenting security :
    // @PostMapping("/course")
    // public ResponseEntity<String> addCourse(@RequestHeader("Authorization")
    // String token,
    // @RequestParam String courseName,
    // @RequestParam SpecialityEnum speciality) {

    // // Extract information from the token (decode JWT, for example)
    // // Use the extracted information to identify the teacher

    // teacherService.addCourse(teacherUsername, courseName, speciality);
    // return ResponseEntity.ok("Course added successfully");
    // }

}
