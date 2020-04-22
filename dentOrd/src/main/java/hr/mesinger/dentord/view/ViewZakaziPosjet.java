/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.mesinger.dentord.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import hr.mesinger.dentord.controller.ObradaPacijent;
import hr.mesinger.dentord.controller.ObradaPosjet;
import hr.mesinger.dentord.controller.ObradaProstorija;
import hr.mesinger.dentord.controller.ObradaStomatolog;
import hr.mesinger.dentord.model.MedicinskaSestra;
import hr.mesinger.dentord.model.Pacijent;
import hr.mesinger.dentord.model.Posjet;
import hr.mesinger.dentord.model.Prostorija;
import hr.mesinger.dentord.model.Stomatolog;
import hr.mesinger.dentord.util.EdunovaException;
import hr.mesinger.dentord.util.Pomocno;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Locale;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Zvonimir
 */
public class ViewZakaziPosjet extends javax.swing.JFrame {
    
    private final ObradaPosjet obrada;
    
    /**
     * Creates new form ViewZakaziPosjet
     */
    public ViewZakaziPosjet() {
        initComponents();
        obrada = new ObradaPosjet();
        postInitComponents();
        
        ucitajStomatologe();
        ucitajPacijente();
        ucitajProstorije();
        
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr","HR"));
        dps.setFormatForDatesCommonEra("dd.MM.yyyy.");
        dpDatumPocetka.setSettings(dps);
        
        
        
    }
    
     private void postInitComponents() {
        setTitle("Posjet - " + Pomocno.LOGIRAN.getPrezime());
        ucitaj();
    }
    
    private void ucitaj() {
       DefaultListModel<Posjet> m = new DefaultListModel<>();
        obrada.getPodaci().forEach(s -> m.addElement(s));
        lstPodaci.setModel(m);
        
    }

    private void postaviVrijednosti() {
        
        txtareaRazlog.setText(obrada.getEntitet().getRazlog());
        txtPredvidenoTrajanje.setText(Pomocno.getFormatDecimalniBroj(obrada.getEntitet().getPredvidenoTrajanje()));
        postaviStomatolog();
        postaviPacijenta();
        postaviProstoriju();
        if(obrada.getEntitet().getPocetak()==null){
            dpDatumPocetka.setDate(null);
        }else{
            dpDatumPocetka.setDate(Pomocno.convertToLocalDateViaInstant(obrada.getEntitet().getPocetak()));
        }
        
        
    }

    private void ucitajVrijednosti() {
        obrada.getEntitet().setRazlog(txtareaRazlog.getText());
        obrada.getEntitet().setPredvidenoTrajanje(Pomocno.getDecimalniBrojIzStringa(txtPredvidenoTrajanje.getText()));
        obrada.getEntitet().setProstorija(cmbProstorija.getModel().getElementAt(cmbProstorija.getSelectedIndex()));
        obrada.getEntitet().setPacijent(cmbPacijent.getModel().getElementAt(cmbPacijent.getSelectedIndex()));
        obrada.getEntitet().setStomatolog(cmbStomatolog.getModel().getElementAt(cmbStomatolog.getSelectedIndex()));  
     
        if(dpDatumPocetka.getDate()!=null){
            Date d = Pomocno.convertToDateViaInstant(dpDatumPocetka.getDate());
            obrada.getEntitet().setPocetak(d);
        }
        
 
    }
    private void postaviStomatolog() {
        ComboBoxModel<Stomatolog> m = cmbStomatolog.getModel();
        for (int i = 0; i < m.getSize(); i++) {
            if (m.getElementAt(i).getId().equals(
                    obrada.getEntitet().getStomatolog().getId())) {
                cmbStomatolog.setSelectedIndex(i);
                break;
            }   
        }
    }
    private void postaviProstoriju() {
        ComboBoxModel<Prostorija> m = cmbProstorija.getModel();
        for (int i = 0; i < m.getSize(); i++) {
            if (m.getElementAt(i).getId().equals(
                    obrada.getEntitet().getProstorija().getId())) {
                cmbProstorija.setSelectedIndex(i);
                break;
            }   
        }
    }
    private void postaviPacijenta() {
        ComboBoxModel<Pacijent> m = cmbPacijent.getModel();
        for (int i = 0; i < m.getSize(); i++) {
            if (m.getElementAt(i).getId().equals(
                    obrada.getEntitet().getPacijent().getId())) {
                cmbPacijent.setSelectedIndex(i);
                break;
            }   
        }
    }
    
    private void ucitajStomatologe(){
        DefaultComboBoxModel<Stomatolog> m = new DefaultComboBoxModel<>();
         new ObradaStomatolog().getPodaci().forEach(p->m.addElement(p));
            cmbStomatolog.setModel(m);
    }

    private void ucitajProstorije(){
        DefaultComboBoxModel<Prostorija> m = new DefaultComboBoxModel<>();
         new ObradaProstorija().getPodaci().forEach(p->m.addElement(p));
            cmbProstorija.setModel(m);
    }
    private void ucitajPacijente(){
        DefaultComboBoxModel<Pacijent> m = new DefaultComboBoxModel<>();
         new ObradaPacijent().getPodaci().forEach(p->m.addElement(p));
            cmbPacijent.setModel(m);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        txtPredvidenoTrajanje = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPromijeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbProstorija = new javax.swing.JComboBox<>();
        cmbStomatolog = new javax.swing.JComboBox<>();
        cmbPacijent = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareaRazlog = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        dpDatumPocetka = new com.github.lgooddatepicker.components.DatePicker();
        btnPovratakUPosjet = new javax.swing.JButton();
        btnPovratak = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        btnDodaj.setText("Zakaži");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel1.setText("Razlog");

        btnPromijeni.setText("Promijeni");
        btnPromijeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromijeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel2.setText("Prostorija");

        jLabel3.setText("Stomatolog");

        jLabel4.setText("Pacijent");

        jLabel5.setText("Predviđeno trajanje");

        txtareaRazlog.setColumns(20);
        txtareaRazlog.setRows(5);
        jScrollPane2.setViewportView(txtareaRazlog);

        jLabel6.setText("Datum");

        btnPovratakUPosjet.setText("Povratak u posjet");
        btnPovratakUPosjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPovratakUPosjetActionPerformed(evt);
            }
        });

        btnPovratak.setText("Povratak u izbornik");
        btnPovratak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPovratakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(cmbPacijent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProstorija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPredvidenoTrajanje)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPromijeni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnObrisi))
                            .addComponent(cmbStomatolog, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(dpDatumPocetka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnPovratak, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPovratakUPosjet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbProstorija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbStomatolog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPacijent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPredvidenoTrajanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromijeni)
                            .addComponent(btnObrisi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPovratakUPosjet, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPovratak, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        obrada.setEntitet(lstPodaci.getSelectedValue());
        if (obrada.getEntitet() == null) {
            return;
        }
        postaviVrijednosti();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            obrada.setEntitet(new Posjet());
            ucitajVrijednosti();
            obrada.create();
            ucitaj();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(null, ex.getPoruka());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromijeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromijeniActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }

        ucitajVrijednosti();
        try {
            obrada.update();
            ucitaj();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
    }//GEN-LAST:event_btnPromijeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(null, "Prvo odaberite stavku");
            return;
        }
        try {
            obrada.delete();
            ucitaj();
        } catch (EdunovaException e) {
            JOptionPane.showMessageDialog(null, e.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPovratakUPosjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPovratakUPosjetActionPerformed
        new ViewPosjet().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPovratakUPosjetActionPerformed

    private void btnPovratakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPovratakActionPerformed
        new Izbornik().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPovratakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPovratak;
    private javax.swing.JButton btnPovratakUPosjet;
    private javax.swing.JButton btnPromijeni;
    private javax.swing.JComboBox<Pacijent> cmbPacijent;
    private javax.swing.JComboBox<Prostorija> cmbProstorija;
    private javax.swing.JComboBox<Stomatolog> cmbStomatolog;
    private com.github.lgooddatepicker.components.DatePicker dpDatumPocetka;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Posjet> lstPodaci;
    private javax.swing.JTextField txtPredvidenoTrajanje;
    private javax.swing.JTextArea txtareaRazlog;
    // End of variables declaration//GEN-END:variables
}
