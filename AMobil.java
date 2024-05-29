import java.util.HashMap;

public abstract class AMobil {
  /**
   * Himpunan mobil semua tipe (e.g. {@link MobilSedan}, {@link MobilMinibus} dan
   * {@link MobilBus}).
   *
   * Indeks berupa string dengan format "{@link AMobil#merek} {@link AMobil#nama}"
   */
  public static HashMap<String, AMobil> hmobil = new HashMap<String, AMobil>();
  public static int kursi;
  public String id, merek, nama;
  public long harga;

  public AMobil(String merek, String nama, long harga) {
    this.merek = merek;
    this.nama = nama;
    this.harga = harga;
    id = merek + " " + nama;
    hmobil.put(id, this);
  }
}
