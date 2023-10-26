package com.example.khalil.controllers;
import com.example.khalil.entities.Publicite;

import com.example.khalil.services.Iservices.IPubliciteService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class PubliciteController {
    IPubliciteService PubliciteService;

    @GetMapping("/user/publicite")
    public List<Publicite> retrieveAllPublicite() {
        return  PubliciteService.retrieveAllPublicites();
    }

    @PostMapping(path="/admin/addpublicite/{idsponsor}",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE   })
    public Publicite addPublicite(@RequestParam MultipartFile file,  @RequestParam String description,@RequestParam float prix,@PathVariable int idsponsor) throws IOException {
        return PubliciteService.addPublicite( file ,description,prix,idsponsor);
    }
    @PutMapping(path="/admin/update/{description}/{prix}/{idPublicite}/{idsponsor}")
    public Publicite updatePublicite(  @PathVariable String description,@PathVariable float prix,@PathVariable int idPublicite,@PathVariable int idsponsor) {
        return PubliciteService.updatePublicite(description,prix,idPublicite,idsponsor);
    }

    @PutMapping(path="/admin/updateImage/{idPublicite}",consumes = {MULTIPART_FORM_DATA_VALUE   })
    public Publicite updatePubliciteimage(@RequestParam MultipartFile file,@PathVariable int idPublicite) throws IOException {
        return PubliciteService.updatePubliciteimage(file ,idPublicite);
    }


    @DeleteMapping("/admin/publicite/{idPublicite}")
    public void deletePublicite( @PathVariable int idPublicite) {
        PubliciteService.deletePublicite(idPublicite);
    }


    @GetMapping("/admin/publicite/{idPublicite}")
    public Publicite retrievePublicite(  @PathVariable int idPublicite) {
        return PubliciteService.retrievePublicite(idPublicite);
    }
    @GetMapping("/admin/publicite/FilterPublicite")
    public List<Publicite> FilterPublicite( @RequestParam String Sponsor, @RequestParam float MaxBudget,@RequestParam float MinBudget){
        return PubliciteService.FilterPublicite(Sponsor,MaxBudget,MinBudget);
    }


}
