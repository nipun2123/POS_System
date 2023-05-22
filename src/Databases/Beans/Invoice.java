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
public class Invoice {

    private String userId;
    private double subTotal;
    private double netTotal;
    private ArrayList<InvoiceItem> invoiceItemList;

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public Invoice setUserId(String userId) {
        this.userId = userId;
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
    public Invoice setSubTotal(double subTotal) {
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
    public Invoice setNetTotal(double netTotal) {
        this.netTotal = netTotal;
         return this;
    }

    /**
     * @return the invoiceItemList
     */
    public ArrayList<InvoiceItem> getInvoiceItemList() {
        return invoiceItemList;
    }

    /**
     * @param invoiceItemList the invoiceItemList to set
     */
    public Invoice setInvoiceItemList(ArrayList<InvoiceItem> invoiceItemList) {
        this.invoiceItemList = invoiceItemList;
         return this;
    }

}
