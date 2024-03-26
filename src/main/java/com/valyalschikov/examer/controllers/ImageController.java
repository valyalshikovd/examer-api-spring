package com.valyalschikov.examer.controllers;

import com.valyalschikov.examer.Models.Image;
import com.valyalschikov.examer.repository.ImageRepository;
import com.valyalschikov.examer.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController

@AllArgsConstructor
@RequestMapping("api/v1/images")
@CrossOrigin(origins = "*")
public class ImageController {
    private final ImageRepository imageRepository;
    private ImageService imageService;
    @GetMapping("/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id) {

        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));

    }
    @PostMapping("addPhoto/{idProduct}")
    public ResponseEntity addPhotoToTask(
            @RequestParam("file") MultipartFile file,
            @PathVariable(name = "idProduct") Long idProduct
    ) throws IOException {
        System.out.println(file);
        imageService.addImageToProduct(idProduct, file);
        return ResponseEntity.status(200).build();
    }
    @GetMapping("/indicies/{id}")
    private ResponseEntity<List<Long>> getImageIndiciesByTaskId(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.getIndicesImagesByTaskId(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteImageById(@PathVariable Long id) {
        deleteImageById(id);
        return ResponseEntity.status(200).build();
    }
}
