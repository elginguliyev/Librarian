package com.example.service_impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    void sendEmailForLateBook(String toEmail, String bookName, String rentsDate, String mustReturnDate) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setTo(toEmail);
            messageHelper.setSubject("Gecikmis kitabiniz var !");
            messageHelper.setText(
                    "Hörmətli oxucu,<br><br>" +
                            "Sizin götürdüyünüz <b>" + bookName + "</b> adlı kitabın qaytarılma tarixi keçib. " +
                            "Zehmet olmasa, kitabı ən qısa zamanda geri qaytarın. " +
                            "Son qaytarma tarixi: <b>" + mustReturnDate + "</b>.<br><br>" +
                            "Götürülme tarixi <b>" + rentsDate + "</b>.<br><br> ",
                    true
            );
            mailSender.send(message);
            System.out.println("E-poçt göndərildi: " + toEmail);
        } catch (MessagingException e) {
            System.out.println("E-poçt göndərilərkən xəta baş verdi: " + e.getMessage());
        }
    }
}
