package org.example.handtohand.repositories;

import org.example.handtohand.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByEmail(String email);
}
