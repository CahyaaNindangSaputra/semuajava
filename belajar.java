import java.util.Scanner;

public class belajar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Deklarasi array untuk menyimpan data
        String[] np = new String[3], kd = new String[3], namabarang = new String[3];
        int[] jml = new int[3], harga = new int[3], total = new int[3];

        int ji, no = 1;
        char ulang;

        do {
            // Input jumlah data
            System.out.print("Masukkan jumlah data yang ingin diinput (maksimal 3): ");
            ji = input.nextInt();
            input.nextLine(); // Konsumsi newline dari nextInt()

            if (ji > 3) {
                System.out.println("Jumlah data melebihi batas maksimal (3). Program dihentikan.");
                break; // Keluar dari perulangan jika jumlah melebihi batas
            }

            // Input data
            for (int c = 0; c < ji; c++) {
                System.out.print("Nama Pembeli: ");
                np[c] = input.nextLine();

                System.out.print("Kode Item (H001, E002, M003): ");
                kd[c] = input.nextLine();

                System.out.print("Jumlah: ");
                jml[c] = input.nextInt();
                input.nextLine(); // Konsumsi newline dari nextInt()

                // Menentukan nama barang dan harga berdasarkan kode
                switch (kd[c]) {
                    case "H001":
                        harga[c] = 400000;
                        namabarang[c] = "Handphone";
                        break;
                    case "E002":
                        harga[c] = 100000;
                        namabarang[c] = "External Memory";
                        break;
                    case "M003":
                        harga[c] = 300000;
                        namabarang[c] = "Modem";
                        break;
                    default:
                        harga[c] = 0;
                        namabarang[c] = "Tidak Diketahui";
                        System.out.println("Kode barang tidak valid! Menggunakan harga default 0.");
                        break;
                }

                // Hitung total bayar
                total[c] = jml[c] * harga[c];
            }

            // Tampilkan semua data
            System.out.println("=====================================================================");
            System.out.println("No   Nama Pembeli       Nama Barang            Jumlah    Harga       Total Bayar");
            System.out.println("=====================================================================");

            for (int c = 0; c < ji; c++) {
                System.out.printf("%-5d%-20s%-20s%-10d%-12d%-12d%n",
                        no++, np[c], namabarang[c], jml[c], harga[c], total[c]);
            }

            // Tanyakan apakah ingin menambah data lagi
            System.out.print("Ada Lagi? (y/t): ");
            ulang = input.next().charAt(0);
            input.nextLine(); // Konsumsi newline dari nextChar
        } while (ulang == 'y' || ulang == 't');

        System.out.println("Program selesai.");
        input.close();
    }
}
