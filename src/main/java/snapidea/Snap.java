package snapidea;
import com.intellij.lang.Language;

public class Snap extends Language {

    private static final String ID = "SNAP";
    static final Snap INSTANCE = new Snap();

    protected Snap()
    {
        super(ID);
    }
}