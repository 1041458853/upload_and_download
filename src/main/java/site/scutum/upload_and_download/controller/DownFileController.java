package site.scutum.upload_and_download.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.scutum.upload_and_download.service.DownLoad;

import javax.servlet.http.HttpServletResponse;

@RestController
public class DownFileController {

    @GetMapping("/down")
    public void downFile(String path,HttpServletResponse response){
           new DownLoad().down(path,response);
    }
}
