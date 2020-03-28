package snapidea;
import reportmill.app.RMEditorPane;

/**
 * Subclass of RMEditorPane to interface with Idea.
 */
public class RptEditorPane extends RMEditorPane {

    // The RptFileEditor
    private RptFileEditor _ideaFileEditor;

    /**
     * Creates RptEditorPane.
     */
    public RptEditorPane(RptFileEditor aFE)
    {
        _ideaFileEditor = aFE;
    }

    @Override
    public void save()
    {
        super.save();
    }
}
