package ui.view;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        ShopUI shopUI = new ShopUI();
        shopUI.start();
        shopUI.print();
    }
}