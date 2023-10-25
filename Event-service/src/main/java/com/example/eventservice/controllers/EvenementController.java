package com.example.eventservice.controllers;
import com.example.eventservice.entities.Evenement;
import com.example.eventservice.repositories.EvenementRepository;
import com.example.eventservice.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class EvenementController {

    @Autowired
     EvenementService evenementService;

    @Autowired
    EvenementRepository evenementRepository;

    @GetMapping("/get-events")
    public List<Evenement> getAllEvents() {
        return evenementService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evenement> getEventById(@PathVariable("id") Long idEvents) {
        Optional<Evenement> event = evenementService.getEventById(idEvents);
        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/admin/AjouterEvent")
    public Evenement saveEvent(@RequestBody Evenement event) {
        return evenementService.saveEvent(event);
    }


    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteEventById(@PathVariable("id") Long eventId) {
        evenementService.deleteEventById(eventId);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/admin/popular")
    public List<Evenement> getPopularEvents() {
        List<Evenement> popularEvents = evenementRepository.findTop3ByOrderByNbrParticipantDesc();
        return popularEvents;
    }

    @GetMapping("/most-popular-events")
    public ResponseEntity<List<Evenement>> getMostPopularEvents() {
        List<Evenement> events = evenementRepository.findTop3ByOrderByNbrParticipantDesc();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
    @GetMapping("/barGraph")
    public Map<String, Integer> getEventPerMonth() {
        List<Evenement> events = evenementRepository.findAll();
        Map<String, Integer> eventsPerMonth = new LinkedHashMap<>();
        for (Evenement event : events) {
            String month = new SimpleDateFormat("MMMM").format(event.getStartDate());
            eventsPerMonth.put(month, eventsPerMonth.getOrDefault(month, 0) + 1);
        }
        return eventsPerMonth;
    }

    @GetMapping("/events/{id}/image")
    public ResponseEntity<byte[]> getEventImage(@PathVariable Long id) {
        Optional<Evenement> eventOptional = evenementRepository.findById(id);
        if (eventOptional.isPresent()) {
            Evenement event = eventOptional.get();
            String base64Image = event.getImage();
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Assurez-vous de définir le type de contenu correct
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/AjouterEventImage")
    public Evenement saveEventWithImage(
            @RequestPart("event") Evenement event,
            @RequestPart("image") MultipartFile image) {
        try {
            if (image != null && !image.isEmpty()) {
                // Handle image data, convert it to Base64, and set it in the event object.
                String base64Image = Base64.getEncoder().encodeToString(image.getBytes());
                event.setImage(base64Image);
            }

            // Save the event in the database.
            Evenement savedEvent = saveEvent(event);

            return savedEvent;
        } catch (IOException e) {
            throw new RuntimeException("Error handling the image file.", e);
        }
    }






   /*@GetMapping("/search")
    public ResponseEntity<List<Evenement>> search(@RequestParam(name="keyword", required=false) String keyword)
    {
        List<Evenement> events;

        if(keyword != null) {
            events = evenementService.searchByNameOrDescription(keyword);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(events, HttpStatus.OK);
    }*/

}
