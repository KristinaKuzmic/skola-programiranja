/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms.predavac;

import communication.Communication;
import constants.ClientConstants;
import controller.Controller;
import domain.Predavac;
import forms.models.ModelTabelePredavac;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Kristina
 */
public class PredavacForm extends javax.swing.JDialog {

    private int operacija;
    private PretraziPredavacaForm ppf;

    /**
     * Creates new form PredavacForm
     */
    public PredavacForm(java.awt.Frame parent, boolean modal, int operacija, PretraziPredavacaForm ppf) {

        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.operacija = operacija;
        this.ppf=ppf;
        popuniFormu();
        
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
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ime");

        jLabel2.setText("prezime");

        btnSacuvaj.setText("sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnObrisi.setText("obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnObrisi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj))
                    .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnObrisi))
                .addContainerGap(17, Short.MAX_VALUE))
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
        try {
            // TODO add your handling code here:
            String ime = txtIme.getText().trim();
            String prezime = txtPrezime.getText().trim();
            if(ime.isEmpty() || prezime.isEmpty()){
                JOptionPane.showMessageDialog(this, "Sva polja moraju da budu popunjena!","", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Predavac predavac = new Predavac(-1l, ime, prezime);
            Communication.getInstance().addPredavac(predavac);
            JOptionPane.showMessageDialog(this, "Sistem je sacuvao predavaca");
            int odgovor=JOptionPane.showConfirmDialog(this, "Da li zelite da dodate jos predavaca?","DODAVANJE PREDAVACA",JOptionPane.YES_NO_OPTION);
            if(odgovor==JOptionPane.YES_OPTION){
                txtIme.setText("");
                txtPrezime.setText("");
            }else{
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"",JOptionPane.ERROR_MESSAGE);
            // Logger.getLogger(PredavacForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
        int odgovor = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da obrisete predavaca?", "BRISANJE", JOptionPane.YES_NO_OPTION);
        if(odgovor==JOptionPane.YES_OPTION){
            try {
                Communication.getInstance().deletePredavac(Controller.getInstance().getPredavac());
                JOptionPane.showMessageDialog(this, "Sistem je obrisao predavaca");
                ppf.osveziFormu(Controller.getInstance().getPredavac().getIme());
                Controller.getInstance().setPredavac(null);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),"",JOptionPane.ERROR_MESSAGE);
                //Logger.getLogger(PredavacForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
           
        }
    }//GEN-LAST:event_btnObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void popuniFormu() {
        switch (operacija) {
            case ClientConstants.KREIRAJ:
                btnObrisi.setEnabled(false);
                break;
            case ClientConstants.OBRISI:
                JOptionPane.showMessageDialog(this, "Sistem je ucitao predavaca");
                Predavac p = Controller.getInstance().getPredavac();
                txtIme.setText(p.getIme());
                txtPrezime.setText(p.getPrezime());
                txtIme.setEnabled(false);
                txtPrezime.setEnabled(false);
                btnSacuvaj.setEnabled(false);
                break;
            default:
                throw new AssertionError();
        }
    }
}
