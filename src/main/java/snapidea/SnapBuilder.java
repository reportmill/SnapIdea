package snapidea;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.beans.PropertyChangeListener;

public class SnapBuilder implements FileEditor {

    /**
     * Invoked when the project corresponding to this component instance is opened.<p>
     * Note that components may be created for even unopened projects and this method can be never
     * invoked for a particular component instance (for example for default project).
     */
    public void projectOpened() {

        System.err.println("SnapBuilder.projectOpened");
    }

    /**
     * Invoked when the project corresponding to this component instance is closed.<p>
     * Note that components may be created for even unopened projects and this method can be never
     * invoked for a particular component instance (for example for default project).
     */
    public void projectClosed() {
    }

    @NotNull
    @Override
    public JComponent getComponent()
    {
        return null;
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent()
    {
        return null;
    }

    @NotNull
    @Override
    public String getName()
    {
        return null;
    }

    @Override
    public void setState(@NotNull FileEditorState state)
    {

    }

    @Override
    public boolean isModified()
    {
        return false;
    }

    @Override
    public boolean isValid()
    {
        return false;
    }

    @Override
    public void addPropertyChangeListener(@NotNull PropertyChangeListener listener)
    {

    }

    @Override
    public void removePropertyChangeListener(@NotNull PropertyChangeListener listener)
    {

    }

    @Nullable
    @Override
    public FileEditorLocation getCurrentLocation()
    {
        return null;
    }

    @Override
    public void dispose()
    {

    }

    @Nullable
    @Override
    public <T> T getUserData(@NotNull Key<T> key)
    {
        return null;
    }

    @Override
    public <T> void putUserData(@NotNull Key<T> key, @Nullable T value)
    {

    }
}
