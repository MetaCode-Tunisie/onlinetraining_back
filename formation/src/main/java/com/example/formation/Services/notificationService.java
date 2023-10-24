package com.example.formation.Services;

import com.example.formation.Entites.Notification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class notificationService implements InotificationService {


    @Override
    public void sendNotification(Notification notification) {
        System.out.println("Notification: formation ajouté oupssss" + notification.getMessage());
    }
}
