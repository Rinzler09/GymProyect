package proyecto;

import ConexionDB.ConexionDB;
import java.text.ParseException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author SAMUEL ULLOA
 */
public class Horarios extends javax.swing.JInternalFrame {

    String clase, horario;
    String usuario, sentenciaSQL;
    Connection con = null;
    ConexionDB conecta;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DefaultTableModel modelo;
    Object[] datosHorarios = new Object[3];

    /**
     * Creates new form Clientes
     *
     */
    public Horarios() {
        initComponents();
        this.ConectarBD();
        clase = (String) cboClase.getSelectedItem();
        horario = (String) cboHorario.getSelectedItem();
    }

    public void ConectarBD() {
        conecta = new ConexionDB("gimnasio");
        con = conecta.getConexion();
    }
    
    public void Limpiar() {
        this.cboClase.setSelectedIndex(0);
        this.cboHorario.setSelectedIndex(0);

        LimpiarTable();
    }
    
    public void Horarios(){
        clase = (String) cboClase.getSelectedItem();
        horario = (String) cboHorario.getSelectedItem();
        
        if (clase == "SELECCIONE:"){
            cboHorario.removeAllItems();
            cboHorario.addItem("SELECCIONE:");
            
        }
        
        if(clase == "Yoga"){
            cboHorario.removeAllItems();
            cboHorario.addItem("SELECCIONE:");
            cboHorario.addItem("7:00 AM - 8:00 AM");
            cboHorario.addItem("9:00 AM - 10:00 AM");
            cboHorario.addItem("2:30 PM - 3:30 PM");
            cboHorario.addItem("5:00 PM - 6:00 PM");
        }
        
        if (clase == "CrossFit"){
            cboHorario.removeAllItems();
            cboHorario.addItem("SELECCIONE:");
            cboHorario.addItem("9:00 AM - 10:30 AM");
            cboHorario.addItem("5:00 PM - 6:15 PM");
            cboHorario.addItem("7:00 PM - 8:30 PM");
            cboHorario.addItem("9:00 PM - 10:00 PM");
        }
        
        if (clase == "Entrenamientos para adultos Mayores"){
            cboHorario.removeAllItems();
            cboHorario.addItem("SELECCIONE:");
            cboHorario.addItem("6:00 AM - 8:00 AM");
            cboHorario.addItem("9:00 AM - 10:30 AM");
            cboHorario.addItem("3:00 PM - 5:00 PM");
        }
        
        if (clase == "Spinning"){
            cboHorario.removeAllItems();
            cboHorario.addItem("SELECCIONE:");
            cboHorario.addItem("6:00 AM - 07:00 AM");
            cboHorario.addItem("7:00 AM - 8:00 AM");
            cboHorario.addItem("8:00 AM - 9:00 AM");
            cboHorario.addItem("9:10 AM - 10:10 AM");
            cboHorario.addItem("5:00 PM - 6:00 PM");
            cboHorario.addItem("6:00 PM - 7:00 PM");
            cboHorario.addItem("7:00 PM - 8:00 PM");
        }
        
        if (clase == "Zumba"){
            cboHorario.removeAllItems();
            cboHorario.addItem("SELECCIONE:");
            cboHorario.addItem("8:45 AM - 10:00 AM");
            cboHorario.addItem("10:45 AM - 12:00 PM");
            cboHorario.addItem("3:45 PM - 5:00 PM");
            cboHorario.addItem("5:45 PM - 7:00 PM");
        }
        
        if (clase == "Calistenia"){
            cboHorario.removeAllItems();
            cboHorario.addItem("SELECCIONE:");
            cboHorario.addItem("8:30 AM - 10:30 AM");
            cboHorario.addItem("4:30 PM - 6:30 PM");
        }
        
        if (clase == "Aerobic"){
            cboHorario.removeAllItems();
            cboHorario.addItem("SELECCIONE:");
            cboHorario.addItem("9:30 AM - 10:30 AM");
            cboHorario.addItem("10:30 AM - 11:30 AM");
            cboHorario.addItem("2:30 PM - 3:30 PM");
            cboHorario.addItem("3:30 PM - 4:30 PM");
            cboHorario.addItem("4:30 PM - 5:30 PM");
        }
        
    }

    private void LimpiarTable() {
        int fila = tbHorarios.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void CrearHorario() {
        try {
            ConectarBD();
            clase = (String) cboClase.getSelectedItem();
            horario = (String) cboHorario.getSelectedItem();
            sentenciaSQL = "INSERT INTO horarios (Id, Clase, Horario, Estado) VALUES(?,?,?,?)";
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, 0);
            ps.setString(2, clase);
            ps.setString(3, horario);
            ps.setString(4, "Activo");
            ps.execute();

            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE!");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO INGRESAR DATOS " + ex.getMessage());
        }
        
    }
    
    public void LeerHorarios() {
        ConectarBD();
        sentenciaSQL = "SELECT id, Clase, Horario FROM horarios WHERE Estado LIKE 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            modelo = (DefaultTableModel) tbHorarios.getModel();
            while (rs.next()) {
                datosHorarios[0] = (rs.getInt(1));
                datosHorarios[1] = (rs.getString(2));
                datosHorarios[2] = (rs.getString(3));
                modelo.addRow(datosHorarios);
            }
            tbHorarios.setModel(modelo);
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUDIERON LEER LOS DATOS " + ex.getMessage());
        }
    }

    

    public void ActualizarHorarios() {
        try {
            ConectarBD();
            clase = (String) cboClase.getSelectedItem();
            horario = (String) cboHorario.getSelectedItem();
            sentenciaSQL = "UPDATE horarios SET Clase=?, Horario=? WHERE id=?";
            ps = con.prepareStatement(sentenciaSQL);
            
            ps.setString(1, clase);
            ps.setString(2, horario);
            //ps.setString(3, "Activo");
            
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE!");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUDIERON ACTUALIZAR LOS DATOS " + ex.getMessage());
        }
    }

    public void EliminarHorarios() {
        try {
            ConectarBD();
            sentenciaSQL = "UPDATE horarios SET Estado='Inactivo' WHERE Clase=" + clase + "horario=" + horario;
            ps = con.prepareStatement(sentenciaSQL);
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS CORRECTAMENTE!");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR, NO SE PUDO ELIMINAR LOS DATOS " + ex.getMessage());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHorarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnCASA = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cboClase = new javax.swing.JComboBox<>();
        cboHorario = new javax.swing.JComboBox<>();
        FONDO = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbHorarios.setAutoCreateRowSorter(true);
        tbHorarios.setBackground(new java.awt.Color(0, 204, 204));
        tbHorarios.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0)));
        tbHorarios.setForeground(new java.awt.Color(0, 0, 0));
        tbHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clase", "Horario"
            }
        ));
        tbHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHorariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHorarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1070, 260));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        btnCrear.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnLeer.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnLeer.setText("LEER");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar)
                    .addComponent(btnLeer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnCrear)
                .addGap(44, 44, 44)
                .addComponent(btnLeer)
                .addGap(35, 35, 35)
                .addComponent(btnActualizar)
                .addGap(30, 30, 30)
                .addComponent(btnEliminar)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 160, 460));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Horario:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 130, 30));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("HORARIOS");

        btnCASA.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnCASA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home.png"))); // NOI18N
        btnCASA.setBorderPainted(false);
        btnCASA.setContentAreaFilled(false);
        btnCASA.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home60.png"))); // NOI18N
        btnCASA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCASAMouseClicked(evt);
            }
        });
        btnCASA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCASAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(544, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(350, 350, 350)
                .addComponent(btnCASA, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCASA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 70));

        jPanel9.setBackground(new java.awt.Color(0, 204, 204));
        jPanel9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Clase:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 110, 30));

        cboClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE:", "Yoga", "CrossFit", "Entrenamientos para adultos Mayores", "Spinning", "Zumba", "Calistenia", "Aerobic" }));
        cboClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboClaseActionPerformed(evt);
            }
        });
        jPanel1.add(cboClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 180, 30));

        jPanel1.add(cboHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 180, 30));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMain.jpg"))); // NOI18N
        jPanel1.add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 280));

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

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        this.CrearHorario();
        this.Limpiar();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        this.LeerHorarios();
    }//GEN-LAST:event_btnLeerActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.ActualizarHorarios();
        this.Limpiar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.EliminarHorarios();
        this.Limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCASAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCASAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCASAActionPerformed

    private void btnCASAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCASAMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCASAMouseClicked

    private void tbHorariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHorariosMouseClicked
        int fila = tbHorarios.getSelectedRow();
        this.cboClase.setSelectedItem(tbHorarios.getValueAt(fila, 1).toString());
        this.cboHorario.setSelectedItem(tbHorarios.getValueAt(fila, 2).toString());
    }//GEN-LAST:event_tbHorariosMouseClicked

    private void cboClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboClaseActionPerformed
        this.Horarios();
    }//GEN-LAST:event_cboClaseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FONDO;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCASA;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLeer;
    private javax.swing.JComboBox<String> cboClase;
    private javax.swing.JComboBox<String> cboHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbHorarios;
    // End of variables declaration//GEN-END:variables
}
