package com.elearning.backend.model.dal.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "file_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String filePath;

    @OneToOne(mappedBy = "fileData")
    private EducationalMaterial educationalMaterial;
}
