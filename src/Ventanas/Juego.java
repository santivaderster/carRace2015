/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

/**
 *
 * @author Pato
 */
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    Point posicionAuto;
    String sIconoActual = "Amarillo";
    Thread GenerarAutos;
    Thread Tiempo;
    boolean correr = true;
    float fVelocidad = 1;
    int iTiempo;
    int iNafta;
    public Juego() 
    {
        initComponents();
        ConfiguracionVisual();
        posicionAuto = lblFondo.getLocation();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInicio = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblAuto = new javax.swing.JLabel();
        lblIzquierda = new javax.swing.JLabel();
        lblDerecha = new javax.swing.JLabel();
        btnComenzar = new javax.swing.JButton();
        pnlPrincipal = new javax.swing.JPanel();
        pnlJuego = new javax.swing.JPanel();
        lblAutoJ = new javax.swing.JLabel();
        lblAuto1 = new javax.swing.JLabel();
        lblAuto3 = new javax.swing.JLabel();
        lblAuto2 = new javax.swing.JLabel();
        lblAuto4 = new javax.swing.JLabel();
        lblAuto5 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        prBarNafta = new javax.swing.JProgressBar();

        jLabel1.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAma.png"))); // NOI18N
        lblAuto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblAutoKeyReleased(evt);
            }
        });

        lblIzquierda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechaIzquierda.png"))); // NOI18N
        lblIzquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIzquierdaMouseClicked(evt);
            }
        });

        lblDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/flechaDereche.png"))); // NOI18N
        lblDerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDerechaMouseClicked(evt);
            }
        });

        btnComenzar.setText("Comenzar");
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIzquierda)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(lblAuto)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(lblDerecha)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(btnComenzar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblIzquierda)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblAuto)
                                .addGap(34, 34, 34)
                                .addComponent(btnComenzar)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))))))
        );

        javax.swing.GroupLayout jInicioLayout = new javax.swing.GroupLayout(jInicio.getContentPane());
        jInicio.getContentPane().setLayout(jInicioLayout);
        jInicioLayout.setHorizontalGroup(
            jInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInicioLayout.setVerticalGroup(
            jInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlJuego.setBorder(new javax.swing.border.MatteBorder(null));
        pnlJuego.setMaximumSize(new java.awt.Dimension(645, 580));
        pnlJuego.setMinimumSize(new java.awt.Dimension(645, 580));
        pnlJuego.setPreferredSize(new java.awt.Dimension(645, 580));
        pnlJuego.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pnlJuegoKeyReleased(evt);
            }
        });
        pnlJuego.setLayout(null);

        lblAutoJ.setBackground(new java.awt.Color(255, 51, 51));
        lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzul.png"))); // NOI18N
        pnlJuego.add(lblAutoJ);
        lblAutoJ.setBounds(80, 0, 60, 120);

        lblAuto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAmaInvertido.png"))); // NOI18N
        pnlJuego.add(lblAuto1);
        lblAuto1.setBounds(80, 460, 60, 113);

        lblAuto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojoInvertido.png"))); // NOI18N
        pnlJuego.add(lblAuto3);
        lblAuto3.setBounds(290, 450, 51, 113);

        lblAuto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzulInvertido.png"))); // NOI18N
        pnlJuego.add(lblAuto2);
        lblAuto2.setBounds(180, 440, 51, 120);

        lblAuto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzulInvertido.png"))); // NOI18N
        pnlJuego.add(lblAuto4);
        lblAuto4.setBounds(390, 450, 51, 113);

        lblAuto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojoInvertido.png"))); // NOI18N
        pnlJuego.add(lblAuto5);
        lblAuto5.setBounds(490, 450, 51, 113);

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        lblFondo.setText("jLabel2");
        pnlJuego.add(lblFondo);
        lblFondo.setBounds(0, 0, 640, 580);

        pnlDatos.setBorder(new javax.swing.border.MatteBorder(null));

        jButton1.setText("Reiniciar (F2)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prBarNafta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(prBarNafta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        Comenzar();
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void pnlJuegoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlJuegoKeyReleased
        int x = lblAutoJ.getLocation().x;
        int y = lblAutoJ.getLocation().y;
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_UP://Aumenta la velocidad
                break;
            case KeyEvent.VK_DOWN:// Baja la velociddad
                break;
            case KeyEvent.VK_LEFT://Auto mueve a la izquierda
                if (correr)
                    if(x > 80)
                        lblAutoJ.setLocation(x-100, y);
                break;
            case KeyEvent.VK_RIGHT://Auto mueve a la derecha
                if (correr)
                    if(x < 480)
                        lblAutoJ.setLocation(x+100, y);
                break;
            case KeyEvent.VK_ESCAPE://Programa en pausa
                correr = false;
                JOptionPane.showMessageDialog(this, "JUEGO PAUSADO!", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                correr = true;
                break;
            case KeyEvent.VK_F2:
                Reiniciar();
                break;
        }        
    }//GEN-LAST:event_pnlJuegoKeyReleased

    private void lblDerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDerechaMouseClicked
        switch(sIconoActual)
        {
            case "Amarillo":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzul.png")));
                sIconoActual = "Azul";
                break;
            case "Rojo":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAma.png")));
                sIconoActual = "Amarillo";
                break;
            case "Azul":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojo.png")));
                sIconoActual = "Rojo";
                break;
        }
    }//GEN-LAST:event_lblDerechaMouseClicked

    private void lblIzquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIzquierdaMouseClicked
       switch(sIconoActual)
        {
            case "Amarillo":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojo.png")));
                sIconoActual = "Rojo";
                break;
            case "Rojo":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzul.png")));
                sIconoActual = "Azul";
                break;
            case "Azul":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAma.png")));
                sIconoActual = "Amarillo";
                break;
        }
    }//GEN-LAST:event_lblIzquierdaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Reiniciar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
            lblAuto.requestFocus();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void lblAutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblAutoKeyReleased
        switch (evt.getKeyCode())
        {
             case KeyEvent.VK_LEFT://Auto mueve a la izquierda
                switch(sIconoActual)
                {
                    case "Amarillo":
                        lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojo.png")));
                        sIconoActual = "Rojo";
                        break;
                    case "Rojo":
                        lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzul.png")));
                        sIconoActual = "Azul";
                        break;
                    case "Azul":
                        lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAma.png")));
                        sIconoActual = "Amarillo";
                        break;
                }
                break;
            case KeyEvent.VK_RIGHT://Auto mueve a la derecha
                switch(sIconoActual)
                {
                    case "Amarillo":
                        lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzul.png")));
                        sIconoActual = "Azul";
                        break;
                    case "Rojo":
                        lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAma.png")));
                        sIconoActual = "Amarillo";
                        break;
                    case "Azul":
                        lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojo.png")));
                        sIconoActual = "Rojo";
                        break;
                }
                break;
            case KeyEvent.VK_ENTER:
                Comenzar();
                break;
        }
    }//GEN-LAST:event_lblAutoKeyReleased

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAuto;
    private javax.swing.JLabel lblAuto1;
    private javax.swing.JLabel lblAuto2;
    private javax.swing.JLabel lblAuto3;
    private javax.swing.JLabel lblAuto4;
    private javax.swing.JLabel lblAuto5;
    private javax.swing.JLabel lblAutoJ;
    private javax.swing.JLabel lblDerecha;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIzquierda;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlJuego;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JProgressBar prBarNafta;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void ComenzarJuego(String text, Icon icon) 
    {
        PosicionAutos();
        this.setTitle("Race: Esta jugando " + text);
        lblAutoJ.setIcon(icon);
        pnlJuego.requestFocus();
        this.setVisible(true);
        GenerarAutos = new Thread(){

            @Override
            public void run() 
            {
                Random oRandom = new Random();
                int num;
                int cant =0;
                super.run(); //To change body of generated methods, choose Tools | Templates.
                while(true)
                {
                    if (correr)
                    {
                        try 
                        {
                            Thread.sleep((long) (100*fVelocidad));
                        } catch (InterruptedException ex){}                      
                        if (cant == 0 )
                        {
                            num = (int)(oRandom.nextDouble() * 5 + 1);
                            switch(num)
                            {
                                case 1:
                                    if (!lblAuto1.isVisible())
                                    {
                                        lblAuto1.setVisible(true);
                                        lblAuto1.setLocation(80, 460);
                                    }
                                break;
                                case 2:
                                if (!lblAuto2.isVisible())
                                {
                                    lblAuto2.setVisible(true);
                                    lblAuto2.setLocation(180, 460);
                                }
                                break;
                                case 3:
                                if (!lblAuto3.isVisible())
                                {
                                    lblAuto3.setVisible(true);                                   
                                    lblAuto3.setLocation(280, 460);
                                }
                                break;
                                case 4:
                                    if (!lblAuto4.isVisible())
                                    {
                                        lblAuto4.setVisible(true);
                                        lblAuto4.setLocation(380, 460);
                                    }
                                break;
                                    case 5:
                                    if (!lblAuto5.isVisible())
                                    {
                                        lblAuto5.setVisible(true);
                                        lblAuto5.setLocation(480, 460);
                                    }
                                break;
                            }                            
                        }
                        else
                        {
                            if (lblAuto1.isVisible())
                            {
                                if(lblAuto1.getLocation().y == lblAutoJ.getLocation().y+100)
                                {
                                    lblAuto1.setVisible(false);
                                    if(lblAutoJ.getLocation().x == lblAuto1.getLocation().x)
                                    {
                                        JOptionPane.showMessageDialog(null, "CHOCASTE MOSTRO!", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                                        switch(sIconoActual)
                                        {
                                            case "Amarillo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAmaRoto.png")));
                                                break;
                                            case "Rojo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojoRoto.png")));
                                                break;
                                            case "Azul":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzulRoto.png")));
                                                break;
                                        }
                                        correr = false;
                                    }
                                }
                                else
                                {
                                    lblAuto1.setLocation(lblAuto1.getLocation().x, lblAuto1.getLocation().y-10);
                                }
                            }
                            if (lblAuto2.isVisible())
                            {
                                if(lblAuto2.getLocation().y == lblAutoJ.getLocation().y+100)
                                {
                                    lblAuto2.setVisible(false);
                                    if(lblAutoJ.getLocation().x == lblAuto2.getLocation().x)
                                    {
                                        JOptionPane.showMessageDialog(null, "CHOCASTE MOSTRO!", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                                        switch(sIconoActual)
                                        {
                                            case "Amarillo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAmaRoto.png")));
                                                break;
                                            case "Rojo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojoRoto.png")));
                                                break;
                                            case "Azul":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzulRoto.png")));
                                                break;
                                        }
                                        correr = false;
                                    }
                                }
                                else
                                    lblAuto2.setLocation(lblAuto2.getLocation().x, lblAuto2.getLocation().y-10);
                            }
                            if (lblAuto3.isVisible())
                            {
                                if(lblAuto3.getLocation().y == lblAutoJ.getLocation().y+100)
                                {    
                                    lblAuto3.setVisible(false);
                                    if(lblAutoJ.getLocation().x == lblAuto3.getLocation().x)
                                    {
                                        JOptionPane.showMessageDialog(null, "CHOCASTE MOSTRO!", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                                        switch(sIconoActual)
                                        {
                                            case "Amarillo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAmaRoto.png")));
                                                break;
                                            case "Rojo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojoRoto.png")));
                                                break;
                                            case "Azul":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzulRoto.png")));
                                                break;
                                        }
                                        correr = false;
                                    }
                                }
                                else
                                    lblAuto3.setLocation(lblAuto3.getLocation().x, lblAuto3.getLocation().y-10);
                            }
                            if (lblAuto4.isVisible())
                            {
                                if(lblAuto4.getLocation().y == lblAutoJ.getLocation().y+100)
                                {
                                    lblAuto4.setVisible(false);
                                    if(lblAutoJ.getLocation().x == lblAuto4.getLocation().x)
                                    {
                                        JOptionPane.showMessageDialog(null, "CHOCASTE MOSTRO!", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                                        switch(sIconoActual)
                                        {
                                            case "Amarillo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAmaRoto.png")));
                                                break;
                                            case "Rojo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojoRoto.png")));
                                                break;
                                            case "Azul":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzulRoto.png")));
                                                break;
                                        }
                                        correr = false;
                                    }
                                }
                                else
                                    lblAuto4.setLocation(lblAuto4.getLocation().x, lblAuto4.getLocation().y-10);
                            }
                            if (lblAuto5.isVisible())
                            {
                                if(lblAuto5.getLocation().y == lblAutoJ.getLocation().y+100)
                                {
                                    lblAuto5.setVisible(false);
                                    if(lblAutoJ.getLocation().x == lblAuto5.getLocation().x)
                                    {
                                        JOptionPane.showMessageDialog(null, "CHOCASTE MOSTRO!", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                                        switch(sIconoActual)
                                        {
                                            case "Amarillo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAmaRoto.png")));
                                                break;
                                            case "Rojo":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojoRoto.png")));
                                                break;
                                            case "Azul":
                                                lblAutoJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzulRoto.png")));
                                                break;
                                        }
                                        correr = false;
                                    }
                                }
                                else
                                    lblAuto5.setLocation(lblAuto5.getLocation().x, lblAuto5.getLocation().y-10);
                            }
                        }
                        cant++;
                        if (cant == 10)
                            cant = 0;
                    }
                    else
                    {
                        
                    }
                }
            }
        };
        GenerarAutos.start();
        iTiempo = 0;
        Tiempo = new Thread()
        {

            @Override
            public void run() 
            {
                super.run(); //To change body of generated methods, choose Tools | Templates.
                while(true)
                {
                    try 
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex){}
                    iTiempo++;
                    if (iNafta != 0 && correr)
                    {
                        if(lblAutoJ.getLocation().x == 80 || lblAutoJ.getLocation().x == 480)
                        {
                            iNafta++;
                        }
                        else
                            iNafta--;
                    }
                    else
                    {
                        if(correr == true)
                        {
                            correr = false;
                            JOptionPane.showMessageDialog(null,"Has Perdido, Vuelve a intentarlo!", "GameOver", JOptionPane.ERROR_MESSAGE);                            
                        }
                    }
                    prBarNafta.setValue(iNafta);
                    if (iTiempo% 60 == 0)
                        fVelocidad = fVelocidad/10;
                    
                }
            }
            
        };
        Tiempo.start();
    }

    private void ConfiguracionVisual() 
    {
        PosicionAutos();
        prBarNafta.setValue(0);
        prBarNafta.setStringPainted(true);
        this.setLocationRelativeTo(null);           
        this.setResizable(false);
        this.setVisible(false);                     
        jInicio.setTitle("Race: Esperando Usuario");
        jInicio.setResizable(false);
        jInicio.setSize(455,284);    
        jInicio.setLocationRelativeTo(this);
        jInicio.setVisible(true);
        jInicio.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        txtNombre.requestFocus();
    }

    private void PosicionAutos() 
    {
        lblAuto1.setLocation(80, 460);
        lblAuto2.setLocation(180, 460);
        lblAuto3.setLocation(280, 460);
        lblAuto4.setLocation(380, 460);
        lblAuto5.setLocation(480, 460);
        lblAuto1.setVisible(false);
        lblAuto2.setVisible(false);
        lblAuto3.setVisible(false);
        lblAuto4.setVisible(false);
        lblAuto5.setVisible(false);
    }

    private void Reiniciar() 
    {
        switch(sIconoActual)
        {
            case "Amarillo":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAma.png")));
                break;
            case "Rojo":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoRojo.png")));
                break;
            case "Azul":
                lblAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/autoAzul.png")));
                break;
        }
        txtNombre.setText("");
        jInicio.setVisible(true);
        this.setVisible(false);
        txtNombre.requestFocus();
        
    }

    private void Comenzar() 
    {
        if (txtNombre.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Debe escribir su nombre para comenzar!", "Error", JOptionPane.ERROR_MESSAGE);
        else
        {
            iNafta = 10;
            prBarNafta.setValue(iNafta);
            jInicio.setVisible(false);
            correr = true;
            ComenzarJuego(txtNombre.getText(),lblAuto.getIcon());
        }
    }
}
