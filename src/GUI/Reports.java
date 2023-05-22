/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Databases.DB;
import Databases.Table.GrnManager;
import Databases.Table.InvoiceManager;
import Databases.Table.ProductManager;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nipun
 */
public class Reports extends javax.swing.JPanel {

    private static Reports instance;

    public static synchronized Reports getInstance() {
        if (instance == null) {
            instance = new Reports();
        }
        return instance;
    }

    /**
     * Creates new form Reports
     */
    public Reports() {
        initComponents();

        mainInvoice.getTableHeader().setFont(new Font("Nirmala UI", 1, 16));
        invoiceItemTable.getTableHeader().setFont(new Font("Nirmala UI", 1, 16));
        mainGrn.getTableHeader().setFont(new Font("Nirmala UI", 1, 16));
        grnItemTable.getTableHeader().setFont(new Font("Nirmala UI", 1, 16));
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
        jScrollPane2 = new javax.swing.JScrollPane();
        reportList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        from = new com.toedter.calendar.JDateChooser();
        to = new com.toedter.calendar.JDateChooser();
        id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        idTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        mainReport = new javax.swing.JPanel();
        invoice = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainInvoice = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        invoiceItemTable = new javax.swing.JTable();
        grn = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        mainGrn = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        grnItemTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(234, 249, 244));
        setMinimumSize(new java.awt.Dimension(1216, 708));
        setPreferredSize(new java.awt.Dimension(1216, 708));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(234, 249, 244));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N

        reportList.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        reportList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ඉන්වොයිසි", "ගැණුම් සටහන්" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        reportList.setSelectedIndex(0);
        reportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(reportList);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 460));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 200, 640));

        jPanel2.setBackground(new java.awt.Color(234, 249, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        from.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        from.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromMouseClicked(evt);
            }
        });
        from.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromPropertyChange(evt);
            }
        });
        from.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fromKeyTyped(evt);
            }
        });
        jPanel2.add(from, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 30));

        to.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        to.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                toFocusLost(evt);
            }
        });
        to.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toPropertyChange(evt);
            }
        });
        to.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                toKeyReleased(evt);
            }
        });
        jPanel2.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 130, 30));

        id.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        id.setText("ඉන්වොයිසි අංකය");
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 160, 30));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel2.setText("සිට");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        jButton1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton1.setText("සොයන්න");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 130, 30));

        idTxt.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jPanel2.add(idTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 260, 30));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel3.setText("දක්වා");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 30));

        jButton2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton2.setText("සොයන්න");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 130, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1200, 50));

        mainReport.setBackground(new java.awt.Color(234, 249, 244));
        mainReport.setLayout(new java.awt.CardLayout());

        invoice.setBackground(new java.awt.Color(234, 249, 244));
        invoice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainInvoice.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        mainInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ඉන්වොයිසි අංකය", "මුළු එකතුව", "වට්ටම", "අවසන් එකතුව", "දිනය", "පරිශීලක නාමය"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mainInvoice.setRowHeight(25);
        mainInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainInvoiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mainInvoice);

        invoice.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 950, 200));

        invoiceItemTable.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        invoiceItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "භාණ්ඩයේ නම", "ඒකක මිල", "ප්‍රමාණය", "වට්ටම", " මුළු මුදල"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceItemTable.setRowHeight(25);
        invoiceItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceItemTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(invoiceItemTable);
        if (invoiceItemTable.getColumnModel().getColumnCount() > 0) {
            invoiceItemTable.getColumnModel().getColumn(0).setPreferredWidth(450);
        }

        invoice.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 950, 390));

        mainReport.add(invoice, "card2");

        grn.setBackground(new java.awt.Color(234, 249, 244));
        grn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainGrn.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        mainGrn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ගැණුම් සටහන් අංකය", "මුළු එකතුව", "වට්ටම", "අවසන් එකතුව", "දිනය", "පරිශීලක නාමය"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mainGrn.setRowHeight(25);
        mainGrn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainGrnMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(mainGrn);

        grn.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 950, 200));

        grnItemTable.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        grnItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "භාණ්ඩයේ නම", "ඒකක මිල", "ප්‍රමාණය", " මුළු මුදල"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grnItemTable.setRowHeight(25);
        grnItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grnItemTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(grnItemTable);
        if (grnItemTable.getColumnModel().getColumnCount() > 0) {
            grnItemTable.getColumnModel().getColumn(0).setPreferredWidth(450);
        }

        grn.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 950, 390));

        mainReport.add(grn, "card3");

        add(mainReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 990, 640));
    }// </editor-fold>//GEN-END:initComponents

    private void fromMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromMouseClicked

    }//GEN-LAST:event_fromMouseClicked

    private void fromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromPropertyChange

    }//GEN-LAST:event_fromPropertyChange

    private void fromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromKeyReleased

    }//GEN-LAST:event_fromKeyReleased

    private void fromKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromKeyTyped

    }//GEN-LAST:event_fromKeyTyped

    private void toFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_toFocusLost

    }//GEN-LAST:event_toFocusLost

    private void toPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toPropertyChange

    }//GEN-LAST:event_toPropertyChange

    private void toKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_toKeyReleased

    }//GEN-LAST:event_toKeyReleased

    private void reportListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportListMouseClicked

        from.setCalendar(null);
        to.setCalendar(null);
        idTxt.setText(null);

        DefaultTableModel dtm1 = (DefaultTableModel) mainInvoice.getModel();
        DefaultTableModel dtm2 = (DefaultTableModel) invoiceItemTable.getModel();
        DefaultTableModel dtm3 = (DefaultTableModel) mainGrn.getModel();
        DefaultTableModel dtm4 = (DefaultTableModel) grnItemTable.getModel();
        dtm1.setRowCount(0);
        dtm2.setRowCount(0);
        dtm3.setRowCount(0);
        dtm4.setRowCount(0);

        switch (reportList.getSelectedValue()) {
            case "ඉන්වොයිසි":
                mainReport.removeAll();
                mainReport.add(invoice);
                mainReport.repaint();
                mainReport.revalidate();
                id.setText("ඉන්වොයිසි අංකය");
                break;
            case "ගැණුම් සටහන්":
                mainReport.removeAll();
                mainReport.add(grn);
                mainReport.repaint();
                mainReport.revalidate();
                id.setText("ගැණුම් සටහන් අංකය");
                break;

        

        }
    }//GEN-LAST:event_reportListMouseClicked

    private void invoiceItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceItemTableMouseClicked

    }//GEN-LAST:event_invoiceItemTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        switch (reportList.getSelectedValue()) {
            case "ඉන්වොයිසි":
                if (from.getDate() != null && to.getDate() != null) {
                    DefaultTableModel dtm = (DefaultTableModel) mainInvoice.getModel();
                    dtm.setRowCount(0);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ResultSet result = InvoiceManager.getInvoicesBetweenDates(sdf.format(from.getDate()), sdf.format(to.getDate()));
                    try {

                        while (result.next()) {
                            Vector v = new Vector();

                            v.add(result.getString("idinvoice"));

                            double sub = result.getDouble("sub_total");
                            double net = result.getDouble("net_total");

                            v.add("රු. " + sub);
                            v.add("රු. " + String.valueOf(sub - net));
                            v.add("රු. " + net);
                            v.add(result.getString("date"));
                            v.add(result.getString("username"));
                            dtm.addRow(v);
                        }

                    } catch (SQLException ex) {
                        DB.processException(ex);
                    }
                }
                break;
            case "ගැණුම් සටහන්":

                if (from.getDate() != null && to.getDate() != null) {
                    DefaultTableModel dtm = (DefaultTableModel) mainGrn.getModel();
                    dtm.setRowCount(0);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ResultSet result = GrnManager.getGrnBetweenDates(sdf.format(from.getDate()), sdf.format(to.getDate()));
                    try {

                        while (result.next()) {
                            Vector v = new Vector();

                            v.add(result.getString("idgrn"));

                            double sub = result.getDouble("sub_total");
                            double net = result.getDouble("net_total");

                            v.add("රු. " + sub);
                            v.add("රු. " + String.valueOf(sub - net));
                            v.add("රු. " + net);
                            v.add(result.getString("date"));
                            v.add(result.getString("username"));
                            dtm.addRow(v);
                        }

                    } catch (SQLException ex) {
                        DB.processException(ex);
                    }
                }

                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mainInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainInvoiceMouseClicked

        if (mainInvoice.getSelectedRow() != -1) {

            String invId = (String) mainInvoice.getValueAt(mainInvoice.getSelectedRow(), 0);

            DefaultTableModel dtm = (DefaultTableModel) invoiceItemTable.getModel();
            dtm.setRowCount(0);

            ResultSet result = InvoiceManager.getInvoiceItemById(invId);
            try {

                while (result.next()) {
                    Vector v = new Vector();

                    v.add(result.getString("code") + " - " + result.getString("barcode") + " - " + result.getString("product_name") + " - " + result.getString("weight"));

                    double sellingPrice = result.getDouble("selling_price");
                    double qty = result.getDouble("invoice_item.qty");
                    double discount = result.getDouble("invoice_item.discount");

                    v.add("රු. " + sellingPrice);
                    v.add(qty);
                    v.add("රු. " + discount);
                    v.add("රු. " + String.valueOf((sellingPrice * qty) - discount));

                    dtm.addRow(v);
                }

            } catch (SQLException ex) {
                DB.processException(ex);
            }

        }

    }//GEN-LAST:event_mainInvoiceMouseClicked

    private void mainGrnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainGrnMouseClicked

        if (mainGrn.getSelectedRow() != -1) {

            String grnId = (String) mainGrn.getValueAt(mainGrn.getSelectedRow(), 0);

            DefaultTableModel dtm = (DefaultTableModel) grnItemTable.getModel();
            dtm.setRowCount(0);

            ResultSet result = GrnManager.getGrnItemById(grnId);
            try {

                while (result.next()) {
                    Vector v = new Vector();

                    v.add(result.getString("code") + " - " + result.getString("barcode") + " - " + result.getString("product_name") + " - " + result.getString("weight"));

                    double sellingPrice = result.getDouble("cost");
                    double qty = result.getDouble("qty");

                    v.add("රු. " + sellingPrice);
                    v.add(qty);
                    v.add("රු. " + String.valueOf(sellingPrice * qty));

                    dtm.addRow(v);
                }

            } catch (SQLException ex) {
                DB.processException(ex);
            }

        }
    }//GEN-LAST:event_mainGrnMouseClicked

    private void grnItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnItemTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_grnItemTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        switch (reportList.getSelectedValue()) {
            case "ඉන්වොයිසි":
                String invId = idTxt.getText().trim();
                if (!invId.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) mainInvoice.getModel();
                    dtm.setRowCount(0);
                    ResultSet result = InvoiceManager.getInvoicesById(invId);
                    try {

                        while (result.next()) {
                            Vector v = new Vector();

                            v.add(result.getString("idinvoice"));

                            double sub = result.getDouble("sub_total");
                            double net = result.getDouble("net_total");

                            v.add("රු. " + sub);
                            v.add("රු. " + String.valueOf(sub - net));
                            v.add("රු. " + net);
                            v.add(result.getString("date"));
                            v.add(result.getString("username"));
                            dtm.addRow(v);
                        }

                        DefaultTableModel dtm1 = (DefaultTableModel) invoiceItemTable.getModel();
                        dtm1.setRowCount(0);

                        ResultSet result1 = InvoiceManager.getInvoiceItemById(invId);

                        while (result1.next()) {
                            Vector v = new Vector();

                            v.add(result1.getString("code") + " - " + result1.getString("barcode") + " - " + result1.getString("product_name") + " - " + result1.getString("weight"));

                            double sellingPrice = result1.getDouble("selling_price");
                            double qty = result1.getDouble("invoice_item.qty");
                            double discount = result1.getDouble("invoice_item.discount");

                            v.add("රු. " + sellingPrice);
                            v.add(qty);
                            v.add("රු. " + discount);
                            v.add("රු. " + String.valueOf((sellingPrice * qty) - discount));

                            dtm1.addRow(v);
                        }

                    } catch (SQLException ex) {
                        DB.processException(ex);
                    }
                }
                break;

            case "ගැණුම් සටහන්":

                String grnId = idTxt.getText().trim();
                if (!grnId.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) mainGrn.getModel();
                    dtm.setRowCount(0);
                    ResultSet result = GrnManager.getGrnById(grnId);
                    try {

                        while (result.next()) {
                            Vector v = new Vector();

                            v.add(result.getString("idgrn"));

                            double sub = result.getDouble("sub_total");
                            double net = result.getDouble("net_total");

                            v.add("රු. " + sub);
                            v.add("රු. " + String.valueOf(sub - net));
                            v.add("රු. " + net);
                            v.add(result.getString("date"));
                            v.add(result.getString("username"));
                            dtm.addRow(v);
                        }

                        DefaultTableModel dtm1 = (DefaultTableModel) grnItemTable.getModel();
                        dtm1.setRowCount(0);

                        ResultSet result1 = GrnManager.getGrnItemById(grnId);

                        while (result1.next()) {
                            Vector v = new Vector();

                            v.add(result1.getString("code") + " - " + result1.getString("barcode") + " - " + result1.getString("product_name") + " - " + result1.getString("weight"));

                            double sellingPrice = result1.getDouble("cost");
                            double qty = result1.getDouble("qty");

                            v.add("රු. " + sellingPrice);
                            v.add(qty);
                            v.add("රු. " + String.valueOf(sellingPrice * qty));

                            dtm1.addRow(v);
                        }

                    } catch (SQLException ex) {
                        DB.processException(ex);
                    }
                }

                break;
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser from;
    private javax.swing.JPanel grn;
    private javax.swing.JTable grnItemTable;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idTxt;
    private javax.swing.JPanel invoice;
    private javax.swing.JTable invoiceItemTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable mainGrn;
    private javax.swing.JTable mainInvoice;
    private javax.swing.JPanel mainReport;
    private javax.swing.JList<String> reportList;
    private com.toedter.calendar.JDateChooser to;
    // End of variables declaration//GEN-END:variables
}