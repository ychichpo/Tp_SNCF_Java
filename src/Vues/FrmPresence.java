package Vues;

import Controlers.CtrlAgent;
import Controlers.CtrlFormation;
import Controlers.CtrlInscription;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrmPresence extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblFormation;
    private JLabel lblAgentsInscrits;
    private JTable tblFormations;
    private JTable tblAgentsInscrits;
    private JButton btnValider;

    ModelJTable mdl;
    CtrlFormation ctrlFormation;
    CtrlAgent ctrlAgent;
    CtrlInscription ctrlInscription;
    String numFormation;


    public FrmPresence()
    {
        this.setTitle("Présence");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);

                // A vous de jouer

                mdl = new ModelJTable();
                ctrlFormation = new CtrlFormation();
                mdl.LoadDatasFormations(ctrlFormation.getAllFormations());
                tblFormations.setModel(mdl);
            }
        });

        tblFormations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer

                mdl = new ModelJTable();
                ctrlAgent = new CtrlAgent();
                numFormation = tblFormations.getValueAt(tblFormations.getSelectedRow(),0).toString();
                mdl.LoadDatasAgentsPresents(ctrlAgent.getAllAgentsPresents(numFormation));
                tblAgentsInscrits.setModel(mdl);
            }
        });
        
        btnValider.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // A vous de jouer

                if(tblFormations.getSelectedRowCount() == 0)
                {
                    JOptionPane.showMessageDialog(null,"Veuillez sélectionner une formation,");
                }
                else if(tblAgentsInscrits.getSelectedRowCount() == 0)
                {
                    JOptionPane.showMessageDialog(null,"Veuillez sélectionner un agent");
                }
                else
                {
                    // TOUT EST OK

                    ctrlInscription = new CtrlInscription();

                    for(int i = 0 ; i < tblAgentsInscrits.getRowCount();i++)
                    {
                        ctrlInscription.ModifierInscription
                                (
                                    numFormation,
                                        tblAgentsInscrits.getValueAt(i,0).toString(),
                                       Boolean.parseBoolean( tblAgentsInscrits.getValueAt(i,3).toString())
                                );
                    }
                    JOptionPane.showMessageDialog(null,"Présences enregistrées");


                }


            }
        });
    }
}