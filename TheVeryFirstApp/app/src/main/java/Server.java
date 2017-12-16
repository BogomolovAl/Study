import java.util.*;

/**
 * Created by vkom on 16.12.2017.
 */

public class Server extends NetworkElement implements Writer, Reader, Keeper {
    private int writeChannelId;
    private int readChannelId;
    private byte[] data;
    private LinkedList<String> clients = new LinkedList<String>();

    public String type()
    {
        return "Server";
    }

    public void write( byte[] data )
    {
        System.out.println( "Data " + data.toString() + " has been written" );
    }
    public void initWrite( int channelId )
    {
        this.writeChannelId = channelId;
        System.out.println( "initWrite " + Integer.toString( channelId ) );
    }
    public void saveData( byte[] data )
    {
        this.data = data;
        System.out.println( "saveData " + data.toString() );
    }
    public byte[] getData()
    {
        return this.data;
    }
    public byte[] read()
    {
        byte[] receivedData;
        String recStr = "Received Data";
        receivedData = recStr.getBytes();
        return receivedData;
    }
    public void initRead( int channelId )
    {
        this.readChannelId = channelId;
        System.out.println( "initRead " + Integer.toString( channelId ) );
    }

    public void addClient( String client )
    {
        clients.add( client );
        System.out.println( "Client " + client + " has benn added" );
    }
}
