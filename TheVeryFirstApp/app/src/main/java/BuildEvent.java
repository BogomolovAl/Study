import android.os.Build;

/**
 * Created by vkom on 16.12.2017.
 */

public class BuildEvent {
    private String name;

    public BuildEvent( String name )
    {
        this.name = name;
    }

    public String name()
    {
        return this.name;
    }
}
