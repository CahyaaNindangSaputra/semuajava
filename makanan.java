import java.util.Scanner;

public class makanan {
    public static void main(String[] args) {
        // Variabel
        String[] makanan = new String[99];
        String[] nama = new String[99];
        String[] namamakanan = new String[99];
        int[] jumlahPesanan = new int[99];
        int harga = 0, total, no = 1;
        String tambahMakanan;

        // Scanner untuk input
        Scanner input = new Scanner(System.in);

        // Loop untuk menambahkan makanan
        do {
            // Input nama pelanggan
            System.out.print("Nama pelanggan: ");
            nama[no] = input.nextLine();

            total = 0; // Reset total untuk setiap pelanggan

            // Loop untuk menambah beberapa makanan
            int itemNo = 1;  // untuk menandai urutan makanan
            do {
                // Pilihan menu makanan
                System.out.println("Pilih menu makanan " + itemNo + ":");
                System.out.println("1. Nasi Padang - Rp20,000");
                System.out.println("2. Soto Ayam - Rp15,000");
                System.out.println("3. Mie Goreng - Rp10,000");
                System.out.print("Masukkan pilihan (1/2/3): ");
                makanan[itemNo] = input.nextLine();

                // Switch untuk menetapkan harga dan nama makanan
                switch (makanan[itemNo]) {
                    case "1":
                        harga = 20000;
                        namamakanan[itemNo] = "Nasi Padang";
                        break;
                    case "2":
                        harga = 15000;
                        namamakanan[itemNo] = "Soto Ayam";
                        break;
                    case "3":
                        harga = 10000;
                        namamakanan[itemNo] = "Mie Goreng";
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                        return; // Keluar dari program jika pilihan tidak valid
                }

                // Input jumlah pesanan
                System.out.print("Jumlah pesanan " + itemNo + ": ");
                jumlahPesanan[itemNo] = input.nextInt();
                input.nextLine(); // Membersihkan newline dari input sebelumnya

                // Menghitung total pesanan untuk item ini
                total += jumlahPesanan[itemNo] * harga;

                // Menanyakan apakah ingin menambahkan makanan lagi
                System.out.print("Apakah Anda ingin menambahkan makanan lagi? (yes/no): ");
                tambahMakanan = input.nextLine();

                itemNo++; // Menambah nomor item makanan
            } while (tambahMakanan.equalsIgnoreCase("yes"));

            // Menampilkan hasil pesanan
            System.out.println("=======================================================");
            System.out.println("No   Nama pelanggan       Nama Pesanan     Jumlah    Total");
            System.out.println("=======================================================");

            for (int i = 1; i < itemNo; i++) {
                System.out.printf("%-5d%-20s%-15s%-10d%-12d%n", i, nama[no], namamakanan[i], jumlahPesanan[i], jumlahPesanan[i] * harga);
            }

            System.out.println("Total keseluruhan: Rp " + total);

            no++; // Menambah nomor pelanggan

            // Menanyakan apakah ingin menambahkan pelanggan lain
            System.out.print("Apakah ada pelanggan lain? (yes/no): ");
            tambahMakanan = input.nextLine();

        } while (tambahMakanan.equalsIgnoreCase("yes"));

        System.out.println("Terima kasih telah memesan!");
        input.close();
    }
}
