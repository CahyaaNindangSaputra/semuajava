import java.util.ArrayList;
import java.util.Scanner;

public class arraysales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data items
        String[] itemCodes = {"H001", "E002", "M003"};
        String[] itemNames = {"Handphone", "External Memory", "Modem"};
        int[] itemPrices = {400000, 100000, 300000};

        // Data to store transactions
        ArrayList<String> customerNames = new ArrayList<>();
        ArrayList<String> purchasedItems = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Integer> totalPrices = new ArrayList<>();

        String repeat;

        do {
            // Input
            System.out.print("Nama Pelanggan: ");
            String customerName = scanner.nextLine();

            System.out.print("Kode Item: ");
            String itemCode = scanner.nextLine();

            System.out.print("Jumlah: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            // Find item by code
            int index = -1;
            for (int i = 0; i < itemCodes.length; i++) {
                if (itemCodes[i].equalsIgnoreCase(itemCode)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                // Calculate total price
                int price = itemPrices[index];
                int totalPrice = price * quantity;

                // Save transaction
                customerNames.add(customerName);
                purchasedItems.add(itemNames[index]);
                quantities.add(quantity);
                totalPrices.add(totalPrice);
            } else {
                System.out.println("Kode Item tidak valid!");
            }

            // Ask if user wants to add more data
            System.out.print("Apakah mau tambah data lagi? (Y/T): ");
            repeat = scanner.nextLine();
        } while (repeat.equalsIgnoreCase("Y"));

        // Output
        System.out.println("\nTampilan Output:");
        System.out.println("No\tNama Pelanggan\tNama Item\tJumlah\tHarga\t\tTotal Bayar");
        for (int i = 0; i < customerNames.size(); i++) {
            int priceIndex = findItemIndex(itemNames, purchasedItems.get(i));
            System.out.printf("%d\t%s\t\t%s\t\t%d\t%d\t\t%d\n",
                    (i + 1),
                    customerNames.get(i),
                    purchasedItems.get(i),
                    quantities.get(i),
                    itemPrices[priceIndex],
                    totalPrices.get(i));
        }

        scanner.close();
    }

    // Helper method to find the index of an item in the names array
    private static int findItemIndex(String[] itemNames, String itemName) {
        for (int i = 0; i < itemNames.length; i++) {
            if (itemNames[i].equalsIgnoreCase(itemName)) {
                return i;
            }
        }
        return -1; // Return -1 if not found
    }
}
