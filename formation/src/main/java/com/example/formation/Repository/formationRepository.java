package com.example.formation.Repository;

import com.example.formation.Entites.formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface formationRepository extends JpaRepository<formation,Long> {
    @Query("SELECT f FROM formation f WHERE (:nomCategorie IS NULL OR f.categorie.NomCategorie LIKE %:nomCategorie%) " +
            "AND (:nomFormation IS NULL OR f.NomFormation LIKE %:nomFormation%) " +
            "AND (:prixMin IS NULL OR f.prix >= :prixMin) " +
            "AND (:prixMax IS NULL OR f.prix <= :prixMax) " +
            "AND (:dureeMin IS NULL OR f.duree >= :dureeMin) " +
            "AND (:dureeMax IS NULL OR f.duree <= :dureeMax)")
    List<formation> rechercherParFiltres(@Param("nomCategorie") String nomCategorie,
                                         @Param("nomFormation") String nomFormation,
                                         @Param("prixMin") Float prixMin,
                                         @Param("prixMax") Float prixMax,
                                         @Param("dureeMin") Integer dureeMin,
                                         @Param("dureeMax") Integer dureeMax);

}
