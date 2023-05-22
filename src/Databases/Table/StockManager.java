/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Table;

import Databases.Beans.Stock;
import Databases.DB;
import java.sql.ResultSet;

/**
 *
 * @author nipun
 */
public class StockManager {

    public static ResultSet getAllStock() {
        return DB.search("SELECT *, CONCAT(PRODUCT_NAME,'-',WEIGHT) AS product_weight FROM product INNER JOIN grn_item INNER JOIN stock ON"
                + " product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item ORDER BY product_name");
    }

    public static ResultSet getAllStockAscSellingPrice() {
        return DB.search("SELECT *, CONCAT(PRODUCT_NAME,'-',WEIGHT) AS product_weight FROM product INNER JOIN grn_item INNER JOIN stock ON"
                + " product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item ORDER BY selling_price");
    }

    public static ResultSet getAllStockDescSellingPrice() {
        return DB.search("SELECT *, CONCAT(PRODUCT_NAME,'-',WEIGHT) AS product_weight FROM product INNER JOIN grn_item INNER JOIN stock ON"
                + " product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item ORDER BY  selling_price DESC");
    }

    public static ResultSet getAllStockFromNameWeight(String productName, String Weight) {
        return DB.search("SELECT *, CONCAT(PRODUCT_NAME,'-',WEIGHT) AS product_weight FROM product INNER JOIN grn_item INNER JOIN stock ON"
                + " product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item WHERE product_name = '" + productName + "' AND weight = '" + Weight + "' ");
    }
    
     public static ResultSet getAllStockFromNameWeightMoreQty(String productName, String Weight) {
        return DB.search("SELECT *, CONCAT(PRODUCT_NAME,'-',WEIGHT) AS product_weight ,if(stock.qty>0,'yes','no') AS status FROM product INNER JOIN grn_item INNER JOIN stock ON"
                + " product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item WHERE product_name = '" + productName + "' AND weight = '" + Weight + "' ");
    }


    public static ResultSet getAllStockFromExpDate(String expDate) {
        return DB.search("SELECT *, CONCAT(PRODUCT_NAME,'-',WEIGHT) AS product_weight FROM product INNER JOIN grn_item INNER JOIN stock ON"
                + " product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item WHERE exp = '" + expDate + "' ");
    }
    
    public static boolean updateSellingPrice(Stock stock){
       return DB.iud("UPDATE product INNER JOIN grn_item INNER JOIN stock ON product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item "
               + "SET selling_price = '"+stock.getNewSellingPrice()+"' WHERE CONCAT(PRODUCT_NAME,'-',WEIGHT) = '"+stock.getProductName()+"' AND mfd = '"+stock.getMfd()+"' AND exp = '"+stock.getExp()+"' AND"
               + " cost = '"+stock.getCost()+"' AND selling_price = '"+stock.getSellingPrice()+"' ");
    }
}
