package com.tn.bedatn.service;

import com.tn.bedatn.model.BookedRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendBookingConfirmationEmail(String toEmail, BookedRoom booking) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@gmail.com");
        message.setTo(toEmail);
        message.setSubject("Booking Confirmation");

        String emailBody = "Dear " + booking.getGuestFullName() + ",\n\n" +
                "Thank you for booking with us!\n\n" +
                "Your booking details:\n" +
                "Check-in Date: " + booking.getCheckInDate() + "\n" +
                "Check-out Date: " + booking.getCheckOutDate() + "\n" +
                "Number of Adults: " + booking.getNumOfAdults() + "\n" +
                "Number of Children: " + booking.getNumOfChildren() + "\n" +
                "Total Guests: " + booking.getTotalNumOfGuest() + "\n" +
                "Total Price: $" + booking.getTotalPrice() + "\n" +
                "Booking Confirmation Code: " + booking.getBookingConfirmationCode() + "\n\n" +
                "We look forward to welcoming you!\n\n" +
                "Best regards,\n" +
                "VIEMEI Hotel";

        message.setText(emailBody);

        mailSender.send(message);
        System.out.println("Booking confirmation email sent successfully to: " + toEmail);
    }
}
