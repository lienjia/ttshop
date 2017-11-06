package com.lej.ttshop.upload;

/**
 * User: lienjiaa
 * Date: 2017/10/31
 * Time: 11:34
 * Version:V1.0
 */
public class FtpUploadTest {
//    @Test
//    public void testFtpUpload() throws IOException {
//        //创建FTPClient客户端
//        FTPClient ftpClient = new FTPClient();
//        //创建FTP连接
//        ftpClient.connect("10.31.166.70",21);
//        //登录
//        ftpClient.login("ftpuser","123456");
//        //读取本地文件
//        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\lienjiaa\\Desktop\\炉石\\Hearthstone Screenshot 03-10-17 13.44.55.png"));
//        //配置上传参数
//        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
//        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//        //上传文件
//        ftpClient.storeFile("hello.png",fileInputStream);
//        //关闭连接
//        fileInputStream.close();
//        ftpClient.logout();
//
//    }
//    @Test
//    public void testFtpUtil() throws FileNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\lienjiaa\\Desktop\\炉石\\Hearthstone Screenshot 07-27-16 22.01.18.png"));
//        FtpUtil.uploadFile("10.31.166.70",21,"ftpuser","123456","/home/ftpuser/www/images","/2017/10/31","hello2.png",fileInputStream);
//    }
}
