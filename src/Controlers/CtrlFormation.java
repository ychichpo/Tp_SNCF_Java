package Controlers;

import Entities.Formation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlFormation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlFormation()
    {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Formation> getFormationsByActivite(int idActivite)
    {
        ArrayList<Formation> lesFormations = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("SELECT formation.code, formation.intitule\n" +
                    "from formation\n" +
                    "WHERE formation.numeroActivite = ?");
            ps.setInt(1,idActivite);
            rs = ps.executeQuery();
            while (rs.next())
            {
                Formation formation = new Formation(rs.getString("code"),rs.getString("intitule"));
                lesFormations.add(formation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return lesFormations;
    }

    public ArrayList<Formation> getAllFormations()
    {
        ArrayList<Formation> lesFormations = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("SELECT formation.code,formation.intitule\n" +
                    "from formation");

            rs = ps.executeQuery();
            while (rs.next())
            {
                Formation formation = new Formation(rs.getString("code"),rs.getString("intitule"));
                lesFormations.add(formation);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return lesFormations;
    }
}
