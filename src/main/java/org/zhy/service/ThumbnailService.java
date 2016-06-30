package org.zhy.service;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ThumbnailService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final static int WIDTH = 100;
    private final static int HEIGHT = 100;


    public Map uploadImage(MultipartFile file, String uploadPath, String realUploadPath) {
        Map resultMap = new HashMap();
        String extName = ""; // 扩展名格式：
        String fileName = UUID.randomUUID().toString().trim().replaceAll("-", "");
        if (file.getOriginalFilename().lastIndexOf(".") >= 0) {
            extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        }
        String thumbPath = realUploadPath + "/thumb_" + fileName + extName;
        try {
            copyFile(file.getInputStream(), realUploadPath, fileName + extName);
            Thumbnails.of(file.getInputStream()).size(WIDTH, HEIGHT).toFile(thumbPath);
        } catch (IOException e) {
            log.error("upload error : {}", e.getMessage());
            e.printStackTrace();
        }
        resultMap.put("imageUrl", uploadPath + "/" + fileName + extName);
        resultMap.put("thumbImageUrl", uploadPath + "/thumb_" + fileName + extName);

        return resultMap;
    }

    private static String copyFile(InputStream in, String dir, String realName) throws IOException {
        File file = new File(dir, realName);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileUtils.copyInputStreamToFile(in, file);
        return realName;
    }
}
