package com.example.evenement.repositories;

import com.example.evenement.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {


    List<Evenement> findTop3ByOrderByNbrParticipantDesc();
   // List<Evenement> findByNameContainingOrDescriptionContaining(String keyword);


    // Method to get the count of events by location
    //@Query(value = "SELECT COUNT(*) FROM events WHERE location = :location", nativeQuery = true)
    //int countEventsByLocation(@Param("location") String location);

    // Method to get the count of events by topic
    //@Query(value = "SELECT COUNT(*) FROM events WHERE topic = :topic", nativeQuery = true)
    //int countEventsByTopic(@Param("topic") String topic);


    //@Query("select u from User u join u.events e where e.idEvents = :eventId")
    //List<User> getUsersRegisteredForEvent(@Param("eventId") Long eventId);


}
