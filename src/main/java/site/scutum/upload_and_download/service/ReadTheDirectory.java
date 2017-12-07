package site.scutum.upload_and_download.service;


import java.io.File;
import java.util.ArrayList;

public class ReadTheDirectory {                          //查看文件目录类

    static File[] getFiles(String path){                             //返回所输入路径下的文件和文件夹的抽象路径名数组
        File dir = new File(path);
        File file[] = dir.listFiles();
        return file;
    }

    public ArrayList getDirectoryName(String path){                                //得到所选择的路径下的所以文件夹名   返回文件夹名数组

        File[] directory= getFiles(path);
        ArrayList names = new ArrayList();
        for(int i=0;i<directory.length;i++)
        {
            if(directory[i].isDirectory()){
                names.add(directory[i]);
            }
        }
        return names;
    }

    public ArrayList getFileName(String path){                                //得到所选择的路径下的所以文件名   返回文件名数组
        File[] file= getFiles(path);
        ArrayList names = new ArrayList();
        for(int i=0;i<file.length;i++)
        {
            if(file[i].isFile()) {
                names.add(file[i]);
            }
        }
        return names;
    }
}
