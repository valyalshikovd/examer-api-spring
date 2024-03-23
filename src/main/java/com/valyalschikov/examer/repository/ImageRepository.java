package com.valyalschikov.examer.repository;

import com.valyalschikov.examer.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    public List<Image> findAllByTaskId(Long taskId);
    public void deleteAllByTaskId(Long taskId);
}
