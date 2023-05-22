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
public class Product {

    
    
    private String productName;
    private String oldProductName;
    private String productId;
    private String code;
    private String barcode;
    private String weight;
    private String oldWeight;
    
    /**
     * @return the oldWeight
     */
    public String getOldWeight() {
        return oldWeight;
    }

    /**
     * @param oldWeight the oldWeight to set
     */
    public Product setOldWeight(String oldWeight) {
        this.oldWeight = oldWeight;
        return this;
    }


    /**
     * @return the oldProductName
     */
    public String getOldProductName() {
        return oldProductName;
    }

    /**
     * @param oldProductName the oldProductName to set
     */
    public Product setOldProductName(String oldProductName) {
        this.oldProductName = oldProductName;
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
    public Product setProductId(String productId) {
        this.productId = productId;
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
    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public Product setCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public Product setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public Product setWeight(String weight) {
        this.weight = weight;
        return this;
    }

}
