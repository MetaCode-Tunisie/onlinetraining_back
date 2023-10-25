package com.example.formationservice.Repository;

import com.example.formationservice.Entites.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
