package org.example.handtohand.repositories;

import org.example.handtohand.entities.MessagePrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessagePriveRepository extends JpaRepository<MessagePrive, Integer> {

    List<MessagePrive> findByRecepteurIdAndSupprimeIsFalseOrderByDateEnvoiDesc(int recepteurId);

    List<MessagePrive> findByEnvoyeurIdAndSupprimeIsFalseOrderByDateEnvoiDesc(int envoyeurId);

    @Query("SELECT m FROM MessagePrive m WHERE " +
            "((m.envoyeur.id = :utilisateurId AND m.recepteur.id = :autreUtilisateurId) OR " +
            "(m.envoyeur.id = :autreUtilisateurId AND m.recepteur.id = :utilisateurId)) AND " +
            "m.supprime = false ORDER BY m.dateEnvoi ASC")
    List<MessagePrive> findConversation(@Param("utilisateurId") int utilisateurId,
                                        @Param("autreUtilisateurId") int autreUtilisateurId);

    @Query("SELECT COUNT(m) FROM MessagePrive m WHERE m.recepteur.id = :utilisateurId AND m.vu = false AND m.supprime = false")
    long countNonLusParUtilisateur(@Param("utilisateurId") int utilisateurId);

}
