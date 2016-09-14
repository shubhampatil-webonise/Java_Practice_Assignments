import java.io.InputStream;

/**
 * Created by webonise on 13/9/16.
 */
public class HttpRequest implements Request {

    InputStream in;
    String request;
    String uri;

    HttpRequest(InputStream in){
        this.in = in;
        parseRequestAndSetUri();
    }

    @Override
    public void parseRequestAndSetUri() {

        byte[] buffer = new byte[8096];
        StringBuffer request = new StringBuffer(8096);
        int lengthOfBufferRead;

        try{
            lengthOfBufferRead = in.read(buffer);
        }catch (Exception e){
            e.printStackTrace();
            lengthOfBufferRead = 0;
        }

        for(int i=0; i< lengthOfBufferRead; i++){
            request.append((char)buffer[i]);
        }

        System.out.println(request);

        uri = request.toString().split(System.getProperty("line.separator"))[0].split(" ")[1];
    }

    @Override
    public String getURI() {
        return uri;
    }
}