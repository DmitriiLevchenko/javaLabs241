//https://github.com/DmitriiLevchenko
package RSA;

import java.io.PrintStream;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream out = System.out;
        RSA rsa = new RSA();
        String text;
        out.println("Input message to encrypt");
        text = scanner.nextLine();
        byte[] encrypted = rsa.encrypt(text.getBytes());
        out.println("Encrypted message:" + encrypted);
        byte[] decrypted = rsa.decrypt(encrypted);
        out.println("Decrypted message:" + new String(decrypted));
    }
}
