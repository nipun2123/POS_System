/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Beans;

/**
 *
 * @author nipun
 */
public class Stock {

          
      
    private String productName;
    private int expYear;
    private int expMonth;
    private int expDay;
    private String mfd;
    private String exp;
    private double sellingPrice;
    private double newSellingPrice;
    private double qty;
    private double cost;
    
    /**
     * @return the exp
     */
    public String getExp() {
        return exp;
    }

    /**
     * @param exp the exp to set
     */
    public Stock setExp(String exp) {
        this.exp = exp;
        return this;
    } 
    
    /**
     * @return the expYear
     */
    public int getExpYear() {
        return expYear;
    }

    /**
     * @param expYear the expYear to set
     */
    public Stock setExpYear(int expYear) {
        this.expYear = expYear;
        return this;
    }

    /**
     * @return the expMonth
     */
    public int getExpMonth() {
        return expMonth;
    }

    /**
     * @param expMonth the expMonth to set
     */
    public Stock setExpMonth(int expMonth) {
        this.expMonth = expMonth;
        return this;
    }

    /**
     * @return the expDay
     */
    public int getExpDay() {
        return expDay;
    }

    /**
     * @param expDay the expDay to set
     */
    public Stock setExpDay(int expDay) {
        this.expDay = expDay;
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
    public Stock setMfd(String mfd) {
        this.mfd = mfd;
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
    public Stock setSellingPrice(double sellingPrice) {
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
    public Stock setQty(double qty) {
        this.qty = qty;
        return this;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public Stock setCost(double cost) {
        this.cost = cost;
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
    public Stock setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * @return the newSellingPrice
     */
    public double getNewSellingPrice() {
        return newSellingPrice;
    }

    /**
     * @param newSellingPrice the newSellingPrice to set
     */
    public Stock setNewSellingPrice(double newSellingPrice) {
        this.newSellingPrice = newSellingPrice;
        return this;
    }

}
