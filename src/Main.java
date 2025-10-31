import java.text.DecimalFormat;
import java.util.Scanner;

class HitungDiskon {
    // Konstanta batas diskon
    private static final double DISKON_20 = 0.20;
    private static final double DISKON_10 = 0.10;
    private static final double DISKON_5 = 0.05;
    private static final double CASHBACK = 0.05;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat formatRupiah = new DecimalFormat("Rp #,###");

        System.out.println("=== PROGRAM MENGHITUNG DISKON BELANJA ===");
        System.out.print("Masukkan total belanja (Rp): ");
        double totalBelanja = input.nextDouble();

        double diskon = tentukanDiskon(totalBelanja);
        double jumlahDiskon = hitungDiskon(totalBelanja, diskon);
        double totalBayar = totalBelanja - jumlahDiskon;
        double cashback = hitungCashback(totalBayar);

        cetakStruk(formatRupiah, totalBelanja, diskon, jumlahDiskon, totalBayar, cashback);
    }

    // Menentukan besaran diskon berdasarkan total belanja
    private static double tentukanDiskon(double total) {
        if (total >= 500000) {
            return DISKON_20;
        } else if (total >= 250000) {
            return DISKON_10;
        } else if (total >= 100000) {
            return DISKON_5;
        }
        return 0;
    }

    // Menghitung jumlah diskon
    private static double hitungDiskon(double total, double diskon) {
        return total * diskon;
    }

    // Menghitung cashback bila memenuhi syarat
    private static double hitungCashback(double totalBayar) {
        if (totalBayar > 600000) {
            return totalBayar * CASHBACK;
        }
        return 0;
    }

    // Mencetak struk pembayaran
    private static void cetakStruk(DecimalFormat formatRupiah, double totalBelanja, double diskon,
                                   double jumlahDiskon, double totalBayar, double cashback) {

        System.out.println("\n=== STRUK PEMBAYARAN ===");
        System.out.println("Total Belanja : " + formatRupiah.format(totalBelanja));
        System.out.println("Diskon (" + (diskon * 100) + "%) : " + formatRupiah.format(jumlahDiskon));
        System.out.println("Total Bayar   : " + formatRupiah.format(totalBayar));

        if (cashback > 0) {
            System.out.println("Bonus Cashback 5% : " + formatRupiah.format(cashback));
        }

        System.out.println("==========================");
    }
}
