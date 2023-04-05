package cn.wolfcode.lww.controller;

import cn.wolfcode.lww.util.Base64Utils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

/**
 * 上传图片Controller
 * 1.文章发布时上传和是删除文章封面
 * 2.文章发布时上传和删除文章的具体信息
 */
@Controller
public class UploadController {
    /**
     * 文章封面图片上传
     *
     * @param file 图片的base64格式的文件
     */
    @PostMapping("/uploadCover")
    @ResponseBody
    public String upArticleCover(@RequestParam("image") String file, String id) throws Exception {
        String path = Base64Utils.writeBase64File(file, id);
        return path;
    }

    /**
     * 文章封面图片删除
     *
     * @param file 图片的信息
     */
    @PostMapping("/deleteCover")
    @ResponseBody
    public String deleteArticleCover(@RequestParam("image") String file, String id) {
        Base64Utils.deleteImageFile(file,id);
        return null;
    }


    /**
     * 文章内容的图片上传
     * @param file 图片
     * @param id 文章id
     * @return 路径信息
     * @throws Exception
     */
    @PostMapping("/uploadArticleImageByPasted")
    @ResponseBody
    public HashMap uploadArticleImageByPasted(@RequestParam("image") String file, String id) throws Exception {
        String path= Base64Utils.writeBase64File(file,id);
        HashMap<String, String> hashMap = new HashMap<String,String>();
        hashMap.put("link", path);
        return hashMap;
    }


    /**
     * 按钮方式中文章内容插入图片
     * @param multipartFile
     * @return
     */
    @PostMapping("/uploadArticleImage")
    @ResponseBody
    public HashMap uploadArticleImage(@RequestParam("file") MultipartFile multipartFile, String id) {
        HashMap<String, String> map = new HashMap<String,String>();
        String url = "http://localhost:8080/cover/"+id+"/";
        String fileType= FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String uuid=UUID.randomUUID().toString().replaceAll("-","");
        String newFileName=uuid+"."+fileType;
        try {
            File fileDirectory=new File("D://file//"+id);
            //如果目录不存在，则创建路径
            if(!fileDirectory.exists()) fileDirectory.mkdirs();
            //写入文件
            multipartFile.transferTo(new File("D:/file/"+id+"/",newFileName));
            map.put("link", url+newFileName);
        } catch (Exception e) {

        }
        return map;
    }

    /**
     * 文章内容图片删除
     *
     * @param file 图片的信息
     */
    @PostMapping("/deleteArticleImage")
    @ResponseBody
    public String deleteArticleImage(@RequestParam("src") String file, String id) {

        Base64Utils.deleteImageFile(file,id);
        return null;
    }




}
