package site.scutum.upload_and_download.service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownLoad {                            //负责下载的方法
    public void down(String path, HttpServletResponse response){                  //负责下载的方法
        File downFile = new File(path);

        response.setHeader("content-type", "application/octet-stream");    //设置响应头
        response.setContentType("application/octet-stream");                         //设置响应类型
        response.setHeader("Content-Disposition", "attachment;filename=" + downFile.getName());         //设置响应类型，用于下载

        byte[] buff = new byte[1024];
        BufferedInputStream bufferedInputStream = null;          //输入缓冲流
        OutputStream outputStream = null;                      //字节输出流
        try{
            outputStream = response.getOutputStream();                 //得到字节输出流
            bufferedInputStream = new BufferedInputStream(new FileInputStream(downFile));
            int i = bufferedInputStream.read(buff);                //将读到的字节存入数组
            //循环将数组内的字节写入到输出流
            while (i != -1){
                outputStream.write(buff,0,buff.length);
                outputStream.flush();
                i = bufferedInputStream.read(buff);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭输入流
            if (bufferedInputStream != null){
                try {
                     bufferedInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
