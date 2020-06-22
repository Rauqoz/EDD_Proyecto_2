/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conductores;

import java.awt.FileDialog;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author josed
 */
public class Cmasiva extends javax.swing.JPanel {
    ListaC lista;
    /**
     * Creates new form Cmasiva
     */
    public Cmasiva() {
        initComponents();
    }
      public Cmasiva(ListaC entrada) {
        lista=entrada;
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

        setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Elegir Texto ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addContainerGap(351, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Carga();

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
                ssplitPOR=psplitPM[i].split("%");
                lista.InsertarUltimo(new Conductor(ssplitPOR[0],ssplitPOR[1],ssplitPOR[2],ssplitPOR[3],ssplitPOR[4],ssplitPOR[5],ssplitPOR[6],ssplitPOR[7]));
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
