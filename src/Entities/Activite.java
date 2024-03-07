package Entities;

public class Activite
{
    private int idActivite;
    private String nomActivite;

    public Activite()
    {

    }
    public Activite(int unId, String unNom)
    {
        idActivite = unId;
        nomActivite = unNom;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public String getNomActivite() {
        return nomActivite;
    }
}
