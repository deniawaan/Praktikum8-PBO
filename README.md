## Penjelasan kode

### 1. `Barang.java`

Merepresentasikan barang inventaris dengan atribut kode barang, nama barang, dan jumlah stok. Metode `tambahStok()` menambah stok, sedangkan `kurangiStok()` mengurangi stok hanya jika jumlahnya valid dan stok mencukupi. Atribut dibuat `private` untuk menerapkan enkapsulasi.

### 2. `TransaksiStok.java`

Merupakan **abstract class** yang menjadi kerangka dasar transaksi stok. Kelas ini menyimpan informasi umum transaksi, yaitu ID, tanggal, barang, dan jumlah. Metode `getJenisTransaksi()` dan `proses()` bersifat abstrak sehingga subclass harus memberikan implementasi sesuai jenis transaksi.

### 3. `DapatDicatat.java` dan `DapatDivalidasi.java`

Kedua interface mendefinisikan kontrak perilaku:

- `DapatDicatat` mewajibkan implementasi metode `buatCatatan()` untuk menghasilkan catatan transaksi.
- `DapatDivalidasi` mewajibkan implementasi metode `validasi()` untuk memeriksa apakah transaksi layak diproses.

### 4. `StokMasuk.java`

Subclass `TransaksiStok` yang mengimplementasikan kedua interface. Metode `proses()` menambahkan jumlah barang ke stok, sementara `validasi()` memastikan jumlah yang masuk lebih dari nol.

### 5. `StokKeluar.java`

Subclass `TransaksiStok` yang juga mengimplementasikan kedua interface. Transaksi hanya valid jika jumlahnya lebih dari nol dan tidak melebihi stok tersedia. Jika stok tidak mencukupi, transaksi ditolak dan stok tidak berubah.

### 6. `MainSIGMA.java`

Kelas utama untuk menjalankan simulasi. Beberapa objek `StokMasuk` dan `StokKeluar` dimasukkan ke dalam satu `List<TransaksiStok>`. Perulangan memanggil metode melalui referensi kelas induk sehingga memperlihatkan **runtime polymorphism / dynamic binding**: metode dari subclass yang sesuai akan dijalankan.

## Konsep PBO yang diterapkan

1. **Method overriding dan polymorphism:** `StokMasuk` dan `StokKeluar` meng-override `getJenisTransaksi()` dan `proses()`. Pemanggilan `proses()` melalui variabel bertipe `TransaksiStok` menjalankan implementasi sesuai objek sebenarnya.
2. **Abstract class dan abstract method:** `TransaksiStok` tidak dapat dibuat objeknya secara langsung dan menjadi kerangka bagi kedua jenis transaksi.
3. **Multiple interface implementation:** `StokMasuk` dan `StokKeluar` menggunakan `implements DapatDicatat, DapatDivalidasi` untuk memenuhi dua kontrak sekaligus.
4. **Encapsulation:** atribut pada `Barang` disimpan sebagai `private` dan diakses melalui metode.
5. **Collection:** `ArrayList` menyimpan berbagai jenis transaksi dalam satu daftar.

## Gambaran hasil program

Dengan stok awal 100 pcs, contoh simulasi melakukan transaksi berikut:

1. Stok masuk 24 pcs: transaksi berhasil, stok menjadi 124 pcs.
2. Stok keluar 30 pcs: transaksi berhasil, stok menjadi 94 pcs.
3. Stok keluar 200 pcs: transaksi ditolak karena stok tidak mencukupi; stok tetap 94 pcs.

Tanggal transaksi menggunakan tanggal saat program dijalankan.
