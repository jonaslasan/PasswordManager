package hranilec.gesel;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jonas
 */
public class UrediVnosOkno extends javax.swing.JFrame {

    /**
     * Creates new form UstvariVnos
     */
    public UrediVnosOkno() {
        initComponents();
    }
    
    public void setVisible(boolean b)
    {
        posodobiPolja();
        System.out.println("visible");
        super.setVisible(b);
    }
    
    public void posodobiPolja()
    {
        Vnos vnos = UpravljalecVnosov.getInstance().getVnos(GlobalniPodatki.izbraniVnos);
        if (vnos == null)
            return;
        
        imeAplikacijeLabel.setText(vnos.imeAplikacije);
        imePolje.setText(vnos.ime);
        gesloPolje.setText(vnos.geslo);
        prikaziToggle.setSelected(false);
        prikaziToggleActionPerformed(null);
   }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        imePolje = new javax.swing.JTextField();
        PosodobiGumb = new javax.swing.JButton();
        PrekličiGumb = new javax.swing.JButton();
        IzbrisiGumb = new javax.swing.JButton();
        imeAplikacijeLabel = new javax.swing.JLabel();
        gesloPolje = new javax.swing.JPasswordField();
        prikaziToggle = new javax.swing.JCheckBox();

        setTitle("Update entry");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update entry");

        jLabel2.setText("Application:");

        jLabel3.setText("Username:");

        jLabel4.setText("Password:");

        PosodobiGumb.setText("Update");
        PosodobiGumb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PosodobiGumbActionPerformed(evt);
            }
        });

        PrekličiGumb.setText("Cancel");
        PrekličiGumb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrekličiGumbActionPerformed(evt);
            }
        });

        IzbrisiGumb.setText("Delete");
        IzbrisiGumb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzbrisiGumbActionPerformed(evt);
            }
        });

        prikaziToggle.setText("show");
        prikaziToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prikaziToggleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PrekličiGumb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IzbrisiGumb)
                        .addGap(18, 18, 18)
                        .addComponent(PosodobiGumb))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imeAplikacijeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gesloPolje, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(prikaziToggle))
                            .addComponent(imePolje, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(imeAplikacijeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(imePolje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(gesloPolje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prikaziToggle))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PosodobiGumb)
                    .addComponent(PrekličiGumb)
                    .addComponent(IzbrisiGumb))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PosodobiGumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PosodobiGumbActionPerformed
        // TODO add your handling code here:
        if (imePolje.getText().isEmpty() || new String(gesloPolje.getPassword()).isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No field can be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try
        {
            UpravljalecVnosov.getInstance().IzbrisiVnos(GlobalniPodatki.izbraniVnos);
            UpravljalecVnosov.getInstance().UstvariVnos(GlobalniPodatki.izbraniVnos ,imePolje.getText(), gesloPolje.getText());
            
            UpravljalecOken.skrijVse();
            UpravljalecOken.prikazi("osnovno", false);
        }
        catch (VnosObstajaIzjema e)
        {
            JOptionPane.showMessageDialog(this, "Entry for this application already exists", "Duplicate entry", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_PosodobiGumbActionPerformed

    private void IzbrisiGumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IzbrisiGumbActionPerformed
        // TODO add your handling code here:
        UpravljalecVnosov.getInstance().IzbrisiVnos(GlobalniPodatki.izbraniVnos);
        UpravljalecOken.skrij("urediVnos");
        UpravljalecOken.prikazi("osnovno");
    }//GEN-LAST:event_IzbrisiGumbActionPerformed

    private void prikaziToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prikaziToggleActionPerformed
        // TODO add your handling code here:
        if (prikaziToggle.isSelected())
            gesloPolje.setEchoChar((char)0);
        else
            gesloPolje.setEchoChar('●');
    }//GEN-LAST:event_prikaziToggleActionPerformed

    private void PrekličiGumbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrekličiGumbActionPerformed
        // TODO add your handling code here:
        UpravljalecOken.skrij("urediVnos");
    }//GEN-LAST:event_PrekličiGumbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UrediVnosOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrediVnosOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrediVnosOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrediVnosOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrediVnosOkno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IzbrisiGumb;
    private javax.swing.JButton PosodobiGumb;
    private javax.swing.JButton PrekličiGumb;
    private javax.swing.JPasswordField gesloPolje;
    private javax.swing.JLabel imeAplikacijeLabel;
    private javax.swing.JTextField imePolje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox prikaziToggle;
    // End of variables declaration//GEN-END:variables
}