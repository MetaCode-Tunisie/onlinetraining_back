package com.example.formationservice.Services;

import com.example.formationservice.Entites.categorie;

import java.util.List;


public interface IcategorieServices {
    categorie  addCategory(categorie categorie);
    public List<categorie> displayCategorys();
    categorie updateCategorie(categorie categorie);
    void deleteCategory(Long idcategorie);

}
