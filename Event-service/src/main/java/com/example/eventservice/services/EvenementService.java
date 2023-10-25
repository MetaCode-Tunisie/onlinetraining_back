package com.example.eventservice.services;

import com.example.eventservice.entities.Evenement;
import com.example.eventservice.entities.Places;
import com.example.eventservice.interfaces.IServiceEvenement;
import com.example.eventservice.repositories.EvenementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class EvenementService  implements IServiceEvenement {

    @Autowired
    EvenementRepository evenementRepository;


    @Override
    public List<Evenement> getAllEvents() {
        return evenementRepository.findAll();
    }

    @Override
    public Optional<Evenement> getEventById(Long idEvents) {
        return evenementRepository.findById(idEvents);
    }

    /*@Override
    public Evenement addOrUpdateEvent(Evenement event) {
        return evenementRepository.save(event);

    }*/

    @Override
    public Evenement saveEvent(Evenement event) {
          Evenement event1 = evenementRepository.save(event);
          return event1;
    }


    @Override
    public void deleteEventById(Long idEvents) {
        evenementRepository.deleteById(idEvents);
    }

    @Override
    public String testPlacesEvent(Long idEvents) {
        // TODO Auto-generated method stub
        Evenement e = evenementRepository.findById(idEvents).orElse(null);

        int NP = e.getNbrParticipant() ;
        int NPMax = e.getMaxNbrParticipant() ;
        float rate = 0 ;

        if (e.getMaxNbrParticipant() - e.getNbrParticipant() == 0){
            rate = 100 ;
            e.setPlaces(Places.full);

        }else{
            rate = NP * 100 / NPMax ;
            e.setPlaces(Places.available);
        }

       // e.setRatiing(rate);

        evenementRepository.save(e);

        return ("Rating for this event is " + rate + " % ");    }



    /*@Override
    public List<Evenement> searchByNameOrDescription(String keyword) {
        return evenementRepository.findByNameContainingOrDescriptionContaining(keyword);
    }*/
}
