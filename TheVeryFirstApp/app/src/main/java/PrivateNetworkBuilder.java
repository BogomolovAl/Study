import java.util.ArrayList;

/**
 * Created by vkom on 16.12.2017.
 */

public class PrivateNetworkBuilder extends NetworkBuilder {
    private String key;
    private ArrayList<String> securityOptions = new ArrayList<String>();

    public void setKey( String key )
    {
        this.key = key;
        securityOptions.clear();
        securityOptions.addAll( getSecurityOptionsFromKey() );
    }

    private ArrayList<String> getSecurityOptionsFromKey()
    {
        System.out.println( "getSecurityOptionsFromKey " +  key );
        return new ArrayList<String>();
    }
}
