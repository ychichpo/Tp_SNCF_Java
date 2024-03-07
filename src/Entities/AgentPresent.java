package Entities;

public class AgentPresent
{
    private String idAgent;
    private String nomAgent;
    private String prenomAgent;
    private boolean presence;
    public AgentPresent()
    {

    }
    public AgentPresent(String unId, String unNom, String unPrenom, boolean estPresent)
    {
        idAgent = unId;
        nomAgent = unNom;
        prenomAgent = unPrenom;
        presence = estPresent;
    }

    public String getIdAgent() {
        return idAgent;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public String getPrenomAgent() {
        return prenomAgent;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }
}
