package hranilec.gesel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dijak
 */
public class OsnovnoOkno extends javax.swing.JFrame {

    /**
     * Creates new form OsnovnoOkno
     */
    
    String shown = "";
    int prejsniVnos = -1;
    
    public OsnovnoOkno() {
        initComponents();
        
        tabelaVnosov.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int vnos = tabelaVnosov.getSelectedRow();

            if (vnos >= 0)
            {
                String novVnos = (String) tabelaVnosov.getModel().getValueAt(vnos, 0);

                System.out.println(1);

                if (shown.equals(novVnos))
                {
                    shown = "";
                    SkrijGeslo(vnos);
                }
                else
                {
                    if (prejsniVnos != -1)
                        SkrijGeslo(prejsniVnos);
                    
                    prejsniVnos = vnos;
                    shown = novVnos;
                    PrikaziGeslo(vnos, novVnos);
                }
            }
        }
        });
    }
    
    public void PrikaziGeslo(int vrstica, String imeAplikacije)
    {
        Vnos vnos = UpravljalecVnosov.getInstance().getVnos(imeAplikacije);
        tabelaVnosov.setValueAt(vnos.geslo, vrstica, 2);
    }
    
    public void SkrijGeslo(int vrstica)
    {
        Vnos vnos = UpravljalecVnosov.getInstance().getVnos((String) tabelaVnosov.getModel().getValueAt(vrstica, 0));
        tabelaVnosov.setValueAt(vnos.geslo.replaceAll(".", "•") , vrstica, 2);
    }
    
    public void PosodobiVnose()
    {
        shown = "";
        prejsniVnos = -1;
        
        String stolpec[]={"Application", "Username", "Password"};         
        String[][] data = UpravljalecVnosov.getInstance().vsiVnosi();
        
        
        
        String[][] newData = new String[data.length][];
        
        int stevec = 0;
        for (String[] vnos : data)
        {
            if (!vnos[2].equals(shown))
                vnos[2] = vnos[2].replaceAll(".", "•");

            newData[stevec] = vnos;
            stevec++;
        }
        
        DefaultTableModel model = new DefaultTableModel(data , stolpec ){
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
        tabelaVnosov.setModel(model);
    }
    
    public void PosodobiVnose(String iskanje)
    {
        shown = "";
        prejsniVnos = -1;
        
        String stolpec[]={"Application", "Username", "Password"};         
        String[][] data = UpravljalecVnosov.getInstance().vsiVnosi();
       
        
        int dolzina = 0;
        for (String[] vnos : data)
        {
            if (vnos[0].contains(iskanje))
                dolzina++;
        }
        
        String[][] rezultat = new String[dolzina][3];
        int stevec = 0;
        for (String[] vnos : data)
        {
            if (vnos[0].contains(iskanje))
            {
                if (!vnos[2].equals(shown))
                    vnos[2] = vnos[2].replaceAll(".", "•");
                
                rezultat[stevec] = vnos;
                stevec++;
            }
        }
        
        DefaultTableModel model = new DefaultTableModel(rezultat , stolpec ){
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
     
        tabelaVnosov.setModel(model);
    }
    
    public void setVisible(boolean b)
    {
        PosodobiVnose();
        
        super.setVisible(b);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVnosov = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        iskalnoPolje = new javax.swing.JTextField();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Saved usernames and passwords:");

        nameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 11)); // NOI18N

        jButton1.setText("New entry");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete entry");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit entry");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tabelaVnosov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaVnosov.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaVnosov.getTableHeader().setResizingAllowed(false);
        tabelaVnosov.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaVnosov);

        jLabel2.setText("Search:");

        iskalnoPolje.setToolTipText("");
        iskalnoPolje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iskalnoPoljeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                iskalnoPoljeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                iskalnoPoljeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(iskalnoPolje))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(iskalnoPolje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        OsnovnoOknoKontroler.OdjaviSe();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UpravljalecOken.prikazi("ustvariVnos");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tabelaVnosov.getSelectedRow();
        if (selectedRow == -1)
        {
            JOptionPane.showMessageDialog(this, "No entry is selected", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String imeIzbraneAplikacije = (String) tabelaVnosov.getModel().getValueAt(selectedRow, 0);
        System.out.println(imeIzbraneAplikacije);
        UpravljalecVnosov.getInstance().IzbrisiVnos(imeIzbraneAplikacije);
        
        PosodobiVnose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int selectedRow = tabelaVnosov.getSelectedRow();
        if (selectedRow == -1)
        {
            JOptionPane.showMessageDialog(this, "No entry is selected", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        GlobalniPodatki.izbraniVnos = (String) tabelaVnosov.getModel().getValueAt(selectedRow, 0);
        
        UpravljalecOken.prikazi("urediVnos");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void iskalnoPoljeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iskalnoPoljeKeyPressed
        // TODO add your handling code here:
        PosodobiVnose(iskalnoPolje.getText());
    }//GEN-LAST:event_iskalnoPoljeKeyPressed

    private void iskalnoPoljeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iskalnoPoljeKeyReleased
        // TODO add your handling code here:
        PosodobiVnose(iskalnoPolje.getText());
    }//GEN-LAST:event_iskalnoPoljeKeyReleased

    private void iskalnoPoljeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iskalnoPoljeKeyTyped
        // TODO add your handling code here:
        PosodobiVnose(iskalnoPolje.getText());
    }//GEN-LAST:event_iskalnoPoljeKeyTyped

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
            java.util.logging.Logger.getLogger(OsnovnoOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OsnovnoOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OsnovnoOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OsnovnoOkno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OsnovnoOkno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField iskalnoPolje;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable tabelaVnosov;
    // End of variables declaration//GEN-END:variables
}
