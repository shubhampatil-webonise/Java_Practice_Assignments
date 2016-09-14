
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by webonise on 13/9/16.
 */
public class HttpServer implements Server {

    boolean isRunning = false;
    ServerSocket serverSocket = null;

    public static String ROOT = System.getProperty("user.dir") + File.separator + "ROOT";
    static final int PORT = 8080;
    static final int BACKLOGLIMIT = 50;

    @Override
    public boolean isServerRunning(){
        return isRunning;
    }

    @Override
    public void startServerAndListenForRequests() {
        try {
            serverSocket = new ServerSocket(PORT, BACKLOGLIMIT, InetAddress.getByName("127.0.0.1"));
            isRunning = true;

            System.out.println("HTTP server started on port 8080 !\n");
            System.out.println("ROOT directory : " + ROOT);

            startListeningForRequests();

        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void stopServer() {

        try {
            serverSocket.close();
            isRunning = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void startListeningForRequests(){

        while(true){

            Socket socket;

            try {
                socket = serverSocket.accept();

                handleRequestInNewThread(socket);


            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void handleRequestInNewThread(Socket socket){

        try{
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            Request request = new HttpRequest(in);
            Response response = new HttpResponse(request, out);

            response.sendRequestedResource();

            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}