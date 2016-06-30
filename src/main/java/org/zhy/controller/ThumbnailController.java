package org.zhy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zhy.service.ThumbnailService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/30.
 */
@Controller
@RequestMapping("/thumbnail")
public class ThumbnailController {

    @Autowired
    private ThumbnailService thumbnailService;


    @RequestMapping(value = "upload", method = RequestMethod.GET)
    public String toUpload(ModelMap model) {
        return "upload";
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(ModelMap model, @RequestParam(value = "image", required = false) MultipartFile image, HttpSession session) {
        String uploadPath = "/image";
        String realUploadPath = session.getServletContext().getRealPath(uploadPath);

        Map resultMap= thumbnailService.uploadImage(image, uploadPath, realUploadPath);

        model.put("imageUrl", resultMap.get("imageUrl"));
        model.put("thumbImageUrl", resultMap.get("thumbImageUrl"));

        return "showImage";
    }
}
