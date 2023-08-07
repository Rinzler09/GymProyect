package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Artica
 */
public class _Facturacion extends javax.swing.JFrame {

    public _Facturacion() {
        initComponents();

        ButtonGroup formaPagoGroup = new ButtonGroup();
        formaPagoGroup.add(jrbtn_tarjeta);
        formaPagoGroup.add(jrbtn_tranferencia);
        formaPagoGroup.add(jrbtn_efectivo);

        jp_detallesPersonales.setVisible(true);
        jp_detallePagos.setVisible(false);
        lb_datos1.setVisible(true);
        lb_formaPago.setVisible(true);
        jrbtn_efectivo.setVisible(true);
        jrbtn_tarjeta.setVisible(true);
        jrbtn_tranferencia.setVisible(true);
        lb_datosDePago.setVisible(false);
        lb_identidad.setVisible(false);
        lb_nombreTitular.setVisible(false);
        lb_numeroTarjeta.setVisible(false);
        txt_nombreTarjeta.setVisible(false);
        txt_numeroTarjeta.setVisible(false);
        txt_identidad.setVisible(false);
        cbo_mes.setVisible(false);
        cbo_anio.setVisible(false);
        lb_mes.setVisible(false);
        lb_anio.setVisible(false);

        jrbtn_tarjeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp_detallesPersonales.setVisible(true);
                jp_detallePagos.setVisible(true);
                lb_datos1.setVisible(true);
                lb_datosDePago.setVisible(true);
                lb_identidad.setVisible(true);
                lb_nombreTitular.setVisible(true);
                lb_numeroTarjeta.setVisible(true);
                txt_nombreTarjeta.setVisible(true);
                txt_numeroTarjeta.setVisible(true);
                txt_identidad.setVisible(true);
                lb_datos1.setVisible(true);
                cbo_mes.setVisible(true);
                cbo_anio.setVisible(true);
                lb_mes.setVisible(true);
                lb_anio.setVisible(true);
            }
        });

        jrbtn_tranferencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp_detallesPersonales.setVisible(true);
                jp_detallePagos.setVisible(true);
                lb_datos1.setVisible(false);
                lb_datosDePago.setVisible(false);
                lb_identidad.setVisible(false);
                lb_nombreTitular.setVisible(false);
                lb_numeroTarjeta.setVisible(false);
                txt_nombreTarjeta.setVisible(false);
                txt_numeroTarjeta.setVisible(false);
                txt_identidad.setVisible(false);
                lb_datos1.setVisible(true);
                cbo_mes.setVisible(false);
                cbo_anio.setVisible(false);
                lb_mes.setVisible(false);
                lb_anio.setVisible(false);
            }
        });

        jrbtn_efectivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp_detallesPersonales.setVisible(true);
                jp_detallePagos.setVisible(true);
                lb_datos1.setVisible(false);
                lb_datosDePago.setVisible(false);
                lb_identidad.setVisible(false);
                lb_nombreTitular.setVisible(false);
                lb_numeroTarjeta.setVisible(false);
                txt_nombreTarjeta.setVisible(false);
                txt_numeroTarjeta.setVisible(false);
                txt_identidad.setVisible(false);
                lb_datos1.setVisible(true);
                cbo_mes.setVisible(false);
                cbo_anio.setVisible(false);
                lb_mes.setVisible(false);
                lb_anio.setVisible(false);
            }
        });

        cbo_membresia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String membresiaSeleccionada = (String) cbo_membresia.getSelectedItem();
                System.out.println("Membresía seleccionada: " + membresiaSeleccionada);

                int cuotas = 0;
                try {
                    cuotas = Integer.parseInt(txt_cuotas.getText());
                } catch (NumberFormatException ex) {
                    System.out.println("Error al convertir cuotas a número");
                }
                System.out.println("Cuotas: " + cuotas);

                int subtotal = 0;
                if (membresiaSeleccionada.equals("Principiante")) {
                    subtotal = cuotas * 500;
                } else if (membresiaSeleccionada.equals("Profesional")) {
                    subtotal = cuotas * 700;
                } else if (membresiaSeleccionada.equals("VIP")) {
                    subtotal = cuotas * 1000;
                }
                System.out.println("Subtotal calculado: " + subtotal);

                txt_subtotal.setText(String.valueOf(subtotal));

                double impuesto = subtotal * 0.15;
                txt_impuestos.setText(String.valueOf(impuesto));

                int diasAtraso = 0;
                try {
                    diasAtraso = Integer.parseInt(txt_diasAtraso.getText());
                } catch (NumberFormatException ex) {
                    System.out.println("Error al convertir días de atraso a número");
                }
                System.out.println("Días de atraso: " + diasAtraso);

                double semanasAtraso = diasAtraso / 7;
                System.out.println("Semanas de atraso: " + semanasAtraso);

                double recargo = semanasAtraso * 25;
                txt_recargos.setText(String.valueOf(recargo));

                int descuento = 0;
                try {
                    descuento = Integer.parseInt(txt_descuento.getText());
                } catch (NumberFormatException ex) {
                    System.out.println("Error al convertir descuento a número");
                }
                System.out.println("Descuento: " + descuento);

                double total = subtotal - descuento + recargo + impuesto;
                txt_Total.setText(String.valueOf(total));
            }
        });

        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }

            private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú'
                        && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'ü' && c != 'Ü') {
                    evt.consume();  // Consume el evento si se ingresó un carácter no permitido
                    JOptionPane.showMessageDialog(null, "Solo se permiten letras y vocales acentuadas.");
                }
            }
        });

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }

            private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != '+' && c != '(' && c != ')') {
                    evt.consume();  // Consume el evento si se ingresó un carácter no permitido
                    JOptionPane.showMessageDialog(null, "Solo se permiten números, +, ( y ).");
                }
            }
        });

        txt_nombreTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreTarjetaKeyTyped(evt);
            }

            private void txt_nombreTarjetaKeyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' && c != 'á' && c != 'é' && c != 'í' && c != 'ó' && c != 'ú'
                        && c != 'Á' && c != 'É' && c != 'Í' && c != 'Ó' && c != 'Ú' && c != 'ü' && c != 'Ü') {
                    evt.consume();  // Consume el evento si se ingresó un carácter no permitido
                    JOptionPane.showMessageDialog(null, "Solo se permiten letras y vocales acentuadas.");
                }
            }
        });

        txt_numeroTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_numeroTarjetaKeyTyped(evt);
            }

            private void txt_numeroTarjetaKeyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();  // Consume el evento si se ingresó un carácter no numérico
                    JOptionPane.showMessageDialog(null, "Solo se permiten números.");
                }
            }
        });

        txt_cuotas.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cuotasKeyTyped(evt);
            }

            private void txt_cuotasKeyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();  // Consume el evento si se ingresó un carácter no numérico
                    JOptionPane.showMessageDialog(null, "Solo se permiten números.");
                }
            }
        });

        txt_diasAtraso.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_diasAtrasoKeyTyped(evt);
            }

            private void txt_diasAtrasoKeyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();  // Consume el evento si se ingresó un carácter no numérico
                    JOptionPane.showMessageDialog(null, "Solo se permiten números.");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lb_cuotas1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp_detallesPersonales = new javax.swing.JPanel();
        jrbtn_tarjeta = new javax.swing.JRadioButton();
        jrbtn_tranferencia = new javax.swing.JRadioButton();
        jrbtn_efectivo = new javax.swing.JRadioButton();
        lb_formaPago = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        lb_telefono = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        lb_datosDePago = new javax.swing.JLabel();
        lb_numeroTarjeta = new javax.swing.JLabel();
        lb_nombreTitular = new javax.swing.JLabel();
        lb_identidad = new javax.swing.JLabel();
        txt_nombreTarjeta = new javax.swing.JTextField();
        txt_numeroTarjeta = new javax.swing.JTextField();
        txt_identidad = new javax.swing.JTextField();
        lb_datos1 = new javax.swing.JLabel();
        lb_anio = new javax.swing.JLabel();
        lb_mes = new javax.swing.JLabel();
        cbo_mes = new javax.swing.JComboBox<>();
        cbo_anio = new javax.swing.JComboBox<>();
        jp_detallePagos = new javax.swing.JPanel();
        lb_detallePago = new javax.swing.JLabel();
        lb_subtotal = new javax.swing.JLabel();
        txt_diasAtraso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        lb_descripcion = new javax.swing.JLabel();
        lb_cuotas = new javax.swing.JLabel();
        lb_descuento = new javax.swing.JLabel();
        lb_recargos = new javax.swing.JLabel();
        lb_impuesto = new javax.swing.JLabel();
        lb_total = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_recargos = new javax.swing.JTextField();
        txt_impuestos = new javax.swing.JTextField();
        txt_Total = new javax.swing.JTextField();
        btn_pagar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        lb_diasAtraso = new javax.swing.JLabel();
        txt_cuotas = new javax.swing.JTextField();
        lb_membresia = new javax.swing.JLabel();
        cbo_membresia = new javax.swing.JComboBox<>();
        Fondo = new javax.swing.JLabel();

        jTextField6.setText("jTextField6");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        lb_cuotas1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_cuotas1.setText("Cuotas: ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Encabezado.setBackground(new java.awt.Color(0, 204, 204));
        Encabezado.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FACTURACIÓN");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout EncabezadoLayout = new javax.swing.GroupLayout(Encabezado);
        Encabezado.setLayout(EncabezadoLayout);
        EncabezadoLayout.setHorizontalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        EncabezadoLayout.setVerticalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncabezadoLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
        );

        jPanel1.add(Encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 930, 80));

        jp_detallesPersonales.setBackground(new java.awt.Color(102, 102, 102));
        jp_detallesPersonales.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jrbtn_tarjeta.setText("Tarjeta de Credito");

        jrbtn_tranferencia.setText("Tranferencia");

        jrbtn_efectivo.setText("Efectivo");

        lb_formaPago.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_formaPago.setText("Forma de Pago");
        lb_formaPago.setToolTipText("");

        lb_nombre.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_nombre.setText("Nombre: ");

        lb_telefono.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_telefono.setText("Telefono: ");
        lb_telefono.setToolTipText("");

        lb_email.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_email.setText("E mail: ");
        lb_email.setToolTipText("");

        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });

        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });

        lb_datosDePago.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_datosDePago.setText("Datos de la Tarjeta Crédito / Debito");
        lb_datosDePago.setToolTipText("");

        lb_numeroTarjeta.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_numeroTarjeta.setText("Número de Tarjeta: ");

        lb_nombreTitular.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_nombreTitular.setText("Nombre Titular: ");

        lb_identidad.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_identidad.setText("Identidad: ");

        lb_datos1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_datos1.setText("Confirmación de Datos");
        lb_datos1.setToolTipText("");

        lb_anio.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_anio.setText("Año: ");

        lb_mes.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lb_mes.setText("Mes: ");

        cbo_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbo_anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028" }));

        javax.swing.GroupLayout jp_detallesPersonalesLayout = new javax.swing.GroupLayout(jp_detallesPersonales);
        jp_detallesPersonales.setLayout(jp_detallesPersonalesLayout);
        jp_detallesPersonalesLayout.setHorizontalGroup(
            jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_datosDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                        .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                                    .addComponent(lb_formaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrbtn_tarjeta)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrbtn_efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrbtn_tranferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                                    .addComponent(lb_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_telefono)
                                    .addGap(53, 53, 53)))
                            .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                                .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                                .addComponent(lb_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_detallesPersonalesLayout.createSequentialGroup()
                                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                                        .addComponent(lb_mes, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                        .addGap(75, 75, 75))
                                    .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                                        .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lb_identidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lb_nombreTitular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lb_numeroTarjeta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                            .addComponent(lb_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_nombreTarjeta)
                                        .addComponent(txt_identidad, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                        .addComponent(txt_numeroTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                                    .addComponent(cbo_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(lb_datos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jp_detallesPersonalesLayout.setVerticalGroup(
            jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_formaPago)
                    .addComponent(jrbtn_efectivo)
                    .addComponent(jrbtn_tarjeta)
                    .addComponent(jrbtn_tranferencia))
                .addGap(43, 43, 43)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lb_datosDePago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nombreTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombreTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                        .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_numeroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_numeroTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(lb_identidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_anio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(jp_detallesPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jp_detallesPersonalesLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(lb_datos1)
                    .addContainerGap(326, Short.MAX_VALUE)))
        );

        jPanel1.add(jp_detallesPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 460, 410));

        jp_detallePagos.setBackground(new java.awt.Color(102, 102, 102));
        jp_detallePagos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lb_detallePago.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lb_detallePago.setText("Detalle de Pago");
        lb_detallePago.setToolTipText("");

        lb_subtotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_subtotal.setText("Subtotal: ");
        lb_subtotal.setToolTipText("");

        txt_diasAtraso.setToolTipText("");
        txt_diasAtraso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diasAtrasoActionPerformed(evt);
            }
        });

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        lb_descripcion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_descripcion.setText("Descripcion: ");

        lb_cuotas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_cuotas.setText("Cuotas: ");

        lb_descuento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_descuento.setText("Descuento: ");

        lb_recargos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_recargos.setText("Recargos: ");
        lb_recargos.setToolTipText("");

        lb_impuesto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_impuesto.setText("Impuestos:  ");
        lb_impuesto.setToolTipText("");

        lb_total.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lb_total.setText("Total: ");

        txt_subtotal.setEditable(false);

        txt_recargos.setEditable(false);

        txt_impuestos.setEditable(false);

        txt_Total.setEditable(false);

        btn_pagar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_pagar.setText("Pagar");
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        lb_diasAtraso.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_diasAtraso.setText("Días Atrasados");
        lb_diasAtraso.setToolTipText("");

        txt_cuotas.setToolTipText("");
        txt_cuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cuotasActionPerformed(evt);
            }
        });

        lb_membresia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lb_membresia.setText("Membresias: ");
        lb_membresia.setToolTipText("");

        cbo_membresia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principiante", "Profesional", "VIP" }));

        javax.swing.GroupLayout jp_detallePagosLayout = new javax.swing.GroupLayout(jp_detallePagos);
        jp_detallePagos.setLayout(jp_detallePagosLayout);
        jp_detallePagosLayout.setHorizontalGroup(
            jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_detallePagosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_detallePagosLayout.createSequentialGroup()
                        .addComponent(lb_membresia)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_membresia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jp_detallePagosLayout.createSequentialGroup()
                        .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_detallePagosLayout.createSequentialGroup()
                                .addComponent(lb_total)
                                .addGap(48, 48, 48)
                                .addComponent(txt_Total))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_detallePagosLayout.createSequentialGroup()
                                .addComponent(lb_impuesto)
                                .addGap(18, 18, 18)
                                .addComponent(txt_impuestos))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jp_detallePagosLayout.createSequentialGroup()
                                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_subtotal)
                                    .addComponent(lb_descuento))
                                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_detallePagosLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jp_detallePagosLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_recargos, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                            .addComponent(txt_descuento))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(jp_detallePagosLayout.createSequentialGroup()
                        .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_detallePago)
                            .addComponent(lb_recargos)
                            .addComponent(lb_descripcion)
                            .addGroup(jp_detallePagosLayout.createSequentialGroup()
                                .addComponent(lb_cuotas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lb_diasAtraso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_diasAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jp_detallePagosLayout.setVerticalGroup(
            jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_detallePagosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lb_detallePago)
                .addGap(18, 18, 18)
                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cuotas)
                    .addComponent(lb_diasAtraso)
                    .addComponent(txt_diasAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_membresia)
                    .addComponent(cbo_membresia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lb_descripcion)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_subtotal)
                    .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_descuento)
                    .addComponent(txt_descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_recargos)
                    .addComponent(txt_recargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_impuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_cancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp_detallePagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_total)
                    .addComponent(txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel1.add(jp_detallePagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 380, 410));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoMain.jpg"))); // NOI18N
        Fondo.setText("jLabel1");
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_diasAtrasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diasAtrasoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diasAtrasoActionPerformed

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
        double total = Double.parseDouble(txt_Total.getText());

        JOptionPane.showMessageDialog(this,
                "Pago realizado con éxito\nTotal: Lps. " + total,
                "Pago Realizado", JOptionPane.INFORMATION_MESSAGE);

        jp_detallesPersonales.setVisible(true);
        jp_detallePagos.setVisible(false);
        lb_datos1.setVisible(true);
        lb_formaPago.setVisible(true);
        jrbtn_efectivo.setVisible(true);
        jrbtn_tarjeta.setVisible(true);
        jrbtn_tranferencia.setVisible(true);
        lb_datosDePago.setVisible(false);
        lb_identidad.setVisible(false);
        lb_nombreTitular.setVisible(false);
        lb_numeroTarjeta.setVisible(false);
        txt_nombreTarjeta.setVisible(false);
        txt_numeroTarjeta.setVisible(false);
        txt_identidad.setVisible(false);
        cbo_mes.setVisible(false);
        cbo_anio.setVisible(false);
        lb_mes.setVisible(false);
        lb_anio.setVisible(false);

    }//GEN-LAST:event_btn_pagarActionPerformed

    private void txt_cuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cuotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cuotasActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        JOptionPane.showMessageDialog(this,
                "No se realizo el pago",
                "Cancelado", JOptionPane.INFORMATION_MESSAGE);

        jp_detallesPersonales.setVisible(true);
        jp_detallePagos.setVisible(false);
        lb_datos1.setVisible(true);
        lb_formaPago.setVisible(true);
        jrbtn_efectivo.setVisible(true);
        jrbtn_tarjeta.setVisible(true);
        jrbtn_tranferencia.setVisible(true);
        lb_datosDePago.setVisible(false);
        lb_identidad.setVisible(false);
        lb_nombreTitular.setVisible(false);
        lb_numeroTarjeta.setVisible(false);
        txt_nombreTarjeta.setVisible(false);
        txt_numeroTarjeta.setVisible(false);
        txt_identidad.setVisible(false);
        cbo_mes.setVisible(false);
        cbo_anio.setVisible(false);
        lb_mes.setVisible(false);
        lb_anio.setVisible(false);
    }//GEN-LAST:event_btn_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(_Facturacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(_Facturacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(_Facturacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(_Facturacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new _Facturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Encabezado;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_pagar;
    private javax.swing.JComboBox<String> cbo_anio;
    private javax.swing.JComboBox<String> cbo_membresia;
    private javax.swing.JComboBox<String> cbo_mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel jp_detallePagos;
    private javax.swing.JPanel jp_detallesPersonales;
    private javax.swing.JRadioButton jrbtn_efectivo;
    private javax.swing.JRadioButton jrbtn_tarjeta;
    private javax.swing.JRadioButton jrbtn_tranferencia;
    private javax.swing.JLabel lb_anio;
    private javax.swing.JLabel lb_cuotas;
    private javax.swing.JLabel lb_cuotas1;
    private javax.swing.JLabel lb_datos1;
    private javax.swing.JLabel lb_datosDePago;
    private javax.swing.JLabel lb_descripcion;
    private javax.swing.JLabel lb_descuento;
    private javax.swing.JLabel lb_detallePago;
    private javax.swing.JLabel lb_diasAtraso;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_formaPago;
    private javax.swing.JLabel lb_identidad;
    private javax.swing.JLabel lb_impuesto;
    private javax.swing.JLabel lb_membresia;
    private javax.swing.JLabel lb_mes;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel lb_nombreTitular;
    private javax.swing.JLabel lb_numeroTarjeta;
    private javax.swing.JLabel lb_recargos;
    private javax.swing.JLabel lb_subtotal;
    private javax.swing.JLabel lb_telefono;
    private javax.swing.JLabel lb_total;
    private javax.swing.JTextField txt_Total;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_cuotas;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_diasAtraso;
    private javax.swing.JTextField txt_identidad;
    private javax.swing.JTextField txt_impuestos;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombreTarjeta;
    private javax.swing.JTextField txt_numeroTarjeta;
    private javax.swing.JTextField txt_recargos;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
