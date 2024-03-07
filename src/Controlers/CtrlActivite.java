package Controlers;

import Entities.Activite;
import Tools.ConnexionBDD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlActivite {

    // cet objet permet de récupérer les infos (serveur + nom de la BDD + user + pwd)
    private Connection cnx;
    // cet objet permet d'écrire la RQT SQL
    private PreparedStatement ps;
    // Cet objet permet de récupérer le jeu d'enregistrements de la RQT
    private ResultSet rs;

    public CtrlActivite() {
        cnx = ConnexionBDD.getCnx();
    }

    // Permet de récupérer toutes les activités
    public ArrayList<Activite> getAllActivites()  {
        ArrayList<Activite> lesActivites = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("SELECT activite.numero,activite.libelle\n" +
                    "from activite");
            rs = ps.executeQuery();

            while (rs.next())
            {
                Activite activite = new Activite(rs.getInt(1),rs.getString("libelle"));
                lesActivites.add(activite);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erreur SQL pour les activités");
        }

        return lesActivites;
    }
}
