package Vues;


import Tools.ConnexionBDD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class FrmMenu extends JFrame{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblInscription;
    private JLabel lblPresence;

    public FrmMenu() throws SQLException, ClassNotFoundException {
        this.setTitle("Projet SNCF");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        ConnexionBDD bdd = new ConnexionBDD();


        ImageIcon imageIcon = new ImageIcon(
                new ImageIcon(getClass().getResource("/Images/Logo.jpg"))
                        .getImage().getScaledInstance(lblTitre.getWidth(), lblTitre.getHeight(), Image.SCALE_DEFAULT));
        lblTitre.setIcon(imageIcon);

        imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Images/Inscription.png")).getImage().getScaledInstance(lblInscription.getWidth(), lblInscription.getHeight(), Image.SCALE_DEFAULT));
        lblInscription.setIcon(imageIcon);

        imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/Images/Presence.png")).getImage().getScaledInstance(lblPresence.getWidth(), lblPresence.getHeight(), Image.SCALE_DEFAULT));
        lblPresence.setIcon(imageIcon);

        lblInscription.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                FrmInscription frm = new FrmInscription();
                frm.setVisible(true);
            }
        });
        lblPresence.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                FrmPresence frm = new FrmPresence();
                frm.setVisible(true);
            }
        });
    }
}
