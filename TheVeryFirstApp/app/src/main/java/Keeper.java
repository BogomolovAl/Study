/**
 * Created by vkom on 16.12.2017.
 */

public interface Keeper {
    void saveData( byte[] data );
    byte[] getData();
}
