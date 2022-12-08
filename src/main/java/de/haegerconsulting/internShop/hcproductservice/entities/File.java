package de.haegerconsulting.internShop.hcproductservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "file_hc")
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String imageId;
    private String fileName;
    private String picType;
    @Lob
    private byte[] picByte;
    private String productName;

    public File(String fileName, String picType, byte[] picByte, String productName) {
        this.fileName = fileName;
        this.picType = picType;
        this.picByte = picByte;
        this.productName = productName;
    }
}
