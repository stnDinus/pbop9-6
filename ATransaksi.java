import java.util.ArrayList;

/**
 * Digunakan saat pembelian untuk membungkus dan meriwayatkan informasi
 * pembelian.
 *
 * Akan menimbulkan error jika memiliki tipe mobil yang berbeda (sesuai
 * instruksi modul PBO).
 *
 * Menggunakan warisan eksklusif dari {@link AMobil} (dan bukan dirinya sendiri)
 * sebagai parameter generik agar tipe mobil-mobil dalam satu objek transaksi
 * terjamin sama. (lihat {@link #ATransaksi(Pembeli, Karyawan, AMobil[])
 * konstruktor})
 */
public abstract class ATransaksi<Mobil extends AMobil> {
  public static ArrayList<ATransaksi> riwayat = new ArrayList<ATransaksi>();

  public Pembeli pembeli;
  public Karyawan karyawan;
  public Mobil[] mobil;

  /**
   * Konstruktor transaksi.
   * - Memanggil {@link #register()} saat inisialisasi.
   * - Memastikan tipe mobil sama (eksklusif subclass dari {@link AMobil} dan
   * bukan dirinya sendiri).
   *
   * @param pembeli  Pembeli transaksi.
   * @param karyawan Karyawan yang bertanggung jawab kepada transaski.
   * @param mobil    Himpunan mobil yang akan dibeli.
   */
  protected ATransaksi(Pembeli pembeli, Karyawan karyawan, Mobil[] mobil) {
    if (mobil.getClass().equals(AMobil[].class))
      throw new IllegalArgumentException();
    this.pembeli = pembeli;
    this.mobil = mobil;
    this.karyawan = karyawan;
    this.register();
  }

  /**
   * - Menambah transaksi ke riwayat.
   * - Menambah transaksi ke himpunan transaksi instansi karyawan.
   */
  private void register() {
    riwayat.add(this);
    karyawan.transaksi.add(this);
  }
}
