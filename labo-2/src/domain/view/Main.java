package domain.view;

import domain.model.CaesarCipher;
import domain.model.MirrorCipher;
import domain.model.Text;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your text: ");
        String string = sc.nextLine();
        Text text = new Text(string);
        System.out.println("Do you want to use Caesar Cipher (1) or Mirror Cipher (2) for your text?");
        int a = sc.nextInt();
        if (a == 1)
            text.setCipher(new CaesarCipher());
        else if (a == 2)
            text.setCipher(new MirrorCipher());
        else
            System.out.println("This won't work.");
        System.out.println("Do you want to decode (1) or encode (2) your text?");
        int b = sc.nextInt();
        if (b == 1)
            text.decode();
        else if (b == 2)
            text.encode();
        else
            System.out.println("This won't work yet again.");
        System.out.println("The result of your choices:");
        text.display();
    }
}
