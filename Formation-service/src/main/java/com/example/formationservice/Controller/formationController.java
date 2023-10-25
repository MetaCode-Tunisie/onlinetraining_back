package com.example.formationservice.Controller;

import com.example.formationservice.Entites.formation;
import com.example.formationservice.Services.IformationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class formationController {
    IformationService fomationService;

    @PostMapping(path = "/admin/ajouterFormation/{idcategorie}/{NomFomation}/{prix}/{duree}" ,consumes = {MULTIPART_FORM_DATA_VALUE  })
    public formation ajouterformation(@PathVariable Long idcategorie, @RequestParam MultipartFile image, @PathVariable String NomFomation , @PathVariable float prix , @PathVariable int duree) throws IOException {
        return fomationService.ajouterformation(idcategorie,image,NomFomation,prix,duree);

    }





    @GetMapping("/display")
    public List<formation> displayFormation(){
        return fomationService.displayFormation();
    }
@PutMapping("/admin/updateFormation")
    formation updateFormation(@RequestBody formation formation){
        return fomationService.updateFormation(formation);
}
@DeleteMapping("/admin/deleteFormation/{idformation}")
    void deleteFormation(@PathVariable Long idformation){
        fomationService.deleteFormation(idformation);
}
    @GetMapping("/user/recherche")
    public ResponseEntity<List<formation>> rechercherFormations(
            @RequestParam(required = false) String nomCategorie,
            @RequestParam(required = false) String nomFormation,
            @RequestParam(required = false) Float prixMin,
            @RequestParam(required = false) Float prixMax,
            @RequestParam(required = false) Integer dureeMin,
            @RequestParam(required = false) Integer dureeMax) {

        List<formation> formations = fomationService.rechercherFormationsParFiltres(
                nomCategorie, nomFormation, prixMin, prixMax, dureeMin, dureeMax);

        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

}
