/**
 * Created by vkom on 06.12.2017.
 */

import java.util.*;

public class TheVeryFirstApp {
    public static void main()
    {
        SomeClass obj = new SomeClass();
        obj.start();

        int clientChannelId = 50300;
        int serverChannelId = 50400;

        System.out.println( NetworkBuilder.getNetworkState() );

        NetworkBuilder networkBuilder = new NetworkBuilder();
        ArrayList<String> environment = new  ArrayList<String>();
        environment.add( "User: user" );
        environment.add( "Host: userhost" );
        networkBuilder.setEnvironment( environment );
        ArrayList<BuildEvent> eventFilter = new ArrayList<BuildEvent>();
        eventFilter.add( new BuildEvent("CreateEvent" ) );
        eventFilter.add( new BuildEvent("DestroyEvent" ) );
        eventFilter.add( new BuildEvent("MoveEvent" ) );
        networkBuilder.setEventFilter( eventFilter );

        Client client = new Client();
        client.setName( "Client1" );
        client.setNet( "SimpleNet" );
        client.initWrite( clientChannelId );
        client.initRead( serverChannelId );
        networkBuilder.addNetworkElement( client );

        Channel channel = new Channel();
        channel.setName( "Channel1" );
        channel.setNet( "SimpleNet" );
        channel.initWrite( clientChannelId );
        channel.initRead( serverChannelId );
        networkBuilder.addNetworkElement( channel );

        Server server = new Server();
        server.setName( "Server1" );
        server.setNet( "SimpleNet" );
        server.initWrite( serverChannelId );
        server.initRead( clientChannelId );
        server.addClient( "First client" );
        server.addClient( "Second client" );
        server.addClient( "Third client" );
        networkBuilder.addNetworkElement( server );

        ArrayList<String> networkConfiguration = new ArrayList<String>();
        networkConfiguration.add( "12.0.0.35" );
        networkConfiguration.add( "0964" );
        networkBuilder.setNetworkConfiguration( networkConfiguration );

        networkBuilder.build();

        NetworkElement networkElement;
        int clientIndex = networkBuilder.getElementIndex( "Client1" );
        networkElement = networkBuilder.getElement( clientIndex );
        networkElement.getName();
        networkElement.getNet();
        doSomeWith( networkElement );

        int channelIndex = networkBuilder.getElementIndex( "Channel1" );
        networkElement = networkBuilder.getElement( channelIndex );
        networkElement.getName();
        networkElement.getNet();
        doSomeWith( networkElement );

        int serverIndex = networkBuilder.getElementIndex( "Server1" );
        networkElement = networkBuilder.getElement( serverIndex );
        networkElement.getName();
        networkElement.getNet();
        doSomeWith( networkElement );

        PrivateNetworkBuilder privateNetworkBuilder = new PrivateNetworkBuilder();
        privateNetworkBuilder.setKey( "qwerty1029384756" );
        networkBuilder.moveToAnotherBuilder( privateNetworkBuilder );
    }

    public static void doSomeWith( NetworkElement element )
    {
        if( element instanceof Client )
        {
            byte[] dataToWrite = new byte[256];
            ((Client)element).write( dataToWrite );

            ((Client)element).read();

            byte[] dataToSave = new byte[256];
            ((Client)element).saveData( dataToSave );
            ((Client)element).getData();
        }else
        {
            if( element instanceof Channel )
            {
                ((Channel)element).read();
                byte[] data = new byte[256];
                ((Channel)element).write( data );
            }else
            {
                if( element instanceof Server )
                {
                    ((Server)element).read();

                    byte[] dataToWrite = new byte[256];
                    ((Server)element).write( dataToWrite );

                    byte[] dataToSave = new byte[256];
                    ((Server)element).saveData( dataToSave );
                    ((Server)element).getData();
                }
            }
        }
    }
}
