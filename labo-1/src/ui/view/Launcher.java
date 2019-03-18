package ui.view;

import domain.db.TextDB;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        ShopUI shopUI = new ShopUI();
        TextDB textDB = new TextDB();
        textDB.read(shopUI.shop);
        shopUI.start();
        textDB.print(shopUI.shop);
    }
}