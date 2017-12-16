import java.util.*;

/**
 * Created by vkom on 16.12.2017.
 */

public abstract class Builder {
    private ArrayList<String> environment = new ArrayList<String>();
    private ArrayList<BuildEvent> eventFilter = new ArrayList<BuildEvent>();

    public abstract void build();
    public abstract void moveToAnotherBuilder( Builder builder );
    protected abstract void move( Builder builder );

    public void setEnvironment( ArrayList<String> environment )
    {
        this.environment.clear();
        this.environment.addAll( environment );
        System.out.println( "setEnvironment " + environment.toString() );
    }
    public void setEventFilter( ArrayList<BuildEvent> eventFilter )
    {
        this.eventFilter.clear();
        this.eventFilter.addAll( eventFilter );
        System.out.println( "setEventFilter " + eventFilter.toString() );
    }
    protected void event( BuildEvent buildEvent )
    {
        if( eventFilter.contains( buildEvent ) )
        {
            System.out.println( "event " + buildEvent.name() + " was ignored" );
        }else
        {
            processBuildEvent( buildEvent );
        }
    }
    private void processBuildEvent( BuildEvent buildEvent )
    {
        System.out.println( "processBuildEvent " + buildEvent.name() );
    }
}
