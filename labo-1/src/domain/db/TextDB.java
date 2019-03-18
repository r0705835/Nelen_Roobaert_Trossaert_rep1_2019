package domain.db;

import domain.model.*;

import java.io.*;
import java.util.Scanner;

public class TextDB {

    public void read(Shop shop) {
        try (Scanner scanner = new Scanner(new File("c:/temp/shop.txt"))) {
            while (scanner.hasNextLine()) {
                String category = scanner.next();
                int id = Integer.parseInt(scanner.next());
                String title = scanner.next();
                Product p;
                if (category.toUpperCase().equals("M")) {
                    p = new Movie(title, id);
                } else if (category.toUpperCase().equals("G")) {
                    p = new Game(title, id);
                } else {
                    p = new CD(title, id);
                }
                shop.getProducts().add(p);
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void print(Shop shop) throws IOException {
        FileWriter fileWriter = new FileWriter("c:/temp/shop.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Product product : shop.getProducts()) {
            if (product instanceof Movie) {
                printWriter.print("M ");
            } else if (product instanceof Game) {
                printWriter.print("G ");
            } else {
                printWriter.print("C ");
            }
            printWriter.println(product.getId() + " " + product.getTitle());
        }
        printWriter.close();
    }
}
