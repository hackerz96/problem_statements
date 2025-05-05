import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    static class Item {
        String name;
        double price;
        int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    static class ShoppingCartException extends Exception {
        public ShoppingCartException(String message) {
            super(message);
        }
    }

    static class InvalidCouponCodeException extends ShoppingCartException {
        public InvalidCouponCodeException(String message) {
            super(message);
        }
    }

    static class OutOfStockException extends ShoppingCartException {
        public OutOfStockException(String message) {
            super(message);
        }
    }

    static class NegativeQuantityException extends ShoppingCartException {
        public NegativeQuantityException(String message) {
            super(message);
        }
    }

    private static final List<Item> storeInventory = new ArrayList<>();

    static {
        storeInventory.add(new Item("apple", 2.0, 10));
        storeInventory.add(new Item("banana", 1.5, 15));
        storeInventory.add(new Item("milk", 3.0, 8));
        storeInventory.add(new Item("bread", 2.5, 12));
        storeInventory.add(new Item("eggs", 4.0, 6));
    }

    private final List<Item> cart = new ArrayList<>();
    private double totalPrice = 0.0;

    private Item findItemByName(String name) {
        for (Item item : storeInventory) {
            if (item.name.equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public void addItem(String name, int quantity) throws ShoppingCartException {
        Item storeItem = findItemByName(name);
        if (storeItem == null) {
            System.out.println("Item not found in the store.");
            return;
        }

        if (quantity < 0) {
            throw new NegativeQuantityException("Quantity cannot be negative.");
        } else if (quantity == 0 || quantity > storeItem.quantity) {
            throw new OutOfStockException("Requested quantity not available.");
        } else {
            cart.add(new Item(storeItem.name, storeItem.price, quantity));
            totalPrice += storeItem.price * quantity;
            storeItem.quantity -= quantity;
            System.out.println("Added " + quantity + " of " + name + " to the cart.");
        }
    }

    public void applyDiscount(String couponCode) throws InvalidCouponCodeException {
        if (!couponCode.equals("DISCOUNT10") && !couponCode.equals("SAVE20")) {
            throw new InvalidCouponCodeException("Invalid coupon code.");
        }

        if (couponCode.equals("DISCOUNT10")) {
            totalPrice *= 0.9;
        } else {
            totalPrice *= 0.8;
        }

        System.out.println("Coupon applied successfully!");
        System.out.printf("New total price: $%.2f%n", totalPrice);
    }

    public void checkout() {
        System.out.println("\nCart Summary:");
        for (Item item : cart) {
            System.out.printf("- %s x%d = $%.2f%n", item.name, item.quantity, item.price * item.quantity);
        }
        System.out.printf("Final total: $%.2f%n", totalPrice);
        cart.clear();
        totalPrice = 0.0;
        System.out.println("Thank you for shopping with us!");
    }

    public static void displayStoreItems() {
        System.out.println("\nAvailable Grocery Items:");
        for (Item item : storeInventory) {
            System.out.printf("- %s: $%.2f (%d in stock)%n", item.name, item.price, item.quantity);
        }
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("🛒 Welcome to the Grocery Store!");

        while (true) {
            displayStoreItems();

            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Item");
            System.out.println("2. Apply Coupon");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        shoppingCart.addItem(name, qty);
                    } catch (ShoppingCartException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter coupon code: ");
                    String coupon = scanner.nextLine();
                    try {
                        shoppingCart.applyDiscount(coupon);
                    } catch (InvalidCouponCodeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    shoppingCart.checkout();
                    break;

                case 4:
                    System.out.println("Exiting... Have a nice day!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose between 1 and 4.");
            }
        }
    }
}
