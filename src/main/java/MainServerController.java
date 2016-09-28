import java.util.Scanner;

public class MainServerController {
    public static void main(String args[]){
        System.out.println("Welcome to ServerHub");

        Scanner in = new Scanner(System.in);

        ServerFactory serverFactory;
        Server server = null;

        try {
            serverFactory = new ServerFactory();
        }catch (Exception e){
            e.printStackTrace();
            return;
        }

        boolean runServer = true;

        while (runServer){

            System.out.println("1. Start/Stop HTTP server (http)\n");
            System.out.println("2. Start/Stop FTP server (ftp)\n");
            System.out.println("3. Start/Stop Database server (db)\n");
            System.out.println("Input :");

            String choice = in.next();

            try {
                switch (choice){
                    case "http":
                        server = serverFactory.getServerInstance("http");
                        break;

                    case "ftp":
                        server = serverFactory.getServerInstance("ftp");
                        break;

                    case "db":
                        server = serverFactory.getServerInstance("db");
                        break;

                    case "shutdown":
                        runServer = false;
                        break;

                    default:
                        System.out.println("Wrong choice !");
                        break;
                }

                if(server != null){
                    if(server.isServerRunning())
                        server.stopServer();
                    else
                        System.out.print("Starting server");
                    server.startServerAndListenForRequests();
                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}