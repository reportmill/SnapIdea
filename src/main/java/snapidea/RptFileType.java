package snapidea;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class RptFileType extends LanguageFileType {

    public static final RptFileType INSTANCE = new RptFileType();

    protected RptFileType()
    {
        super(RptLang.INSTANCE);
    }

    @NotNull
    @Override
    public String getName()
    {
        return "RPT";
    }

    @NotNull
    @Override
    public String getDescription()
    {
        return "ReportMill template file";
    }

    @NotNull
    @Override
    public String getDefaultExtension()
    {
        return "rpt";
    }

    @Nullable
    @Override
    public Icon getIcon()
    {
        return null;
    }

    @Nullable
    @Override
    public String getCharset(@NotNull VirtualFile file, @NotNull byte[] content)
    {
        return super.getCharset(file, content);
    }
}
