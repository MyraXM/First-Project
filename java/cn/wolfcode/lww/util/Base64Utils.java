package cn.wolfcode.lww.util;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.UUID;

public class Base64Utils {
    /**
     * 私有构造方法
      */
    private Base64Utils(){}

    /**
     * 写入文件，
     * @param file Base6的文件信息
     * @param params 子文件夹路径参数
     * @return 写入的文件对应的路径
     */
    public static String writeBase64File(String file,String ... params) throws Exception{
        //获取文件扩展名
        int index1 = file.indexOf("/");
        int index2 = file.indexOf(";");
        String s = file.substring(index1 + 1, index2);//截取后缀名
        //获取文件名
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String newFileName = uuid + "." + s;
        //获取Base64的文件
        int index3 = file.indexOf("base64");
        String base64 = file.substring(index3 + 7);//获取到base64的值
        base64 = base64.replaceAll("\\s", "+");//将所有的空格替换成+

        //初始的目录路径
        StringBuffer directory=new StringBuffer("D:\\file");
        //遍历参数，将子文件夹的路径设置在目录中
        for (String param:params) {
            directory.append("\\"+param);
        }
        //新建文件目录
        File  directoryFile= new File(directory.toString());
        if(!directoryFile.exists()){
            directoryFile.mkdirs();
        }
        //新建文件
        File newFile = new File(directory+"\\"+newFileName);
        if (!newFile.exists()) {
            newFile.createNewFile();
        }
        //写入文件
        byte[] buffer= Base64.getDecoder().decode(base64);
//        byte[] buffer = new BASE64Decoder().decodeBuffer(base64);
        FileOutputStream out = new FileOutputStream(newFile, true);
        out.write(buffer);
        out.close();
        //设置子路径
        StringBuffer resPath=new StringBuffer("http://localhost:8080/cover");
        for(String param:params){
            resPath.append("/"+param);
        }

        //返回对应的路径信息
        return resPath+"/"+newFileName;
    }

    /**
     * 删除图片信息
     * @param file 文件名
     * @param param id
     */
    public static void deleteImageFile(String file,String param){
        int index = file.lastIndexOf("/");//获取最后/的位置
        file = file.substring(index + 1);//获取图片名字
        File file1 = new File("D://file//"+param+"//" + file);//获取文件
        if (file1.isFile()&&file1.exists()) {//判断是否是文件并且是否存在，如果是则删除
            file1.delete();//删除文件
        }
    }

    /**
     * 删除对应的文件夹
     */
    public static void deleteFolder(String folderId){
        try{
            File file=new File("D://file//"+folderId);
            File[] files = file.listFiles();
            for (File newFile:files) {//删除文件夹里面的文件
                if(newFile.exists()){
                    newFile.delete();
                }
            }
            if(file.exists()&&file.isDirectory()){//如果文件夹存在并且
                System.out.println(file.delete());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
