import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Main.Cupcake> cupcakeMenu, ArrayList<Main.Drink> drinkMenu) {
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();

        ArrayList<Object> order = new ArrayList<Object>();

        if (placeOrder.equalsIgnoreCase("Y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("\nHere is the menu ");
            System.out.println("\nCUPCAKES: ");

            int itemNumber = 0;

            for (int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber = itemNumber + 1;

                System.out.println(itemNumber);

                cupcakeMenu.get(i).type();

                System.out.println("\nPrice: " + cupcakeMenu.get(i).getPrice());
            }
                System.out.println();

                System.out.println("\nDRINKS: ");

                for (int i = 0; i < drinkMenu.size(); i++) {
                    itemNumber = itemNumber + 1;

                    System.out.println(itemNumber);

                    drinkMenu.get(i).type();

                    System.out.println("\nPrice: " + drinkMenu.get(i).getPrice());
                }
                    System.out.println();

        } else {
            System.out.println("Have a nice day then.");
        }

        boolean ordering = true;

        while (ordering) {
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
                System.out.println("\nPrice of that cupcake: " + cupcakeMenu.get(0).getPrice());
                subtotal = subtotal + cupcakeMenu.get(0).getPrice();
            }
            if (order.get(i).equals(cupcakeMenu.get(1))) {
                cupcakeMenu.get(1).type();
                System.out.println("\nPrice of that cupcake: " + cupcakeMenu.get(1).getPrice());
                subtotal = subtotal + cupcakeMenu.get(1).getPrice();
            }
            if (order.get(i).equals(cupcakeMenu.get(2))) {
                cupcakeMenu.get(2).type();
                System.out.println("\nPrice of that cupcake: " + cupcakeMenu.get(2).getPrice());
                subtotal = subtotal + cupcakeMenu.get(2).getPrice();
            }
            if (order.get(i).equals(drinkMenu.get(0))) {
                drinkMenu.get(0).type();
                System.out.println("\nPrice of that drink: " + drinkMenu.get(0).getPrice());
                subtotal = subtotal + drinkMenu.get(0).getPrice();
            }
            if (order.get(i).equals(drinkMenu.get(1))){
                drinkMenu.get(1).type();
                System.out.println("\nPrice of that drink: " + drinkMenu.get(1).getPrice());
                subtotal = subtotal + drinkMenu.get(1).getPrice();
            }
            if (order.get(i).equals(drinkMenu.get(2))) {
                drinkMenu.get(2).type();
                System.out.println("\nPrice of that drink: " + drinkMenu.get(2).getPrice());
                subtotal = subtotal + drinkMenu.get(2).getPrice();
            }
            System.out.println(subtotal);
            new CreateFile();
            new WriteToFile(order);
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
    public WriteToFile(ArrayList<Object> order) {
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
