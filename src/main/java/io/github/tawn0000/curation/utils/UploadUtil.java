package io.github.tawn0000.curation.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UploadUtil {
    /**
     * 上传文件，由系统根据日期随机生成文件名
     * @param file
     * @param uploadDir
     * @return
     */
    public static String uploadFile(MultipartFile file, String uploadDir) {
        // 文件名
        String fileName = new SimpleDateFormat("yyyyMMDDHHmmss").format(new Date()) +
                "_" + file.getOriginalFilename();
        return storeFile(file, uploadDir, fileName);
    }

    /**
     * 上传文件，自定义文件名
     * @param file
     * @param uploadDir 上传保存路径
     * @param fileName
     * @return
     */
    public static String uploadFile(MultipartFile file, String uploadDir, String fileName) {
        return storeFile(file, uploadDir, fileName);
    }

    private static String storeFile(MultipartFile file, String uploadDir, String fileName) {
        // 文件名
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File serverFile = new File(uploadDir + "/" + fileName);
        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadDir + "/" + fileName;
    }
}
