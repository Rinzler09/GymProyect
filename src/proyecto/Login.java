/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto;

import ConexionDB.ConexionDB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MILTON PAZ
 */
public class Login extends javax.swing.JFrame {

    String usuario, perfil, sentenciaSQL, SentenciaSQL2;
    Connection con = null;
    ConexionDB conecta;
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;
    ResultSet rs = null;
    ResultSet rsRoles = null;
    DefaultTableModel modelo;

    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtUSER.requestFocus();
    }

    public void conectarBD() {
        conecta = new ConexionDB("gimnasio");
        con = conecta.getConexion();
    }

    public void ValidarUsuario() {
        try {
            conectarBD();
            String usuario = txtUSER.getText();
            String password = txtPassword.getText();
            String SentenciaSQL2 = "", Roles;
            sentenciaSQL = "SELECT user, password FROM usuarios WHERE estado LIKE 'Activo' and user=? and password=?";
            ps = con.prepareStatement(sentenciaSQL);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                SentenciaSQL2 = "SELECT rol FROM usuarios WHERE user=?";
                ps2 = con.prepareStatement(SentenciaSQL2);
                ps2.setString(1, usuario);
                ResultSet rsRoles = ps2.executeQuery();

                if (rsRoles.next()) {
                    MenuPrincipal mdi = new MenuPrincipal();
                    Roles = rsRoles.getString(1);

                    if (Roles.contains("Administrador")) {
                        mdi.setVisible(true);
                        this.hide();
                        System.out.println("Es perfil de Administrador");

                    } else if (Roles.contains("Horarios")) {
                        mdi.setVisible(true);
                        mdi.menuHorarios.setVisible(true);
                        mdi.menuClientes.setVisible(false);
                        mdi.menuMembresias.setVisible(false);
                        mdi.menuMensajeria.setVisible(false);
                        mdi.menuControl.setVisible(false);
                        mdi.menuFacturacion.setVisible(false);
                        this.hide();
                        System.out.println("Es perfil de Horarios");

                    } else if (Roles.contains("Clientes")) {
                        mdi.setVisible(true);
                        mdi.menuHorarios.setVisible(false);
                        mdi.menuClientes.setVisible(true);
                        mdi.menuMembresias.setVisible(false);
                        mdi.menuMensajeria.setVisible(false);
                        mdi.menuControl.setVisible(false);
                        mdi.menuFacturacion.setVisible(false);
                        this.hide();
                        System.out.println("Es perfil de Clientes");

                    } else if (Roles.contains("Membresias")) {
                        mdi.setVisible(true);
                        mdi.menuHorarios.setVisible(false);
                        mdi.menuClientes.setVisible(false);
                        mdi.menuMembresias.setVisible(true);
                        mdi.menuMensajeria.setVisible(false);
                        mdi.menuControl.setVisible(false);
                        mdi.menuFacturacion.setVisible(false);
                        this.hide();
                        System.out.println("Es perfil de Membresias");

                    } else if (Roles.contains("Mensajeria")) {
                        mdi.setVisible(true);
                        mdi.menuHorarios.setVisible(false);
                        mdi.menuClientes.setVisible(false);
                        mdi.menuMembresias.setVisible(false);
                        mdi.menuMensajeria.setVisible(true);
                        mdi.menuControl.setVisible(false);
                        mdi.menuFacturacion.setVisible(false);
                        this.hide();
                        System.out.println("Es perfil de Mensajeria");

                    } else if (Roles.contains("Control")) {
                        mdi.setVisible(true);
                        mdi.menuHorarios.setVisible(false);
                        mdi.menuClientes.setVisible(false);
                        mdi.menuMembresias.setVisible(false);
                        mdi.menuMensajeria.setVisible(false);
                        mdi.menuControl.setVisible(true);
                        mdi.menuFacturacion.setVisible(false);
                        this.hide();
                        System.out.println("Es perfil de Control");

                    } else if (Roles.contains("Facturacion")) {
                        mdi.setVisible(true);
                        mdi.menuHorarios.setVisible(false);
                        mdi.menuClientes.setVisible(false);
                        mdi.menuMembresias.setVisible(false);
                        mdi.menuMensajeria.setVisible(false);
                        mdi.menuControl.setVisible(false);
                        mdi.menuFacturacion.setVisible(true);
                        this.hide();
                        System.out.println("Es perfil de Facturacion");
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUSER = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        FONDO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/muscle.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/candado.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        txtPassword.setText("jPasswordField1");
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 250, 40));
        jPanel1.add(txtUSER, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 250, 40));

        btnIngresar.setBackground(new java.awt.Color(102, 153, 255));
        btnIngresar.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoLogin.jpg"))); // NOI18N
        jPanel1.add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 702, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        this.ValidarUsuario();

    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FONDO;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUSER;
    // End of variables declaration//GEN-END:variables
}
