package repositories;

import entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur , Integer> {

    Utilisateur findByEmail(String email);

}
