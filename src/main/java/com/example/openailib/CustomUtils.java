package com.example.openailib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.nio.charset.StandardCharsets;

@Slf4j
public class CustomUtils {

    public static synchronized String readMarkdownFile(String filePath) {
        try {
            ClassPathResource resource = new ClassPathResource(filePath);
            byte[] fileData = FileCopyUtils.copyToByteArray(resource.getInputStream());
            return new String(fileData, StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.warn(e.getMessage());
            return null;
        }
    }
}
