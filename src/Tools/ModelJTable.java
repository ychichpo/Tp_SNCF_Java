package Tools;

import Entities.Activite;
import Entities.Agent;
import Entities.AgentPresent;
import Entities.Formation;

import javax.swing.table.AbstractTableModel;
import java.text.Normalizer;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel {
    private String[] nomsColonnes;
    private Object[][] rows;

    @Override
    public String getColumnName(int column) {
        return nomsColonnes[column];
    }

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        rows[row][column] = value;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        if (columnIndex == 3) {
            return Boolean.class;
        }
        return super.getColumnClass(columnIndex);


    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3 ;
    }

    public void LoadDatasActivites(ArrayList<Activite> lesActivites)
    {
        nomsColonnes = new String[]{"Numéro","Libellé"};
        rows = new Object[lesActivites.size()][2];
        int i = 0;
        for (Activite act : lesActivites)
        {
            rows[i][0] = act.getIdActivite();
            rows[i][1] = act.getNomActivite();
            i++;
        }
        // Mettre à jour le JTABLE
        fireTableChanged(null);
    }
    public void LoadDatasFormations(ArrayList<Formation> lesFormations)
    {
        nomsColonnes = new String[]{"Code","Intitulé"};
        rows = new Object[lesFormations.size()][2];
        int i = 0;
        for (Formation form : lesFormations)
        {
            rows[i][0] = form.getIdFormation();
            rows[i][1] = form.getNomFormation();
            i++;
        }
        // Mettre à jour le JTABLE
        fireTableChanged(null);
    }
    public void LoadDatasAgents(ArrayList<Agent> lesAgents)
    {
        nomsColonnes = new String[]{"Code","Nom","Prénom"};
        rows = new Object[lesAgents.size()][3];
        int i = 0;
        for (Agent agt : lesAgents)
        {
            rows[i][0] = agt.getIdAgent();
            rows[i][1] = agt.getNomAgent();
            rows[i][2] = agt.getPrenomAgent();
            i++;
        }
        // Mettre à jour le JTABLE
        fireTableChanged(null);
    }
    public void LoadDatasAgentsPresents(ArrayList<AgentPresent> lesAgents)
    {
        nomsColonnes = new String[]{"Code","Nom","Prénom","Présence"};
        rows = new Object[lesAgents.size()][4];
        int i = 0;
        for (AgentPresent agt : lesAgents)
        {
            rows[i][0] = agt.getIdAgent();
            rows[i][1] = agt.getNomAgent();
            rows[i][2] = agt.getPrenomAgent();
            rows[i][3] = agt.isPresence();
            i++;
        }
        // Mettre à jour le JTABLE
        fireTableChanged(null);
    }

}
