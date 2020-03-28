package snapidea;
import com.intellij.lang.Language;

public class SnapLang extends Language {

    private static final String ID = "SNAP";
    public static final SnapLang INSTANCE = new SnapLang();

    protected SnapLang()
    {
        super(ID);
    }
}
