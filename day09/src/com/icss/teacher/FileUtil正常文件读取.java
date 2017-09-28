package com.icss.teacher;

import java.io.*;

public class FileUtil正常文件读取 {
    private final static File root = new File("/home/taroballs/Documents");//定义一个File对象

    public static void copy(File sourceFile,File targetFile) throws Exception{
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(targetFile);
        try{
            byte[] bs = new byte[1024];//
            int len = 0;
            while ((len=in.read(bs))>-1){
                out.write(bs,0,len);//每次书写1024个字节
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            in.close();
            out.close();
        }
    }


    public static String readText(File file, String charset) throws Exception{
        Reader reader = new InputStreamReader(new FileInputStream(file),charset);
        BufferedReader br = new BufferedReader(reader);
        try{
            String line = null;
            StringBuffer sb = new StringBuffer();
            while((line=br.readLine())!=null){
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        }
        finally {
            br.close();
            reader.close();
        }
    }

    public static void main(String[] args) throws Exception{
        /*
        File f1 = new File(root,"1.txt");
        File f2 = new File(root,"2.txt");
        copy(f1,f2);
        在文件1.txt中写入“just a test!"
        得到文件2 一样的结果：
        taroballs@taroballs-PC:~/Documents$ cat 2.txt
        Just a test!
        */

        System.out.println(readText(new File(root,"2.txt"),"UTF-8"));
        /*读取文件2的内容*/
        /*Result:
        Just a test!
         */
    }

}
