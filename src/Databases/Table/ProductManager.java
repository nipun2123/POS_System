/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Table;

import Databases.Beans.Product;
import Databases.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nipun
 */
public class ProductManager {

    public static boolean addProduct(Product product) {
        return DB.iud("INSERT INTO product(product_name,barcode,weight,code) VALUES('" + product.getProductName() + "', '" + product.getBarcode() + "','" + product.getWeight() + "','" + product.getCode() + "') ");
    }

    public static boolean editProduct(Product product) {
        product.setProductId(getProductIdFromNameWeight(product.getOldProductName(), product.getOldWeight()));
        return DB.iud("UPDATE product SET product_name = '" + product.getProductName() + "',  barcode ='" + product.getBarcode() + "', weight ='" + product.getWeight() + "', code ='" + product.getCode() + "' WHERE idproduct = '" + product.getProductId() + "' ");
    }

    public static String getProductIdFromNameWeight(String productName, String weight) {
        ResultSet result = DB.search("SELECT idproduct FROM product WHERE product_name = '" + productName + "' AND weight = '" + weight + "' ");

        try {
            if (result.next()) {
                return result.getString("idproduct");
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }

        return null;
    }

    public static boolean isCodeExits(String code) {
        ResultSet result = DB.search("SELECT code FROM product WHERE code = '" + code + "' ");

        try {
            if (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }
        return false;
    }

    public static boolean isBarcodeExits(String barcode) {
        ResultSet result = DB.search("SELECT barcode FROM product WHERE barcode = '" + barcode + "' ");

        try {
            if (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }
        return false;
    }

    public static boolean isNameWeightExits(String productName, String weight) {
        ResultSet result = DB.search("SELECT product_name,weight FROM product WHERE product_name = '" + productName + "' AND weight = '" + weight + "' ");

        try {
            if (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }
        return false;
    }

    public static ResultSet getAllProduct() {
        return DB.search("SELECT * FROM product");
    }

    public static ResultSet getAllProductOrderByProduct() {
        return DB.search("SELECT * FROM product ORDER BY product_name");
    }

    public static ResultSet getAllProductOrderByCode() {
        return DB.search("SELECT * FROM product ORDER BY code");
    }

    public static ResultSet getProductFromNameWeight(String productName, String weight) {
        return DB.search("SELECT * FROM product WHERE product_name ='" + productName + "' AND weight = '" + weight + "' ");
    }

    public static ResultSet getAllLikeName(String productName) {
        return DB.search("SELECT * FROM product WHERE product_name LIKE '%" + productName + "%' ");
    }

    public static ResultSet getAllFromName(String productName) {
        return DB.search("SELECT * FROM product WHERE product_name =  '" + productName + "' ");
    }

    public static ResultSet getAllLikeBarcode(String barcode) {
        return DB.search("SELECT * FROM product WHERE barcode LIKE '" + barcode + "%' ");
    }

    public static ResultSet getAllFromBarcode(String barcode) {
        return DB.search("SELECT * FROM product WHERE barcode = '" + barcode + "' ");
    }

    public static ResultSet getAllLikeCode(String code) {
        return DB.search("SELECT * FROM product WHERE code LIKE '" + code + "%' ");
    }

    public static ResultSet getAllFromCode(String code) {
        return DB.search("SELECT * FROM product WHERE code = '" + code + "' ");
    }

    public static ResultSet getAllLikeNameBarcodeCode(String data) {
        return DB.search("SELECT product_name,barcode,code,weight FROM product WHERE product_name LIKE '%" + data + "%' or barcode LIKE '" + data + "%' or code LIKE '" + data + "%' ");
    }

    public static ResultSet getAllLikeNameBarcodeCodeMoreQty(String data) {
        return DB.search("SELECT DISTINCT barcode,code,product_name,weight,exp ,if(stock.qty>0,'yes','no') AS status, selling_price FROM product INNER JOIN grn_item INNER JOIN stock ON product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item WHERE product_name LIKE '%" + data + "%' or barcode LIKE '" + data + "%' or code LIKE '" + data + "%' ");
    }

    public static ResultSet getAllFromNameWeightPrice(String productName, String weight, String sellingPrice) {
        return DB.search("SELECT DISTINCT idStock,barcode,code,product_name,weight,exp ,if(stock.qty>0,'yes','no') AS status, selling_price, stock.qty FROM product INNER JOIN grn_item INNER JOIN stock ON product.idproduct = grn_item.idproduct AND grn_item.idgrn_item = stock.idgrn_item WHERE product_name = '" + productName + "' AND weight = '" + weight + "' AND selling_price = '" + sellingPrice + "' ");
    }
}
