package com.elearning.backend.model.dal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.backend.model.dal.entities.FileData;

public interface FileDataRepository extends JpaRepository<FileData, Long> {

}
