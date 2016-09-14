/**
 * Created by webonise on 13/9/16.
 */
public class ServerFactory {

    public Server getServerInstance(String serverType){
        if (serverType.equalsIgnoreCase("http")){
            return new HttpServer();
        }else if (serverType.equalsIgnoreCase("ftp")){
            return new FtpServer();
        }else if (serverType.equalsIgnoreCase("db")){
            //db instance;
        }

        return null;
    }

}