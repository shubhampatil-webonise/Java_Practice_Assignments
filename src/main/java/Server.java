/**
 * Created by webonise on 13/9/16.
 */
public interface Server {

    public boolean isServerRunning();
    public void startServerAndListenForRequests();
    public void stopServer();
}