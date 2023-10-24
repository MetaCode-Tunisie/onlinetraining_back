package com.example.sponsorpublicite.services.Iservices;

import com.example.sponsorpublicite.entities.Sponsor;


import java.util.List;


public interface ISponsorService {

	List<Sponsor> retrieveAllSponsors();

	Sponsor addSponsor(Sponsor sponsor);

	void deleteSponsor(int id);



    Sponsor updateSponsor(Sponsor sponsor);

    Sponsor retrieveSponsor(int id);




	public List<Sponsor> trouverTroisPremiersSponsors() ;
	public Sponsor trouverSponsorAvecLaPlusGrandeSomme();
}
