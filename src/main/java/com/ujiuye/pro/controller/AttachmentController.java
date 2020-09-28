package com.ujiuye.pro.controller;

import com.ujiuye.pro.bean.Analysis;
import com.ujiuye.pro.bean.Attachment;
import com.ujiuye.pro.service.AttachmentService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author LiLe
 * @create 2020-07-08 10:45
 */
@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    @Resource
    private AttachmentService attachmentService;

    @Resource
    private JedisPool jedisPool;

    @RequestMapping("showAllInfo")
    @ResponseBody
           public List<Attachment>    showAllInfo(){
                  return  attachmentService.showAllInfo();
    }


    @RequestMapping(value = "saveInfo",method = RequestMethod.POST)
    public String saveInfo(Attachment attachment, MultipartFile file){

        //文件上传
        //构建文件位置(目录)
        String path = "D:\\attachment\\";
        if (file.getSize()>0){
            //构建完整路径（目录+名称）
            path += file.getOriginalFilename();

            File newfile = new File(path);
            try {
                //执行文件上传
                file.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //数据库中保存数据
        //设置文件上传路径
        attachment.setPath(path);
        boolean b = attachmentService.saveInfo(attachment);
        if (b){
            return "redirect:/project-file.jsp";
        }else {
            return "error";
        }
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(int id) throws IOException {
    //获取下载路径  从redis获取，在showall方法保存过serviceimpl中
//        Jedis jedis = jedisPool.getResource();
//        String  filepath  =jedis.get(id+"");
         Attachment attachment=attachmentService.selectByPrimaryKey(id);
        String filepath = attachment.getPath();
         File file =new File(filepath);

        //指定下载文件名称
        String  nfile=filepath.substring(filepath.lastIndexOf("\\"), filepath.length());

        HttpHeaders headers = new HttpHeaders();
        //中文文件名乱码问题解决  使用硬编码
        String nnfile=new String(nfile.getBytes("utf-8"), "ISO-8859-1");

        //附件
        headers.setContentDispositionFormData("attachment", nnfile);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return  new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);

    }

}
