package org.debugroom.sample.spring.batch.app;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class S3FileUploadHelper {

    private static final String S3_BUCKET_PREFIX = "s3://";

    @Value("${bucket.name}")
    private String bucketName;

    @Autowired
    ResourceLoader resourceLoader;

    public String saveFile(String classPathFileResource){
        String objectKey = new StringBuilder()
                .append(S3_BUCKET_PREFIX)
                .append(bucketName)
                .append(classPathFileResource)
                .toString();
        WritableResource writableResource = (WritableResource)resourceLoader.getResource(objectKey);
        try(InputStream inputStream = getClass().getResourceAsStream(classPathFileResource);
            OutputStream outputStream = writableResource.getOutputStream()){
            IOUtils.copy(inputStream, outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return objectKey;
    }

}
