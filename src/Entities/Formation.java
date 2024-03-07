package Entities;

public class Formation
{
    private String idFormation;
    private String nomFormation;


    public Formation()
    {

    }
    public Formation(String unId, String unNom)
    {
        idFormation = unId;
        nomFormation = unNom;
    }

    /**
     * @return the idFormation
     */
    public String getIdFormation() {
        return idFormation;
    }

    public String getNomFormation() {
        return nomFormation;
    }
}
