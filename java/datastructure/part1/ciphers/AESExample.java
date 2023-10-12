package part1.ciphers;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESExample {

    public static void main(String[] args) {
        try {
            // Generate a random AES key
            SecretKey secretKey = generateAESKey();

            // Encrypt and decrypt a message
            String originalMessage = "Hello, AES!";
            String encryptedMessage = encryptAES(originalMessage, secretKey);
            String decryptedMessage = decryptAES(encryptedMessage, secretKey);

            System.out.println("Original Message: " + originalMessage);
            System.out.println("Encrypted Message: " + encryptedMessage);
            System.out.println("Decrypted Message: " + decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Generate a random AES key
    public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // 128-bit key size
        return keyGenerator.generateKey();
    }

    // Encrypt a message using AES
    public static String encryptAES(String message, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Decrypt a message using AES
    public static String decryptAES(String encryptedMessage, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedMessage);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes);
    }
}
