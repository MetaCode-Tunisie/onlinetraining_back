package com.example.formationservice.Controller;

import com.example.formationservice.Entites.categorie;
import com.example.formationservice.Services.IcategorieServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class categorieController {
IcategorieServices categorieService;

@PostMapping("/admin/addCAtegorie")
public categorie addCategory(@RequestBody categorie categorie) {

    return categorieService.addCategory(categorie);
}
    @GetMapping("/displayCategory")
    List<categorie> displayCategorys(){
        return categorieService.displayCategorys();
    }
    @PutMapping("/admin/updateCategorie")
    categorie updateCategorie(@RequestBody categorie categorie){
    return categorieService.updateCategorie(categorie);
    }
@DeleteMapping("/admin/deleteCategory/{idCategory}")
void deleteCategory(@PathVariable Long idCategory){
    categorieService.deleteCategory(idCategory);
}

}
