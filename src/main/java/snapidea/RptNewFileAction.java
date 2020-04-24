package snapidea;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import snap.gfx.Image;

import javax.swing.*;

/**
 * An action to create a new file.
 */
public class RptNewFileAction extends CreateFileFromTemplateAction {

    // The icon
    static ImageIcon _icon;

    public RptNewFileAction()
    {
        super("ReportMill template file", "Create ReportMill template file", getIcon());
    }

    public RptNewFileAction(@Nls(capitalization = Nls.Capitalization.Title) String text, @Nls(capitalization = Nls.Capitalization.Sentence) String description, Icon icon)
    {
        super(text, description, icon);
    }

    @Override
    protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder)
    {
        builder.setTitle("New ReportMill template file")
                .addKind("ReportMill template file", getIcon(), "ReportMillSample");
    }

    @Override
    protected String getActionName(PsiDirectory directory, @NotNull String newName, String templateName)
    {
        return "New SnapKit UI file";
    }

    private static Icon getIcon()
    {
        if (_icon!=null) return _icon;
        Image img = Image.get(RptNewFileAction.class.getResource("ReportMill.png"));
        Image img2 = img.cloneForSizeAndScale(18, 18, 1);
        ImageIcon icon = new ImageIcon((java.awt.Image)img2.getNative());
        return _icon = icon;
    }
}
