/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.Color;
import java.text.MessageFormat;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class print extends javax.swing.JFrame {
    /**
     * Creates new form
     */
    public print() {
        initComponents();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               /*if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/  UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel"); // Set the Nimbus look and feel For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new print().setVisible(true);
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();


        newPanelLVL1 = new JPanel();
        newPanelLVL1.setBorder(BorderFactory.createLineBorder(Color.black));
        newPanelLVL2 = new JPanel();//new GridBagLayout()
        newPanelLVL2.setBorder(BorderFactory.createDashedBorder(Color.orange));
        JPanel newPanelLVL3 = new JPanel();//new GridBagLayout()
        newPanelLVL3.setBorder(BorderFactory.createDashedBorder(Color.black));


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Food Chain");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("View All Records ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("cccc ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        //layout.setAutoCreateGaps(true);
        //layout.setAutoCreateContainerGaps(true);

        /*Horizontal layout*/
        /*
        GroupLayout.SequentialGroup h = layout.createSequentialGroup();
        GroupLayout.SequentialGroup v = layout.createSequentialGroup();

        GroupLayout.SequentialGroup gLV23 = layout.createSequentialGroup();
        gLV23.addContainerGap();
        gLV23.addComponent(newPanelLVL2);
        gLV23.addContainerGap();
        gLV23.addComponent(newPanelLVL3);
        gLV23.addContainerGap();

        GroupLayout.ParallelGroup pg = layout.createParallelGroup();
        pg.addComponent(newPanelLVL1);
        //pg.addGroup(gLV23);
        pg.addComponent(jScrollPane1);

        h.addContainerGap();
        //h.addGroup(gLV23);
        h.addContainerGap();
        //layout.setHorizontalGroup(h);

       // v.addGap(50);
        v.addContainerGap();
        v.addGroup(gLV23);
        v.addContainerGap();
        //layout.setVerticalGroup(v);*/

        GroupLayout.SequentialGroup hg;
        hg = layout.createSequentialGroup();//(javax.swing.GroupLayout.Alignment.LEADING)

        GroupLayout.ParallelGroup h_easyic =
        layout.createParallelGroup(GroupLayout.Alignment.CENTER);

        GroupLayout.SequentialGroup hG1 = layout.createSequentialGroup(), hG2 = layout.createSequentialGroup(), hG3 = layout.createSequentialGroup();

        hG1
            .addComponent(jButton1)
            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE);
        //hG2
           // .addComponent(jButton3);
           // .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE);


        h_easyic.addGroup(hG1);
        h_easyic.addGroup(hG2);
        //h_easyic.addGroup(hG3);
        h_easyic.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE);
/*
        h_easyic
            .addGroup(layout.createSequentialGroup()
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
            )
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE);
 */

        hg.addGroup(h_easyic);
        layout.setHorizontalGroup(hg);


        /*Horizontal layout :  component needs to be defined also in that dimension in the layout, if not generate an exception!. */
        GroupLayout.SequentialGroup vg = layout.createSequentialGroup();//javax.swing.GroupLayout.Alignment.LEADING
        GroupLayout.SequentialGroup v_easyic = layout.createSequentialGroup();

        //
        GroupLayout.ParallelGroup vG1, vG2, vG3;
        vG1 = layout.createParallelGroup();
        vG2 = layout.createParallelGroup();
        vG3 = layout.createParallelGroup();
        vG1
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE);
        //vG2
               // .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE);
                //.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE);
        v_easyic.addGroup(vG1);
        h_easyic.addGroup(vG2);
        //h_easyic.addGroup(hG3);
        v_easyic.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,369, GroupLayout.PREFERRED_SIZE);

/*
        v_easyic
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
            )
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE);

 */

        vg.addGroup(v_easyic);
        layout.setVerticalGroup(vg);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      view_all_records view_all_records = new view_all_records();
      view_all_records.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
                
                MessageFormat header = new MessageFormat("Annie's Place");
                MessageFormat footer = new MessageFormat("Page{0,number,integer}");
                jTable1.print(JTable.PrintMode.NORMAL, header, footer);
            }catch(java.awt.print.PrinterException e){
                System.err.format("Cannot print %s%n", e.getMessage());
            }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton3;

    private javax.swing.JTable jTable1;

    JPanel newPanelLVL1;//new GridBagLayout()
    JPanel newPanelLVL2;//new GridBagLayout()

    // End of variables declaration//GEN-END:variables
}
