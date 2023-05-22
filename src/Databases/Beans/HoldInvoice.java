/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nipun
 */
public class HoldInvoice implements Serializable {

    
    private double subTotal;
    private double netTotal;
    private double discount;
    private double percentage;
    private ArrayList<InvoiceItem> invoiceItemList;
    
    /**
     * @return the invoiceItemList
     */
    public ArrayList<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    /**
     * @param invoiceItemList the invoiceItemList to set
     */
    public HoldInvoice setInvoiceItemList(ArrayList<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
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
    public HoldInvoice setSubTotal(double subTotal) {
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
    public HoldInvoice setNetTotal(double netTotal) {
        this.netTotal = netTotal;
        return this;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public HoldInvoice setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    /**
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public HoldInvoice setPercentage(double percentage) {
        this.percentage = percentage;
        return this;
    }

}
