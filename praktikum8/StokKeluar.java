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

public class StokKeluar extends TransaksiStok implements DapatDicatat, DapatDivalidasi {
    public StokKeluar(String idTransaksi, LocalDate tanggal, Barang barang, int jumlah) {
        super(idTransaksi, tanggal, barang, jumlah);
    }

    @Override
    public String getJenisTransaksi() {
        return "Stok Keluar";
    }

    @Override
    public boolean validasi() {
        return jumlah > 0 && jumlah <= barang.getStok();
    }

    @Override
    public boolean proses() {
        if (!validasi()) {
            return false;
        }
        return barang.kurangiStok(jumlah);
    }

    @Override
    public String buatCatatan() {
        return "Catatan stok keluar: " + barang.getNamaBarang()
                + ", diminta keluar " + jumlah + " pcs.";
    }
}
