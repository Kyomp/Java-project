package Hotel;

import java.math.BigInteger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HexFormat;

public class Encryption {
private final int KEY_SIZE = 128;
private SecretKey key;
private final int DATA_LENGTH = 128;
private Cipher encryptionCipher, decryptionCipher;

    public Encryption(String startingKey) throws Exception {
        byte[] bytes = HexFormat.of().parseHex(toHexString(getSHA(startingKey)));
        bytes = Arrays.copyOfRange(bytes, 0, 16);
//        System.out.println(bytes.length);
//    	KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(KEY_SIZE);
//        key = keyGenerator.generateKey();
        key = new SecretKeySpec(bytes, 0, bytes.length, "AES"); 
        encryptionCipher = Cipher.getInstance("AES");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptionCipher = Cipher.getInstance("AES");
        decryptionCipher.init(Cipher.DECRYPT_MODE, key);
    }
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
    public static String toHexString(byte[] hash){
        BigInteger number = new BigInteger(1, hash);
 
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
 
        return hexString.toString();
    }
    public String encrypt(String data) throws Exception {
        return encode(encryptionCipher.doFinal(data.getBytes()));
    }
    public String decrypt(String encryptedData) throws Exception {
        byte[] decryptedBytes = decryptionCipher.doFinal(decode(encryptedData));
        return new String(decryptedBytes);
    }
    
    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }
}
