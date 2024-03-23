package com.valyalschikov.examer.services.impl;

import com.valyalschikov.examer.Models.Image;
import com.valyalschikov.examer.Models.Task;
import com.valyalschikov.examer.exceptions.NotFoundException;
import com.valyalschikov.examer.repository.ImageRepository;
import com.valyalschikov.examer.repository.TaskRepository;
import com.valyalschikov.examer.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private TaskRepository taskRepository;
    private ImageRepository imageRepository;

    @Override
    public void addImageToProduct(Long idProduct, MultipartFile file) throws IOException {
        Task task = taskRepository.findById(idProduct).orElseThrow(
                () -> new NotFoundException()
        );
        Image image;
        if (file.getSize() != 0) {
            image = toImageEntity(file);
            image.setPreviewImage(true);
            image.setTaskId(idProduct);
            imageRepository.save(image);
        }
    }
    private Image toImageEntity(MultipartFile file) throws  IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    @Override
    public void deleteAllImagesByTaskId(Long taskId){
        imageRepository.deleteAllByTaskId(taskId);
    }

    public List<Long> getIndicesImagesByTasId(Long taskId){
        return imageRepository.findAllByTaskId(taskId).stream().map((image) -> image.getId()).toList();
    }
}
