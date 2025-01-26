package com.example.config;

import com.example.service_impl.LateBookNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationSchedulerConfig {

    private final LateBookNotificationService bookNotificationService;

    @Scheduled(cron = "0 0 9 1,15 * ?")
    public void sendDailyLateBookNotifications() {
        bookNotificationService.sendNotificationsForLateBooks();
    }
}
