package message_auth_code;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * @author Adam Ostrozlik
 * @version 1.0
 * @since 14.10.2018
 **/
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecureRandom secureRandom = new SecureRandom();
        keyGenerator.init(secureRandom);
        Key key = keyGenerator.generateKey();

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);

        boolean cont;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter something (empty line = end program): ");
            String line = scanner.nextLine();
            if (cont = !line.isEmpty()) {
                byte[] macResult = mac.doFinal(line.getBytes());
                System.out.println(line + ":\t" + new String(macResult));
            }
        } while (cont);
    }
}
