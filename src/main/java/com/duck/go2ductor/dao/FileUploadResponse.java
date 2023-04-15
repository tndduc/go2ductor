package com.duck.go2ductor.dao;

import lombok.Data;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/11/2023
 */
@Data
public class FileUploadResponse {
    private String fileName;
    private String downloadUri;
    private long size;

    // getters and setters are not shown for brevity

}