import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by webonise on 13/9/16.
 */
public class HttpResponse implements Response {

    Request request;
    OutputStream out;

    HttpResponse(Request request, OutputStream out){
        this.request = request;
        this.out = out;
    }

    @Override
    public void sendRequestedResource(){

        String uri = request.getURI();
        byte[] outputBuffer = new byte[8096];
        FileInputStream fileInputStream = null;
        try{
            File file = new File(HttpServer.ROOT, uri);

            if(file.exists()){
                fileInputStream = new FileInputStream(file);

                int lengthOfBufferRead = fileInputStream.read(outputBuffer);

                while(lengthOfBufferRead != -1){
                    out.write(outputBuffer);
                    lengthOfBufferRead = fileInputStream.read(outputBuffer);
                }
            }else {
                outputBuffer = "<h1>Error : File not found ! </h1>".getBytes();
                out.write(outputBuffer);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}