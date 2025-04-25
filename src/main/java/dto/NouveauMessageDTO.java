package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NouveauMessageDTO {
    @NotNull (message =" ID employeur obligatoire")
    private int envoyeurId;

    @NotNull (message = "ID recepteur obligatoire")
    private int recepteurId;

    @NotBlank(message= "le contenu message ne peut pas ete vide")
    private String contenu;

    public NouveauMessageDTO() {}

    public NouveauMessageDTO(Integer envoyeurId, Integer recepteurId, String contenu) {
        this.envoyeurId = envoyeurId;
        this.recepteurId = recepteurId;
        this.contenu = contenu;
    }

    public Integer getEnvoyeurId() {
        return envoyeurId;
    }

    public void setEnvoyeurId(Integer envoyeurId) {
        this.envoyeurId = envoyeurId;
    }

    public Integer getRecepteurId() {
        return recepteurId;
    }

    public void setRecepteurId(Integer recepteurId) {
        this.recepteurId = recepteurId;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
