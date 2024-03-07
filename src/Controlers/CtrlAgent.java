package Controlers;

import Entities.Activite;
import Entities.Agent;
import Entities.AgentPresent;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlAgent {
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlAgent() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Agent> getAllAgentsNonInscrits(String idFormation)
    {
        ArrayList<Agent> lesAgents = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("SELECT agent.code,agent.nom,agent.prenom\n" +
                    "from agent\n" +
                    "WHERE agent.code not in (\n" +
                    "SELECT inscription.codeAgent\n" +
                    "from inscription\n" +
                    "where inscription.numeroFormation = ?)");

            ps.setString(1,idFormation);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Agent agent = new Agent(rs.getString("code"),rs.getString("nom"),rs.getString("prenom"));
                lesAgents.add(agent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lesAgents;
    }

    public ArrayList<AgentPresent> getAllAgentsPresents(String numFormation)
    {
        ArrayList<AgentPresent> lesAgents = new ArrayList<>();

        try {
            ps = cnx.prepareStatement("SELECT agent.code,agent.nom,agent.prenom,inscription.presence\n" +
                    "from agent\n" +
                    "inner join inscription on agent.code = inscription.codeAgent\n" +
                    "WHERE inscription.numeroFormation = ?");
            ps.setString(1,numFormation);
            rs = ps.executeQuery();
            while(rs.next())
            {
                AgentPresent agentPresent = new AgentPresent(rs.getString("code"),rs.getString("nom"),
                        rs.getString("prenom"),rs.getBoolean("presence"));
                lesAgents.add(agentPresent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lesAgents;
    }
}
