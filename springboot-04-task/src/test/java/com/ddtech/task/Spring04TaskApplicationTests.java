package com.ddtech.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring04TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;

	/**
	 * 简单邮件发送
	 */
	@Test
	public void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		//设置邮件标题
		simpleMailMessage.setSubject("邮件发送测试");
		//设置内容
		simpleMailMessage.setText("邮件内容");
		//收件人地址
		simpleMailMessage.setTo("bin_pu@ddtech.net.cn");
		//发件人
		simpleMailMessage.setFrom("865373452@qq.com");

		mailSender.send( simpleMailMessage);
	}
	/**
	 * 复杂邮件发送，带html和附件
	 */
	@Test
	public void sendTwo(){

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper =null;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			//设置邮件标题
			mimeMessageHelper.setSubject("My发送带附件邮件测试");
			//设置内容
			mimeMessageHelper.setText("<p style='color:red'>邮件内容，带html</p>",true);
			//收件人地址
			mimeMessageHelper.setTo("bin_pu@ddtech.net.cn");
			//发件人
			mimeMessageHelper.setFrom("865373452@qq.com");
			//上传文件
			mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\pubin\\Desktop\\a1.jpg"));
			mailSender.send( mimeMessage);
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
