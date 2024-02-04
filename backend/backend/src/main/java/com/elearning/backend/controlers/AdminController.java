package com.elearning.backend.controlers;

import org.springframework.beans.factory.annotation.Autowired;

import com.elearning.backend.model.dal.entities.Admin;
import com.elearning.backend.model.dal.entities.Student;
import com.elearning.backend.model.dal.entities.Teacher;
import com.elearning.backend.model.services.AdminService;
import com.elearning.backend.model.services.StudentService;
import com.elearning.backend.model.services.TeacherService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @PostMapping("/a")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @DeleteMapping("/a")
    public String deleteAdmin(@RequestParam String username) {
        return adminService.deleteAdmin(username);
    }

    @GetMapping("/la")
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/a")
    public Admin getAdmin(@RequestParam String username) {
        return adminService.getAdmin(username);
    }

    @GetMapping("/a/{username}")
    public List<Admin> serachAdmin(@PathVariable String username) {
        return adminService.search(username);
    }

    @PutMapping("/a")
    public Admin updateAdmin(@RequestParam String username, @RequestBody Admin newAdmin) {
        return adminService.updateAdmin(username, newAdmin);
    }

    ////////////////////////////////////////////////////////////////////////////

    @PostMapping("/t")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @DeleteMapping("/t")
    public String deleteTeacher(@RequestParam String username) {
        return teacherService.deleteTeacher(username);
    }

    @GetMapping("/lt")
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("/t")
    public Teacher getTeacher(@RequestParam String username) {
        return teacherService.getTeacher(username);
    }

    @GetMapping("/t/{username}")
    public List<Teacher> searchTeacher(@PathVariable String username) {
        return teacherService.search(username);
    }

    @PutMapping("/t")
    public Teacher updateTeacher(@RequestParam String username, @RequestBody Teacher newTeacher) {
        return teacherService.updateTeacher(username, newTeacher);
    }

    ////////////////////////////////////////////////////////////////////////////

    @PostMapping("/s")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/s")
    public String deleteStudent(@RequestParam String username) {
        return studentService.deleteStudent(username);
    }

    @GetMapping("/ls")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/s")
    public Student getStudent(@RequestParam String username) {
        return studentService.getStudent(username);
    }

    @GetMapping("/s/{username}")
    public List<Student> searchStudent(@PathVariable String username) {
        return studentService.search(username);
    }

    @PutMapping("/s")
    public Student updateStudent(@RequestParam String username, @RequestBody Student newStudent) {
        return studentService.updateStudent(username, newStudent);
    }

}
