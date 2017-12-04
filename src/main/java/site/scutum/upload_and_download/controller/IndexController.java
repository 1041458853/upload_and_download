package site.scutum.upload_and_download.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    public String indexPage(){
        return "index.html";
    }
}
