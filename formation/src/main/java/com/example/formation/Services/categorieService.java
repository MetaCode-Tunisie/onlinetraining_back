package com.example.formation.Services;

import com.example.formation.Entites.categorie;
import com.example.formation.Repository.categorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
