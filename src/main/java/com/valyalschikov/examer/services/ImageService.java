package com.valyalschikov.examer.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    public void addImageToProduct(Long idProduct, MultipartFile file) throws IOException;
    public void deleteAllImagesByTaskId(Long taskId);
    public List<Long> getIndicesImagesByTaskId(Long taskId);
    public void deleteByImageId(Long imageId);
}
