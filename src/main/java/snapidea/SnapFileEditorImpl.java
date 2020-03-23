package snapidea;
import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorStateLevel;
import com.intellij.openapi.fileEditor.impl.text.TextEditorState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.UserDataHolderBase;
import com.intellij.openapi.vfs.VirtualFile;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snap.view.ViewUtils;
import snap.web.WebURL;
import snapbuild.app.*;

/**
 *
 */
public class SnapFileEditorImpl extends UserDataHolderBase implements FileEditor {

    private static final String NAME = "Snap File Editor";
    private final VirtualFile _file;

    SnapFileEditorImpl(@NotNull Project project, @NotNull VirtualFile file)
    {
        _file = file;
    }

    @Nullable
    public VirtualFile getFile() { return _file; }

    @Override
    public JComponent getComponent()
    {
        String url = getFile().getUrl();
        WebURL wurl = WebURL.getURL(url);
        EditorPane epane = new EditorPane().open(wurl);
        JComponent comp = (JComponent)epane.getNative();
        ViewUtils.setShowing(epane.getUI().getRootView(), true);
        return comp;
    }

    @Override
    public JComponent getPreferredFocusedComponent()
    {
        return null;
    }

    @NotNull
    @Override
    public String getName()
    {
        return NAME;
    }

    @NotNull
    @Override
    public FileEditorState getState(@NotNull FileEditorStateLevel level)
    {
        return new TextEditorState();
    }

    @Override
    public void setState(@NotNull FileEditorState state)  { }

    @Override
    public boolean isModified()  { return false; }

    @Override
    public boolean isValid()  { return _file.isValid(); }

    @Override
    public void selectNotify()  { }

    @Override
    public void deselectNotify()  { }

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener)  { }

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener)  { }

    @Override
    public BackgroundEditorHighlighter getBackgroundHighlighter()  { return null; }

    @Override
    public FileEditorLocation getCurrentLocation()  { return null; }

    @Override
    public StructureViewBuilder getStructureViewBuilder() {
        return null;
    }

    @Override
    public void dispose()  { }
}