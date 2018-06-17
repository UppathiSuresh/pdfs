
import java.math.BigInteger;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import sun.misc.*;
public class MDAlgo {

    private static final String ALGO = "AES";
    private static final byte[] keyValue = new byte[] {'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
       
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
}
 public static String md5(String encryptedData) throws Exception {
     MessageDigest md=MessageDigest.getInstance("MD5");

    md.update(encryptedData.getBytes(),0,encryptedData.length());
    String returnstr=new BigInteger(1,md.digest()).toString(16);
    return returnstr;
 }
    String encrypt(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
