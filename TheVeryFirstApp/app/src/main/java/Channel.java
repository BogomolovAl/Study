/**
 * Created by vkom on 16.12.2017.
 */

public class Channel extends NetworkElement implements Writer, Reader {
    private int writeChannelId;
    private int readChannelId;

    public String type()
    {
        return "Channel";
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
        System.out.println(  "initRead " + Integer.toString( channelId ) );
    }
}
