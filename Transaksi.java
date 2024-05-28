import java.util.ArrayList;

/**
 * Digunakan saat pembelian untuk membungkus dan meriwayatkan informasi
 * pembelian.
 *
 * Akan menimbulkan error jika memiliki tipe mobil yang berbeda (sesuai
 * instruksi modul PBO).
 *
 * Menggunakan warisan dari {@link AMobil} sebagai parameter generik agar tipe
 * mobil-mobil dalam satu objek transaksi terjamin sama.
 */
public class Transaksi<Mobil extends AMobil> {
  public static ArrayList<Transaksi> riwayat = new ArrayList<Transaksi>();

  public Pembeli pembeli;
  public Karyawan karyawan;
  public Mobil[] mobil;

  /**
   * Konstruktor transaksi.
   * Juga memanggil {@link #register()} saat inisialisasi.
   *
   * @param pembeli  Pembeli transaksi.
   * @param karyawan Karyawan yang bertanggung jawab kepada transaski.
   * @param mobil    Himpunan mobil yang akan dibeli.
   */
  public Transaksi(Pembeli pembeli, Karyawan karyawan, Mobil[] mobil) {
    this.pembeli = pembeli;
    this.mobil = mobil;
    this.karyawan = karyawan;
    this.register();
  }

  /**
   * - Menambah transaksi ke riwayat.
   * - Menambah transaksi ke himpunan transaksi instansi karyawan.
   */
  public void register() {
    riwayat.add(this);
    karyawan.transaksi.add(this);
  }
}
