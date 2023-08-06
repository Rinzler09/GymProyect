package proyecto;

import ConexionDB.ConexionDB;
import java.text.ParseException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

/**
 *
 * @author MILTON PAZ
 */
public class ControlAcceso extends javax.swing.JInternalFrame {

    String rol = " ";
    String usuario, sentenciaSQL;
    Connection con = null;
    ConexionDB conecta;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DefaultTableModel modelo;
    Object datosAcceso[] = new Object[4];

    /**
     * Creates new form Membresias
     */
    public ControlAcceso() {
        initComponents();
        txtID.setText("0");

    }

    public void ConectarBD() {
        conecta = new ConexionDB("gimnasio");
        con = conecta.getConexion();
    }

    public void Limpiar() {
        txtID.setText("0");
        txtUSER.setText("");
        txtPASSWORD.setText("");
        GrupoRoles.clearSelection();
        LimpiarTable();
        this.rol = "";
    }

    private void LimpiarTable() {
        int fila = tbAccesos.getRowCount();
        for (int i = fila - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    public void takeROL() {
        String administrador = " ", mensajeria = " ", horarios = " ", facturacion = " ", membresias = " ", clientes = " ", control = " ";

        if (chkADMIN.isSelected()) {
            administrador = " Administrador ";
            rol += administrador;
        }

        if (chkMENSAJERIA.isSelected()) {
            mensajeria = " Mensajeria ";
            rol += mensajeria;
        }

        if (chkHORARIOS.isSelected()) {
            horarios = " Horarios ";
            rol += horarios;
        }

        if (chkFACTURACION.isSelected()) {
            facturacion = " Facturacion ";
            rol += facturacion;
        }

        if (chkMEMBRESIAS.isSelected()) {
            membresias = " Membresias ";
            rol += membresias;
        }

        if (chkCLIENTES.isSelected()) {
            clientes = " Clientes ";
            rol += clientes;
        }

        if (chkACESSCONTROL.isSelected()) {
            control = " Control ";
            rol += control;
        }

    }

    public void CrearRoles() {
        this.takeROL();
        try {
            ConectarBD();
            sentenciaSQL = "INSERT INTO usuarios (id, user, password, rol, estado) VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(sentenciaSQL);
            ps.setInt(1, 0);
            ps.setString(2, txtUSER.getText().toString());
            ps.setString(3, txtPASSWORD.getText().toString());
            ps.setString(4, rol);
            ps.setString(5, "Activo");
            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE!");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUDO INGRESAR DATOS " + ex.getMessage());
        }

    }

    public void LeerRoles() {
        ConectarBD();
        sentenciaSQL = "SELECT id, user, password, rol FROM usuarios WHERE Estado LIKE 'Activo'";
        try {
            ps = con.prepareStatement(sentenciaSQL);
            rs = ps.executeQuery();
            modelo = (DefaultTableModel) tbAccesos.getModel();
            while (rs.next()) {
                datosAcceso[0] = (rs.getInt(1));
                datosAcceso[1] = (rs.getString(2));
                datosAcceso[2] = (rs.getString(3));
                datosAcceso[3] = (rs.getString(4));
                modelo.addRow(datosAcceso);
            }
            tbAccesos.setModel(modelo);
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUDIERON LEER LOS DATOS " + ex.getMessage());
        }
    }

    public void ActualizarRoles() {
        takeROL();
        try {
            ConectarBD();
            sentenciaSQL = "UPDATE usuarios SET user=?, password=?, rol=? WHERE id=?";
            ps = con.prepareStatement(sentenciaSQL);

            ps.setString(1, txtUSER.getText().toString());
            ps.setString(2, txtPASSWORD.getText().toString());
            ps.setString(3, rol);
            ps.setInt(4, Integer.parseInt(txtID.getText()));

            ps.execute();
            JOptionPane.showMessageDialog(null, "DATOS ACTUALIZADOS CORRECTAMENTE!");
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR NO SE PUDIERON ACTUALIZAR LOS DATOS " + ex.getMessage());
        }
    }

    public void EliminarRoles() {
        try {
            ConectarBD();
            sentenciaSQL = "UPDATE usuarios SET Estado='Inactivo' WHERE id=" + txtID.getText().trim();
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

        GrupoRoles = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAccesos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUSER = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnCASA = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPASSWORD = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        chkCLIENTES = new javax.swing.JCheckBox();
        chkMEMBRESIAS = new javax.swing.JCheckBox();
        chkHORARIOS = new javax.swing.JCheckBox();
        chkADMIN = new javax.swing.JCheckBox();
        chkMENSAJERIA = new javax.swing.JCheckBox();
        chkFACTURACION = new javax.swing.JCheckBox();
        chkACESSCONTROL = new javax.swing.JCheckBox();
        FONDO = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbAccesos.setBackground(new java.awt.Color(204, 255, 204));
        tbAccesos.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(0, 0, 0)));
        tbAccesos.setForeground(new java.awt.Color(0, 0, 0));
        tbAccesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUARIO", "PASSWORD", "ROLES"
            }
        ));
        tbAccesos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAccesosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAccesos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 390, 1070, 180));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLeer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnCrear)
                .addGap(42, 42, 42)
                .addComponent(btnLeer)
                .addGap(37, 37, 37)
                .addComponent(btnActualizar)
                .addGap(40, 40, 40)
                .addComponent(btnEliminar)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 160, 500));

        txtID.setEditable(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 190, 30));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID del Usuario:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 120, 20));

        txtUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUSERActionPerformed(evt);
            }
        });
        jPanel1.add(txtUSER, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 250, 30));

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CONTRASEÑA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 120, 20));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CONTROL DE ACCESO");

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
                .addContainerGap(437, Short.MAX_VALUE)
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

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));
        jPanel7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("USUARIO:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(23, 23, 23))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 120, 20));

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ROLES:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(184, 184, 184))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 70, 20));

        txtPASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPASSWORDActionPerformed(evt);
            }
        });
        jPanel1.add(txtPASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 250, 30));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        GrupoRoles.add(chkCLIENTES);
        chkCLIENTES.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        chkCLIENTES.setForeground(new java.awt.Color(255, 255, 255));
        chkCLIENTES.setText("CLIENTES");

        GrupoRoles.add(chkMEMBRESIAS);
        chkMEMBRESIAS.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        chkMEMBRESIAS.setForeground(new java.awt.Color(255, 255, 255));
        chkMEMBRESIAS.setText("MEMBRESIAS");

        GrupoRoles.add(chkHORARIOS);
        chkHORARIOS.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        chkHORARIOS.setForeground(new java.awt.Color(255, 255, 255));
        chkHORARIOS.setText("HORARIOS");

        GrupoRoles.add(chkADMIN);
        chkADMIN.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        chkADMIN.setForeground(new java.awt.Color(255, 255, 255));
        chkADMIN.setText("ADMINISTRADOR");

        GrupoRoles.add(chkMENSAJERIA);
        chkMENSAJERIA.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        chkMENSAJERIA.setForeground(new java.awt.Color(255, 255, 255));
        chkMENSAJERIA.setText("MENSAJERIA");

        GrupoRoles.add(chkFACTURACION);
        chkFACTURACION.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        chkFACTURACION.setForeground(new java.awt.Color(255, 255, 255));
        chkFACTURACION.setText("FACTURACION");

        GrupoRoles.add(chkACESSCONTROL);
        chkACESSCONTROL.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        chkACESSCONTROL.setForeground(new java.awt.Color(255, 255, 255));
        chkACESSCONTROL.setText("CONTROL DE ACCESO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(chkADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chkHORARIOS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(chkACESSCONTROL, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(chkCLIENTES, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkMENSAJERIA, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(chkMEMBRESIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkFACTURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(chkADMIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkCLIENTES, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMENSAJERIA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkFACTURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMEMBRESIAS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkHORARIOS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkACESSCONTROL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 330, 170));

        FONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMain.jpg"))); // NOI18N
        jPanel1.add(FONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -5, 1050, 570));

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

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUSERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUSERActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        this.CrearRoles();
        this.Limpiar();
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        this.Limpiar();
        this.LeerRoles();
    }//GEN-LAST:event_btnLeerActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        this.ActualizarRoles();
        this.Limpiar();
        this.LeerRoles();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.EliminarRoles();
        this.Limpiar();
        this.LeerRoles();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCASAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCASAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCASAActionPerformed

    private void btnCASAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCASAMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCASAMouseClicked

    private void tbAccesosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccesosMouseClicked
        int fila = tbAccesos.getSelectedRow();
        txtID.setText(tbAccesos.getValueAt(fila, 0).toString());
        txtUSER.setText(tbAccesos.getValueAt(fila, 1).toString());
        txtPASSWORD.setText(tbAccesos.getValueAt(fila, 2).toString());


    }//GEN-LAST:event_tbAccesosMouseClicked

    private void txtPASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPASSWORDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPASSWORDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FONDO;
    private javax.swing.ButtonGroup GrupoRoles;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCASA;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLeer;
    private javax.swing.JCheckBox chkACESSCONTROL;
    private javax.swing.JCheckBox chkADMIN;
    private javax.swing.JCheckBox chkCLIENTES;
    private javax.swing.JCheckBox chkFACTURACION;
    private javax.swing.JCheckBox chkHORARIOS;
    private javax.swing.JCheckBox chkMEMBRESIAS;
    private javax.swing.JCheckBox chkMENSAJERIA;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAccesos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPASSWORD;
    private javax.swing.JTextField txtUSER;
    // End of variables declaration//GEN-END:variables
}
