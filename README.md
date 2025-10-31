# 💰 Program Menghitung Diskon Belanja

Program Java sederhana untuk menghitung **total bayar setelah diskon dan cashback** berdasarkan jumlah pembelian.

---

## 📦 Deskripsi

Aplikasi ini menerima input **total belanja (dalam rupiah)**, lalu menghitung:
- Diskon berdasarkan nominal pembelian
- Total bayar akhir setelah diskon
- Bonus cashback 5% jika memenuhi syarat

Dilengkapi dengan **JavaDoc** agar mudah dipahami dan dikembangkan.

---

## 🧮 Aturan Diskon
| Total Belanja | Diskon |
|----------------|--------|
| ≥ Rp500.000 | 20% |
| ≥ Rp250.000 | 10% |
| ≥ Rp100.000 | 5% |
| < Rp100.000 | Tidak ada diskon |

💸 **Bonus:** Cashback 5% jika total bayar > Rp600.000

---

## 🚀 Cara Menjalankan
1. Kompilasi program:
   ```bash
   javac HitungDiskon.java
