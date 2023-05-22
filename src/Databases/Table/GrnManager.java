/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Table;

import Databases.Beans.Grn;
import Databases.Beans.GrnItem;
import Databases.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nipun
 */
public class GrnManager {

    public static int getLastGrnId() {
        ResultSet result = DB.search("SELECT idgrn FROM grn  ORDER BY idgrn DESC  LIMIT 1");

        try {
            if (result.next()) {
                return result.getInt("idgrn");
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }

        return 0;
    }

    public static boolean addGrn(Grn grn) {

        int grnId = -1;
        int grnItemId = -1;
        boolean flag = true;
        String supplierId = SupplierManager.getSupplierIdFromCode(grn.getSupplierCode());

        if (supplierId != null) {
            grn.setSupplierId(supplierId);

            if (flag) {

                grnId = DB.iudReturnId("INSERT INTO grn(idsupplier,sub_total,net_total,date,iduser) VALUES('" + grn.getSupplierId() + "', '" + grn.getSubTotal() + "', '" + grn.getNetTotal() + "', now() , '"+grn.getUserId()+"' ) ");

            }

            if (grnId != -1) {
                flag = true;
            } else {
                flag = false;
            }

            if (flag) {
                for (GrnItem grnItem : grn.getGrnItemList()) {

                    String productId = ProductManager.getProductIdFromNameWeight(grnItem.getProductName(), grnItem.getProductWeight());

                    if (productId != null) {
                        grnItemId = DB.iudReturnId("INSERT INTO grn_item(idgrn,idproduct,qty,cost) VALUES('" + grnId + "' , '" + productId + "' , '" + grnItem.getQty() + "' ,'" + grnItem.getUnitCostPrice()+ "'  ) ");
                        
                        if(grnItemId != -1){
                            flag = DB.iud("INSERT INTO stock( qty,selling_price,mfd,exp,idgrn_item) VALUES('"+grnItem.getQty()+"', '"+grnItem.getUnitSellingPrice()+"', '"+grnItem.getMfd()+"', '"+grnItem.getExp()+"' , '"+grnItemId+"' ) ");
                        }
                    }
                }
            }

            if (flag) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }
    
        public static ResultSet getGrnBetweenDates(String from, String to) {

        return DB.search("SELECT * FROM grn INNER JOIN user On grn.iduser = user.iduser WHERE grn.date >= '"+from+"' AND grn.date <= '"+to+"' ");
    }
        
            public static ResultSet getGrnItemById(String grnId) {
        return DB.search("SELECT * FROM grn_item INNER JOIN product ON grn_item.idproduct = product.idproduct WHERE grn_item.idgrn = '"+grnId+"' ");
    }
            
                 public static ResultSet getGrnById(String grnId) {

        return DB.search("SELECT * FROM grn INNER JOIN user On grn.iduser = user.iduser WHERE grn.idgrn = '"+grnId+"' ");
    }



}
