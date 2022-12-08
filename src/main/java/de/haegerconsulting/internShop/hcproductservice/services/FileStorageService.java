package de.haegerconsulting.internShop.hcproductservice.services;

import de.haegerconsulting.internShop.hcproductservice.entities.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorageService  {

    File saveImage(MultipartFile file, String productName) throws Exception;

    File getImage(String imageId) throws Exception;

    List<File> getAllUploadFiles(String productName);

    List<File> getAllFiles();
}
