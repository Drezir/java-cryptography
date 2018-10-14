package digi_signatures;

import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * @author Adam Ostrozlik
 * @version 1.0
 * @since 14.10.2018
 **/
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);

        String data = "Hello World";
        signature.update(data.getBytes());
        byte[] bytes = signature.sign();
        System.out.println(new String(bytes, "UTF-8"));


        // verify
        Signature signature1 = Signature.getInstance("SHA256withDSA");
        signature1.initVerify(keyPair.getPublic());
        signature1.update(data.getBytes());
        System.out.println(signature1.verify(bytes) ? "Verified" : "Not verified");
    }
}
