package dto;

import entities.MessagePrive;

import java.time.LocalDateTime;

public class MessageDTO {
    private int id;
    private int envoyeurId;
    private String envoyeurNom;
    private int recepteurId;
    private String recepteurNom;
    private String message;
    private LocalDateTime dateEnvoi;
    private boolean vu;

    public MessageDTO() {}

    public MessageDTO(MessagePrive message) {
        this.id = message.getId();
        this.envoyeurId = message.getEnvoyeur().getId();
        this.envoyeurNom = message.getEnvoyeur().getNom() + " " + message.getEnvoyeur().getPrenom();
        this.recepteurId = message.getRecepteur().getId();
        this.recepteurNom = message.getRecepteur().getNom() + " " + message.getRecepteur().getPrenom();
        this.message = message.getMessage();
        this.dateEnvoi = message.getDateEnvoi();
        this.vu = message.isVu();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnvoyeurId() {
        return envoyeurId;
    }

    public void setEnvoyeurId(int envoyeurId) {
        this.envoyeurId = envoyeurId;
    }

    public String getEnvoyeurNom() {
        return envoyeurNom;
    }

    public void setEnvoyeurNom(String envoyeurNom) {
        this.envoyeurNom = envoyeurNom;
    }

    public int getRecepteurId() {
        return recepteurId;
    }


    public void setRecepteurId(int recepteurId) {
        this.recepteurId = recepteurId;
    }

    public String getRecepteurNom() {
        return recepteurNom;
    }

    public void setRecepteurNom(String recepteurNom) {
        this.recepteurNom = recepteurNom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public boolean isVu() {
        return vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }
}
