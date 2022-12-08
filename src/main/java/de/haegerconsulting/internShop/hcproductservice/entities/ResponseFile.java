package de.haegerconsulting.internShop.hcproductservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseFile {

    private String name;
    private String url;
    private String type;
    private long size;
}
