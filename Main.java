import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();

        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("\nWe are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");

        Scanner input = new Scanner(System.in);

        System.out.println("\nWe are deciding on the price for our standard cupcake. Here is the description");
        cupcake.type();

        System.out.println("""

                How much would you like to charge for the cupcake?\s
                Input a numerical number taken to 2 decimal places.""");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);



        System.out.println("\nWe are deciding on the price for our redvelvet cupcake. Here is the description");
        redVelvet.type();

        System.out.println("\nHow much would you like to charge for the redvelvet cupcake? ");
         priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);



        System.out.println("\nWe are deciding on the price for our chocolate cupcake. Here is the description");
        chocolate.type();

        System.out.println("\nHow much would you like to charge for the chocolate cupcake? ");
         priceText = input.nextLine();
         price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

        ArrayList<Drink> drinkMenu = new ArrayList<>();

         Drink water = new Drink();
         Soda soda = new Soda();
         Milk milk = new Milk();

        System.out.println("\nWe are deciding on the price for our bottle of water. Here is the description");
        water.type();

        System.out.println("""

                How much would you like to charge for the water?\s
                Input a numerical number taken to 2 decimal places.""");
         priceText = input.nextLine();
         price = Double.parseDouble(priceText);
        water.setPrice(price);



        System.out.println("\nWe are deciding on the price for our soda. Here is the description");
        soda.type();

        System.out.println("\nHow much would you like to charge for the soda? ");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);



        System.out.println("\nWe are deciding on the price for our milk. Here is the description");
        milk.type();

        System.out.println("\nHow much would you like to charge for the milk? ");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        new Order(cupcakeMenu, drinkMenu);

    }
    public static class Cupcake {
        public double price;

        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
        public void type() {
            System.out.println("A basic, generic cupcake, with vanilla frosting");
        }

    }

    public static class RedVelvet extends Cupcake {
        @Override
        public void type() {
            System.out.println("A red velvet based cupcake, with cream cheese frosting.");
        }

    }

    public static class Chocolate extends Cupcake {
        @Override
        public void type() {
            System.out.println("A chocolate based cupcake, with chocolate frosting.");
        }

    }

    static class Drink {
        public double price;

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void type() {
            System.out.println("Bottle of water");
        }
    }
    static class Soda extends Drink {
        @Override
        public void type() {
            System.out.println("A bottle of soda.");
        }
    }
    static class Milk extends Drink {
        @Override
        public void type() {
            System.out.println("A bottle of milk.");
        }
    }

}