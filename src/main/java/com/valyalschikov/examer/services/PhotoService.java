package com.valyalschikov.examer.services;

import java.io.File;

public interface PhotoService {

    boolean saveFile(File file);
    boolean getFile(String token, int num);


}
