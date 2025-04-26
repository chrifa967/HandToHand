package org.example.handtohand.controllers;

import org.example.handtohand.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.handtohand.services.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/envoyer")
    public ResponseEntity<?> envoyerMessage(@RequestBody MessageDTO dto) {
        return ResponseEntity.ok(messageService.envoyerMessage(dto.getEnvoyeurId(), dto.getRecepteurId(), dto.getMessage()));
    }

    @GetMapping("/recus/{utilisateurId}")
    public ResponseEntity<?> getMessagesRecus(@PathVariable int utilisateurId) {
        return ResponseEntity.ok(messageService.getMessagesRecus(utilisateurId));
    }

    @GetMapping("/envoyes/{utilisateurId}")
    public ResponseEntity<?> getMessagesEnvoyes(@PathVariable int utilisateurId) {
        return ResponseEntity.ok(messageService.getMessagesEnvoyes(utilisateurId));
    }

    @GetMapping("/conversation")
    public ResponseEntity<?> getConversation(
            @RequestParam int utilisateurId,
            @RequestParam int autreUtilisateurId) {
        return ResponseEntity.ok(messageService.getConversation(utilisateurId, autreUtilisateurId));
    }

    @PutMapping("/{messageId}/lu")
    public ResponseEntity<?> marquerCommeLu(
            @PathVariable int messageId,
            @RequestParam int utilisateurId) {
        return ResponseEntity.ok(messageService.marquerCommeLu(messageId, utilisateurId));
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<?> supprimerMessage(
            @PathVariable int messageId,
            @RequestParam int utilisateurId) {
        messageService.supprimerMessage(messageId, utilisateurId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/non-lus/{utilisateurId}")
    public ResponseEntity<?> compterMessagesNonLus(@PathVariable int utilisateurId) {
        return ResponseEntity.ok(messageService.compterMessagesNonLus(utilisateurId));
    }
}