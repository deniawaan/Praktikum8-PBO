/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum8;

/**
 *
 * @author HP
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainSIGMA {
    public static void main(String[] args) {
        Barang barang = new Barang("BRG001", "Beras Premium 5 kg", 100);

        List<TransaksiStok> daftarTransaksi = new ArrayList<>();
        daftarTransaksi.add(new StokMasuk("TRX001", LocalDate.now(), barang, 24));
        daftarTransaksi.add(new StokKeluar("TRX002", LocalDate.now(), barang, 30));
        daftarTransaksi.add(new StokKeluar("TRX003", LocalDate.now(), barang, 200));

        System.out.println("=== SIMULASI TRANSAKSI INVENTARIS SIGMA ===");
        System.out.println("Stok awal: " + barang);

        for (TransaksiStok transaksi : daftarTransaksi) {
            System.out.println("\n" + transaksi.getRingkasan());

            DapatDivalidasi validator = (DapatDivalidasi) transaksi;
            if (!validator.validasi()) {
                System.out.println("Validasi gagal. Transaksi ditolak.");
                System.out.println(((DapatDicatat) transaksi).buatCatatan());
                System.out.println("Stok tidak berubah: " + barang.getStok() + " pcs");
                continue;
            }

            boolean berhasil = transaksi.proses();
            System.out.println(((DapatDicatat) transaksi).buatCatatan());
            System.out.println(berhasil ? "Hasil: transaksi berhasil." : "Hasil: transaksi gagal.");
            System.out.println("Stok sekarang: " + barang.getStok() + " pcs");
        }
    }
}
