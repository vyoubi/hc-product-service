package de.haegerconsulting.internShop.hcproductservice.serviceImpl;

import de.haegerconsulting.internShop.hcproductservice.entities.File;
import de.haegerconsulting.internShop.hcproductservice.repositories.FileRepository;
import de.haegerconsulting.internShop.hcproductservice.services.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final FileRepository fileRepository;

    public FileStorageServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public File saveImage(MultipartFile file, String productName) throws Exception {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if(fileName.contains("..")) {
                throw  new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            File productImage
                    = new File(fileName,
                    file.getContentType(),
                    file.getBytes(),
                    productName);
            return fileRepository.save(productImage);

        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    @Override
    public File getImage(String imageId) throws Exception {
        return fileRepository
                .findById(imageId)
                .orElseThrow(
                        () -> new Exception("File not found with Id: " + imageId));
    }

    @Override
    public List<File> getAllUploadFiles(String productName) {
        return fileRepository.findAllByProductName(productName);
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
