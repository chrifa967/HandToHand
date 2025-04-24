package services;

import entities.MessagePrive;
import entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MessagePriveRepository;
import repositories.UtilisateurRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessagePriveRepository messageRepo;

    @Autowired
    private UtilisateurRepository utilisateurRepo;

    public MessagePrive envoyerMessage(int envoyeurId, int recepteurId, String contenu ){

        Utilisateur envoyeur = utilisateurRepo.findById(envoyeurId).orElseThrow();
        Utilisateur recepteur = utilisateurRepo.findById(recepteurId).orElseThrow();

        MessagePrive message = new MessagePrive();
        message.setEnvoyeur(envoyeur);
        message.setRecepteur(recepteur);
        message.setMessage(contenu);
        message.setDateEnvoi(LocalDateTime.now());
        message.setVu(false);

        return messageRepo.save(message);
    }



}
