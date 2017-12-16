/**
 * Created by vkom on 16.12.2017.
 */

public abstract class NetworkElement {
    private String name;
    private String net;

    public NetworkElement() {}
    public NetworkElement( String name, String net )
    {
        this.name = name;
        this.net = net;
    }

    public abstract String type();

    public void setName( String name )
    {
        this.name = name;
    }
    public void setNet( String net )
    {
        this.net = net;
    }
    public String getName()
    {
        return this.name;
    }
    public String getNet()
    {
        return this.net;
    }
}
