package domain.view;

import domain.model.CaesarCipherStrategy;
import domain.model.CipherContext;
import domain.model.MirrorCipherStrategy;

import java.util.Scanner;

public class CipherUI {

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your text: ");
        String string = sc.nextLine();
        CipherContext cipherContext = new CipherContext(string);
        System.out.println("Do you want to use Caesar encryption (1) or Mirror encryption (2) for your text?");
        int a = sc.nextInt();
        if (a == 1)
            cipherContext.setCipherStrategy(new CaesarCipherStrategy(cipherContext));
        else if (a == 2)
            cipherContext.setCipherStrategy(new MirrorCipherStrategy(cipherContext));
        else
            System.out.println("This won't work.");
        System.out.println("Do you want to decode (1) or encode (2) your text?");
        int b = sc.nextInt();
        if (b == 1)
            cipherContext.decode();
        else if (b == 2)
            cipherContext.encode();
        else
            System.out.println("This won't work yet again.");
        System.out.println("The result of your choices:");
        cipherContext.display();
    }
}
