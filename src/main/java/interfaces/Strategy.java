package interfaces;

/**
 * Created by Chargi on 3.5.2016.
 */
public interface Strategy {
    void setMessage(String message);
    void setUser(String user);
    boolean canHandle(String identifier);
    void saveMessage();
}
