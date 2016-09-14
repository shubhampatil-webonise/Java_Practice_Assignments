/**
 * Created by webonise on 13/9/16.
 */
public class FtpServer implements Server {

    boolean isRunning = false;

    @Override
    public boolean isServerRunning() {
        return isRunning;
    }

    @Override
    public void startServerAndListenForRequests() {

    }

    @Override
    public void stopServer() {

    }
}