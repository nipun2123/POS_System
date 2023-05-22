/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Table;

import Databases.Beans.GrnItem;
import Databases.Beans.Invoice;
import Databases.Beans.InvoiceItem;
import Databases.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nipun
 */
public class InvoiceManager {

    public static int getLastInvoiceId() {
        ResultSet result = DB.search("SELECT idinvoice FROM invoice  ORDER BY idinvoice DESC  LIMIT 1");

        try {
            if (result.next()) {
                return result.getInt("idinvoice");
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }

        return 0;
    }

    public static boolean addInvoice(Invoice invoice) {

        int invoiceId = -1;
        int invoiceItemId = -1;
        boolean flag = true;

        if (flag) {

            invoiceId = DB.iudReturnId("INSERT INTO invoice(sub_total,net_total,date,iduser) VALUES('" + invoice.getSubTotal() + "', '" + invoice.getNetTotal() + "', now() , '" + invoice.getUserId() + "' ) ");

        }

        if (invoiceId != -1) {
            flag = true;
        } else {
            flag = false;
        }

        if (flag) {
            for (InvoiceItem invoiceItem : invoice.getInvoiceItemList()) {

                ResultSet result = ProductManager.getAllFromNameWeightPrice(invoiceItem.getProductName(), invoiceItem.getProductWight(), String.valueOf(invoiceItem.getSellingPrice()));

                try {
                    while (result.next()) {
                        if (!result.getString("selling_price").equals("0")) {
                            if (result.getString("status").equals("yes")) {

                                String expTxt = result.getString("exp");

                                if (!expTxt.equals("null")) {

                                    SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
                                    Date expDate = sdf.parse(expTxt);

                                    Calendar c = Calendar.getInstance();

                                    c.set(Calendar.HOUR_OF_DAY, 0);
                                    c.set(Calendar.MINUTE, 0);
                                    c.set(Calendar.SECOND, 0);
                                    c.set(Calendar.MILLISECOND, 0);

                                    Date today = c.getTime();

                                    if (expDate.after(new Date()) || expDate.equals(today)) {
                                        if (flag) {
                                            flag = DB.iud("INSERT INTO invoice_item(idinvoice,idstock,discount,qty) VALUES('" + invoiceId + "' , '" + result.getString("idstock") + "' , '" + invoiceItem.getItemDiscount() + "', '" + invoiceItem.getQty() + "' )");
                                        }

                                        if (result.getDouble("stock.qty") >= invoiceItem.getQty()) {
                                            double updatedQty = result.getDouble("stock.qty") - invoiceItem.getQty();
                                            flag = DB.iud("UPDATE stock SET qty = '" + updatedQty + "' WHERE idStock = '" + result.getString("idstock") + "' ");
                                            break;
                                        } else {
                                            double updatedQty = invoiceItem.getQty() - result.getDouble("stock.qty");
                                            invoiceItem.setQty(updatedQty);
                                            flag = DB.iud("UPDATE stock SET qty = '0' WHERE idStock = '" + result.getString("idstock") + "' ");
                                            flag = false;

                                        }

                                    }

                                } else {
                                    if (flag) {
                                        flag = DB.iud("INSERT INTO invoice_item(idinvoice,idstock,discount,qty) VALUES('" + invoiceId + "' , '" + result.getString("idstock") + "' , '" + invoiceItem.getItemDiscount() + "', '" + invoiceItem.getQty() + "' )");
                                    }

                                    if (result.getDouble("stock.qty") >= invoiceItem.getQty()) {
                                        double updatedQty = result.getDouble("stock.qty") - invoiceItem.getQty();
                                        flag = DB.iud("UPDATE stock SET qty = '" + updatedQty + "' WHERE idStock = '" + result.getString("idstock") + "' ");
                                        break;
                                    } else {
                                        double updatedQty = invoiceItem.getQty() - result.getDouble("stock.qty");
                                        invoiceItem.setQty(updatedQty);
                                        flag = DB.iud("UPDATE stock SET qty = '0' WHERE idStock = '" + result.getString("idstock") + "' ");
                                        flag = false;
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    DB.processException(ex);
                }
            }
        }

        if (flag) {
            return true;
        } else {
            return false;
        }

    }

    public static ResultSet getInvoicesBetweenDates(String from, String to) {

        return DB.search("SELECT * FROM invoice INNER JOIN user ON invoice.iduser = user.iduser WHERE invoice.date >= '" + from + "' AND invoice.date <= '" + to + "' ");
    }

    public static ResultSet getInvoiceItemById(String invId) {
        return DB.search("SELECT * FROM invoice_item INNER JOIN stock INNER JOIN grn_item INNER JOIN product ON invoice_item.idstock = stock.idstock AND "
                + "stock.idgrn_item = grn_item.idgrn_item AND grn_item.idproduct = product.idproduct WHERE invoice_item.idinvoice = '"+invId+"' ");
    }
    
        public static ResultSet getInvoicesById(String invId) {

        return DB.search("SELECT * FROM invoice INNER JOIN user ON invoice.iduser = user.iduser WHERE invoice.idinvoice = '"+invId+"' ");
    }

}
