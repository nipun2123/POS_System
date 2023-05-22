/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Table;

import Databases.Beans.HoldInvoice;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author nipun
 */
public class HoldInvoiceManager {

    public static boolean writeFile(HoldInvoice holdInvoice) {

        try {

            File f = new File("D:\\HoldInvoice_File\\HoldInvoice.txt");
            if (!f.exists()) {
                f.getParentFile().mkdirs();
                f.createNewFile();

                FileOutputStream fs = new FileOutputStream(f);
                ObjectOutputStream invoiceWriter = new ObjectOutputStream(fs);
                invoiceWriter.writeObject(holdInvoice);
                invoiceWriter.close();
                System.out.println("Successfully wrote to the file.");
                return true;

            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public static HoldInvoice readFile() throws ClassNotFoundException {
        try {

            File f = new File("D:\\HoldInvoice_File\\HoldInvoice.txt");
            if (f.exists()) {

                FileInputStream fs = new FileInputStream(f);
                ObjectInputStream invoiceReader = new ObjectInputStream(fs);
                HoldInvoice holdInvoiceObj = (HoldInvoice) invoiceReader.readObject();
                invoiceReader.close();
                f.delete();
                System.out.println("Successfully read the file.");
                return holdInvoiceObj;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }
}
