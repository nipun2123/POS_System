/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Beans;

import java.io.Serializable;

/**
 *
 * @author nipun
 */
public class InvoiceItem implements Serializable{

    
        private String productName;
    private String productWight;
    private double sellingPrice;
    private double qty;
    private double itemDiscount;
    private double itemTotal;
    
    /**
     * @return the productWight
     */
    public String getProductWight() {
        return productWight;
    }

    /**
     * @param productWight the productWight to set
     */
    public void setProductWight(String productWight) {
        this.productWight = productWight;
    }

    /**
     * @return the itemDiscount
     */
    public double getItemDiscount() {
        return itemDiscount;
    }

    /**
     * @param itemDiscount the itemDiscount to set
     */
    public InvoiceItem setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
        return this;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public InvoiceItem setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * @return the sellingPrice
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * @param sellingPrice the sellingPrice to set
     */
    public InvoiceItem setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public InvoiceItem setQty(double qty) {
        this.qty = qty;
        return this;
    }

    /**
     * @return the itemTotal
     */
    public double getItemTotal() {
        return itemTotal;
    }

    /**
     * @param itemTotal the itemTotal to set
     */
    public InvoiceItem setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
        return this;
    }

}
