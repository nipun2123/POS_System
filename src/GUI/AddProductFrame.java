/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Databases.Beans.Product;
import Databases.DB;
import Databases.Table.ProductManager;
import Databases.Table.SupplierManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nipun
 */
public class AddProductFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddProductFrame
     */
    private static final String CODEUSEDERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">මෙම කේතය දැනටමත් භාවිතා කර ඇත!"
            + "</font></p></html>";

    private static final String BARCODEUSEDERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">මෙම  තීරු කේතය(Bar code) දැනටමත් භාවිතා කර ඇත!"
            + "</font></p></html>";

    private static final String PRODUCTNAMEREQUIEDERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">කරුණාකර භාණ්ඩයේ නම ලබා දෙන්න!"
            + "</font></p></html>";

    private static final String BARORCODEREQUIEDERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">කරුණාකර කේතය හෝ තීරු කේතය(Bar code) ලබා දෙන්න!"
            + "</font></p></html>";

    private static final String TRYAGAINERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">ක්‍රියාවලිය සම්පූර්ණ නැත. නැවත උත්සාහ කරන්න."
            + "</font></p></html>";

    private static final String PRODUCTUSEDERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">මෙම භාණ්ඩය දැනටමත් ඇතුලත් කර ඇත!"
            + "</font></p></html>";

    boolean add = true;

    boolean isEditing = false;

    private String addedCode = "";
    private String addedBarcode = "";
    private String addedProductName = "";
    private String addedWeight = "";

    public AddProductFrame() {
        initComponents();

//         this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private static AddProductFrame instance;

    public static synchronized AddProductFrame getInstance() {
        if (instance == null) {
            instance = new AddProductFrame();
        }
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        productName = new javax.swing.JTextField();
        weight = new javax.swing.JTextField();
        barCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(234, 249, 244));
        setType(java.awt.Window.Type.POPUP);

        jPanel2.setBackground(new java.awt.Color(234, 249, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addBtn.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        addBtn.setText("ඇතුලත් කරන්න");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel2.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 3, -1, 45));

        cancelBtn.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        cancelBtn.setText(" අවලංගු කරන්න");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        jPanel2.add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 3, -1, 45));

        jPanel3.setBackground(new java.awt.Color(234, 249, 244));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel2.setText("භාණ්ඩයේ නම*");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 190, 30));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel3.setText("කේතය");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, 30));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel4.setText("බර");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, 30));

        code.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        code.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codeFocusLost(evt);
            }
        });
        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codeKeyTyped(evt);
            }
        });
        jPanel3.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 400, 30));

        productName.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        productName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productNameKeyTyped(evt);
            }
        });
        jPanel3.add(productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 400, 30));

        weight.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        weight.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                weightFocusLost(evt);
            }
        });
        weight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                weightKeyTyped(evt);
            }
        });
        jPanel3.add(weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 400, 30));

        barCode.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        barCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                barCodeFocusLost(evt);
            }
        });
        barCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                barCodeKeyTyped(evt);
            }
        });
        jPanel3.add(barCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 400, 30));

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel6.setText(" තීරු කේතය(Bar code)");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 160, 30));

        jPanel1.setBackground(new java.awt.Color(234, 249, 244));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        if (!productName.getText().toString().isEmpty()) {

            System.out.println("Name have");
            if (!(code.getText().toString().isEmpty() && barCode.getText().toString().isEmpty())) {

                if (add) {
                    if (!isEditing) {
                        System.out.println("no edit");

                        if (!ProductManager.isCodeExits(code.getText())) {
                                  if (!ProductManager.isBarcodeExits(barCode.getText())) {
                            if (!ProductManager.isNameWeightExits(productName.getText(), weight.getText())) {

                                Product product = new Product().setProductName(productName.getText());
                                if (!code.getText().isEmpty()) {
                                    product.setCode(code.getText());
                                }

                                if (!barCode.getText().isEmpty()) {
                                    product.setBarcode(barCode.getText());
                                }

                                if (!weight.getText().isEmpty()) {
                                    product.setWeight(weight.getText());
                                }

                                if (ProductManager.addProduct(product)) {
                                    clearFeilds();
                                    this.dispose();
                                    Stock.getInstance().loadProductTable();
                                } else {
                                    JOptionPane.showMessageDialog(this, TRYAGAINERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                                }

                            } else {
                                JOptionPane.showMessageDialog(this, PRODUCTUSEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                                productName.grabFocus();
                                productName.selectAll();
                            }
                                  } else {
                                JOptionPane.showMessageDialog(this, BARCODEUSEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                                barCode.selectAll();
                                barCode.grabFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, CODEUSEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                            code.selectAll();
                            code.grabFocus();
                        }

                    } else {

                        if (!ProductManager.isCodeExits(code.getText()) || code.getText().equals(addedCode)) {

                            if (!ProductManager.isBarcodeExits(barCode.getText()) || barCode.getText().equals(addedBarcode)) {

                                System.out.println(ProductManager.isNameWeightExits(productName.getText(), weight.getText()));
                                System.out.println((productName.getText().trim().equals(addedProductName.trim())) && (weight.getText().trim().equals(addedWeight.trim())));
                                if (!ProductManager.isNameWeightExits(productName.getText(), weight.getText()) || (productName.getText().trim().equals(addedProductName.trim()) && (weight.getText().trim().equals(addedWeight.trim())))) {

                                    Product product = new Product().setProductName(productName.getText());
                                    if (!code.getText().isEmpty()) {
                                        product.setCode(code.getText());
                                    }

                                    if (!barCode.getText().isEmpty()) {
                                        product.setBarcode(barCode.getText());
                                    }

                                    if (!weight.getText().isEmpty()) {
                                        product.setWeight(weight.getText());
                                    }

                                    System.out.println(addedProductName);
                                    System.out.println(addedWeight);
                                    product.setOldProductName(addedProductName);
                                    product.setOldWeight(addedWeight);
                                    if (ProductManager.editProduct(product)) {
                                        this.dispose();
                                        Stock.getInstance().loadProductTable();
                                        clearFeilds();
                                    } else {
                                        JOptionPane.showMessageDialog(this, TRYAGAINERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(this, PRODUCTUSEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                                    productName.grabFocus();
                                    productName.selectAll();
                                }

                            } else {
                                JOptionPane.showMessageDialog(this, BARCODEUSEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                                barCode.selectAll();
                                barCode.grabFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, CODEUSEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                            code.selectAll();
                            code.grabFocus();
                        }
//

                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, BARORCODEREQUIEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, PRODUCTNAMEREQUIEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void codeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codeFocusLost
        if (ProductManager.isCodeExits(code.getText()) && !code.getText().equals(addedCode)) {
            add = false;
            JOptionPane.showMessageDialog(this, CODEUSEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
            code.selectAll();
            code.grabFocus();

        } else {
            add = true;
        }
    }//GEN-LAST:event_codeFocusLost

    private void codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }

        if (Character.isWhitespace(evt.getKeyChar())) {
            evt.consume();
        }

        if ((code.getText().length() == 5)) {
            evt.consume();
        }
    }//GEN-LAST:event_codeKeyTyped

    private void productNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productNameKeyTyped

    }//GEN-LAST:event_productNameKeyTyped

    private void weightFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_weightFocusLost

    }//GEN-LAST:event_weightFocusLost

    private void weightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weightKeyTyped


    }//GEN-LAST:event_weightKeyTyped

    private void barCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barCodeKeyTyped

    }//GEN-LAST:event_barCodeKeyTyped

    private void barCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_barCodeFocusLost
        if (ProductManager.isBarcodeExits(barCode.getText()) && !barCode.getText().equals(addedBarcode)) {
            add = false;
            JOptionPane.showMessageDialog(this, BARCODEUSEDERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
            barCode.selectAll();
            barCode.grabFocus();

        } else {
            add = true;
        }
    }//GEN-LAST:event_barCodeFocusLost

    public void clearFeilds() {
        code.setText(null);
        barCode.setText(null);
        productName.setText(null);
        weight.setText(null);
        code.grabFocus();
        code.selectAll();
        isEditing = false;
    }

    public void loadAddedProducted(String addedProductName, String addedWeight) {
        clearFeilds();
        ResultSet result = ProductManager.getProductFromNameWeight(addedProductName, addedWeight);

        try {
            if (result.next()) {
                if (!result.getString("code").equals("null")) {
                    addedCode = result.getString("code");
                    code.setText(addedCode);
                }
                if (!result.getString("barcode").equals("null")) {
                    addedBarcode = result.getString("barcode");
                    barCode.setText(addedBarcode);
                }
                this.addedProductName = result.getString("product_name");
                productName.setText(this.addedProductName);

                if (!result.getString("weight").equals("null")) {
                    this.addedWeight = result.getString("weight");
                    weight.setText(this.addedWeight);
                }

            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }

        code.grabFocus();
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProductFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField barCode;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField code;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField productName;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}
