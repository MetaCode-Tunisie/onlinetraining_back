package com.example.formationservice.Services;

import com.example.formationservice.Entites.formation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IformationService {
    public formation ajouterformation(Long idcategorie, MultipartFile image, String NomFomation , float prix , int duree) throws IOException;
    public formation addFormationWithCategory(Long idCategorie, formation formation);
    public List<formation> displayFormation();
    formation updateFormation(formation formation);
    public void deleteFormation(Long idformation);
    public List<formation> rechercherFormationsParFiltres(String nomCategorie, String nomFormation, Float prixMin, Float prixMax, Integer dureeMin, Integer dureeMax);
}
