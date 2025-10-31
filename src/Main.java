import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Kelas HitungDiskon digunakan untuk menghitung total belanja
 * setelah menerapkan diskon dan cashback berdasarkan jumlah pembelian.
 *
 * <p>Program ini akan meminta input total belanja dari pengguna, lalu
 * menghitung diskon sesuai kategori nominal pembelian, serta memberikan
 * cashback jika memenuhi syarat tertentu.</p>
 *
 * @author AAD
 * @version 1.0
 * @since 2025-10-31
 */
public class HitungDiskon {

    /** Diskon 20% untuk pembelian ≥ Rp500.000 */
    private static final double DISKON_20 = 0.20;
    /** Diskon 10% untuk pembelian ≥ Rp250.000 */
    private static final double DISKON_10 = 0.10;
    /** Diskon 5% untuk pembelian ≥ Rp100.000 */
    private static final double DISKON_5 = 0.05;
    /** Cashback 5% untuk total bayar > Rp600.000 */
    private static final double CASHBACK = 0.05;

    /**
     * Metode utama program yang dijalankan pertama kali.
     * <p>Berfungsi untuk membaca input pengguna, menghitung diskon,
     * dan menampilkan hasil struk pembayaran.</p>
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
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

    /**
     * Menentukan persentase diskon berdasarkan total belanja.
     *
     * @param total jumlah total belanja pengguna
     * @return nilai diskon dalam bentuk desimal (contoh: 0.1 untuk 10%)
     */
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

    /**
     * Menghitung total potongan harga berdasarkan diskon.
     *
     * @param total  total belanja sebelum diskon
     * @param diskon persentase diskon yang berlaku
     * @return jumlah diskon dalam satuan rupiah
     */
    private static double hitungDiskon(double total, double diskon) {
        return total * diskon;
    }

    /**
     * Menghitung bonus cashback bila total bayar memenuhi syarat.
     *
     * @param totalBayar jumlah total pembayaran setelah diskon
     * @return nilai cashback dalam satuan rupiah (0 jika tidak memenuhi)
     */
    private static double hitungCashback(double totalBayar) {
        if (totalBayar > 600000) {
            return totalBayar * CASHBACK;
        }
        return 0;
    }

    /**
     * Menampilkan struk pembayaran akhir ke layar.
     *
     * @param formatRupiah   formatter untuk menampilkan angka dalam format rupiah
     * @param totalBelanja   nilai total belanja sebelum diskon
     * @param diskon         persentase diskon yang diberikan
     * @param jumlahDiskon   nominal potongan diskon
     * @param totalBayar     total bayar setelah diskon
     * @param cashback       nilai cashback (jika ada)
     */
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