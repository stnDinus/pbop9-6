public class TransaksiBorongan<Mobil extends AMobil> extends ATransaksi<Mobil> {
  public TransaksiBorongan(PembeliBorongan pembeli, Karyawan karyawan, Mobil[] mobil) {
    super(pembeli, karyawan, mobil);
  }
}
