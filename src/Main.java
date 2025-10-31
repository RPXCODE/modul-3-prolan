import java.text.DecimalFormat;
import java.util.Scanner;
//iqodhul himam
/**
 * Kelas HitungDiskon digunakan untuk menghitung total belanja
 * setelah menerapkan diskon dan cashback berdasarkan jumlah pembelian.
 *
 * <p>Program ini sudah di-refactor agar lebih modular, mudah dibaca, dan
 * aman terhadap input yang salah.</p>
 *
 * <p>Fitur program:
 * <ul>
 *   <li>Validasi input belanja agar positif</li>
 *   <li>Menentukan besaran diskon berdasarkan total belanja</li>
 *   <li>Menghitung total pembayaran setelah diskon</li>
 *   <li>Memberikan cashback jika total bayar > Rp600.000</li>
 *   <li>Mencetak struk pembayaran dengan format rupiah</li>
 * </ul>
 * </p>
 *
 * @author AAD
 * @version 1.1
 * @since 2025-10-31
 */
class HitungDiskon {

    /** Diskon 20% untuk pembelian ≥ Rp500.000 */
    private static final double DISKON_20 = 0.20;
    /** Diskon 10% untuk pembelian ≥ Rp250.000 */
    private static final double DISKON_10 = 0.10;
    /** Diskon 5% untuk pembelian ≥ Rp100.000 */
    private static final double DISKON_5 = 0.05;

    /** Cashback 5% untuk total bayar > Rp600.000 */
    private static final double CASHBACK = 0.05;

    /** Formatter rupiah global untuk mencetak nominal */
    private static final DecimalFormat formatRupiah = new DecimalFormat("Rp #,###");

    /**
     * Metode utama program.
     * <p>Membaca input total belanja, menghitung diskon, cashback,
     * dan mencetak struk pembayaran.</p>
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== PROGRAM MENGHITUNG DISKON BELANJA ===");
        System.out.print("Masukkan total belanja (Rp): ");

        double totalBelanja = bacaInputAngka(input);

        double diskon = tentukanDiskon(totalBelanja);
        double jumlahDiskon = hitungDiskon(totalBelanja, diskon);
        double totalBayar = totalBelanja - jumlahDiskon;
        double cashback = hitungCashback(totalBayar);

        cetakStruk(totalBelanja, diskon, jumlahDiskon, totalBayar, cashback);
    }

    /**
     * Membaca input dari pengguna dan memastikan nilai yang dimasukkan positif.
     *
     * @param input Scanner untuk membaca input pengguna
     * @return nilai input positif dalam bentuk double
     */
    private static double bacaInputAngka(Scanner input) {
        double nilai;
        while (true) {
            try {
                nilai = Double.parseDouble(input.nextLine());
                if (nilai < 0) {
                    System.out.print("Masukkan nilai positif: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid! Masukkan angka: ");
            }
        }
        return nilai;
    }

    /**
     * Menentukan besaran diskon berdasarkan total belanja.
     *
     * @param total total belanja sebelum diskon
     * @return nilai diskon dalam bentuk desimal (misal 0.1 untuk 10%)
     */
    private static double tentukanDiskon(double total) {
        if (total >= 500_000) return DISKON_20;
        else if (total >= 250_000) return DISKON_10;
        else if (total >= 100_000) return DISKON_5;
        else return 0;
    }

    /**
     * Menghitung nominal diskon.
     *
     * @param total total belanja sebelum diskon
     * @param diskon persentase diskon
     * @return jumlah nominal diskon dalam satuan rupiah
     */
    private static double hitungDiskon(double total, double diskon) {
        return total * diskon;
    }

    /**
     * Menghitung nominal cashback jika total bayar melebihi Rp600.000.
     *
     * @param totalBayar total pembayaran setelah diskon
     * @return nilai cashback dalam satuan rupiah, 0 jika tidak memenuhi syarat
     */
    private static double hitungCashback(double totalBayar) {
        return (totalBayar > 600_000) ? totalBayar * CASHBACK : 0;
    }

    /**
     * Mencetak struk pembayaran ke layar.
     *
     * @param totalBelanja total belanja sebelum diskon
     * @param diskon persentase diskon
     * @param jumlahDiskon nominal potongan diskon
     * @param totalBayar total pembayaran setelah diskon
     * @param cashback nominal cashback jika ada
     */
    private static void cetakStruk(double totalBelanja, double diskon, double jumlahDiskon,
                                   double totalBayar, double cashback) {

        System.out.println("\n=== STRUK PEMBAYARAN ===");
        System.out.println("Total Belanja : " + formatRupiah.format(totalBelanja));
        System.out.println("Diskon (" + (diskon * 100) + "%) : " + formatRupiah.format(jumlahDiskon));
        System.out.println("Total Bayar   : " + formatRupiah.format(totalBayar));

        if (cashback > 0)
            System.out.println("Bonus Cashback 5% : " + formatRupiah.format(cashback));

        System.out.println("==========================");
    }
}
