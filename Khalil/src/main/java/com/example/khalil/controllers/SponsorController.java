package com.example.khalil.controllers;
import com.example.khalil.entities.Sponsor;
import com.example.khalil.services.Iservices.ISponsorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class SponsorController {
    ISponsorService SponsorService;
    @GetMapping("/user/sponsor")
    public List<Sponsor> retrieveAllSponsors() {
            return  SponsorService.retrieveAllSponsors();
    }

    @PostMapping("/admin/sponsor")
    public Sponsor addSponsor(@RequestBody Sponsor sponsor) {
        return SponsorService.addSponsor( sponsor);
    }

    @DeleteMapping("/admin/sponsor/{idSponsor}")
    public void deleteSponsor( @PathVariable int idSponsor) {
        SponsorService.deleteSponsor(idSponsor);
    }

    @PutMapping("/admin/sponsor")
    public Sponsor updateSponsor(@RequestBody Sponsor sponsor) {
        return SponsorService.updateSponsor(sponsor);
    }
    @GetMapping("/admin/sponsor/{idSponsor}")
    public Sponsor retrieveSponsor(  @PathVariable int idSponsor) {
        return SponsorService.retrieveSponsor(idSponsor);
    }
    @GetMapping("/admin/sponsor/sponsorAvecPlusGrandeSomme")
    public Sponsor sponsorAvecPlusGrandeSomme() {
        return SponsorService.trouverSponsorAvecLaPlusGrandeSomme();
    }
    @GetMapping("/admin/sponsor/troisPremiersSponsors")
    public List<Sponsor> troisPremiersSponsors() {
        return SponsorService.trouverTroisPremiersSponsors();
    }

}
