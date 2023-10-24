package com.example.sponsorpublicite.controllers;
import com.example.sponsorpublicite.entities.Sponsor;
import com.example.sponsorpublicite.services.Iservices.ISponsorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class SponsorController {
    ISponsorService SponsorService;
    @GetMapping("/sponsor")
    public List<Sponsor> retrieveAllSponsors() {
            return  SponsorService.retrieveAllSponsors();
    }

    @PostMapping("/sponsor")
    public Sponsor addSponsor(@RequestBody Sponsor sponsor) {
        return SponsorService.addSponsor( sponsor);
    }

    @DeleteMapping("/sponsor/{idSponsor}")
    public void deleteSponsor( @PathVariable int idSponsor) {
        SponsorService.deleteSponsor(idSponsor);
    }

    @PutMapping("/sponsor")
    public Sponsor updateSponsor(@RequestBody Sponsor sponsor) {
        return SponsorService.updateSponsor(sponsor);
    }
    @GetMapping("/sponsor/{idSponsor}")
    public Sponsor retrieveSponsor(  @PathVariable int idSponsor) {
        return SponsorService.retrieveSponsor(idSponsor);
    }
    @GetMapping("/sponsor/sponsorAvecPlusGrandeSomme")
    public Sponsor sponsorAvecPlusGrandeSomme() {
        return SponsorService.trouverSponsorAvecLaPlusGrandeSomme();
    }
    @GetMapping("/sponsor/troisPremiersSponsors")
    public List<Sponsor> troisPremiersSponsors() {
        return SponsorService.trouverTroisPremiersSponsors();
    }

}
