package Entities;

public class Agent
{
    private String idAgent;
    private String nomAgent;
    private String prenomAgent;

    public Agent()
    {

    }
    public Agent(String unId, String unNom, String unPrenom)
    {
        idAgent = unId;
        nomAgent = unNom;
        prenomAgent = unPrenom;
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
}
