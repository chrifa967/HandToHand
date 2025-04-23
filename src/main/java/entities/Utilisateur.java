package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String pswd;

    @OneToMany(mappedBy = "envoyeur")
    private List<MessagePrive> messagesEnvoyes;

    @OneToMany(mappedBy = "recepteur")
    private List<MessagePrive> messagesRecus;

    public Utilisateur(int id, String nom, String prenom, String email, String pswd, List<MessagePrive> messagesEnvoyes, List<MessagePrive> messagesRecus) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pswd = pswd;
        this.messagesEnvoyes = messagesEnvoyes;
        this.messagesRecus = messagesRecus;
    }

    public Utilisateur() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public List<MessagePrive> getMessagesEnvoyes() {
        return messagesEnvoyes;
    }

    public void setMessagesEnvoyes(List<MessagePrive> messagesEnvoyes) {
        this.messagesEnvoyes = messagesEnvoyes;
    }

    public List<MessagePrive> getMessagesRecus() {
        return messagesRecus;
    }

    public void setMessagesRecus(List<MessagePrive> messagesRecus) {
        this.messagesRecus = messagesRecus;
    }




}
