package com.elearning.backend.model.dal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teaching_week")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachingWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int weekNumber;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // @OneToMany(mappedBy = "teachingWeek", cascade = CascadeType.ALL)
    // private List<EducationalMaterial> educationalMaterials;
}
