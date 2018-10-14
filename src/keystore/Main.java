package keystore;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

/**
 * @author Adam Ostrozlik
 * @version 1.0
 * @since 14.10.2018
 **/
public class Main {

    public static final String SECRET_KEY_ALIAS = "secretKeyAlias";

    public static void main(String[] args) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException {
        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        String password = "password";
        KeyStore.ProtectionParameter protectionParameter = new KeyStore.PasswordProtection(password.toCharArray());
        SecretKey secretKey = new SecretKeySpec(password.getBytes(), "DSA");
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);

        keyStore.load(null, null);
        keyStore.setEntry(SECRET_KEY_ALIAS, secretKeyEntry, protectionParameter);

        // storing
        String pathname = "out/mykeystore";
        keyStore.store(new FileOutputStream(new File(pathname)), password.toCharArray());

        KeyStore keyStore1 = KeyStore.getInstance("JCEKS");
        keyStore1.load(new FileInputStream(new File(pathname)), password.toCharArray());
        KeyStore.SecretKeyEntry secretKeyEntry1 = (KeyStore.SecretKeyEntry) keyStore1.getEntry(SECRET_KEY_ALIAS, protectionParameter);
        System.out.println(secretKeyEntry1.toString());
    }
}
