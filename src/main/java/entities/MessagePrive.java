package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class MessagePrive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "envoyeur_id")
     private Utilisateur envoyeur;

    @ManyToOne
    @JoinColumn(name = "recepteur_id")
    private Utilisateur recepteur;


    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime dateEnvoi;
    private boolean vu = false;
    private boolean supprime = false;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getEnvoyeur() {
        return envoyeur;
    }

    public void setEnvoyeur(Utilisateur envoyeur) {
        this.envoyeur = envoyeur;
    }

    public Utilisateur getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Utilisateur recepteur) {
        this.recepteur = recepteur;
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

    public MessagePrive() {

    }

    public boolean isSupprime() {
        return supprime;
    }

    public void setSupprime(boolean supprime) {
        this.supprime = supprime;
    }



    public MessagePrive(Utilisateur envoyeur, Utilisateur recepteur, String message) {
        this.envoyeur = envoyeur;
        this.recepteur = recepteur;
        this.message = message;
        this.dateEnvoi = LocalDateTime.now();
        this.vu = false;
        this.supprime = false;
    }
}
