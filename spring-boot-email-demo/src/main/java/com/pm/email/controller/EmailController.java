package com.pm.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.email.model.EmailDto;
import com.pm.email.service.EmailSendService;

@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailSendService emailService;
	
	@GetMapping("/sendEmail")
	public String sendEmail(Model model) {
		//model.setViewName("send-email");
		EmailDto email=new EmailDto();
		model.addAttribute("email",email);
		return "send-email";
	}
	
	@PostMapping("/sendSimpleMail")
	public String sendSimpleEmail(@ModelAttribute("email") EmailDto email) {
		System.out.println(email.toString());
		boolean status=emailService.sendEmail(email);
		if(status) {
			System.out.println("Send Success");
		}else {
			System.out.println(" Error ");
		}
		return "send-email";
	}
}
