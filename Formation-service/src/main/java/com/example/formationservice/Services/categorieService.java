package com.example.formationservice.Services;

import com.example.formationservice.Entites.categorie;
import com.example.formationservice.Repository.categorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class categorieService implements IcategorieServices {

categorieRepository categorieRepository;
    @Override
    public categorie addCategory(categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<categorie> displayCategorys() {
        return categorieRepository.findAll();
    }

    @Override
    public categorie updateCategorie(categorie categorie) {
        if (categorie.getIdcategorie() == null) {
            throw new IllegalArgumentException("L'identifiant de la catégorie est requis pour la mise à jour.");
        }
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategory(Long idcategorie) {
categorieRepository.deleteById(idcategorie);
    }




}
