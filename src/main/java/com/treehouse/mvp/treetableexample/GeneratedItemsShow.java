/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treehouse.mvp.treetableexample;

import com.treehouse.mvp.treetableexample.datasource.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 *
 * @author hanus
 */
public class GeneratedItemsShow extends javax.swing.JFrame {
    private static final Logger LOGGER = Logger.getLogger( GeneratedItemsShow.class.getName() );
    private ItemsGenerator ig;
    private List<Item> listOfItems = new ArrayList<>();
    
    public GeneratedItemsShow() {
        initComponents();
        Handler loggerHandler;
        setLocationRelativeTo(null);
        loggerHandler = new Handler() {
            @Override
            public void publish(LogRecord record) {
                lblLoggerMessage.setText(record.getLevel() + " timestamp: " + record.getMillis() + " " + record.getMessage());
            }

            @Override
            public void flush() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void close() throws SecurityException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
                
        Logger log = Logger.getLogger("");
        log.addHandler(loggerHandler);
        LOGGER.log(Level.INFO, "Form loaded successfully");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textHowMany = new javax.swing.JTextField();
        btnGanerate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaOutput = new javax.swing.JTextArea();
        progressBarItemsGenerated = new javax.swing.JProgressBar();
        lblLoggerMessage = new javax.swing.JLabel();
        btnSaveToDb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("How many items to generate:");

        textHowMany.setText("0");

        btnGanerate.setText("Generate");
        btnGanerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGanerateActionPerformed(evt);
            }
        });

        textAreaOutput.setColumns(20);
        textAreaOutput.setRows(5);
        jScrollPane1.setViewportView(textAreaOutput);

        lblLoggerMessage.setText("...");

        btnSaveToDb.setText("Save to DB");
        btnSaveToDb.setEnabled(false);
        btnSaveToDb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveToDbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBarItemsGenerated, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLoggerMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(textHowMany, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGanerate)
                                .addGap(18, 18, 18)
                                .addComponent(btnSaveToDb))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textHowMany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGanerate)
                    .addComponent(btnSaveToDb))
                .addGap(11, 11, 11)
                .addComponent(progressBarItemsGenerated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLoggerMessage)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGanerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanerateActionPerformed
        int howMany = 0;
        int counter = 0;
        progressBarItemsGenerated.setValue(0);
        textAreaOutput.setText("");
        try {
            howMany = Integer.valueOf(textHowMany.getText());
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        if (howMany > 0) {
            ig = new ItemsGenerator(howMany, "-");
            listOfItems = ig.getListOfItems();
            for (Item item : listOfItems) {
                progressBarItemsGenerated.setMaximum(listOfItems.size());
                counter++;
                textAreaOutput.append(item.getJmeno() + " - " + item.getCena() + "\n");
                if (item.getChildren().size() > 0) {
                    for (Item child : item.getChildren()) {
                        textAreaOutput.append("   child: " + child.getJmeno() + " has parent: " + item.getJmeno() + "\n");
                    }
                    
                }
                try {
                    progressBarItemsGenerated.setValue(counter);
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    LOGGER.log(Level.SEVERE, "interrupted");
                }
                
                
            } 
            btnSaveToDb.setEnabled(true);
            LOGGER.log(Level.INFO, "Records created: " + listOfItems.size());
        }
        
    }//GEN-LAST:event_btnGanerateActionPerformed

    private void btnSaveToDbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveToDbActionPerformed
        if (listOfItems.size() > 0) {
            Database db = new Database();
            try {
                db.saveDataToDatabase(listOfItems);
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "");
            }
        }
    }//GEN-LAST:event_btnSaveToDbActionPerformed

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
            java.util.logging.Logger.getLogger(GeneratedItemsShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneratedItemsShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneratedItemsShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneratedItemsShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneratedItemsShow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGanerate;
    private javax.swing.JButton btnSaveToDb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoggerMessage;
    private javax.swing.JProgressBar progressBarItemsGenerated;
    private javax.swing.JTextArea textAreaOutput;
    private javax.swing.JTextField textHowMany;
    // End of variables declaration//GEN-END:variables
}
