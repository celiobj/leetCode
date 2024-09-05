/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problems;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DecryptAES {
    public static void main(String[] args) throws Exception {
        String encryptedText = "Z5B1vkyfUFPmyAn+ETPUqOGqByfKYh2I8VeqtfVhXh1i8MnsPH2ylYEAwC6z9gB9jgsIuKcF+4cKdo4+J6U6HDLC0JoVge/aKz831rRdQrOjAUpiIXfgjLIEkr4hBlmxZuRJyo8qBD58HIuBxVRvxA==";
        String sikHex = "404142434445464748494A4B4C4D4E4F4F4E4D4C4B4A49484746454443424140";
        String ivHex = "2242BBE364E48B65629822108EC5012B";
        
        // Convert hex strings to byte arrays
        byte[] sik = hexStringToByteArray(sikHex);
        byte[] iv = hexStringToByteArray(ivHex);
        
        // Convert encrypted text from base64 to byte array
        byte[] encryptedData = Base64.getDecoder().decode(encryptedText);
        
        // Create AES key
        SecretKeySpec secretKeySpec = new SecretKeySpec(sik, "AES");
        
        // Initialize cipher
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(iv));
        
        // Decrypt the data
        byte[] decryptedData = cipher.doFinal(encryptedData);
        
        // Convert decrypted byte array to string
        String decryptedText = new String(decryptedData);
        System.out.println("Decrypted Text: " + decryptedText);
    }
    
    // Helper method to convert hex string to byte array
    private static byte[] hexStringToByteArray(String hexString) {
        int len = hexString.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4)
                    + Character.digit(hexString.charAt(i+1), 16));
        }
        return data;
    }
}