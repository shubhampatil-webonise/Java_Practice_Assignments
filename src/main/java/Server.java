
public interface Server {

    boolean isServerRunning();

    void startServerAndListenForRequests();

    void stopServer();
}