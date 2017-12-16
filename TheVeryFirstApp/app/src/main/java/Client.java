/**
 * Created by vkom on 16.12.2017.
 */

public class Client extends NetworkElement implements Writer, Reader, Keeper{
    private int writeChannelId;
    private int readChannelId;
    private byte[] data;

    public String type()
    {
        return "Client";
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
}
