import java.lang.reflect.Array;

public class TransaksiIndividu<Mobil extends AMobil> extends ATransaksi<Mobil> {
  public TransaksiIndividu(PembeliIndividu pembeli, Karyawan karyawan, Mobil mobil) {
    super(pembeli, karyawan,
        // Karena java tidak dapat membuat array generik
        // https://stackoverflow.com/questions/529085/how-can-i-create-a-generic-array-in-java
        (Mobil[]) Array.newInstance(mobil.getClass(), 1));
    super.mobil[0] = mobil;
  }
}
