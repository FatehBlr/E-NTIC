package com.elearning.backend.model.dal.entities;

import com.elearning.backend.model.dal.entities.Enumerated.SpecialityEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "speciality")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Speciality {

    @Id
    @Enumerated(EnumType.STRING)
    private SpecialityEnum name;

    // @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
    // private List<Course> courses;

    // @OneToMany(mappedBy = "speciality", cascade = CascadeType.ALL)
    // private List<Student> student;

}
