package snapidea;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class SnapFileType extends LanguageFileType {

    public static final SnapFileType INSTANCE = new SnapFileType();

    protected SnapFileType()
    {
        super(Snap.INSTANCE);
    }

    @NotNull
    @Override
    public String getName()
    {
        return "SNAP";
    }

    @NotNull
    @Override
    public String getDescription()
    {
        return "SnapKit UI File";
    }

    @NotNull
    @Override
    public String getDefaultExtension()
    {
        return "snp";
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
