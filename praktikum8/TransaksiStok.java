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

public abstract class TransaksiStok {
    private final String idTransaksi;
    private final LocalDate tanggal;
    protected final Barang barang;
    protected final int jumlah;

    public TransaksiStok(String idTransaksi, LocalDate tanggal, Barang barang, int jumlah) {
        if (idTransaksi == null || idTransaksi.trim().isEmpty()) {
            throw new IllegalArgumentException("ID transaksi tidak boleh kosong.");
        }
        if (tanggal == null) {
            throw new IllegalArgumentException("Tanggal transaksi tidak boleh kosong.");
        }
        if (barang == null) {
            throw new IllegalArgumentException("Objek barang tidak boleh null.");
        }

        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public abstract String getJenisTransaksi();

    public abstract boolean proses();

    public String getRingkasan() {
        return "ID: " + idTransaksi
                + " | Tanggal: " + tanggal
                + " | Jenis: " + getJenisTransaksi()
                + " | Barang: " + barang.getNamaBarang()
                + " | Jumlah: " + jumlah + " pcs";
    }
}

