import java.util.ArrayList;

public class Karyawan {
  public static ArrayList<Karyawan> karyawan = new ArrayList<Karyawan>();
  public int id;
  protected Biodata biodata;
  /**
   * Transaksi yang merupakan tanggung jawab Karyawan.
   */
  public ArrayList<ATransaksi<AMobil>> transaksi = new ArrayList<ATransaksi<AMobil>>();

  public Karyawan(int id, String nama, String alamat) {
    this.id = id;
    this.biodata = new Biodata(nama, alamat);
    karyawan.add(this);
  }

  /**
   * Tambah harga sebuah mobil di {@link AMobil#hmobil}.
   *
   * @param idMobil Indeks mobil (lihat {@link AMobil#hmobil}).
   * @param harga   Nilai yang akan ditambahkan ke harga mobil.
   */
  public void thMobil(String idMobil, long harga) {
    AMobil mobilBaru = AMobil.hmobil.get(idMobil);
    mobilBaru.harga += harga;
    AMobil.hmobil.replace(idMobil, mobilBaru);
  }

  /**
   * Menghitung total untung karyawan dari {@link #transaksi semua transaksi} yang
   * terlibat oleh instansi/objek karyawan ini.
   */
  public long getUntung() {
    long untung = 0;
    for (ATransaksi<AMobil> t : transaksi) {
      for (AMobil m : t.mobil) {
        untung += m.harga * 10 / 100;
      }
    }
    return untung;
  }
}
