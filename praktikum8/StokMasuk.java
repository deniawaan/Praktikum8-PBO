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

public class StokMasuk extends TransaksiStok implements DapatDicatat, DapatDivalidasi {
    public StokMasuk(String idTransaksi, LocalDate tanggal, Barang barang, int jumlah) {
        super(idTransaksi, tanggal, barang, jumlah);
    }

    @Override
    public String getJenisTransaksi() {
        return "Stok Masuk";
    }

    @Override
    public boolean validasi() {
        return jumlah > 0;
    }

    @Override
    public boolean proses() {
        if (!validasi()) {
            return false;
        }
        barang.tambahStok(jumlah);
        return true;
    }

    @Override
    public String buatCatatan() {
        return "Catatan stok masuk: " + barang.getNamaBarang()
                + ", bertambah " + jumlah + " pcs.";
    }
}
