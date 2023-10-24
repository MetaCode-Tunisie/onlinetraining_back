package com.example.sponsorpublicite.repositories;

import com.example.sponsorpublicite.entities.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SponsorRepository extends JpaRepository<Sponsor,Integer> {
   Sponsor findByIdSponsor(int idSponsor);
}
