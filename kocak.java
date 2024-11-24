import java.util.Scanner;

public class kocak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] kb = new String[3], np = new String[3];
        int[] jb = new int[3], harga = new int[3], total = new int[3];
        int ji, no = 1;
        char ulang;

do
{
            System.out.print("Jumlah Banyak Inputan [maks 3]: ");
            ji = input.nextInt();

if(ji>3)
{
System.out.print("Cuman Bisa Tiga Dodol");
}
            input.nextLine(); 
            for (int c = 0; c < ji; c++) {
                System.out.print("Masukan Nama Pembeli: ");
                np[c] = input.nextLine();

                System.out.print("Masukan Kode Barang (F001, M001, P001): ");
                kb[c] = input.nextLine();

                System.out.print("Masukan Jumlah Barang: ");
                jb[c] = input.nextInt();

                input.nextLine(); 

                // harga perbarang
                switch (kb[c]) {
                    case "F001":
                        harga[c] = 50000;
                        break;
                    case "M001":
                        harga[c] = 80000;
                        break;
                    case "P001":
                        harga[c] = 300000;
                        break;
                    default:
                        System.out.println("Kode barang tidak valid! Menggunakan harga default 0.");
                        harga[c] = 0;
                        break;
                }

                total[c] = jb[c] * harga[c];
            }

            // Display data
            System.out.println("===================================================================================================================");
            System.out.println("No   Nama Pembeli         Kode Barang     Nama Barang       Jumlah       Harga        Total Bayar");
            System.out.println("===================================================================================================================");
            for (int c = 0; c < ji; c++) {
                String namaBarang;
                switch (kb[c]) {
                    case "F001":
                        namaBarang = "Flashdisk";
                        break;
                    case "M001":
                        namaBarang = "Modem";
                        break;
                    case "P001":
                        namaBarang = "Printer";
                        break;
                    default:
                        namaBarang = "Tidak Diketahui";
                        break;
                }
                System.out.printf("%-5d%-20s%-15s%-15s%-10d%-12d%-12d%n", 
                                          no++, np[c], kb[c], namaBarang, jb[c], harga[c], total[c]);
            }
            System.out.printf("Ada Lagi? (y/t) "); 
            ulang=input.next().charAt(0);
            }while(ulang=='y' || ulang=='Y');
        input.close();
    }
}