package snapidea;
import com.intellij.lang.Language;

public class RptLang extends Language {

    private static final String ID = "RPT";
    public static final RptLang INSTANCE = new RptLang();

    protected RptLang()
    {
        super(ID);
    }
}
