package com.example.sponsorpublicite.services;
import com.example.sponsorpublicite.entities.Publicite;
import com.example.sponsorpublicite.entities.Sponsor;
import com.example.sponsorpublicite.repositories.PubliciteRepository;
import com.example.sponsorpublicite.repositories.SponsorRepository;
import com.example.sponsorpublicite.services.Iservices.IPubliciteService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PubliciteService implements IPubliciteService {

    PubliciteRepository publiciteRepository;
    SponsorRepository sponsorRepository;
    @Override
    public List<Publicite> retrieveAllPublicites() {
         return (List<Publicite>) publiciteRepository.findAll();
    }







    @Override
    public Publicite addPublicite(MultipartFile image, String description, float prix, int idsponsor) throws IOException {
        Sponsor sponsor = sponsorRepository.findByIdSponsor(idsponsor);
       Publicite publicite = new Publicite();

        String filename = StringUtils.cleanPath(image.getOriginalFilename());
        if (filename.contains("..")) {
            System.out.println("!!! Not a valid File");
        }

        publicite.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        publicite.setDescription(description);
        publicite.setPrix(prix);
        publicite.setSponsor(sponsor);
        return publiciteRepository.save(publicite);
    }
    @Override
    public Publicite updatePublicite( String description, float prix, int idPublicite, int idsponsor)  {
        Sponsor sponsor = sponsorRepository.findByIdSponsor(idsponsor);
        Publicite publicite = publiciteRepository.findByIdPublicite(idPublicite);

        publicite.setDescription(description);
        publicite.setPrix(prix);
        publicite.setSponsor(sponsor);
        return publiciteRepository.save(publicite);
    }

    public Publicite updatePubliciteimage(MultipartFile image, int idPublicite) throws IOException {
        Publicite publicite = publiciteRepository.findByIdPublicite(idPublicite);
        String filename = StringUtils.cleanPath(image.getOriginalFilename());
        if (filename.contains("..")) {
            System.out.println("!!! Not a valid File");
        }
        publicite.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        return publiciteRepository.save(publicite);
    }


        @Override
    public void deletePublicite(int id) {
            publiciteRepository.deleteById(id);
    }


    @Override
    public Publicite retrievePublicite(int id) {
        return publiciteRepository.findByIdPublicite(id);
    }


    public List<Publicite> FilterPublicite( String Sponsor, float MaxBudget, float MinBudget) {
        List<Publicite> Publicite = publiciteRepository.findAll();
        List<Publicite> Publicite1 = new ArrayList<>();


        if(!Sponsor.equals("")){
            Publicite1 = Publicite.stream().filter(pr -> pr.getSponsor().getSname().equals(Sponsor)).collect(Collectors.toList());
            if(MaxBudget != 0.0){
                Publicite1 = Publicite1.stream().filter(pr -> pr.getPrix()<=MaxBudget).collect(Collectors.toList());
            }
            if(MinBudget != 0.0){
                Publicite1 = Publicite1.stream().filter(pr -> pr.getPrix()>=MinBudget).collect(Collectors.toList());
            }
        }else if(MaxBudget != 0.0){
            Publicite1 = Publicite.stream().filter(pr -> pr.getPrix()<=MaxBudget).collect(Collectors.toList());
            if(MinBudget != 0.0){
                Publicite1 = Publicite.stream().filter(pr -> pr.getPrix()>=MinBudget).collect(Collectors.toList());
            }
        }
        return Publicite1;
    }

}
