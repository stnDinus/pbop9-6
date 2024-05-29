import java.text.NumberFormat;
import java.util.Locale;

public abstract class Lib {
  private static Locale idloc = Locale.of("id");
  public static NumberFormat cf = NumberFormat.getCurrencyInstance(idloc);
}
