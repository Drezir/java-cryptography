package message_digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @author Adam Ostrozlik
 * @version 1.0
 * @since 14.10.2018
 **/
public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        boolean cont;
        do {
            System.out.print("Enter something (empty line = end program): ");
            String line = scanner.nextLine();
            if (cont = !line.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                byte[] bytes = messageDigest.digest(line.getBytes());
                for (int i = 0; i < bytes.length; ++i) {
                    sb.append(String.format("%02X", bytes[i]));
                }
                System.out.println(line + ":\t" + sb.toString());
            }
        } while (cont);
    }
}
