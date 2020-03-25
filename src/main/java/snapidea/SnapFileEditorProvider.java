package snapidea;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.fileEditor.FileEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class SnapFileEditorProvider implements FileEditorProvider {

    private static final String EDITOR_TYPE_ID = "snap";

    @Override
    public boolean accept(@NotNull Project project, @NotNull VirtualFile file)
    {
        return true;
    }

    @NotNull
    @Override
    public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile file)
    {
        return new SnapFileEditor(project, file);
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
        return FileEditorPolicy.HIDE_DEFAULT_EDITOR;
    }
}
