package com.valyalschikov.examer.repository;

import com.valyalschikov.examer.Models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
