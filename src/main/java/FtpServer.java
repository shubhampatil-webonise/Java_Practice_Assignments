
public class FtpServer implements Server {

    boolean isRunning = false;

    @Override
    public boolean isServerRunning() {
        return isRunning;
    }

    @Override
    public void startServerAndListenForRequests() {
        System.out.println("Starting FTP server.");
    }

    @Override
    public void stopServer() {
        System.out.println("Stoping FTP server.");
    }
}