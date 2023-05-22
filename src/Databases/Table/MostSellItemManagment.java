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
public class MostSellItemManagment {

    public static ResultSet getMostSellingOfWeek(String year, int week) {
        return DB.search("select concat(product.product_name,'-',product.weight) as productName, sum(invoice_item.qty) as qty from invoice"
                + " inner join invoice_item inner join stock inner join grn_item inner join product on invoice.idinvoice = invoice_item.idinvoice and "
                + "invoice_item.idstock = stock.idstock and stock.idgrn_item = grn_item.idgrn_item and grn_item.idproduct = product.idproduct WHERE "
                + "WEEK(invoice.date) = '"+week+"' -1   AND YEAR(invoice.date) = '"+year+"' group by "
                + "concat(product.product_name,'-',product.weight) ORDER BY SUM(invoice_item.qty) desc limit 5");
    }

    public static ResultSet getMostSellingOfMonth(String year, String month) {
        return DB.search("select concat(product.product_name,'-',product.weight) as productName, sum(invoice_item.qty) as qty from invoice"
                + " inner join invoice_item inner join stock inner join grn_item inner join product on invoice.idinvoice = invoice_item.idinvoice and "
                + "invoice_item.idstock = stock.idstock and stock.idgrn_item = grn_item.idgrn_item and grn_item.idproduct = product.idproduct "
                + "WHERE MONTH(invoice.date) = '"+month+"' AND YEAR(invoice.date) = '"+year+"' group by concat(product.product_name,'-',product.weight) "
                + "ORDER BY SUM(invoice_item.qty) desc limit 5");
    }
    
    public static ResultSet getMostSellingOfYear(String year) {
        return DB.search("select concat(product.product_name,'-',product.weight) as productName, sum(invoice_item.qty) as qty from invoice"
                + " inner join invoice_item inner join stock inner join grn_item inner join product on invoice.idinvoice = invoice_item.idinvoice and "
                + "invoice_item.idstock = stock.idstock and stock.idgrn_item = grn_item.idgrn_item and grn_item.idproduct = product.idproduct "
                + "WHERE  YEAR(invoice.date) = '"+year+"' group by concat(product.product_name,'-',product.weight) "
                + "ORDER BY SUM(invoice_item.qty) desc limit 5");
    }
    
        public static ResultSet getMostSellingFromTo(String from, String to) {
        return DB.search("select concat(product.product_name,'-',product.weight) as productName, sum(invoice_item.qty) as qty from invoice"
                + " inner join invoice_item inner join stock inner join grn_item inner join product on invoice.idinvoice = invoice_item.idinvoice and "
                + "invoice_item.idstock = stock.idstock and stock.idgrn_item = grn_item.idgrn_item and grn_item.idproduct = product.idproduct "
                + "WHERE  invoice.date >= '"+from+"' AND invoice.date <= '"+to+"' group by concat(product.product_name,'-',product.weight) "
                + "ORDER BY SUM(invoice_item.qty) desc limit 5");
    }

}
