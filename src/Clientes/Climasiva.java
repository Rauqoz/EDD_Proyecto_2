/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clientes;

import edd_proyecto2.EDD_Proyecto2.*;
import Clientes.*;
import static edd_proyecto2.EDD_Proyecto2.*;
import edd_proyecto2.EDD_Proyecto2;
import java.awt.FileDialog;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;


/**
 *
 * @author josed
 */
public class Climasiva extends javax.swing.JPanel {
    
    /**
     * Creates new form Cmasiva
     */
    public Climasiva() {
        initComponents();
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
        cargados = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Elegir Archivo de Carga");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cargados.setBackground(new java.awt.Color(102, 102, 102));
        cargados.setColumns(20);
        cargados.setForeground(new java.awt.Color(102, 102, 102));
        cargados.setRows(5);
        jScrollPane1.setViewportView(cargados);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Carga Masiva de Conductor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Carga();
        cargados.enable(false);
        cargados.setText(tablita.DatosCargados());
        tablita.Imprimir();
        tablita.GenerarGrafico();
        System.out.println(tablita.getTama());
        System.out.println(tablita.Porcentaje());
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea cargados;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
public void Carga(){
	String[] psplitPM = null;
        String[] ssplitPOR = null;
	String cadena="", temp="";
        JFileChooser rutachooser = new JFileChooser();
	Scanner Txtr = null;
        rutachooser.showOpenDialog(rutachooser);
        try {
            String rutanueva = rutachooser.getSelectedFile().getAbsolutePath();                                        
            File extraer = new File(rutanueva);
            FileReader ee=new FileReader(extraer);
            BufferedReader bb=new BufferedReader(ee);
            while ((temp=bb.readLine())!=null) {
                cadena=cadena+temp;
            }
            bb.close();
            psplitPM=cadena.split(";");
            for (int i = 0; i < psplitPM.length; i++) {
                ssplitPOR=psplitPM[i].split(",");
                tablita.Insertar(new Cliente(ssplitPOR[0],ssplitPOR[1],ssplitPOR[2],ssplitPOR[3],ssplitPOR[4],ssplitPOR[5],ssplitPOR[6]));
            }
			
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (Txtr != null) {
                Txtr.close();
            }
        }
}
}
