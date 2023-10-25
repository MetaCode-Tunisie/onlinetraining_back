package com.example.formationservice.Services;

import com.example.formationservice.Entites.Notification;
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
