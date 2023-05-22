/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Beans;

import java.util.ArrayList;

/**
 *
 * @author nipun
 */
public class Grn {
    
    
    private String userId;
      private String supplierId;
    private String supplierCode;

    private double subTotal;
    private double netTotal;

    private String productId;
    private String qty;
    private double unitPrice;
    private double unitDiscount;
    
    private ArrayList<GrnItem> grnItemList;

    /**
     * @return the grnItemList
     */
    public ArrayList<GrnItem> getGrnItemList() {
        return grnItemList;
    }

    /**
     * @param grnItemList the grnItemList to set
     */
    public Grn setGrnItemList(ArrayList<GrnItem> grnItemList) {
        this.grnItemList = grnItemList;
        return this;
    }

    /**
     * @return the supplierCode
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * @param supplierCode the supplierCode to set
     */
    public Grn setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
         return this;
    }

    /**
     * @return the supplierId
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public Grn setSupplierId(String supplierId) {
        this.supplierId = supplierId;
         return this;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public Grn setSubTotal(double subTotal) {
        this.subTotal = subTotal;
         return this;
    }

    /**
     * @return the netTotal
     */
    public double getNetTotal() {
        return netTotal;
    }

    /**
     * @param netTotal the netTotal to set
     */
    public Grn setNetTotal(double netTotal) {
        this.netTotal = netTotal;
         return this;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public Grn setProductId(String productId) {
        this.productId = productId;
         return this;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public Grn setQty(String qty) {
        this.qty = qty;
         return this;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public Grn setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
         return this;
    }

    /**
     * @return the unitDiscount
     */
    public double getUnitDiscount() {
        return unitDiscount;
    }

    /**
     * @param unitDiscount the unitDiscount to set
     */
    public Grn setUnitDiscount(double unitDiscount) {
        this.unitDiscount = unitDiscount;
        return this;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public Grn setUserId(String userId) {
        this.userId = userId;
        return this;
    }

}
