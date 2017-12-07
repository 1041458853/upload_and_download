package site.scutum.upload_and_download;

import java.io.File;

public class Test {
    static File[] getFiles(String path){                             //返回所输入路径下的文件和文件夹的抽象路径名数组
        File dir = new File(path);
        File file[] = dir.listFiles();
        return file;
    }

    public static void main(String[] args) {
//        for (String names:
//             new File(System.getProperty("user.dir")).list()) {
//            System.out.println(names);
//        }

//        for (File names:
//                new File("C:").listFiles()) {
//
//                System.out.println(names.getName());
//
//        }

//        for (String names:
//                new File("C:").list()) {
//                System.out.println(names);
//        }

//        String path = "D:\\dfsdf";
//        String rootPath;                                     //上一级目录
//        if (path.contains("\\") && path.charAt(2) != '\\'){
//            rootPath = path.substring(0,path.lastIndexOf("\\"));
//        }else {
//            rootPath = path;
//        }
//        System.out.println(rootPath);

        File[] file = getFiles("E:\\程序员之家网站");
        for (File fi:
             file) {
            System.out.println(fi.getName());
        }

    }
}

