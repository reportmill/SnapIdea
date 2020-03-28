package snapidea;
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
    public void save()
    {
        super.save();
    }
}
