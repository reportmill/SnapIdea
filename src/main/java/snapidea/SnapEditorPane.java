package snapidea;
import snap.web.WebURL;
import snapbuild.app.Editor;
import snapbuild.app.EditorPane;

/**
 * Subclass of SnapBuilder EditorPane to interface with Idea.
 */
public class SnapEditorPane extends EditorPane {

    // The SnapFileEditor
    private SnapFileEditor _ideaFileEditor;

    /**
     * Creates SnapEditorPane.
     */
    public SnapEditorPane(SnapFileEditor aFE)
    {
        _ideaFileEditor = aFE;
    }

    @Override
    protected Editor createEditor()
    {
        return new SnapEditor(_ideaFileEditor);
    }

    @Override
    protected WebURL getSourceURL()
    {
        return WebURL.getURL(_ideaFileEditor.getUrl());
    }

    @Override
    public void save()
    {
        super.save();
    }
}
