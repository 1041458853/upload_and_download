package site.scutum.upload_and_download.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import site.scutum.upload_and_download.service.ReadTheDirectory;

import java.util.ArrayList;

@RestController
public class CatalogController {

@RequestMapping("/catalog")
ModelAndView catalog(String path){
        ReadTheDirectory readTheDirectory = new ReadTheDirectory();        //创建“读取目录” 的那个类的对象
        ArrayList directoryNames = readTheDirectory.getDirectoryName(path);      //返回目录名数组
        ArrayList fileNames = readTheDirectory.getFileName(path);      //返回文件名数组

        ModelAndView modelAndView = new ModelAndView();                 //创建一个模型
        modelAndView.setViewName("catalog");                        //设置名称

        //将两个数组添加到模型对象中
        modelAndView.addObject("directoryNames",directoryNames);
        modelAndView.addObject("fileNames",fileNames);

       //截取最后一个“\”之前的路径，加入模型，用于返回上一级
       String rootPath;                                     //上一级目录
       if (path.contains("\\")){
           if (path.lastIndexOf("\\") == 2){
              rootPath = path.substring(0,path.lastIndexOf("\\")+1);
           }else {
               rootPath = path.substring(0,path.lastIndexOf("\\"));
           }
       }else {
           rootPath = path;
       }

        modelAndView.addObject("goBack",rootPath);                          //截取最后一个“/”之前的路径，加入模型，用于返回上一级
        return modelAndView;
    }
}
