package com.trip.user.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

	JavaMailSender mailSender;
	
	public SendEmailService(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	public String createPassword(String email) {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        
        this.sendMail(email,str);
        return str;
	}

	public void sendMail(String email, String str) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setFrom("kimjeonghwan123@gmail.com");
		message.setSubject("YOUCANCE 임시 비밀번호 안내 메일입니다.");
		message.setText("YOUCANCE 임시 비밀번호 안내 메일입니다.\n"
				+ "임시 비밀번호는 [" +str+"]" + "입니다.");
		mailSender.send(message);
	}
}
