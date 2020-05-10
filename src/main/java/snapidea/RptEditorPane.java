package snapidea;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import reportmill.app.RMEditorPane;
import snap.util.XMLElement;
import snap.web.WebURL;

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
    protected WebURL getSourceURL()
    {
        return WebURL.getURL(_ideaFileEditor.getUrl());
    }

    @Override
    public void save()
    {
        super.save();
    }

    /**
     * The real save method.
     */
    protected void saveImpl()
    {
        ApplicationManager.getApplication().runWriteAction(() -> saveImplImpl());
    }

    /**
     * The real save method.
     */
    protected void saveImplImpl()
    {
        XMLElement xml = getDoc().getXML();
        String text = xml.getString();
        Document doc = _ideaFileEditor.getDoc();
        doc.setText(text);
        _ideaFileEditor.saveDoc();
    }
}
