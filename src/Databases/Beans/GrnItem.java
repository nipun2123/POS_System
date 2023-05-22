/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Beans;

import java.util.Date;

/**
 *
 * @author nipun
 */
public class GrnItem {

    
        private String productName;
    private String productWeight;
    private double qty;
    private double unitCostPrice;
    private double unitSellingPrice;
    private double unitDiscount;
    private String mfd;
    private String exp;
    
    /**
     * @return the unitCostPrice
     */
    public double getUnitCostPrice() {
        return unitCostPrice;
    }

    /**
     * @param unitCostPrice the unitCostPrice to set
     */
    public GrnItem setUnitCostPrice(double unitCostPrice) {
        this.unitCostPrice = unitCostPrice;
        return this;
    }

    /**
     * @return the unitSellPrice
     */
    public double getUnitSellingPrice() {
        return unitSellingPrice;
    }

    /**
     * @param unitSellPrice the unitSellPrice to set
     */
    public GrnItem setUnitSellingPrice(double unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
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
    public GrnItem setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * @return the productWeight
     */
    public String getProductWeight() {
        return productWeight;
    }

    /**
     * @param productWeight the productWeight to set
     */
    public GrnItem setProductWeight(String productWeight) {
        this.productWeight = productWeight;
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
    public GrnItem setQty(double qty) {
        this.qty = qty;
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
    public GrnItem setUnitDiscount(double unitDiscount) {
        this.unitDiscount = unitDiscount;
        return this;
    }

    /**
     * @return the mfd
     */
    public String getMfd() {
        return mfd;
    }

    /**
     * @param mfd the mfd to set
     */
    public GrnItem setMfd(String mfd) {
        this.mfd = mfd;
        return this;
    }

    /**
     * @return the exp
     */
    public String getExp() {
        return exp;
    }

    /**
     * @param exd the exp to set
     */
    public GrnItem setExp(String exp) {
        this.exp = exp;
        return this;
    }
}
