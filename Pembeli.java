import java.util.ArrayList;

public abstract class Pembeli {
  public int id;
  public Biodata biodata;

  public Pembeli(int id, String nama, String alamat) {
    this.id = id;
    this.biodata = new Biodata(nama, alamat);
  }
}
