package snapidea;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.fileEditor.FileEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import reportmill.app.Welcome;

public class RptFileEditorProvider implements FileEditorProvider {

    private static final String EDITOR_TYPE_ID = "rpt";

    @Override
    public boolean accept(@NotNull Project project, @NotNull VirtualFile file)
    {
        String ext = file!=null ? file.getExtension() : null;
        return ext!=null && ext.equals("rpt");
    }

    @NotNull
    @Override
    public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile file)
    {
        Welcome.getShared();
        return new RptFileEditor(project, file);
    }

    @NotNull
    @Override
    public String getEditorTypeId()
    {
        return EDITOR_TYPE_ID;
    }

    @NotNull
    @Override
    public FileEditorPolicy getPolicy()
    {
        //return FileEditorPolicy.HIDE_DEFAULT_EDITOR;
        return FileEditorPolicy.PLACE_BEFORE_DEFAULT_EDITOR;
    }
}
