package com.example.sponsorpublicite.repositories;

import com.example.sponsorpublicite.entities.Publicite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PubliciteRepository extends JpaRepository<Publicite,Integer> {
    Publicite findByIdPublicite(int idPublicite);
}
