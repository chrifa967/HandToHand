package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.MessageService;

@RestController
@RequestMapping("/api/messages")

public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/envoyer")

    public ResponseEntity<?> envoyerMessage(@RequestBody MessageDto dto) {
        return ResponseEntity.ok(messageService.envoyerMessage(dto.getEnvoyeurId(), dto.getRecepteurId(), dto.getMessage()));
    }


}
