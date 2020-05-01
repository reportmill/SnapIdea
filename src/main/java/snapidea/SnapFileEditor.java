package snapidea;
import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.*;
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
 * An Idea FileEditor implementation for SnapBuilder.
 */
public class SnapFileEditor extends UserDataHolderBase implements FileEditor {

    // The File
    private final VirtualFile _file;

    // The SnapEditorPane
    private SnapEditorPane _epane;

    // The component
    private JComponent  _comp;

    // The Document
    private Document  _doc;

    // Constants
    private static final String NAME = "Snap File Editor";

    public SnapFileEditor(Project project, VirtualFile file)
    {
        _file = file;
    }

    @Nullable
    public VirtualFile getFile() { return _file; }

    /**
     * Returns a SnapBuilder EditorPane.
     */
    public SnapEditorPane getEditorPane()
    {
        if (_epane!=null) return _epane;

        // Get URL
        String path = getFile().getPath();
        if (!path.startsWith("/")) path = '/' + path;
        WebURL wurl = WebURL.getURL(path);

        // Create EditorPane for URL
        _epane = new SnapEditorPane(this);
        _epane.open(wurl);
        return _epane;
    }

    @Override
    public JComponent getComponent()
    {
        // If already set, just return
        if (_comp!=null) return _comp;

        // Create editor and get JComponent
        EditorPane epane = getEditorPane();
        JComponent comp = (JComponent)epane.getNative();
        ViewUtils.setShowing(epane.getUI().getRootView(), true);
        return _comp = comp;
    }

    @Override
    public JComponent getPreferredFocusedComponent()
    {
        return _comp;
    }

    @NotNull
    @Override
    public String getName()
    {
        return NAME;
    }

    @NotNull
    @Override
    public FileEditorState getState(FileEditorStateLevel level)
    {
        return new TextEditorState();
    }

    @Override
    public void setState(FileEditorState state)
    {
    }

    @Override
    public boolean isModified()
    {
        boolean mod = getEditorPane().getEditor().getUndoer().hasUndos();
        return mod;
    }

    @Override
    public boolean isValid()
    {
        return _file.isValid();
    }

    @Override
    public void selectNotify()  { }

    @Override
    public void deselectNotify()  { }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener)  { }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener)  { }

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

    /**
     * Returns the document.
     */
    public Document getDoc()
    {
        if (_doc!=null) return _doc;
        Document doc = FileDocumentManager.getInstance().getDocument(_file);
        return _doc = doc;
    }

    public String getUrl()
    {
        return getFile().getUrl();
    }

    /**
     * Saves the document.
     */
    public void saveDoc()
    {
        Document doc = getDoc();
        FileDocumentManager.getInstance().saveDocument(doc);
    }
}