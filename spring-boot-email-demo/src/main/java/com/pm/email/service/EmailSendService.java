package com.pm.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pm.email.model.EmailDto;

@Service
public class EmailSendService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public boolean sendEmail(EmailDto emailDto) {
		boolean flag = true;
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailDto.getTo());
			message.setSubject(emailDto.getSubject());
			message.setText(emailDto.getMailBody());
			javaMailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
}
