package com.example.sponsorpublicite.services.Iservices;

import com.example.sponsorpublicite.entities.Publicite;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface IPubliciteService {
    List<Publicite> retrieveAllPublicites();






    Publicite addPublicite(MultipartFile image, String description, float prix, int idsponsor) throws IOException;

    public Publicite updatePublicite( String description, float prix, int idPublicite, int idsponsor)  ;
    public Publicite updatePubliciteimage(MultipartFile image, int idPublicite) throws IOException;
    void deletePublicite(int id);

    public List<Publicite> FilterPublicite( String Sponsor, float MaxBudget, float MinBudget);

    Publicite retrievePublicite(int id);
}
