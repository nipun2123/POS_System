
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encription;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 *
 * @author nipun
 */
public class Encript {
    private static final String algorithem = "AES";
    private static final byte[] keyValue = new byte[]{'2','8','5','d','S','w','S','j','Q','1','6','L','K','g','z','T'};
    
    public static String encript(String data)throws Exception{
        String encriptedValue = "";
        Key key = generateKey();
        Cipher c = Cipher.getInstance(algorithem);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        encriptedValue = new BASE64Encoder().encode(encVal);
        return encriptedValue;
    }
    
    public static String decript(String encriptedData) throws Exception{
         Key key = generateKey();
        Cipher c = Cipher.getInstance(algorithem);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encriptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decriptedValue = new String(decValue);
        return decriptedValue;
    }
    
    
    private static Key generateKey(){
      Key key =  new SecretKeySpec(keyValue, algorithem);
      return key;
    }
    
    public static void main(String[] args) {
        try {
        System.out.println(encript("admin"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
