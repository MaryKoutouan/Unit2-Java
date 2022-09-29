import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Main.Cupcake> cupcakeMenu, ArrayList<Main.Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();

        ArrayList<Objects> order = new ArrayList<>();

        if (placeOrder.equalsIgnoreCase("Y")) {
            order.add(LocalDate.now());
            order.add(LocalDate.now());
            System.out.println("\nHere is the menu ");
            System.out.println("\nCUPCAKES: ");

            int itemNumber = 0;

            for (int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber = itemNumber + 1;

                System.out.println(itemNumber);

                cupcakeMenu.get(i).type();

                System.out.println("\nPrice: " + cupcakeMenu.get(i).getPrice());
                System.out.println();

                System.out.println("\nDRINKS: ");

                for (i = 0; i < drinkMenu.size(); i++) {
                    System.out.println(itemNumber);
                    drinkMenu.get(i).type();
                    System.out.println("\nPrice: " + drinkMenu.get(i).getPrice());
                    System.out.println();
                }
            }

        } else {
            System.out.println("Have a nice day then.");
        }

        boolean ordering = true;

        while (ordering == true) {
            System.out.println("\nWhat would you like to order? Please use the number associated with each item to order.");

            int orderChoice = input.nextInt();
            input.nextLine();

            if (orderChoice == 1) {
                order.add(cupcakeMenu.get(0));
                System.out.println("\nItem added to order");
            } else if (orderChoice == 2) {
                order.add(cupcakeMenu.get(1));
                System.out.println("\nItem added to order");
            } else if (orderChoice == 3) {
                order.add(cupcakeMenu.get(2));
                System.out.println("\nItem added to order");
            } else if (orderChoice == 4) {
                order.add(drinkMenu.get(0));
                System.out.println("\nItem added to order");
            } else if (orderChoice == 5) {
                order.add(drinkMenu.get(1));
                System.out.println("\nItem added to order");
            } else if (orderChoice == 6) {
                order.add(drinkMenu.get(2));
                System.out.println("\nItem added to order");
            } else {
                System.out.println("\nSorry, we don’t seem to have that on the menu.");
                System.out.println("\nWould you like to continue ordering? (Y/N)");
                placeOrder = input.nextLine();

                if (!placeOrder.equalsIgnoreCase("Y")) {
                    ordering = false;
                }
            }
        }
        System.out.println(order.get(0));
        System.out.println(order.get(1));

        double subtotal = 0.0;

        for (int i = 2; i < order.size(); i++) {
            if (order.get(i).equals(cupcakeMenu.get(0))) {
                cupcakeMenu.get(0).type();
            }
        }

    }
}

class CreateFile {
    public CreateFile() {
        try {
            File salesData = new File("salesData.txt");
            if (salesData.createNewFile()) {
                createNewFile();
                System.out.println("\nFile created: " + salesData.getName());
            } else {
                System.out.println("File already exists");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred");
        }
    }

    private boolean createNewFile() {

        return true;
    }
}

class WriteToFile {
    public WriteToFile(ArrayList<Objects> order) {
        try {
            FileWriter fw = new FileWriter("salesData.txt", true);

            PrintWriter salesWriter = new PrintWriter(fw);

            for ( int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i));

                salesWriter.close();

                System.out.println("Successfully wrote to the file");
            }
        }
        catch (IOException e){
            System.out.println("An error occurred");
        }
    }
}
