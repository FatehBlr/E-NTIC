package com.elearning.backend.model.dal.entities;

import com.elearning.backend.model.dal.entities.Enumerated.MaterialTypeEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "educational_material")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EducationalMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaterialTypeEnum materialType;

    @Column(nullable = false)
    private String materialName;

    @Column(nullable = false)
    private String materialDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_data", referencedColumnName = "id")
    private FileData fileData;

    @ManyToOne
    @JoinColumn(name = "teaching_week_id", nullable = false)
    private TeachingWeek teachingWeek;

}
