package com.liuxun.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {
    /**
     * 使用命令：curl -F "file=@文件全名" localhost:8050/upload
     * @param file 待上传的文件
     * @return 文件在服务器上的绝对路径
     * @throws IOException IO异常
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam(value = "file",required = true) MultipartFile file) throws IOException {
//        此种方式容易造成内存不足
//        byte[] bytes = file.getBytes();
//        File fileToSave = new File(file.getOriginalFilename());
//        FileCopyUtils.copy(bytes,fileToSave);
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(fileToSave));
        return fileToSave.getAbsolutePath();
    }
}
