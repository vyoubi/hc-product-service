package de.haegerconsulting.internShop.hcproductservice.controllers;

import de.haegerconsulting.internShop.hcproductservice.entities.File;
import de.haegerconsulting.internShop.hcproductservice.serviceImpl.FileStorageServiceImpl;
import de.haegerconsulting.internShop.hcproductservice.servlet.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/products/images")
@RequiredArgsConstructor
public class FileController {

    private final FileStorageServiceImpl fileStorageService;

    @PostMapping("/files/upload/{productName}")
    ResponseData uploadImage(@RequestParam("file")MultipartFile file, @PathVariable("productName") String productName) throws Exception {
        File productImage = null;
        String downloadURl = "";
        productImage = fileStorageService.saveImage(file, productName);
        downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/products/images/file/download/")
                .path(productImage.getImageId())
                .toUriString();

        return new ResponseData(productImage.getFileName(),
                downloadURl,
                file.getContentType(),
                file.getSize());
    }

    @GetMapping("/files/product/{productName}")
    List<File> listUploadFiles(@PathVariable("productName") String username) {
        return fileStorageService.getAllUploadFiles(username);
    }

    @GetMapping("/files/users")
    List<File> listUploadFiles() {
        return fileStorageService.getAllFiles();
    }

    @GetMapping("/file/download/{fileId}")
    ResponseEntity<Resource> downloadFile(@PathVariable("fileId") String imageId) throws Exception {
        File productImage = null;
        productImage = fileStorageService.getImage(imageId);
        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(productImage.getPicType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "userImage; filename=\"" + productImage.getFileName()
                                + "\"")
                .body(new ByteArrayResource(productImage.getPicByte()));
    }

}
