/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms.termin;

import communication.Communication;
import constants.ClientConstants;
import controller.Controller;
import domain.Clan;
import domain.Grupa;
import domain.Termin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kristina
 */
public class TerminForm extends javax.swing.JDialog {

    private PretraziTermine pt;

    /**
     * Creates new form TerminForm
     */
    public TerminForm(java.awt.Frame parent, boolean modal, PretraziTermine pt) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.pt = pt;
        popuniCombo();
        popuniVreme();
        popuniFormu();
        popuniClanove();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbGrupe = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtDatum = new javax.swing.JTextField();
        btnIzmeni = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbVreme = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("id");

        jLabel2.setText("grupa");

        cmbGrupe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("datum");

        btnIzmeni.setText("izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel4.setText("vreme");

        cmbVreme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj))
                    .addComponent(txtId)
                    .addComponent(cmbGrupe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDatum)
                    .addComponent(cmbVreme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbGrupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbVreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnSacuvaj))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        // TODO add your handling code here:
        Grupa grupa = (Grupa) cmbGrupe.getSelectedItem();
        try {
            Long id = Long.valueOf(txtId.getText());
            if (txtDatum.getText().isEmpty() || cmbVreme.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Sva polja moraju da budu popunjena","", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Date datume = ClientConstants.SDFDATUM.parse(txtDatum.getText());
            String vreme = (String) cmbVreme.getSelectedItem();
            Termin termin = new Termin(id, grupa, datume, vreme);
            Communication.getInstance().updateTermin(termin);
            JOptionPane.showMessageDialog(this, "Sistem je sacuvao termin");
            pt.osveziFormu(grupa);
            txtDatum.setEnabled(false);
            cmbGrupe.setEnabled(false);
            cmbVreme.setEnabled(false);
            btnSacuvaj.setEnabled(false);
            btnIzmeni.setEnabled(true);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            // Logger.getLogger(TerminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(TerminForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        // TODO add your handling code here:
        btnSacuvaj.setEnabled(true);
        btnIzmeni.setEnabled(false);
        txtDatum.setEnabled(true);
        //cmbGrupe.setEnabled(true);
        cmbVreme.setEnabled(true);
    }//GEN-LAST:event_btnIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbGrupe;
    private javax.swing.JComboBox<String> cmbVreme;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables

    private void popuniFormu() {
        JOptionPane.showMessageDialog(this, "Sistem je ucitao termin");
        Termin termin = Controller.getInstance().getTermin();
        txtId.setText(termin.getId() + "");
        txtDatum.setText(ClientConstants.SDFDATUM.format(termin.getDatum()) + "");
        cmbGrupe.setSelectedItem(termin.getGrupa());
        cmbVreme.setSelectedItem(termin.getVreme());
        txtId.setEnabled(false);
        txtDatum.setEnabled(false);
        cmbGrupe.setEnabled(false);
        cmbVreme.setEnabled(false);
        btnSacuvaj.setEnabled(false);
    }

    private void popuniCombo() {
        try {
            cmbGrupe.removeAllItems();
            List<Grupa> grupe = Communication.getInstance().vratiGrupe();
            for (Grupa grupa : grupe) {
                cmbGrupe.addItem(grupa);
            }
            cmbGrupe.setSelectedIndex(-1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            //Logger.getLogger(AddTerminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniVreme() {
        List<String> vremena = Controller.getInstance().getVremeTermina();
        cmbVreme.removeAllItems();
        for (String vreme : vremena) {
            cmbVreme.addItem(vreme);
        }
        cmbVreme.setSelectedIndex(-1);
    }

    private void popuniClanove() throws Exception {
        System.out.println("dosao do combo");
        List<Clan> clanovi=Communication.getInstance().vratiClanove1(Controller.getInstance().getTermin());
        System.out.println(Controller.getInstance().getTermin());
        jComboBox1.removeAllItems();
        for (Clan clan : clanovi) {
            jComboBox1.addItem(clan);
        }
        
        
    }
}
