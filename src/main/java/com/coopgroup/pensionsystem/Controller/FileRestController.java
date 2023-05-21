package com.coopgroup.pensionsystem.Controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileRestController {
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public String uploadPicture(@RequestParam("file") MultipartFile file, HttpSession session) throws IOException {
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/img";
        String realPath = path.replace('/', '\\').substring(1,path.length());
        System.out.println(realPath);
        String fileName= UUID.randomUUID().toString().replace("-","")+file.getOriginalFilename();
        File target=new File(realPath,fileName);
        file.transferTo(target);
        return null;
    }
}
