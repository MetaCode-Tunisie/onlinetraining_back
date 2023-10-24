package com.example.sponsorpublicite.services;

import com.example.sponsorpublicite.entities.Publicite;
import com.example.sponsorpublicite.entities.Sponsor;
import com.example.sponsorpublicite.repositories.SponsorRepository;
import com.example.sponsorpublicite.services.Iservices.ISponsorService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SponsorService implements ISponsorService {

    SponsorRepository sponsorRepository;


    @Override
    public List<Sponsor> retrieveAllSponsors() {
        return (List<Sponsor>) sponsorRepository.findAll();
    }

    @Override
    public Sponsor addSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public void deleteSponsor(int id) {
        sponsorRepository.deleteById(id);
    }

    @Override
    public Sponsor updateSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Override
    public Sponsor retrieveSponsor(int id) {
        return sponsorRepository.findByIdSponsor(id);
    }


            public double calculerSommePrixPublicites(Sponsor sponsor) {
                List<Publicite> publicites = sponsor.getPublicites();
                double sommePrix = 0.0;

                for (Publicite publicite : publicites) {
                    sommePrix += publicite.getPrix();
                }

                return sommePrix;
            }






    public List<Sponsor> trouverTroisPremiersSponsors() {
        List<Sponsor> sponsors = sponsorRepository.findAll();

        sponsors.sort((s1, s2) -> Double.compare(calculerSommePrixPublicites(s2), calculerSommePrixPublicites(s1)));
        return sponsors.subList(0, Math.min(3, sponsors.size()));
    }






            @Override
            public Sponsor trouverSponsorAvecLaPlusGrandeSomme() {

                List<Sponsor> sponsors = sponsorRepository.findAll();

                Sponsor sponsorAvecPlusGrandeSomme = null;
                double sommeMax = Double.MIN_VALUE;

                for (Sponsor sponsor : sponsors) {
                    double sommePrix = calculerSommePrixPublicites(sponsor);
                    if (sommePrix > sommeMax) {
                        sommeMax = sommePrix;
                        sponsorAvecPlusGrandeSomme = sponsor;
                    }
                }

                return sponsorAvecPlusGrandeSomme;
            }

}
