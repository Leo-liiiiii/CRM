package com.ujiuye.usual.controller;

import com.ujiuye.usual.bean.Email;
import com.ujiuye.usual.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Date;
import java.util.Properties;

/**
 * @author LiLe
 * @create 2020-07-10 22:13
 */
@Controller
@RequestMapping("/mail")
public class EmailController  {
    @Resource
    private EmailService emailService;
    @RequestMapping("sendMail")
    public  String  sendMail (Email email, String reemp, MultipartFile file)throws Exception{

        // 发件人的邮箱和密码
        String myEmailAccount = "lile1149618203@163.com";
        String myEmailPassword = "lile123god";// 邮箱密码

        String[] info = reemp.split(",");
        //收件人邮箱
        String receiveMailAccount = info[1];
        //创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();  // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");// 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", "smtp.163.com");// 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");// 需要请求认证

        // 创建验证器
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                // 授权码验证
                return new PasswordAuthentication("lile1149618203", "OFEUZRSVRYCKCRQU");// 邮箱的授权码
            }
        };

        //当前程序和网易邮件服务器之间的交互会话（需要服务和授权码验证）
        Session session = Session.getInstance(props,auth);
        //开启debug模式  查看邮件的发送状态
        session.setDebug(true);

        //创建一个邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(myEmailAccount));
        //给自己的当前抄送一份
        message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(myEmailAccount));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMailAccount));
        //邮件的标题
        message.setSubject(email.getTitle(), "UTF-8");

        // 创建一个封装多个消息容器 map
        Multipart multipart = new MimeMultipart();
        // 创建消息部分
        BodyPart messageBodyPart = new MimeBodyPart();
        // 包装文本内容
        messageBodyPart.setText(email.getEmailcontent());
        // 设置文本消息部分
        multipart.addBodyPart(messageBodyPart);

        // Content: 邮件正文（可以使用html标签）
        message.setContent(multipart);
        // 设置发件时间
        message.setSentDate(new Date());
        // 保存设置
        message.saveChanges();

        //处理附件  文件上传，避免找不到
        String path ="D:\\attachment\\";
        if (file.getSize()>0){
            path += file.getOriginalFilename();
         File nFile = new File(path);
           file.transferTo(nFile);
            //处理附件
            messageBodyPart = new MimeBodyPart();
            DataSource dataSource = new FileDataSource(path);
            messageBodyPart.setDataHandler(new DataHandler(dataSource));
            //处理附件名称中文（附带文件路径） 乱码问题
            messageBodyPart.setFileName(MimeUtility.encodeText(path));
            //添加附件到容器
            multipart.addBodyPart(messageBodyPart);

        }


        //创建发送邮件对象（通过连接获取）
        Transport transport = session.getTransport();
        //设定当前邮箱的名称和密码
        transport.connect(myEmailAccount, myEmailPassword);
        //发送邮件对象和抄送人（邮件发送）
        transport.sendMessage(message, message.getAllRecipients());
        //关闭当前程序和邮件服务器之间的连接
        transport.close();

        //数据库中应该出现一条发送记录
        //收件人的id
        email.setEmpFk(Integer.parseInt(info[0]));
        //设定发件时间
        email.setSendtime(new Date());
        //发件人
        email.setEmpFk2(1);

        emailService.saveEmailMsg(email);


        return  "redirect:/index.jsp";
    }

}
