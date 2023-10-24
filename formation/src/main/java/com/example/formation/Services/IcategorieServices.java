package com.example.formation.Services;

import com.example.formation.Entites.categorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IcategorieServices {
    categorie  addCategory(categorie categorie);
    public List<categorie> displayCategorys();
    categorie updateCategorie(categorie categorie);
    void deleteCategory(Long idcategorie);

}
