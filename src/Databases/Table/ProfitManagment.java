/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Table;

import Databases.DB;
import java.sql.ResultSet;

/**
 *
 * @author nipun
 */
public class ProfitManagment {

//    public static ResultSet getAllGrnInvoiceOfToday(String year, String month, String date) {
//        return DB.search("select net_total, grn.date from grn where YEAR(date) = '" + year + "' AND MONTH(date) = '" + month + "' AND DAY(date) ='" + date + "' group by grn.date union select net_total, invoice.date from invoice where YEAR(date) = '" + year + "' AND MONTH(date) = '" + month + "' AND DAY(date) ='" + date + "' group by invoice.date");
//    }
    public static ResultSet getAllInvoiceOfToday(String year, String month, String date) {
        return DB.search("select net_total, invoice.date from invoice where YEAR(date) = '" + year + "' AND MONTH(date) = '" + month + "' AND DAY(date) ='" + date + "' group by invoice.date");
    }

    public static ResultSet getAllGrnOfToday(String year, String month, String date) {
        return DB.search("select net_total, grn.date from grn where YEAR(date) = '" + year + "' AND MONTH(date) = '" + month + "' AND DAY(date) ='" + date + "' group by grn.date");
    }

    public static ResultSet getAllInvoiceOfMonth(String year, String month) {
        return DB.search("select net_total, invoice.date from invoice where YEAR(date) = '" + year + "' AND MONTH(date) = '" + month + "'  group by invoice.date");
    }

    public static ResultSet getAllGrnOfMonth(String year, String month) {
        return DB.search("select net_total, grn.date from grn where YEAR(date) = '" + year + "' AND MONTH(date) = '" + month + "' group by grn.date");
    }
    
    public static ResultSet getAllInvoiceOfYear(String year) {
        return DB.search("select net_total, invoice.date from invoice where YEAR(date) = '" + year + "' group by invoice.date");
    }

    public static ResultSet getAllGrnOfYear(String year) {
        return DB.search("select net_total, grn.date from grn where YEAR(date) = '" + year + "' group by grn.date");
    }
    
    public static ResultSet getAllInvoiceFromTo(String from, String to) {
        return DB.search("select net_total, invoice.date from invoice where invoice.date >= '"+from+"' AND invoice.date <= '"+to+"' group by invoice.date");
    }

    public static ResultSet getAllGrnFromTo(String from, String to) {
        return DB.search("select net_total, grn.date from grn where grn.date >= '"+from+"' AND grn.date <= '"+to+"' group by grn.date");
    }
}
