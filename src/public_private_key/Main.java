package public_private_key;

import java.security.*;

/**
 * @author Adam Ostrozlik
 * @version 1.0
 * @since 14.10.2018
 **/
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println(privateKey);
        System.out.println(publicKey);
    }
}
