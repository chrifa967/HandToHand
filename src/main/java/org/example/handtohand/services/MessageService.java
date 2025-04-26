package org.example.handtohand.services;

import org.example.handtohand.dto.MessageDTO;
import org.example.handtohand.entities.MessagePrive;
import org.example.handtohand.entities.Utilisateur;
import org.example.handtohand.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.handtohand.repositories.MessagePriveRepository;
import org.example.handtohand.repositories.UtilisateurRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessagePriveRepository messageRepo;

    @Autowired
    private UtilisateurRepository utilisateurRepo;

    @Transactional
    public MessageDTO envoyerMessage(int envoyeurId, int recepteurId, String contenu) {
        Utilisateur envoyeur = utilisateurRepo.findById(envoyeurId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", envoyeurId));

        Utilisateur recepteur = utilisateurRepo.findById(recepteurId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", recepteurId));

        MessagePrive message = new MessagePrive();
        message.setEnvoyeur(envoyeur);
        message.setRecepteur(recepteur);
        message.setMessage(contenu);
        message.setDateEnvoi(LocalDateTime.now());
        message.setVu(false);
        message.setSupprime(false);

        return new MessageDTO(messageRepo.save(message));
    }

    public List<MessageDTO> getMessagesRecus(int utilisateurId) {
        verifierUtilisateur(utilisateurId);
        return messageRepo.findByRecepteurIdAndSupprimeIsFalseOrderByDateEnvoiDesc(utilisateurId)
                .stream().map(MessageDTO::new).collect(Collectors.toList());
    }

    public List<MessageDTO> getMessagesEnvoyes(int utilisateurId) {
        verifierUtilisateur(utilisateurId);
        return messageRepo.findByEnvoyeurIdAndSupprimeIsFalseOrderByDateEnvoiDesc(utilisateurId)
                .stream().map(MessageDTO::new).collect(Collectors.toList());
    }

    public List<MessageDTO> getConversation(int utilisateurId, int autreUtilisateurId) {
        verifierUtilisateur(utilisateurId);
        verifierUtilisateur(autreUtilisateurId);
        return messageRepo.findConversation(utilisateurId, autreUtilisateurId)
                .stream().map(MessageDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public MessageDTO marquerCommeLu(int messageId, int utilisateurId) {
        MessagePrive message = messageRepo.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message", "id", messageId));

        if (message.getRecepteur().getId() != utilisateurId) {
            throw new IllegalArgumentException("Non autorisé à marquer ce message comme lu");
        }

        message.setVu(true);
        return new MessageDTO(messageRepo.save(message));
    }

    @Transactional
    public void marquerConversationCommeLue(int utilisateurId, int autreUtilisateurId) {
        List<MessagePrive> messages = messageRepo.findConversation(utilisateurId, autreUtilisateurId);
        for (MessagePrive message : messages) {
            if (message.getRecepteur().getId() == utilisateurId && !message.isVu()) {
                message.setVu(true);
                messageRepo.save(message);
            }
        }
    }

    @Transactional
    public void supprimerMessage(int messageId, int utilisateurId) {
        MessagePrive message = messageRepo.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message", "id", messageId));

        if (message.getEnvoyeur().getId() != utilisateurId && message.getRecepteur().getId() != utilisateurId) {
            throw new IllegalArgumentException("Non autorisé à supprimer ce message");
        }

        message.setSupprime(true);
        messageRepo.save(message);
    }

    public long compterMessagesNonLus(int utilisateurId) {
        verifierUtilisateur(utilisateurId);
        return messageRepo.countNonLusParUtilisateur(utilisateurId);
    }

    private void verifierUtilisateur(int utilisateurId) {
        if (!utilisateurRepo.existsById(utilisateurId)) {
            throw new ResourceNotFoundException("Utilisateur", "id", utilisateurId);
        }
    }
}
