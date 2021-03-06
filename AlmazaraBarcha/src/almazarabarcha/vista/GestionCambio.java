/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almazarabarcha.vista;

import almazarabarcha.Modelo.GestorAlmazara;
import almazarabarcha.estilos.Estilos;
import capaDAO.DaoCambio;
import excepciones.BusinessException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import pojos.Cambio;
import pojos.Proveedor;
import pojos.Usuario;

/**
 *
 * @author jose
 */
public class GestionCambio extends JFrame {

    private Proveedor p;
    private List<Cambio> cambiosPagados;
    private List<Cambio> cambiosNoPagados;
    private JPanel jpanel;
    private JPanel jpanel1;
    private Estilos estilos;
    private GestorAlmazara ga;
    private Usuario u;

    /**
     * Creates new form GestionMolturaciones
     */

    public GestionCambio(Proveedor p, JPanel jpanel, JPanel jPanel1, Usuario u) {
        initComponents();

        estilos = new Estilos();
        this.jpanel = jpanel;
        this.jpanel1 = jPanel1;
        this.p = p;
        this.u = u;
        float kg_totales = 0;
        float litro_cambio_totales = 0;
        float litros_retira_totales = 0;
        float precio_total = 0;
        ga = new GestorAlmazara();
        

        try {
            cambiosNoPagados = DaoCambio.getCambiosNoPagadas(p);
            cambiosPagados = DaoCambio.getCambiosPagadas(p);
        } catch (BusinessException ex) {
            Logger.getLogger(GestionMolturaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cambiosNoPagados.isEmpty()){
            btn_pagar.setVisible(false);
        }
               
        DefaultTableModel modelo_no_pagados = (DefaultTableModel) tabla_no_pagados.getModel();
        Object[] filaNoPagados = new Object[6];
        for (Cambio c : cambiosNoPagados) {
            filaNoPagados[0] = c.getIdCambio();
            filaNoPagados[1] = c.getFecha();
            filaNoPagados[2] = c.getKgOliva();
            filaNoPagados[3] = c.getLitrosAceiteRetirados();
            filaNoPagados[4] = c.getLitrosAceiteCambio();
            filaNoPagados[5] = c.getPrecioMolturacion();
            modelo_no_pagados.addRow(filaNoPagados);
            kg_totales += c.getKgOliva();
            litro_cambio_totales += c.getLitrosAceiteCambio();
            litros_retira_totales += c.getLitrosAceiteRetirados();
            precio_total += c.getPrecioMolturacion();

        }
        lb_kgOliva_totales1.setText(String.format("% .2f", kg_totales) + " Kg");
        lb_retirados_totales.setText(String.format("% .2f", litros_retira_totales) + " L");
        lb_totales_p_cambio.setText(String.format("% .2f", litro_cambio_totales) + " L");
        lb_precio_total.setText(String.format("% .2f", precio_total) + " €");
        lb_nombre_cliente.setText(p.getNombre());
        lb_nombre_usuario.setText(u.getNombre());

        /*DefaultTableModel modelo_pagados = (DefaultTableModel) tabla_pagados.getModel();
         Object[] filaPagados = new Object[2];
         for (Cambio c : cambiosPagados) {
         filaPagados[0] = c.getIdCambio();
         filaPagados[1] = c.getFecha();
            
         modelo_pagados.addRow(filaPagados);   
         }*/
        tabla_no_pagados.setModel(modelo_no_pagados);
        //tabla_pagados.setModel(modelo_pagados);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_no_pagados = new javax.swing.JTable();
        label_no_pagados = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_precio_total = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_retirados_totales = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_kgOliva_totales1 = new javax.swing.JLabel();
        lb_totales_p_cambio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_nombre_cliente = new javax.swing.JLabel();
        lb_nombre_usuario = new javax.swing.JLabel();
        btn_pagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        label_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Gestión Cambio");

        tabla_no_pagados.setBackground(new java.awt.Color(255, 153, 153));
        tabla_no_pagados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabla_no_pagados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Kg Oliva", "Litros retirados", "Litros cambio", "Precio molturacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_no_pagados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla_no_pagados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_no_pagadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_no_pagados);

        label_no_pagados.setText("Tabla de cambios");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Precio total:");

        lb_precio_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_precio_total.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Kg Oliva Totales:");

        lb_retirados_totales.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_retirados_totales.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Litros totales para cambio:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Litros retirados totales:");

        lb_kgOliva_totales1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_kgOliva_totales1.setText("jLabel2");

        lb_totales_p_cambio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_totales_p_cambio.setText("jLabel2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Usuario:");

        lb_nombre_cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nombre_cliente.setText("jLabel2");

        lb_nombre_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nombre_usuario.setText("jLabel2");

        btn_pagar.setText("Pagar");
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(648, 648, 648)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_nombre_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_retirados_totales, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lb_totales_p_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(171, 171, 171))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_precio_total, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lb_kgOliva_totales1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(132, 132, 132))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_no_pagados)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_no_pagados)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(lb_nombre_cliente)
                            .addComponent(lb_nombre_usuario))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lb_kgOliva_totales1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_retirados_totales)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lb_totales_p_cambio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lb_precio_total)
                            .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_no_pagadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_no_pagadosMouseClicked
        FinalizarCambio fc = new FinalizarCambio(jpanel, u, p, cambiosNoPagados.get(tabla_no_pagados.getSelectedRow()));
        jpanel1.removeAll();
        fc.getContentPane().setBackground(estilos.getColorInterior());
        jpanel1.add(fc.getContentPane());
        jpanel1.repaint();
    }//GEN-LAST:event_tabla_no_pagadosMouseClicked

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
        ga.GeneraAlbaranConParametros(p);
        for (Cambio c : cambiosNoPagados) {
            c.setPaga(true);
            try {
                DaoCambio.update(c);
            } catch (BusinessException ex) {
                Logger.getLogger(GestionCambio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        GestorAlmazara.RetrocederASeleccionarCliente(jpanel, estilos, u);
    }//GEN-LAST:event_btn_pagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_no_pagados;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel lb_kgOliva_totales1;
    private javax.swing.JLabel lb_nombre_cliente;
    private javax.swing.JLabel lb_nombre_usuario;
    private javax.swing.JLabel lb_precio_total;
    private javax.swing.JLabel lb_retirados_totales;
    private javax.swing.JLabel lb_totales_p_cambio;
    private javax.swing.JTable tabla_no_pagados;
    // End of variables declaration//GEN-END:variables
}
