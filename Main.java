public class Main {
  public static void main(String[] args) {
    // Inisialisasi data {
    MobilSedan ms1 = new MobilSedan("Toyota", "Camry", 850_000_000);
    MobilSedan ms2 = new MobilSedan("Honda", "Accord", 787_000_000);
    MobilSedan ms3 = new MobilSedan("Mercedes Benz", "S-Class S 450 4Matic Luxury", 3_280_000_000L);

    MobilMinibus mm1 = new MobilMinibus("Hyundai", "H-1", 573_500_500);
    MobilMinibus mm2 = new MobilMinibus("Mitsubishi", "Xpander", 322_900_000);
    MobilMinibus mm3 = new MobilMinibus("Toyota", "HiAce", 545_800_000);

    MobilBus mb1 = new MobilBus("Mercedes Benz", "Sprinter 415 CDI A3", 1_425_000_000);
    MobilBus mb2 = new MobilBus("Hino", "Durto Bus 110 SDBL", 470_000_000);
    MobilBus mb3 = new MobilBus("Isuzu", "Elf NLR 55B", 315_000_000);

    Karyawan k1 = new Karyawan(1, "Steven",
        "Jl. Imam Bonjol No.207, Pendrikan Kidul, Kec. Semarang Tengah, Kota Semarang, Jawa Tengah 50131");
    Karyawan k2 = new Karyawan(2, "Satria",
        "Jl. Pemuda No.160, Sekayu, Kec. Semarang Tengah, Kota Semarang, Jawa Tengah 50132");
    Karyawan k3 = new Karyawan(3, "Nugraha",
        "Jl. Yudistira 1, Pendrikan Kidul, Kec. Semarang Tengah, Kota Semarang, Jawa Tengah 50131");

    PembeliIndividu pi1 = new PembeliIndividu(1, "Parjo",
        "Jl. Nakula Raya No.31, Pendrikan Kidul, Kec. Semarang Tengah, Kota Semarang, Jawa Tengah 50131");
    PembeliIndividu pi2 = new PembeliIndividu(2, "Ararya",
        "Jl. Pemuda No.150, Sekayu, Kec. Semarang Tengah, Kota Semarang, Jawa Tengah 50132");
    PembeliIndividu pi3 = new PembeliIndividu(3, "Bayu",
        "Jl. Nasional 14, Banaran, Sendangadi, Kec. Mlati, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55285");

    PembeliBorongan pb1 = new PembeliBorongan(1, "Arik",
        "Jl. Baru Mulungan 18, Gilingan, Sendangadi, Kec. Mlati, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55285");
    PembeliBorongan pb2 = new PembeliBorongan(2, "Prama",
        "Jl. Gito Gati, Grojogan, Pandowoharjo, Kec. Ngaglik, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55512");
    PembeliBorongan pb3 = new PembeliBorongan(3, "Davka",
        "Jl. Griya Taman Asri 8, Grojogan, Pandowoharjo, Kec. Sleman, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55512");
    // }

    new TransaksiBorongan(pb1, k1, new MobilSedan[] { ms1, ms2 });
    new TransaksiIndividu(pi1, k1, ms3);
    new TransaksiBorongan(pb2, k1, new MobilMinibus[] { mm1, mm2, mm3 });
    new TransaksiBorongan(pb3, k2, new MobilBus[] { mb1, mb3 });
    new TransaksiIndividu(pi2, k3, mb3);
    new TransaksiIndividu(pi3, k3, mb2);

    System.out.println("# DAFTAR TRANSAKSI");
    for (var t : ATransaksi.riwayat) {
      var tb = t.pembeli.biodata;

      System.out.println("\n## Rincian Transaksi");
      System.out.println("- ID Karyawan:\t" + t.karyawan.id);
      System.out.println("- Total:\t" + Lib.cf.format(t.getTotal()));
      System.out.println("\n### Pembeli");
      System.out.println("- Nama:\t\t" + tb.nama);
      System.out.println("- Alamat:\t" + tb.alamat);
      System.out.println("\n### Mobil Terjual");
      for (var m : t.mobil) {
        System.out.println("- " + m.id);
        System.out.println("\t- Merek:\t" + m.merek);
        System.out.println("\t- Nama:\t\t" + m.nama);
        System.out.println("\t- Harga:\t" + Lib.cf.format(m.harga));
      }
    }

    System.out.println("\n# DAFTAR KARYAWAN");
    for (var k : Karyawan.karyawan) {
      var b = k.biodata;
      System.out.println("\n## Biodata");
      System.out.println("- Nama:\t\t" + b.nama);
      System.out.println("- Alamat:\t" + b.alamat);
      System.out.println("- Transaksi:\t" + k.transaksi.size());
      System.out.println("- Gaji:\t\t" + Lib.cf.format(k.getUntung()));
    }
  }
}
