/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Databases.Beans.Grn;
import Databases.Beans.GrnItem;
import Databases.DB;
import Databases.Table.GrnManager;
import Databases.Table.ProductManager;
import Databases.Table.StockManager;
import Databases.Table.SupplierManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author nipun
 */
public class Stock extends javax.swing.JPanel implements NativeKeyListener{

    private static Stock instance;

    private double subTotalSum = 0.00;
    private double netTotalSum = 0.00;

    public static synchronized Stock getInstance() {
        if (instance == null) {
            instance = new Stock();
        }
        return instance;
    }

    /**
     * Creates new form Stock
     */
    public Stock() {
        initComponents();

        editBtn.setText("<html> වෙනස් <br> කරන්න</html>");
        
                cancelGRNLabel.setText("<html> <p> අවලංගු<br/> කරන්න </p></html>");

        productTable.getTableHeader().setFont(new Font("Nirmala UI", 1, 17));
        grnTable.getTableHeader().setFont(new Font("Nirmala UI", 1, 17));
        stockTable.getTableHeader().setFont(new Font("Nirmala UI", 1, 17));

        loadProductTable();
        if (productTable.getRowCount() != 0) {
            productTable.setRowSelectionInterval(0, 0);
        }

        generateGrnId();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        grnDate.setText(sdf.format(new Date()));

        calendar.add(Calendar.DAY_OF_YEAR, 1);

        exp.setMinSelectableDate(calendar.getTime());
        mfd.setMaxSelectableDate(new Date());

        loadStockTable();
        
                try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(this);
    }

    private static final String WRONGSELLINGPRICEERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">විකුනුම් මිල නැවත පරික්ෂා කරන්න!"
            + "</font></p></html>";

    private static final String SELECTPRODUCTERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">කරුණාකර භාණ්ඩයේ නම ලබා දෙන්න!"
            + "</font></p></html>";

    private static final String SELECTQTYERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">කරුණාකර ප්‍රමාණය ලබා දෙන්න!"
            + "</font></p></html>";

    private static final String SELECTSUPPLIERERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">කරුණාකර සැපයුම්කරුවා ලබා දෙන්න!"
            + "</font></p></html>";

    private static final String SELECTPRODUCTITEMERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">කරුණාකර භාණ්ඩ ඇතුලත් කරන්න!"
            + "</font></p></html>";

    private static final String INVALIDSELLINGPRICEERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">කරුණාකර ඉලක්කම් පමණක් භාවිතා කරන්න!"
            + "</font></p></html>";

    private static final String TRYAGAINERROR
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\">ක්‍රියාවලිය සම්පූර්ණ නැත. නැවත උත්සාහ කරන්න."
            + "</font></p></html>";

    private static final String PRINTORNOT
            = "<html><p><font color=\"#000\" "
            + "size=\"4\" face=\"Nirmala UI\"> ඔබට ගැණුම් සටහන මුද්‍රණය කිරීමට අවශ්‍යද?"
            + "</font></p></html>";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        supplierSearchTxt = new com.alee.laf.text.WebTextField();
        productSearchTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        grnDate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        grnId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grnTable = new javax.swing.JTable();
        productLoadCombo = new javax.swing.JComboBox<>();
        supplierLoadCombo = new javax.swing.JComboBox<>();
        gap = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        sellingPrice = new javax.swing.JTextField();
        cost = new javax.swing.JTextField();
        netTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        pecentage = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        subTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        productName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        exp = new com.toedter.calendar.JDateChooser();
        mfd = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        subTotal1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        subTotal2 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        cancelGRNLabel = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        stockSearchTxt = new javax.swing.JTextField();
        stockLoadCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        searchExpStock = new com.toedter.calendar.JDateChooser();
        jButton8 = new javax.swing.JButton();
        stockSortCombo = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        stockTable1 = new javax.swing.JTable();
        stockSearchTxt1 = new javax.swing.JTextField();
        stockLoadCombo1 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        searchExpStock1 = new com.toedter.calendar.JDateChooser();
        jButton10 = new javax.swing.JButton();
        stockSortCombo1 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        searchCombo = new javax.swing.JComboBox<>();
        searchTxt = new javax.swing.JTextField();
        loadCombo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        sortCombo = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(229, 234, 237));
        setMinimumSize(new java.awt.Dimension(1216, 708));
        setPreferredSize(new java.awt.Dimension(1216, 708));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(234, 249, 244));
        jTabbedPane1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(234, 249, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplierSearchTxt.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        supplierSearchTxt.setInputPrompt("සමාගමේ නම හෝ කේතය ");
        supplierSearchTxt.setInputPromptFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        supplierSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                supplierSearchTxtKeyReleased(evt);
            }
        });
        jPanel1.add(supplierSearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 8, 320, 33));

        productSearchTxt.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        productSearchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productSearchTxtActionPerformed(evt);
            }
        });
        productSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productSearchTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                productSearchTxtKeyTyped(evt);
            }
        });
        jPanel1.add(productSearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 390, 30));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel1.setText("සැපයුම්කරුවා");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 130, 30));

        grnDate.setFont(new java.awt.Font("Nirmala UI", 1, 17)); // NOI18N
        grnDate.setText("5/1/2020");
        jPanel1.add(grnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 170, 30));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel3.setText("භාණ්ඩයේ නම හෝ තීරු කේතය(Bar code),කේතය");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 420, 30));

        grnId.setFont(new java.awt.Font("Nirmala UI", 1, 17)); // NOI18N
        grnId.setText("22");
        jPanel1.add(grnId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 170, 30));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("විකුනුම් මිල");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 120, 100, 30));

        grnTable.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        grnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "භාණ්ඩයේ නම", "ක.ඉ.දි", "නි.දි", "ප්‍රමාණය", "ගැනුම් මිල", "විකුනුම් මිල", " මුළු මුදල"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grnTable.setRowHeight(25);
        grnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grnTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grnTable);
        if (grnTable.getColumnModel().getColumnCount() > 0) {
            grnTable.getColumnModel().getColumn(0).setPreferredWidth(280);
            grnTable.getColumnModel().getColumn(1).setPreferredWidth(80);
            grnTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            grnTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 1170, 360));

        productLoadCombo.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        productLoadCombo.setOpaque(false);
        jPanel1.add(productLoadCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 410, 30));

        supplierLoadCombo.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        supplierLoadCombo.setOpaque(false);
        jPanel1.add(supplierLoadCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 340, 30));

        gap.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        gap.setEnabled(false);
        jPanel1.add(gap, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 150, 90, 30));

        qty.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });
        jPanel1.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 70, 30));

        sellingPrice.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        sellingPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sellingPriceFocusLost(evt);
            }
        });
        sellingPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellingPriceActionPerformed(evt);
            }
        });
        sellingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sellingPriceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sellingPriceKeyTyped(evt);
            }
        });
        jPanel1.add(sellingPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 150, 90, 30));

        cost.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        cost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                costFocusLost(evt);
            }
        });
        cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costActionPerformed(evt);
            }
        });
        cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                costKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costKeyTyped(evt);
            }
        });
        jPanel1.add(cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 150, 90, 30));

        netTotal.setFont(new java.awt.Font("Nirmala UI", 0, 28)); // NOI18N
        netTotal.setForeground(new java.awt.Color(255, 51, 51));
        netTotal.setText("අවසන් එකතුව = රු 0.00");
        jPanel1.add(netTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 370, 50));

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel7.setText("වට්ටම");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, -1, 35));

        discount.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                discountKeyTyped(evt);
            }
        });
        jPanel1.add(discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 610, 100, 35));

        pecentage.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        pecentage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pecentageKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pecentageKeyTyped(evt);
            }
        });
        jPanel1.add(pecentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 610, 70, 35));

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel9.setText("%");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 20, 35));

        subTotal.setFont(new java.awt.Font("Nirmala UI", 0, 22)); // NOI18N
        subTotal.setText("මුළු එකතුව = රු 0.00");
        jPanel1.add(subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, 260, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1160, 10));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel4.setText("ගැණුම් බිල්පත් අංකය");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, 30));

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel11.setText("දිනය");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        productName.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        productName.setForeground(new java.awt.Color(102, 102, 102));
        productName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productName.setText("භාණ්ඩයේ නම ");
        jPanel1.add(productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 310, 30));

        jLabel13.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("නි.දි");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 120, 30));

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("ක.ඉ.දි");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 120, 130, 30));

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ගැනුම් මිල");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 120, 90, 30));

        jLabel16.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("වට්ටම");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 120, 90, 30));

        exp.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        exp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                expFocusLost(evt);
            }
        });
        exp.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                expPropertyChange(evt);
            }
        });
        exp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                expKeyReleased(evt);
            }
        });
        jPanel1.add(exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 150, 130, 30));

        mfd.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        mfd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mfdMouseClicked(evt);
            }
        });
        mfd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                mfdPropertyChange(evt);
            }
        });
        mfd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mfdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mfdKeyTyped(evt);
            }
        });
        jPanel1.add(mfd, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 150, 130, 30));

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ප්‍රමාණය");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 90, 30));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 560, 10, 90));

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        jLabel10.setText(" ප්‍රතිශතය");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 610, -1, 35));

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(" මුළු මුදල");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 120, 90, 30));

        total.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        total.setEnabled(false);
        total.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                totalFocusLost(evt);
            }
        });
        total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                totalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totalKeyTyped(evt);
            }
        });
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 150, 90, 30));

        jPanel7.setBackground(new java.awt.Color(79, 195, 109));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102)));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        subTotal1.setFont(new java.awt.Font("Nirmala UI", 0, 22)); // NOI18N
        subTotal1.setText(" ගෙවන්න");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(subTotal1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(subTotal1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 600, 320, 50));

        jPanel8.setBackground(new java.awt.Color(153, 255, 204));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        subTotal2.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        subTotal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTotal2.setText("මකන්න");

        jLabel25.setFont(new java.awt.Font("Nirmala UI", 1, 17)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("BACKSPACE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subTotal2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(subTotal2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 120, 90));

        jPanel9.setBackground(new java.awt.Color(153, 255, 204));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        cancelGRNLabel.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        cancelGRNLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelGRNLabel.setText(" අවලංගු කරන්න");

        jLabel26.setFont(new java.awt.Font("Nirmala UI", 1, 17)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ctrl+v");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
            .addComponent(cancelGRNLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelGRNLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 120, 90));

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clear.png"))); // NOI18N
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 80, 70, 40));

        jTabbedPane1.addTab("ගැණුම් සටහන", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockTable.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "භාණ්ඩයේ නම", "නි.දි", "ක.ඉ.දි", "ගැනුම් මිල", "විකුනුම් මිල", "ප්‍රමාණය"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable.setRowHeight(22);
        jScrollPane3.setViewportView(stockTable);
        if (stockTable.getColumnModel().getColumnCount() > 0) {
            stockTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        }

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 1160, 520));

        stockSearchTxt.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        stockSearchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSearchTxtActionPerformed(evt);
            }
        });
        stockSearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockSearchTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockSearchTxtKeyTyped(evt);
            }
        });
        jPanel2.add(stockSearchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 390, 30));

        stockLoadCombo.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        stockLoadCombo.setOpaque(false);
        jPanel2.add(stockLoadCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 30));

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel8.setText("ක.ඉ.දි");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 60, 30));

        jLabel12.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel12.setText("භාණ්ඩයේ නම හෝ තීරු කේතය(Bar code),කේතය");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 420, 30));

        searchExpStock.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        searchExpStock.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchExpStockPropertyChange(evt);
            }
        });
        jPanel2.add(searchExpStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 160, 30));

        jButton8.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton8.setText("විකුනුම් මිල වෙනස් කරන්න");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 230, 40));

        stockSortCombo.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        stockSortCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "සාමාන්‍ය ලෙස සකසන්න", "ආසන්නතම ක.ඉ.දි සිට සකසන්න ", "දුරම ක.ඉ.දි සිට සකසන්න ", "අඩුම මිල සිට සකසන්න", "වැඩිම මිල සිට සකසන්න" }));
        stockSortCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSortComboActionPerformed(evt);
            }
        });
        jPanel2.add(stockSortCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 260, 30));

        jButton9.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton9.setText("පෙර පරිදි සකසන්න");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 170, 30));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockTable1.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        stockTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "භාණ්ඩයේ නම", "නි.දි", "ක.ඉ.දි", "ගැනුම් මිල", "විකුනුම් මිල", "ප්‍රමාණය"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockTable1.setRowHeight(22);
        jScrollPane4.setViewportView(stockTable1);
        if (stockTable1.getColumnModel().getColumnCount() > 0) {
            stockTable1.getColumnModel().getColumn(0).setPreferredWidth(300);
        }

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 1160, 520));

        stockSearchTxt1.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        stockSearchTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSearchTxt1ActionPerformed(evt);
            }
        });
        stockSearchTxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stockSearchTxt1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockSearchTxt1KeyTyped(evt);
            }
        });
        jPanel6.add(stockSearchTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 390, 30));

        stockLoadCombo1.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jPanel6.add(stockLoadCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 30));

        jLabel19.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel19.setText("ක.ඉ.දි");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 60, 30));

        jLabel20.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel20.setText("භාණ්ඩයේ නම හෝ තීරු කේතය(Bar code),කේතය");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 420, 30));

        searchExpStock1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        searchExpStock1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                searchExpStock1PropertyChange(evt);
            }
        });
        jPanel6.add(searchExpStock1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 160, 30));

        jButton10.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton10.setText("විකුනුම් මිල වෙනස් කරන්න");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 230, 40));

        stockSortCombo1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        stockSortCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "සාමාන්‍ය ලෙස සකසන්න", "ආසන්නතම ක.ඉ.දි සිට සකසන්න ", "දුරම ක.ඉ.දි සිට සකසන්න ", "අඩුම මිල සිට සකසන්න", "වැඩිම මිල සිට සකසන්න" }));
        stockSortCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSortCombo1ActionPerformed(evt);
            }
        });
        jPanel6.add(stockSortCombo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 260, 30));

        jButton11.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton11.setText("පෙර පරිදි සකසන්න");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 170, 30));

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel21.setText("ප්‍රමාණය 5ට වඩා අඩුයි");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 210, 30));

        jLabel22.setBackground(new java.awt.Color(251, 240, 146));
        jLabel22.setForeground(new java.awt.Color(251, 240, 146));
        jLabel22.setOpaque(true);
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, 40, 30));

        jLabel18.setBackground(new java.awt.Color(251, 127, 121));
        jLabel18.setForeground(new java.awt.Color(251, 127, 121));
        jLabel18.setOpaque(true);
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, 40, 30));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel2.setText("කල් ඉකුත් වන දිනය අදයි");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 620, 210, 30));

        jButton6.setFont(new java.awt.Font("Nirmala UI", 1, 17)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Print.png"))); // NOI18N
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 615, 110, 40));

        jLabel23.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        jLabel23.setText("කල් ඉකුත්වී ඇත");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 620, 150, 30));

        jLabel24.setBackground(new java.awt.Color(205, 211, 211));
        jLabel24.setForeground(new java.awt.Color(205, 211, 211));
        jLabel24.setOpaque(true);
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 620, 40, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 660));

        jTabbedPane1.addTab("ගබඩාව", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton1.setText("අලුත්");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 3, -1, 45));

        editBtn.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        editBtn.setText("වෙනස් කරන්න");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel4.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 3, -1, 45));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1160, 50));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productTable.setFont(new java.awt.Font("Nirmala UI", 0, 16)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "කේතය", " තීරු කේතය(Bar code)", "භාණ්ඩයේ නම", "බර"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setRowHeight(22);
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1120, 480));

        searchCombo.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        searchCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "භාණ්ඩයේ නම අනුව සොයන්න", " තීරු කේතය(Bar code) අනුව සොයන්න", "කේතය අනුව සොයන්න" }));
        searchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboActionPerformed(evt);
            }
        });
        jPanel5.add(searchCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 30));

        searchTxt.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTxtKeyTyped(evt);
            }
        });
        jPanel5.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 270, 30));

        loadCombo.setFont(new java.awt.Font("Nirmala UI", 0, 17)); // NOI18N
        loadCombo.setOpaque(false);
        loadCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadComboActionPerformed(evt);
            }
        });
        jPanel5.add(loadCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 270, 30));

        jButton2.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jButton2.setText("පෙර පරිදි සකසන්න");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 170, 30));

        sortCombo.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        sortCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "සාමාන්‍ය ලෙස සකසන්න", "භාණ්ඩයේ නම අනුව සකසන්න", "කේතය අනුව සකසන්න" }));
        sortCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboActionPerformed(evt);
            }
        });
        jPanel5.add(sortCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 210, 30));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 30, 30));

        jButton5.setFont(new java.awt.Font("Nirmala UI", 1, 17)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Print.png"))); // NOI18N
        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 550, 110, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1160, 600));

        jTabbedPane1.addTab("භාණ්ඩ කළමනාකරණය", jPanel3);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 2, 1190, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddProductFrame frame = AddProductFrame.getInstance();
        frame.clearFeilds();
        frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int selectedRow = productTable.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();

            String selectProductName = (String) dtm.getValueAt(selectedRow, 2);
            String selectWeight = (String) dtm.getValueAt(selectedRow, 3);

            AddProductFrame frame = AddProductFrame.getInstance();
            frame.loadAddedProducted(selectProductName, selectWeight);
            frame.isEditing = true;
            frame.setVisible(true);
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        if (evt.getClickCount() == 2) {
            int selectedRow = productTable.getSelectedRow();

            DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();

            String selectProductName = (String) dtm.getValueAt(selectedRow, 2);
            String selectWeight = (String) dtm.getValueAt(selectedRow, 3);

            AddProductFrame frame = AddProductFrame.getInstance();
            frame.loadAddedProducted(selectProductName, selectWeight);
            frame.isEditing = true;
            frame.setVisible(true);
        }

    }//GEN-LAST:event_productTableMouseClicked

    private void searchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboActionPerformed
        searchTxt.setText(null);
    }//GEN-LAST:event_searchComboActionPerformed

    int x = 0;
    int y = 0;
    int i = 0;
    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        if (searchTxt.getText().isEmpty()) {
            loadProductTable();
            loadCombo.hidePopup();
            searchTxt.setText(null);
        }
        DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();
        try {

            if (searchCombo.getSelectedItem().toString().trim().equals("භාණ්ඩයේ නම අනුව සොයන්න")) {
                Vector v = new Vector();
                ResultSet rs_nic = ProductManager.getAllLikeName(searchTxt.getText().trim());
                while (rs_nic.next()) {
                    v.add(rs_nic.getString("product_name"));
                }
                DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
                loadCombo.setModel(dcb);

                if (loadCombo.getItemCount() != 0) {
                    loadCombo.showPopup();

                    int c = loadCombo.getItemCount();
                    if (evt.getKeyCode() == 40) {
                        i++;
                        if (i == c) {
                            i = 0;
                        }
                        loadCombo.setSelectedIndex(i);
                    }

                    if (evt.getKeyCode() == 38) {
                        i--;
                        if (i == -1) {
                            i = c - 1;
                        }
                        loadCombo.setSelectedIndex(i);
                    }

                    if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                        loadCombo.setSelectedIndex(i);
                        loadCombo.hidePopup();
                        i = 0;
                        dtm.setRowCount(0);
                        searchTxt.setText(loadCombo.getSelectedItem().toString());
                        ResultSet rs_tbl = ProductManager.getAllFromName(searchTxt.getText().trim());
                        while (rs_tbl.next()) {
                            Vector v1 = new Vector();
                            v1.add(rs_tbl.getString("code"));
                            v1.add(rs_tbl.getString("barcode"));
                            v1.add(rs_tbl.getString("product_name"));
                            v1.add(rs_tbl.getString("weight"));

                            dtm.addRow(v1);
                        }
                    }
                }

            }

        } catch (Exception e) {
            DB.processException(e);
        }

        try {

            if (searchCombo.getSelectedItem().toString().trim().equals("තීරු කේතය(Bar code) අනුව සොයන්න")) {

                Vector v = new Vector();
                ResultSet rs_tp = ProductManager.getAllLikeBarcode(searchTxt.getText().trim());
                while (rs_tp.next()) {
                    v.add(rs_tp.getString("barcode"));
                }
                DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
                loadCombo.setModel(dcb);
                if (loadCombo.getItemCount() != 0) {

                    loadCombo.showPopup();
                    int c = loadCombo.getItemCount();
                    if (evt.getKeyCode() == 40) {
                        x++;
                        if (x == c) {
                            x = 0;
                        }
                        loadCombo.setSelectedIndex(x);
                    }

                    if (evt.getKeyCode() == 38) {
                        x--;
                        if (x == -1) {
                            x = c - 1;
                        }
                        loadCombo.setSelectedIndex(x);
                    }
                    if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                        loadCombo.setSelectedIndex(x);
                        loadCombo.hidePopup();
                        x = 0;
                        dtm.setRowCount(0);
                        searchTxt.setText(loadCombo.getSelectedItem().toString());
                        ResultSet rs_tbl = ProductManager.getAllFromBarcode(searchTxt.getText().trim());
                        if (rs_tbl.next()) {
                            Vector v1 = new Vector();
                            v1.add(rs_tbl.getString("code"));
                            v1.add(rs_tbl.getString("barcode"));
                            v1.add(rs_tbl.getString("product_name"));
                            v1.add(rs_tbl.getString("weight"));

                            dtm.addRow(v1);

                        }
                    }
                }
            }

        } catch (Exception e) {
            DB.processException(e);
        }

        try {

            if (searchCombo.getSelectedItem().toString().trim().equals("කේතය අනුව සොයන්න")) {

                Vector v = new Vector();
                ResultSet rs_tp = ProductManager.getAllLikeCode(searchTxt.getText().trim());
                while (rs_tp.next()) {
                    v.add(rs_tp.getString("code"));
                }
                DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
                loadCombo.setModel(dcb);
                if (loadCombo.getItemCount() != 0) {

                    loadCombo.showPopup();
                    int c = loadCombo.getItemCount();
                    if (evt.getKeyCode() == 40) {
                        y++;
                        if (y == c) {
                            y = 0;
                        }
                        loadCombo.setSelectedIndex(y);
                    }

                    if (evt.getKeyCode() == 38) {
                        y--;
                        if (y == -1) {
                            y = c - 1;
                        }
                        loadCombo.setSelectedIndex(y);
                    }
                    if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                        loadCombo.setSelectedIndex(y);
                        loadCombo.hidePopup();
                        y = 0;
                        dtm.setRowCount(0);
                        searchTxt.setText(loadCombo.getSelectedItem().toString());
                        ResultSet rs_tbl = ProductManager.getAllFromCode(searchTxt.getText().trim());
                        if (rs_tbl.next()) {
                            Vector v1 = new Vector();
                            v1.add(rs_tbl.getString("code"));
                            v1.add(rs_tbl.getString("barcode"));
                            v1.add(rs_tbl.getString("product_name"));
                            v1.add(rs_tbl.getString("weight"));

                            dtm.addRow(v1);

                        }
                    }
                }
            }

        } catch (Exception e) {
            DB.processException(e);
        }
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyTyped

    }//GEN-LAST:event_searchTxtKeyTyped

    private void loadComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadComboActionPerformed


    }//GEN-LAST:event_loadComboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadProductTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void sortComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortComboActionPerformed
        loadProductTable();
    }//GEN-LAST:event_sortComboActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();
        dtm.setRowCount(0);

        if (searchCombo.getSelectedItem().toString().trim().equals("භාණ්ඩයේ නම අනුව සොයන්න")) {
            try {
                ResultSet result = ProductManager.getAllFromName(searchTxt.getText().trim());
                while (result.next()) {
                    Vector v = new Vector();
                    v.add(result.getString("code"));
                    v.add(result.getString("barcode"));
                    v.add(result.getString("product_name"));
                    v.add(result.getString("weight"));

                    dtm.addRow(v);
                }
            } catch (SQLException ex) {
                DB.processException(ex);
            }

        } else if (searchCombo.getSelectedItem().toString().trim().equals("තීරු කේතය(Bar code) අනුව සොයන්න")) {
            try {
                ResultSet result = ProductManager.getAllFromBarcode(searchTxt.getText().trim());
                if (result.next()) {
                    Vector v = new Vector();
                    v.add(result.getString("code"));
                    v.add(result.getString("barcode"));
                    v.add(result.getString("product_name"));
                    v.add(result.getString("weight"));

                    dtm.addRow(v);
                }
            } catch (SQLException ex) {
                DB.processException(ex);
            }
        } else if (searchCombo.getSelectedItem().toString().trim().equals("කේතය අනුව සොයන්න")) {
            try {
                ResultSet result = ProductManager.getAllFromCode(searchTxt.getText().trim());
                if (result.next()) {
                    Vector v = new Vector();
                    v.add(result.getString("code"));
                    v.add(result.getString("barcode"));
                    v.add(result.getString("product_name"));
                    v.add(result.getString("weight"));

                    dtm.addRow(v);
                }
            } catch (SQLException ex) {
                DB.processException(ex);
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed
    int z = 0;
    private void supplierSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierSearchTxtKeyReleased
        if (supplierSearchTxt.getText().isEmpty()) {
            supplierLoadCombo.hidePopup();
            supplierLoadCombo.removeAllItems();
            supplierSearchTxt.setText(null);
        } else {
            try {
                Vector v = new Vector();
                ResultSet rs_nic = SupplierManager.getAllLikeCompanyAndCode(supplierSearchTxt.getText().trim());
                while (rs_nic.next()) {
                    v.add(rs_nic.getString("code") + " - " + rs_nic.getString("company"));
                }
                DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
                supplierLoadCombo.setModel(dcb);

                if (supplierLoadCombo.getItemCount() != 0) {
                    supplierLoadCombo.showPopup();

                    int c = supplierLoadCombo.getItemCount();
                    if (evt.getKeyCode() == 40) {
                        z++;
                        if (z == c) {
                            z = 0;
                        }
                        supplierLoadCombo.setSelectedIndex(z);
                    }

                    if (evt.getKeyCode() == 38) {
                        z--;
                        if (z == -1) {
                            z = c - 1;
                        }
                        supplierLoadCombo.setSelectedIndex(z);
                    }

                    if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                        supplierLoadCombo.setSelectedIndex(z);
                        supplierLoadCombo.hidePopup();
                        z = 0;
                        supplierSearchTxt.setText(supplierLoadCombo.getSelectedItem().toString());
                        productSearchTxt.grabFocus();
                    }
                }

            } catch (Exception e) {
                DB.processException(e);
            }
        }
    }//GEN-LAST:event_supplierSearchTxtKeyReleased

    int k = 0;
    private void productSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productSearchTxtKeyReleased
        if (productSearchTxt.getText().isEmpty()) {
            productLoadCombo.hidePopup();
            productLoadCombo.removeAllItems();
            productSearchTxt.setText(null);
        } else {
            try {
                Vector v = new Vector();
                ResultSet rs_nic = ProductManager.getAllLikeNameBarcodeCode(productSearchTxt.getText().trim());
                while (rs_nic.next()) {
                    v.add(rs_nic.getString("code") + " - " + rs_nic.getString("barcode") + " - " + rs_nic.getString("product_name") + " - " + rs_nic.getString("weight"));
                }
                DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
                productLoadCombo.setModel(dcb);

                if (productLoadCombo.getItemCount() != 0) {
                    productLoadCombo.showPopup();

                    int c = productLoadCombo.getItemCount();
                    if (evt.getKeyCode() == 40) {
                        k++;
                        if (k == c) {
                            k = 0;
                        }
                        productLoadCombo.setSelectedIndex(k);
                    }

                    if (evt.getKeyCode() == 38) {
                        k--;
                        if (k == -1) {
                            k = c - 1;
                        }
                        productLoadCombo.setSelectedIndex(k);
                    }

                    if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                        productLoadCombo.setSelectedIndex(k);
                        productLoadCombo.hidePopup();
                        k = 0;
                        productSearchTxt.setText(productLoadCombo.getSelectedItem().toString());
                        qty.setText("1");
                        qty.selectAll();
                        qty.grabFocus();

                        productName.setText(productSearchTxt.getText().split(" - ")[2].trim() + "-" + productSearchTxt.getText().split(" - ")[3].trim());
                    }
                }

            } catch (Exception e) {
                DB.processException(e);
            }
        }
    }//GEN-LAST:event_productSearchTxtKeyReleased

    private void productSearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productSearchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productSearchTxtActionPerformed

    private void productSearchTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productSearchTxtKeyTyped

    }//GEN-LAST:event_productSearchTxtKeyTyped

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (qty.getText().isEmpty() && evt.getKeyChar() == '.') {
            evt.consume();
        }
        if (qty.getText().contains(".") && evt.getKeyChar() == '.') {
            evt.consume();
        }
    }//GEN-LAST:event_qtyKeyTyped

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        if (!qty.getText().isEmpty()) {
            if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                mfd.getDateEditor().getUiComponent().requestFocus();
            }
        }

    }//GEN-LAST:event_qtyKeyReleased

    private void expKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cost.grabFocus();
        }
    }//GEN-LAST:event_expKeyReleased

    private void mfdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mfdKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            exp.getDateEditor().getUiComponent().requestFocus();
        }
    }//GEN-LAST:event_mfdKeyReleased

    private void sellingPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellingPriceKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (supplierLoadCombo.getSelectedItem() != null) {
                if (productLoadCombo.getSelectedItem() != null) {
                    if (!qty.getText().isEmpty()) {
                        if (!cost.getText().isEmpty()) {

                            if (sellingPrice.getText().isEmpty()) {
                                sellingPrice.setText("0.0");
                            }

                            isRowExits = false;

                            DefaultTableModel dtm = (DefaultTableModel) grnTable.getModel();

                            String product = (String) productLoadCombo.getSelectedItem();

                            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");

                            for (int j = 0; j < dtm.getRowCount(); j++) {

                                if (dtm.getValueAt(j, 0).equals(product.split(" - ")[2].trim() + "-" + product.split(" - ")[3].trim()) && dtm.getValueAt(j, 5).equals(Double.parseDouble(sellingPrice.getText())) && dtm.getValueAt(j, 4).equals(Double.parseDouble(cost.getText()))) {

                                    System.out.println("a");

                                    if (mfd.getDate() != null) {
                                        System.out.println("b");
                                        if (dtm.getValueAt(j, 1).equals(sdf.format(mfd.getDate()))) {
                                            System.out.println("c");
                                            if (exp.getDate() != null) {
                                                System.out.println("d");
                                                if (dtm.getValueAt(j, 2).equals(sdf.format(exp.getDate()))) {
                                                    System.out.println("e");
                                                    isRowExits = true;

                                                    String qtyTxt = String.valueOf(dtm.getValueAt(j, 3));

                                                    double qtydb = Double.parseDouble(qty.getText()) + Double.parseDouble(qtyTxt);

                                                    dtm.setValueAt(qtydb, j, 3);
                                                    dtm.setValueAt(qtydb * Double.parseDouble(cost.getText()), j, 6);

                                                    subTotalSum += Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText()));
                                                    subTotal.setText("මුළු එකතුව = රු " + subTotalSum);
                                                    netTotal.setText("අවසන් එකතුව = රු " + subTotalSum);

                                                    clearItemTextField();
                                                    break;
                                                }

                                            } else {
                                                System.out.println("f");
                                                if (dtm.getValueAt(j, 2).toString().isEmpty()) {
                                                    isRowExits = true;
                                                    System.out.println("g");
                                                    String qtyTxt = String.valueOf(dtm.getValueAt(j, 3));

                                                    double qtydb = Double.parseDouble(qty.getText()) + Double.parseDouble(qtyTxt);

                                                    dtm.setValueAt(qtydb, j, 3);
                                                    dtm.setValueAt(qtydb * Double.parseDouble(cost.getText()), j, 6);

                                                    subTotalSum += Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText()));
                                                    subTotal.setText("මුළු එකතුව = රු " + subTotalSum);
                                                    netTotal.setText("අවසන් එකතුව = රු " + subTotalSum);

                                                    clearItemTextField();

                                                    break;
                                                }
                                            }

                                        }

                                    } else {
                                        System.out.println("h");
                                        if (dtm.getValueAt(j, 1).toString().isEmpty()) {
                                            System.out.println("i");
                                            if (exp.getDate() != null) {
                                                System.out.println("j");
                                                if (dtm.getValueAt(j, 2).equals(sdf.format(exp.getDate()))) {
                                                    System.out.println("k");
                                                    isRowExits = true;

                                                    String qtyTxt = String.valueOf(dtm.getValueAt(j, 3));

                                                    double qtydb = Double.parseDouble(qty.getText()) + Double.parseDouble(qtyTxt);

                                                    dtm.setValueAt(qtydb, j, 3);
                                                    dtm.setValueAt(qtydb * Double.parseDouble(cost.getText()), j, 6);

                                                    subTotalSum += Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText()));
                                                    subTotal.setText("මුළු එකතුව = රු " + subTotalSum);
                                                    netTotal.setText("අවසන් එකතුව = රු " + subTotalSum);

                                                    clearItemTextField();
                                                    break;
                                                }

                                            } else {
                                                System.out.println("l");
                                                if (dtm.getValueAt(j, 2).toString().isEmpty()) {
                                                    isRowExits = true;
                                                    System.out.println("m");
                                                    String qtyTxt = String.valueOf(dtm.getValueAt(j, 3));

                                                    double qtydb = Double.parseDouble(qty.getText()) + Double.parseDouble(qtyTxt);

                                                    dtm.setValueAt(qtydb, j, 3);
                                                    dtm.setValueAt(qtydb * Double.parseDouble(cost.getText()), j, 6);

                                                    subTotalSum += Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText()));
                                                    subTotal.setText("මුළු එකතුව = රු " + subTotalSum);
                                                    netTotal.setText("අවසන් එකතුව = රු " + subTotalSum);

                                                    clearItemTextField();
                                                    break;
                                                }
                                            }

                                        }
                                    }

                                }
                            }

                            if (!isRowExits) {
                                Vector v = new Vector();

                                v.add(product.split(" - ")[2].trim() + "-" + product.split(" - ")[3].trim());
                                if (mfd.getDate() != null) {
                                    v.add(sdf.format(mfd.getDate()));
                                } else {
                                    v.add("");
                                }
                                if (exp.getDate() != null) {
                                    v.add(sdf.format(exp.getDate()));
                                } else {
                                    v.add("");
                                }
                                v.add(Double.parseDouble(qty.getText()));

                                if (!sellingPrice.getText().isEmpty()) {

                                    if (Double.parseDouble(cost.getText()) > Double.parseDouble(sellingPrice.getText()) && !sellingPrice.getText().equals("0.0")) {
                                        JOptionPane.showMessageDialog(this, WRONGSELLINGPRICEERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                                        sellingPrice.grabFocus();
                                    } else {
                                        gap.setText(String.valueOf(Double.parseDouble(sellingPrice.getText()) - Double.parseDouble(cost.getText())));

                                        v.add(Double.parseDouble(cost.getText()));
                                        v.add(Double.parseDouble(sellingPrice.getText()));
                                        v.add(Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText())));
                                        dtm.addRow(v);

                                        subTotalSum += Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText()));
                                        subTotal.setText("මුළු එකතුව = රු " + subTotalSum);
                                        netTotal.setText("අවසන් එකතුව = රු " + subTotalSum);
                                        isRowExits = false;
                                        clearItemTextField();
                                    }

                                } else {
                                    v.add("");
                                    v.add(Double.parseDouble(cost.getText()));
                                    v.add(Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText())));
                                    dtm.addRow(v);

                                    subTotalSum += Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText()));
                                    subTotal.setText("මුළු එකතුව = රු " + subTotalSum);
                                    isRowExits = false;
                                    clearItemTextField();
                                }

                            }

                        }
                    } else {
                        JOptionPane.showMessageDialog(this, SELECTQTYERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                        qty.grabFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, SELECTPRODUCTERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                    productSearchTxt.grabFocus();
                }

            } else {
                JOptionPane.showMessageDialog(this, SELECTSUPPLIERERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                supplierSearchTxt.grabFocus();
            }

        }


    }//GEN-LAST:event_sellingPriceKeyReleased

    boolean isRowExits = false;
    private void costKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyReleased
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!cost.getText().isEmpty()) {
                if (!qty.getText().isEmpty()) {
                    total.setText(String.valueOf(Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText()))));
                    sellingPrice.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(this, SELECTQTYERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                    qty.grabFocus();
                }
            }

        }

    }//GEN-LAST:event_costKeyReleased

    private void mfdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mfdKeyTyped

    }//GEN-LAST:event_mfdKeyTyped

    private void mfdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mfdMouseClicked

    }//GEN-LAST:event_mfdMouseClicked

    private void mfdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_mfdPropertyChange
        if (mfd.getDate() != null) {
            exp.getDateEditor().getUiComponent().requestFocus();
        }
    }//GEN-LAST:event_mfdPropertyChange

    private void expPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_expPropertyChange
        if (exp.getDate() != null) {
            cost.grabFocus();
        }
    }//GEN-LAST:event_expPropertyChange

    private void expFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_expFocusLost

    }//GEN-LAST:event_expFocusLost

    private void sellingPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellingPriceKeyTyped

        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (sellingPrice.getText().isEmpty() && evt.getKeyChar() == '.') {
            evt.consume();
        }
        if (sellingPrice.getText().contains(".") && evt.getKeyChar() == '.') {
            evt.consume();
        }
    }//GEN-LAST:event_sellingPriceKeyTyped

    private void costKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (cost.getText().isEmpty() && evt.getKeyChar() == '.') {
            evt.consume();
        }
        if (cost.getText().contains(".") && evt.getKeyChar() == '.') {
            evt.consume();
        }
    }//GEN-LAST:event_costKeyTyped

    private void costFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_costFocusLost
        if (!cost.getText().isEmpty()) {
            total.setText(String.valueOf(Double.parseDouble(cost.getText()) * (Double.parseDouble(qty.getText()))));
            sellingPrice.grabFocus();
        }


    }//GEN-LAST:event_costFocusLost

    private void grnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnTableMouseClicked
  
        if (evt.getClickCount() == 2) {

            int selectRow = grnTable.getSelectedRow();

            String productTxt = (String) grnTable.getValueAt(selectRow, 0);
            ResultSet rs_nic = ProductManager.getProductFromNameWeight(productTxt.split("-")[0].trim(), productTxt.split("-")[1].trim());
            try {
                Vector v = new Vector();
                if (rs_nic.next()) {
                    v.add(rs_nic.getString("code") + " - " + rs_nic.getString("barcode") + " - " + rs_nic.getString("product_name") + " - " + rs_nic.getString("weight"));
                    productSearchTxt.setText(rs_nic.getString("code") + " - " + rs_nic.getString("barcode") + " - " + rs_nic.getString("product_name") + " - " + rs_nic.getString("weight"));
                }

                DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
                productLoadCombo.setModel(dcb);

                productName.setText(productTxt);
                String mfdTxt = (String) grnTable.getValueAt(selectRow, 1);
                String expTxt = (String) grnTable.getValueAt(selectRow, 2);

                if (!mfdTxt.isEmpty()) {
                    Date mfdDate = new SimpleDateFormat("MMM d, yyyy").parse(mfdTxt);
                    mfd.setDate(mfdDate);
                }

                if (!expTxt.isEmpty()) {
                    Date expDate = new SimpleDateFormat("MMM d, yyyy").parse(expTxt);
                    exp.setDate(expDate);
                }

                double sellingPriceTxt = (Double) grnTable.getValueAt(selectRow, 5);
                double costTxt = (Double) grnTable.getValueAt(selectRow, 4);

                qty.setText(String.valueOf(grnTable.getValueAt(selectRow, 3)));
                sellingPrice.setText(String.valueOf(sellingPriceTxt));
                cost.setText(String.valueOf(costTxt));

                if (sellingPriceTxt != 0.0) {
                    gap.setText(String.valueOf(sellingPriceTxt - costTxt));
                }

                total.setText(String.valueOf(grnTable.getValueAt(selectRow, 6)));

                deleteSelectedRow();

            } catch (Exception ex) {
//                DB.processException(ex);
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_grnTableMouseClicked

    private void sellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sellingPriceFocusLost

    }//GEN-LAST:event_sellingPriceFocusLost

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased

        if (supplierLoadCombo.getSelectedItem() != null) {

            if (subTotalSum != 0.0) {

                if (!discount.getText().isEmpty()) {
                    pecentage.setText(null);
                    netTotalSum = subTotalSum - Double.parseDouble(discount.getText());
                    netTotal.setText("අවසන් එකතුව = රු " + netTotalSum);
                    pecentage.setText(String.valueOf(Math.round((Double.parseDouble(discount.getText()) * 100.0 / subTotalSum) * 100.0) / 100.0));
                } else {
                    netTotal.setText("අවසන් එකතුව = රු " + subTotalSum);
                    pecentage.setText(null);
                }

            } else {
                JOptionPane.showMessageDialog(this, SELECTPRODUCTITEMERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                productSearchTxt.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, SELECTSUPPLIERERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
            supplierSearchTxt.grabFocus();
        }

        if (evt.getKeyCode() == 39) {
            pecentage.grabFocus();
        }

    }//GEN-LAST:event_discountKeyReleased

    private void pecentageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pecentageKeyReleased

        if (supplierLoadCombo.getSelectedItem() != null) {

            if (subTotalSum != 0.0) {

                if (!pecentage.getText().isEmpty()) {
                    discount.setText(null);
                    netTotalSum = ((100 - Double.parseDouble(pecentage.getText())) * subTotalSum) / 100;
                    netTotal.setText("අවසන් එකතුව = රු " + netTotalSum);
                    discount.setText(String.valueOf(subTotalSum - netTotalSum));
                } else {
                    netTotal.setText("අවසන් එකතුව = රු " + subTotalSum);
                    discount.setText(null);
                }

            } else {
                JOptionPane.showMessageDialog(this, SELECTPRODUCTITEMERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                productSearchTxt.grabFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, SELECTSUPPLIERERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
            supplierSearchTxt.grabFocus();
        }

        if (evt.getKeyCode() == 37) {
            discount.grabFocus();
        }
    }//GEN-LAST:event_pecentageKeyReleased

    private void costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costActionPerformed

    private void totalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_totalFocusLost

    private void totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_totalKeyReleased

    private void totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_totalKeyTyped

    private void sellingPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellingPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sellingPriceActionPerformed

    private void discountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (discount.getText().isEmpty() && evt.getKeyChar() == '.') {
            evt.consume();
        }
        if (discount.getText().contains(".") && evt.getKeyChar() == '.') {
            evt.consume();
        }
    }//GEN-LAST:event_discountKeyTyped

    private void pecentageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pecentageKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (pecentage.getText().isEmpty() && evt.getKeyChar() == '.') {
            evt.consume();
        }
        if (pecentage.getText().contains(".") && evt.getKeyChar() == '.') {
            evt.consume();
        }
    }//GEN-LAST:event_pecentageKeyTyped

    private void stockSearchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSearchTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockSearchTxtActionPerformed

    int j = 0;
    private void stockSearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockSearchTxtKeyReleased
        if (stockSearchTxt.getText().isEmpty()) {
            stockLoadCombo.hidePopup();
            stockLoadCombo.removeAllItems();
            stockSearchTxt.setText(null);
        } else {
            try {
                Vector v = new Vector();
                ResultSet rs_nic = ProductManager.getAllLikeNameBarcodeCode(stockSearchTxt.getText().trim());
                while (rs_nic.next()) {
                    v.add(rs_nic.getString("code") + " - " + rs_nic.getString("barcode") + " - " + rs_nic.getString("product_name") + " - " + rs_nic.getString("weight"));
                }
                DefaultComboBoxModel dcb = new DefaultComboBoxModel(v);
                stockLoadCombo.setModel(dcb);

                if (stockLoadCombo.getItemCount() != 0) {
                    stockLoadCombo.showPopup();

                    int c = stockLoadCombo.getItemCount();
                    if (evt.getKeyCode() == 40) {
                        j++;
                        if (j == c) {
                            j = 0;
                        }
                        stockLoadCombo.setSelectedIndex(j);
                    }

                    if (evt.getKeyCode() == 38) {
                        j--;
                        if (j == -1) {
                            j = c - 1;
                        }
                        stockLoadCombo.setSelectedIndex(j);
                    }

                    if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                        stockLoadCombo.setSelectedIndex(j);
                        stockLoadCombo.hidePopup();
                        j = 0;
                        stockSearchTxt.setText(stockLoadCombo.getSelectedItem().toString());
                        loadStockTable(stockSearchTxt.getText().split(" - ")[2].trim(), stockSearchTxt.getText().split(" - ")[3].trim());
                        searchExpStock.setCalendar(null);
                    }
                }

            } catch (Exception e) {
                DB.processException(e);
            }
        }
    }//GEN-LAST:event_stockSearchTxtKeyReleased

    private void stockSearchTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockSearchTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stockSearchTxtKeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        if (stockTable.getSelectedRow() != -1) {

            String newSellingPrice = JOptionPane.showInputDialog("<html><p><font color=\"#000\" "
                    + "size=\"3\" face=\"Nirmala UI\">විකුනුම් මිල"
                    + "</font></p></html>");

            if (!newSellingPrice.isEmpty()) {
                System.out.println("yes");
                if (newSellingPrice.matches("[0-9]+")) {

                    DefaultTableModel dtm = (DefaultTableModel) stockTable.getModel();

                    Databases.Beans.Stock s = new Databases.Beans.Stock()
                            .setProductName((String) dtm.getValueAt(stockTable.getSelectedRow(), 0))
                            .setMfd((String) dtm.getValueAt(stockTable.getSelectedRow(), 1))
                            .setExp((String) dtm.getValueAt(stockTable.getSelectedRow(), 2))
                            .setCost((Double) dtm.getValueAt(stockTable.getSelectedRow(), 3))
                            .setSellingPrice((Double) dtm.getValueAt(stockTable.getSelectedRow(), 4))
                            .setNewSellingPrice(Double.parseDouble(newSellingPrice));

                    if (StockManager.updateSellingPrice(s)) {
                        loadStockTable();
                        JOptionPane.showMessageDialog(this, "<html><p><font color=\"#000\" size=\"4\" face=\"Nirmala UI\">" + s.getProductName() + " විකුණුම් මිල " + newSellingPrice + " ලෙස වෙනස් විය. </font></p></html>");
                    } else {
                        JOptionPane.showMessageDialog(this, TRYAGAINERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, INVALIDSELLINGPRICEERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                    newSellingPrice = JOptionPane.showInputDialog("<html><p><font color=\"#000\" "
                            + "size=\"3\" face=\"Nirmala UI\">විකුනුම් මිල"
                            + "</font></p></html>");
                }
            } else {
                newSellingPrice = JOptionPane.showInputDialog("<html><p><font color=\"#000\" "
                        + "size=\"3\" face=\"Nirmala UI\">විකුනුම් මිල"
                        + "</font></p></html>");
            }

            System.out.println(newSellingPrice);
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void stockSortComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSortComboActionPerformed
        loadStockTable();
    }//GEN-LAST:event_stockSortComboActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        loadStockTable();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void searchExpStockPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchExpStockPropertyChange
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        if (searchExpStock.getDate() != null) {
            loadStockTable(searchExpStock.getDate());

            stockSearchTxt.setText(null);
            stockLoadCombo.removeAllItems();
        }
    }//GEN-LAST:event_searchExpStockPropertyChange

    private void stockSearchTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSearchTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockSearchTxt1ActionPerformed

    private void stockSearchTxt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockSearchTxt1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_stockSearchTxt1KeyReleased

    private void stockSearchTxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockSearchTxt1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stockSearchTxt1KeyTyped

    private void searchExpStock1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_searchExpStock1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_searchExpStock1PropertyChange

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void stockSortCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSortCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockSortCombo1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        saveGrn();
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        deleteSelectedRow();
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        cancelGrn();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        clearItemTextField();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      try {
//        productTable.getColumnModel().getColumn(0).setHeaderValue("Code");
          MessageFormat header = new MessageFormat("Product Report");
          productTable.print(JTable.PrintMode.NORMAL,header,null); 
//          productTable.getColumnModel().getColumn(0).setHeaderValue("කේතය");

        } catch (java.awt.print.PrinterException e) {
     System.err.format("Cannot print %s%n", e.getMessage()); 
}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     try {
       stockTable.getColumnModel().getColumn(0).setHeaderValue("Product Name");
          MessageFormat header = new MessageFormat("Stock Report");
          stockTable.print(JTable.PrintMode.FIT_WIDTH,header,null); 
stockTable.getColumnModel().getColumn(0).setHeaderValue("භාණ්ඩයේ නම");
        } catch (java.awt.print.PrinterException e) {
     System.err.format("Cannot print %s%n", e.getMessage()); 
}
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cancelGRNLabel;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField discount;
    private javax.swing.JButton editBtn;
    private com.toedter.calendar.JDateChooser exp;
    private javax.swing.JTextField gap;
    private javax.swing.JLabel grnDate;
    private javax.swing.JLabel grnId;
    private javax.swing.JTable grnTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> loadCombo;
    private com.toedter.calendar.JDateChooser mfd;
    private javax.swing.JLabel netTotal;
    private javax.swing.JTextField pecentage;
    private javax.swing.JComboBox<String> productLoadCombo;
    private javax.swing.JLabel productName;
    private javax.swing.JTextField productSearchTxt;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField qty;
    private javax.swing.JComboBox<String> searchCombo;
    private com.toedter.calendar.JDateChooser searchExpStock;
    private com.toedter.calendar.JDateChooser searchExpStock1;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTextField sellingPrice;
    private javax.swing.JComboBox<String> sortCombo;
    private javax.swing.JComboBox<String> stockLoadCombo;
    private javax.swing.JComboBox<String> stockLoadCombo1;
    private javax.swing.JTextField stockSearchTxt;
    private javax.swing.JTextField stockSearchTxt1;
    private javax.swing.JComboBox<String> stockSortCombo;
    private javax.swing.JComboBox<String> stockSortCombo1;
    private javax.swing.JTable stockTable;
    private javax.swing.JTable stockTable1;
    private javax.swing.JLabel subTotal;
    private javax.swing.JLabel subTotal1;
    private javax.swing.JLabel subTotal2;
    private javax.swing.JComboBox<String> supplierLoadCombo;
    private com.alee.laf.text.WebTextField supplierSearchTxt;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables

    public void loadProductTable() {
        searchTxt.setText(null);
        DefaultTableModel dtm = (DefaultTableModel) productTable.getModel();
        dtm.setRowCount(0);

        if (sortCombo.getSelectedItem().equals("සාමාන්‍ය ලෙස සකසන්න")) {

            ResultSet result1 = ProductManager.getAllProduct();
            try {

                while (result1.next()) {
                    Vector v = new Vector();

                    if (!result1.getString("code").equals("null")) {
                        v.add(result1.getString("code"));
                    } else {
                        v.add("");
                    }

                    if (!result1.getString("barcode").equals("null")) {
                        v.add(result1.getString("barcode"));
                    } else {
                        v.add("");
                    }

                    v.add(result1.getString("product_name"));

                    if (!result1.getString("weight").equals("null")) {
                        v.add(result1.getString("weight"));
                    } else {
                        v.add("");
                    }

                    dtm.addRow(v);
                }

            } catch (SQLException ex) {
                DB.processException(ex);
            }

        } else if (sortCombo.getSelectedItem().equals("භාණ්ඩයේ නම අනුව සකසන්න")) {

            ResultSet result1 = ProductManager.getAllProductOrderByProduct();
            try {

                while (result1.next()) {
                    Vector v = new Vector();

                    v.add(result1.getString("code"));
                    v.add(result1.getString("barcode"));
                    v.add(result1.getString("product_name"));
                    v.add(result1.getString("weight"));

                    dtm.addRow(v);
                }

            } catch (SQLException ex) {
                DB.processException(ex);
            }

        } else if (sortCombo.getSelectedItem().equals("කේතය අනුව සකසන්න")) {

            ResultSet result1 = ProductManager.getAllProductOrderByCode();
            try {

                while (result1.next()) {
                    Vector v = new Vector();

                    v.add(result1.getString("code"));
                    v.add(result1.getString("barcode"));
                    v.add(result1.getString("product_name"));
                    v.add(result1.getString("weight"));

                    dtm.addRow(v);
                }

            } catch (SQLException ex) {
                DB.processException(ex);
            }

        }

//        supplierTable.setRowSelectionInterval(dtm.getRowCount()-1, dtm.getRowCount()-1);
    }

    private void generateGrnId() {
        try {
            int count = GrnManager.getLastGrnId();
            String idGrn = String.valueOf(count + 1);
            String id = "00000000";
            int id_length = idGrn.length();
            id = id.substring(id_length);
            id = id.concat(idGrn);
            grnId.setText(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void clearItemTextField() {
        productLoadCombo.removeAllItems();
        productSearchTxt.setText(null);
        qty.setText(null);
        mfd.setCalendar(null);
        exp.setCalendar(null);
        sellingPrice.setText(null);
        total.setText(null);
        cost.setText(null);
        gap.setText(null);
        productName.setText(null);
        productSearchTxt.grabFocus();
    }

    private void deleteSelectedRow() {
        int selectRow = grnTable.getSelectedRow();

        if (selectRow != -1) {
            DefaultTableModel dtm = (DefaultTableModel) grnTable.getModel();

            double selectedSubTotal = (double) dtm.getValueAt(selectRow, 6);

            subTotalSum -= selectedSubTotal;

            subTotal.setText("මුළු එකතුව = රු " + subTotalSum);
            netTotal.setText("අවසන් එකතුව = රු " + subTotalSum);
            dtm.removeRow(selectRow);
        }
    }

    private void saveGrn() {

        if (supplierLoadCombo.getSelectedItem() != null) {

            if (grnTable.getRowCount() != 0) {

                String supplierTxt = (String) supplierLoadCombo.getSelectedItem();
                Grn grn = new Grn()
                        .setSubTotal(subTotalSum)
                        .setNetTotal(Double.parseDouble(netTotal.getText().split("අවසන් එකතුව = රු ")[1]))
                        .setSupplierCode(supplierTxt.split(" - ")[0].trim())
                        .setUserId(Main.userId);

                ArrayList<GrnItem> grnItemList = new ArrayList<GrnItem>();

                DefaultTableModel dtm = (DefaultTableModel) grnTable.getModel();

                for (int i = 0; i < grnTable.getRowCount(); i++) {
                    GrnItem grnItem = new GrnItem();
                    String productTxt = (String) dtm.getValueAt(i, 0);
                    grnItem.setProductName(productTxt.split("-")[0].trim());
                    grnItem.setProductWeight(productTxt.split("-")[1].trim());

                    SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");

                    String mfdTxt = (String) dtm.getValueAt(i, 1);
                    String expTxt = (String) dtm.getValueAt(i, 2);

                    if (!mfdTxt.isEmpty()) {
                        System.out.println("A");
                        try {
                            Date mfdDate = sdf.parse(mfdTxt);
                            grnItem.setMfd(sdf.format(mfdDate));

                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }
                    }
                    if (!expTxt.isEmpty()) {
                        System.out.println("c");
                        try {
                            Date expDate = sdf.parse(expTxt);
//                            grnItem.setExp(new Timestamp(expDate.getTime()));
                            grnItem.setExp(sdf.format(expDate));

                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }
                    }

                    grnItem.setQty((Double) dtm.getValueAt(i, 3));
                    grnItem.setUnitCostPrice((Double) dtm.getValueAt(i, 4));
                    grnItem.setUnitSellingPrice((Double) dtm.getValueAt(i, 5));

                    grnItemList.add(grnItem);
                }
                grn.setGrnItemList(grnItemList);

                if (GrnManager.addGrn(grn)) {
                    System.out.println("Yes");
                    if (JOptionPane.showConfirmDialog(null, PRINTORNOT, "WARNING",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        printGrn();
                        System.out.println("Print");
                    } else {
                        System.out.println("Not Print");
                    }
                    generateGrnId();
                    cancelGrn();
                } else {
                    System.out.println("No");
                    JOptionPane.showMessageDialog(this, TRYAGAINERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                    cancelGrn();
                }

            } else {
                JOptionPane.showMessageDialog(this, SELECTPRODUCTITEMERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
                productSearchTxt.grabFocus();
            }

        } else {
            JOptionPane.showMessageDialog(this, SELECTSUPPLIERERROR, "වැරදි", JOptionPane.ERROR_MESSAGE);
            supplierSearchTxt.grabFocus();
        }

    }

    private void printGrn() {
        try {
            HashMap<String, Object> m = new HashMap();
            String i = String.valueOf(Integer.parseInt(grnId.getText()));

            m.put("grnId", i);
            InputStream is = Invoice.class.getResourceAsStream("/Reports/MyRetail_Grn.jrxml");
            JasperReport report = JasperCompileManager.compileReport(is);

            JasperPrint print1 = JasperFillManager.fillReport(report, m, DB.getConnection());
            JasperViewer.viewReport(print1, false);
            JasperPrintManager.printReport(print1, true);

        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
    
    private void cancelGrn() {
        clearItemTextField();
        supplierSearchTxt.setText(null);
        supplierLoadCombo.removeAllItems();

        DefaultTableModel dtm = (DefaultTableModel) grnTable.getModel();
        dtm.setRowCount(0);

        subTotal.setText("මුළු එකතුව = රු 0.00");
        discount.setText(null);
        pecentage.setText(null);
        netTotal.setText("අවසන් එකතුව = රු 0.00");

        subTotalSum = 0.0;
        netTotalSum = 0.0;
    }

    ArrayList<String> stockValues = new ArrayList<String>();
    ArrayList<Databases.Beans.Stock> stockBeans = new ArrayList<Databases.Beans.Stock>();

    private void loadStockTable() {

        DefaultTableModel dtm = (DefaultTableModel) stockTable.getModel();

        stockSearchTxt.setText(null);
        stockLoadCombo.removeAllItems();
        searchExpStock.setCalendar(null);
        stockValues.clear();
        stockBeans.clear();
        dtm.setRowCount(0);

        try {
//        සාමාන්‍ය ලෙස සකසන්න
//අකාරාදී පිළිවෙලට සකසන්න
//ආසන්නතම ක.ඉ.දි සිට සකසන්න 
//දුරම ක.ඉ.දි සිට සකසන්න 
//අඩුම මිල සිට සකසන්න
//වැඩිම මිල සිට සකසන්න

            if (stockSortCombo.getSelectedItem().equals("සාමාන්‍ය ලෙස සකසන්න")) {

                ResultSet result1 = StockManager.getAllStock();

                while (result1.next()) {

                    String productNameTxt = result1.getString("product_weight");
                    String mfdTxt = result1.getString("mfd");
                    String expTxt = result1.getString("exp");
                    double sellingPriceTxt = result1.getDouble("selling_price");
                    double costTxt = result1.getDouble("cost");
                    double qtyTxt = result1.getDouble("stock.qty");

                    if (stockValues.contains(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt)) {

                        double pastQty = (double) dtm.getValueAt(stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);
                        dtm.setValueAt(pastQty + qtyTxt, stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);

                    } else {
                        Vector v = new Vector();

                        v.add(productNameTxt);
                        v.add(mfdTxt);
                        v.add(expTxt);
                        v.add(costTxt);
                        v.add(sellingPriceTxt);
                        v.add(qtyTxt);

                        dtm.addRow(v);

                        stockValues.add(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt);
                    }
                }
            } else if (stockSortCombo.getSelectedIndex() == 1) {

                ResultSet result1 = StockManager.getAllStock();

                while (result1.next()) {

                    Databases.Beans.Stock s = new Databases.Beans.Stock();

                    s.setProductName(result1.getString("product_weight"));
                    s.setMfd(result1.getString("mfd"));
                    s.setSellingPrice(result1.getDouble("selling_price"));
                    s.setCost(result1.getDouble("cost"));
                    s.setQty(result1.getDouble("stock.qty"));

                    String expTxt = result1.getString("exp");
                    s.setExp(expTxt);
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                    SimpleDateFormat sdfomatter = new SimpleDateFormat("yyyy,MM, dd");

                    if (!expTxt.equals("null")) {

                        try {
                            Date expDate = sdf.parse(expTxt);

                            s.setExpYear(Integer.parseInt(sdfomatter.format(expDate).split(",")[0].trim()));
                            s.setExpMonth(Integer.parseInt(sdfomatter.format(expDate).split(",")[1].trim()));
                            s.setExpDay(Integer.parseInt(sdfomatter.format(expDate).split(",")[2].trim()));

                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }

                    }

                    stockBeans.add(s);
                }

                Collections.sort(stockBeans, Comparator.comparing(Databases.Beans.Stock::getExpYear).thenComparing(Databases.Beans.Stock::getExpMonth).thenComparing(Databases.Beans.Stock::getExpDay));

                for (Databases.Beans.Stock ss : stockBeans) {

                    if (stockValues.contains(ss.getProductName() + "/" + ss.getMfd() + "/" + ss.getExp() + "/" + ss.getCost() + "/" + ss.getSellingPrice())) {

                        double pastQty = (double) dtm.getValueAt(stockValues.indexOf(ss.getProductName() + "/" + ss.getMfd() + "/" + ss.getExp() + "/" + ss.getCost() + "/" + ss.getSellingPrice()), 5);
                        dtm.setValueAt(pastQty + ss.getQty(), stockValues.indexOf(ss.getProductName() + "/" + ss.getMfd() + "/" + ss.getExp() + "/" + ss.getCost() + "/" + ss.getSellingPrice()), 5);

                    } else {
                        Vector v = new Vector();

                        v.add(ss.getProductName());
                        v.add(ss.getMfd());
                        v.add(ss.getExp());
                        v.add(ss.getCost());
                        v.add(ss.getSellingPrice());
                        v.add(ss.getQty());

                        dtm.addRow(v);

                        stockValues.add(ss.getProductName() + "/" + ss.getMfd() + "/" + ss.getExp() + "/" + ss.getCost() + "/" + ss.getSellingPrice());
                    }

                }

            } else if (stockSortCombo.getSelectedIndex() == 2) {
                System.out.println("Aa");
                ResultSet result1 = StockManager.getAllStock();

                while (result1.next()) {

                    Databases.Beans.Stock s = new Databases.Beans.Stock();

                    s.setProductName(result1.getString("product_weight"));
                    s.setMfd(result1.getString("mfd"));
                    s.setSellingPrice(result1.getDouble("selling_price"));
                    s.setCost(result1.getDouble("cost"));
                    s.setQty(result1.getDouble("stock.qty"));

                    String expTxt = result1.getString("exp");
                    s.setExp(expTxt);
                    SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                    SimpleDateFormat sdfomatter = new SimpleDateFormat("yyyy,MM, dd");

                    if (!expTxt.equals("null")) {

                        try {
                            Date expDate = sdf.parse(expTxt);

                            s.setExpYear(Integer.parseInt(sdfomatter.format(expDate).split(",")[0].trim()));
                            s.setExpMonth(Integer.parseInt(sdfomatter.format(expDate).split(",")[1].trim()));
                            s.setExpDay(Integer.parseInt(sdfomatter.format(expDate).split(",")[2].trim()));

                        } catch (ParseException ex) {
                            System.out.println(ex);
                        }

                    }

                    stockBeans.add(s);
                }

                Collections.sort(stockBeans, Comparator.comparing(Databases.Beans.Stock::getExpYear).thenComparing(Databases.Beans.Stock::getExpMonth).thenComparing(Databases.Beans.Stock::getExpDay));

                Collections.reverse(stockBeans);

                for (Databases.Beans.Stock ss : stockBeans) {

                    if (stockValues.contains(ss.getProductName() + "/" + ss.getMfd() + "/" + ss.getExp() + "/" + ss.getCost() + "/" + ss.getSellingPrice())) {

                        double pastQty = (double) dtm.getValueAt(stockValues.indexOf(ss.getProductName() + "/" + ss.getMfd() + "/" + ss.getExp() + "/" + ss.getCost() + "/" + ss.getSellingPrice()), 5);
                        dtm.setValueAt(pastQty + ss.getQty(), stockValues.indexOf(ss.getProductName() + "/" + ss.getMfd() + "/" + ss.getExp() + "/" + ss.getCost() + "/" + ss.getSellingPrice()), 5);

                    } else {
                        Vector v = new Vector();

                        v.add(ss.getProductName());
                        v.add(ss.getMfd());
                        v.add(ss.getExp());
                        v.add(ss.getCost());
                        v.add(ss.getSellingPrice());
                        v.add(ss.getQty());

                        dtm.addRow(v);

                        stockValues.add(ss.getProductName() + "/" + ss.getMfd() + "/" + ss.getExp() + "/" + ss.getCost() + "/" + ss.getSellingPrice());
                    }

                }

            } else if (stockSortCombo.getSelectedItem().equals("අඩුම මිල සිට සකසන්න")) {

                ResultSet result1 = StockManager.getAllStockAscSellingPrice();

                while (result1.next()) {

                    String productNameTxt = result1.getString("product_weight");
                    String mfdTxt = result1.getString("mfd");
                    String expTxt = result1.getString("exp");
                    double sellingPriceTxt = result1.getDouble("selling_price");
                    double costTxt = result1.getDouble("cost");
                    double qtyTxt = result1.getDouble("stock.qty");

                    if (stockValues.contains(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt)) {

                        double pastQty = (double) dtm.getValueAt(stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);
                        dtm.setValueAt(pastQty + qtyTxt, stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);

                    } else {
                        Vector v = new Vector();

                        v.add(productNameTxt);
                        v.add(mfdTxt);
                        v.add(expTxt);
                        v.add(costTxt);
                        v.add(sellingPriceTxt);
                        v.add(qtyTxt);

                        dtm.addRow(v);

                        stockValues.add(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt);
                    }

                }
            } else if (stockSortCombo.getSelectedItem().equals("වැඩිම මිල සිට සකසන්න")) {

                ResultSet result1 = StockManager.getAllStockDescSellingPrice();

                while (result1.next()) {

                    String productNameTxt = result1.getString("product_weight");
                    String mfdTxt = result1.getString("mfd");
                    String expTxt = result1.getString("exp");
                    double sellingPriceTxt = result1.getDouble("selling_price");
                    double costTxt = result1.getDouble("cost");
                    double qtyTxt = result1.getDouble("stock.qty");

                    if (stockValues.contains(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt)) {

                        double pastQty = (double) dtm.getValueAt(stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);
                        dtm.setValueAt(pastQty + qtyTxt, stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);

                    } else {
                        Vector v = new Vector();

                        v.add(productNameTxt);
                        v.add(mfdTxt);
                        v.add(expTxt);
                        v.add(costTxt);
                        v.add(sellingPriceTxt);
                        v.add(qtyTxt);

                        dtm.addRow(v);

                        stockValues.add(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt);
                    }

                }
            }

        } catch (SQLException ex) {
            DB.processException(ex);
        }
        stockTable.setDefaultRenderer(Object.class, new StockTableCellRender());
    }

    private void loadStockTable(String productName, String weight) {

        DefaultTableModel dtm = (DefaultTableModel) stockTable.getModel();

        stockValues.clear();
        dtm.setRowCount(0);
        ResultSet result1 = StockManager.getAllStockFromNameWeight(productName, weight);
        try {

            while (result1.next()) {

                String productNameTxt = result1.getString("product_weight");
                String mfdTxt = result1.getString("mfd");
                String expTxt = result1.getString("exp");
                double sellingPriceTxt = result1.getDouble("selling_price");
                double costTxt = result1.getDouble("cost");
                double qtyTxt = result1.getDouble("stock.qty");

                if (stockValues.contains(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt)) {

                    double pastQty = (double) dtm.getValueAt(stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);
                    dtm.setValueAt(pastQty + qtyTxt, stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);

                } else {
                    Vector v = new Vector();

                    v.add(productNameTxt);
                    v.add(mfdTxt);
                    v.add(expTxt);
                    v.add(costTxt);
                    v.add(sellingPriceTxt);
                    v.add(qtyTxt);

                    dtm.addRow(v);

                    stockValues.add(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt);
                }
                stockTable.setDefaultRenderer(Object.class, new StockTableCellRender());
            }

        } catch (SQLException ex) {
            DB.processException(ex);
        }

    }

    private void loadStockTable(Date searchExpDate) {

        DefaultTableModel dtm = (DefaultTableModel) stockTable.getModel();

        stockValues.clear();
        dtm.setRowCount(0);
        ResultSet result1 = StockManager.getAllStock();
        try {

            while (result1.next()) {

                String productNameTxt = result1.getString("product_weight");
                String mfdTxt = result1.getString("mfd");
                String expTxt = result1.getString("exp");
                double sellingPriceTxt = result1.getDouble("selling_price");
                double costTxt = result1.getDouble("cost");
                double qtyTxt = result1.getDouble("stock.qty");

                SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");

                if (!expTxt.equals("null")) {

                    Date expDate = sdf.parse(expTxt);

                    if (expDate.before(searchExpDate)) {

                        if (stockValues.contains(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt)) {

                            double pastQty = (double) dtm.getValueAt(stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);
                            dtm.setValueAt(pastQty + qtyTxt, stockValues.indexOf(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt), 5);

                        } else {
                            Vector v = new Vector();

                            v.add(productNameTxt);
                            v.add(mfdTxt);
                            v.add(expTxt);
                            v.add(costTxt);
                            v.add(sellingPriceTxt);
                            v.add(qtyTxt);

                            dtm.addRow(v);

                            stockValues.add(productNameTxt + "/" + mfdTxt + "/" + expTxt + "/" + costTxt + "/" + sellingPriceTxt);
                        }
                        stockTable.setDefaultRenderer(Object.class, new StockTableCellRender());

                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
       
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
             if (nke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {

            deleteSelectedRow();
        }
    }

}

class StockTableCellRender extends DefaultTableCellRenderer {

    public StockTableCellRender() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(new java.awt.Font("Nirmala UI", 0, 17));
        try {
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();

            String expTxt = (String) dtm.getValueAt(row, 2);
            double count = (double) dtm.getValueAt(row, 5);

            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");

            if (!expTxt.equals("null")) {

                Date expDate = sdf.parse(expTxt);

                if (expDate.before(new Date())) {

                    Calendar cc = Calendar.getInstance();

                    // set the calendar to start of today
                    cc.set(Calendar.HOUR_OF_DAY, 0);
                    cc.set(Calendar.MINUTE, 0);
                    cc.set(Calendar.SECOND, 0);
                    cc.set(Calendar.MILLISECOND, 0);

                    Date today = cc.getTime();

                    if (expDate.equals(today)) {
setBackground(Color.decode("#FB7F79"));
                        setForeground(Color.black);
                    } else {
                        setBackground(Color.decode("#CDD3D3"));
                        setForeground(Color.black);
                    }
                } else {
                    if (count < 5) {
                  setBackground(Color.decode("#FBF092"));
                        setForeground(Color.black);
                    } else {
                        setBackground(Color.white);
                        setForeground(Color.black);
                    }
                }

            } else {

                if (count < 5) {
                   setBackground(Color.decode("#FBF092"));
                        setForeground(Color.black);
                } else {
                    setBackground(Color.white);
                    setForeground(Color.black);
                }
            }

            setText(value != null ? value.toString() : "");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}
