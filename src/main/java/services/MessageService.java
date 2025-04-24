package services;

import entities.MessagePrive;
import entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MessagePriveRepository;
import repositories.UtilisateurRepository;

@Service
public class MessageService {
    @Autowired
    private MessagePriveRepository messageRepo;

    @Autowired
    private UtilisateurRepository utilisateurRepo;

    public MessagePrive envoyerMessage(int envoyeurId, int recepteurId, String contenu ){

        Utilisateur envoyeur = utilisateurRepo.findByEmail(envoyeurId).orElseThrow();
        Utilisateur recepteur = utilisateurRepo.findByEmail(email).orElseThrow();
    }

}
