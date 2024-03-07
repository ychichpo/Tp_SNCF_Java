package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlInscription
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlInscription()
    {
        cnx = ConnexionBDD.getCnx();
    }


    public void InsererInscription(String codeFormation, String codeAgent)
    {
        try {
            ps = cnx.prepareStatement("insert into inscription values(?,?,0)");
            ps.setString(1,codeFormation);
            ps.setString(2,codeAgent);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void ModifierInscription(String numForm,String numAgent, boolean present)
    {
        try {
            ps = cnx.prepareStatement("update inscription set presence = ? where numeroFormation = ? and codeAgent = ?");
            ps.setBoolean(1,present);
            ps.setString(2,numForm);
            ps.setString(3,numAgent);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
