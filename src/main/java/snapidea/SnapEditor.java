package snapidea;
import com.intellij.openapi.editor.Document;
import snap.util.XMLElement;
import snapbuild.app.Editor;

public class SnapEditor extends Editor {

    // The SnapFileEditor
    private SnapFileEditor _ideaFileEditor;

    /**
     * Constructor.
     */
    public SnapEditor(SnapFileEditor aFE)
    {
        _ideaFileEditor = aFE;
    }

    /**
     * The real save method.
     */
    public void save()
    {
        // Get source file and save (update file might get called from here)
        //updateFile(); WebFile file = getSourceFile(true); file.save();

        XMLElement xml = getContentXML();
        String text = xml.getString();
        Document doc = _ideaFileEditor.getDoc();
        doc.setText(text);
        _ideaFileEditor.saveDoc();

        // Clear undoer
        getUndoer().reset();
    }
}
