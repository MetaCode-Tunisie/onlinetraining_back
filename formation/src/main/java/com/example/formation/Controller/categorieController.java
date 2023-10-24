package com.example.formation.Controller;

import com.example.formation.Entites.categorie;
import com.example.formation.Services.IcategorieServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class categorieController {
IcategorieServices categorieService;

@PostMapping("/addCAtegorie")
public categorie addCategory(@RequestBody categorie categorie) {

    return categorieService.addCategory(categorie);
}
    @GetMapping("/displayCategory")
    List<categorie> displayCategorys(){
        return categorieService.displayCategorys();
    }
    @PutMapping("/updateCategorie")
    categorie updateCategorie(@RequestBody categorie categorie){
    return categorieService.updateCategorie(categorie);
    }
@DeleteMapping("/deleteCategory/{idCategory}")
void deleteCategory(@PathVariable Long idCategory){
    categorieService.deleteCategory(idCategory);
}

}
