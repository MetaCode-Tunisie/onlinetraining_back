package com.example.eventservice.interfaces;


import com.example.eventservice.entities.Evenement;

import java.util.List;
import java.util.Optional;

public interface IServiceEvenement {

    List<Evenement> getAllEvents();

    Optional<Evenement> getEventById(Long idEvents);
    public String testPlacesEvent(Long idEvents);
    Evenement saveEvent(Evenement event);
    void deleteEventById(Long idEvents);

   // List<Evenement> searchByNameOrDescription(String keyword);


    // Evenement addOrUpdateEvent(Evenement event);


}
