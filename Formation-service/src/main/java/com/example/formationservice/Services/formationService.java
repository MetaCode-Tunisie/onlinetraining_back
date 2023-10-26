package com.example.formationservice.Services;

import com.example.formationservice.Entites.Notification;
import com.example.formationservice.Entites.categorie;
import com.example.formationservice.Entites.formation;
import com.example.formationservice.Repository.NotificationRepository;
import com.example.formationservice.Repository.categorieRepository;
import com.example.formationservice.Repository.formationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
public class formationService implements IformationService {

    formationRepository formationRepository;
    categorieRepository categorieRepository;
    NotificationRepository notificationRepository;
    notificationService notificationService;

    @Override
    public formation ajouterformation(Long idcategorie, MultipartFile image, String NomFomation, float prix, int duree) throws IOException {
        formation formation= new formation();
        categorie categorie = categorieRepository.findById(idcategorie).orElse(null);
        String filename = StringUtils.cleanPath(image.getOriginalFilename());
        if (filename.contains("..")) {
            System.out.println("!!! Not a valid File");
        }
        formation.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        formation.setNomFormation(NomFomation);
        formation.setPrix(prix);
        formation.setDuree(duree);
        formation.setCategorie(categorie);
        return formationRepository.save(formation);
    }

    @Override
    public formation addFormationWithCategory(Long idCategorie, formation formation) {
        categorie categorie = categorieRepository.findById(idCategorie)
                .orElseThrow(() -> new EntityNotFoundException("categorie avec id" + idCategorie + "not found"));

        formation.setCategorie(categorie);

        formationRepository.save(formation);
        Notification notification = new Notification();
        notification.setMessage("Nouvelle formation ajoutée : " + formation.getNomFormation());
        notificationService.sendNotification(notification);

        return formation;
    }

    @Override
    public List<formation> displayFormation() {
        return formationRepository.findAll();
    }

    @Override
    public formation updateFormation(formation formation) {
        if (formation.getIdformation() == null){
            throw new IllegalArgumentException("L'identifiant de formation est requis pour la mise à jour.");


        }

        return formationRepository.save(formation);

    }
    @Override
    public void deleteFormation(Long idformation) {
        formationRepository.deleteById(idformation);
    }
    @Override
    public List<formation> rechercherFormationsParFiltres(String nomCategorie, String nomFormation, Float prixMin, Float prixMax, Integer dureeMin, Integer dureeMax) {
        return formationRepository.rechercherParFiltres(nomCategorie, nomFormation, prixMin, prixMax, dureeMin, dureeMax);
    }
}
