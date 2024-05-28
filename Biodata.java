public class Biodata {
  String nama, alamat;

  public Biodata(String nama, String alamat) {
    this.nama = nama;
    this.alamat = alamat;
  }

  /**
   * Cetak rincian sebuah instansi/objek biodata.
   */
  public void cetak() {
    System.out.printf("Nama:\t%s\n", nama);
    System.out.printf("Alamat:\t%s\n", alamat);
  }
}
