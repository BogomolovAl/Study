import java.util.*;

/**
 * Created by vkom on 16.12.2017.
 */

public class NetworkBuilder extends Builder {
    private LinkedList<NetworkElement> elements = new LinkedList<NetworkElement>();
    private ArrayList<String> configuration = new ArrayList<String>();

    public void build()
    {
        ListIterator<NetworkElement> it = elements.listIterator();
        NetworkElement element;
        while( it.hasNext() )
        {
            element = it.next();
            switch( element.type() )
            {
                case "Client":
                    System.out.println( "build client " + element.getName() );
                    break;
                case "Channel":
                    System.out.println( "build channel " + element.getName() );
                    break;
                case "Server":
                    System.out.println( "build server " + element.getName() );
                    break;
                default:
                    break;
            }
        }
    }
    public void moveToAnotherBuilder( Builder builder )
    {
        if( builder instanceof NetworkBuilder )
        {
            /* preparation */
            move( builder );
        }
    }
    protected void move( Builder builder )
    {
        /* moving */
    }

    public static String getNetworkState()
    {
        /* getting network state*/
        String networkState = "State: good";
        return networkState;
    }

    public void setNetworkConfiguration( ArrayList<String> configuration )
    {
        this.configuration.clear();
        this.configuration.addAll( configuration );
        System.out.println( "setNetworkConfiguration " + configuration.size() );
    }
    public int getElementIndex( String name )
    {
        ListIterator<NetworkElement> it = elements.listIterator();
        int elementIndex = 0;
        while( it.hasNext() )
        {
            elementIndex = it.nextIndex();
            if( it.next().getName() == name )
            {
                return elementIndex;
            }
        }
        return elementIndex;
    }
    public void addNetworkElement( NetworkElement element )
    {
        this.elements.add( element );
        System.out.println( "setNetworkElement " + element.type() );
    }
    public NetworkElement getElement( int index )
    {
        return elements.get( index );
    }
}
