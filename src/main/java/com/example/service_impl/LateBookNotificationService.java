package com.example.service_impl;

import com.example.entities.BookRents;
import com.example.repository.BookRentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LateBookNotificationService {


    private final BookRentRepository rentRepository;
    private final EmailService emailService;

    public void sendNotificationsForLateBooks() {
        List<BookRents> rentsList = rentRepository.lateBook(LocalDateTime.now());

        for (BookRents rents : rentsList) {
            String email = rents.getStudent().getEmail();
            String bookName = rents.getBook().getName();
            String mustReturnDate = rents.getMustReturnDate().toString();
            String rentsDate = rents.getRentsDate().toString();

            emailService.sendEmailForLateBook(email, bookName, mustReturnDate, rentsDate);
        }
    }
}
