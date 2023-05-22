/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Table;

import Databases.Beans.Supplier;
import Databases.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nipun
 */
public class SupplierManager {

    public static boolean addSupplier(Supplier supplier) {
        return DB.iud("INSERT INTO supplier(code,agent_fname,agent_lname,company,contact_number1,contact_number2) VALUES('" + supplier.getCode() + "','" + supplier.getAgentFname() + "','" + supplier.getAgentLname() + "','" + supplier.getCompany() + "','" + supplier.getTp1() + "','" + supplier.getTp2() + "') ");
    }

    public static boolean editSupplier(Supplier supplier) {

        return DB.iud("UPDATE supplier SET code = '" + supplier.getCode() + "', agent_fname = '" + supplier.getAgentFname() + "'  , agent_lname = '" + supplier.getAgentLname() + "' , company = '" + supplier.getCompany() + "' , contact_number1 ='" + supplier.getTp1() + "',  contact_number2 ='" + supplier.getTp2() + "' WHERE code = '" + supplier.getOldCode() + "'   ");
    }

    public static boolean isCodeExits(String code) {
        ResultSet result = DB.search("SELECT code FROM supplier WHERE code = '" + code + "' ");

        try {
            if (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }
        return false;
    }
    
        public static boolean isCompanyExits(String company) {
        ResultSet result = DB.search("SELECT company FROM supplier WHERE company = '" + company + "' ");

        try {
            if (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }
        return false;
    }

    public static ResultSet getAllSupplier() {
        return DB.search("SELECT * FROM supplier");
    }

    public static ResultSet getAllSupplierOrderCode() {
        return DB.search("SELECT * FROM supplier ORDER BY code");
    }

    public static ResultSet getAllSupplierOrderCompany() {
        return DB.search("SELECT * FROM supplier ORDER BY company");
    }

    public static ResultSet getSupplierFromCode(String code) {
        return DB.search("SELECT * FROM supplier WHERE code = '" + code + "' ");
    }
    
        public static String getSupplierIdFromCode(String code) {
        ResultSet result =  DB.search("SELECT idsupplier FROM supplier WHERE code = '" + code + "' ");
        
        try {
            if(result.next()){
                return result.getString("idsupplier");
            }
        } catch (SQLException ex) {
           DB.processException(ex);
        }
        return null;
    }

    public static ResultSet getAllLikeCompany(String company) {
        return DB.search("SELECT * FROM supplier WHERE company LIKE '%" + company + "%' ");
    }

    public static ResultSet getAllFromCompany(String company) {
        return DB.search("SELECT * FROM supplier WHERE company = '" + company + "' ");
    }

    public static ResultSet getAllLikeCode(String code) {
        return DB.search("SELECT * FROM supplier WHERE code LIKE '" + code + "%' ");
    }

    public static ResultSet getAllFromCode(String code) {
        return DB.search("SELECT * FROM supplier WHERE code = '" + code + "' ");
    }

    public static ResultSet getAllLikeCompanyAndCode(String data) {
        return DB.search("SELECT company,code FROM supplier WHERE company LIKE '" + data + "%' or code LIKE '" + data + "%' ");
    }
}
