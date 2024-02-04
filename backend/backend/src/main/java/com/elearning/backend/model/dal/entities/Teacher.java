package com.elearning.backend.model.dal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@Table(name = "teacher")
public class Teacher extends AppUser {

    // @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    // private List<Course> courses;

}
