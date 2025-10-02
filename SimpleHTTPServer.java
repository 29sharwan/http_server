import java.net.*;
import java.io.*;

public class SimpleHTTPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server running on port 8080");
        while(true)
        {
            Socket client=server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            //Read Request
            String line;
            while(!(line=in.readLine()).isEmpty())
            {
               System.out.println(line);

            }
            //Send response
            out.write("HTTP/1.1 200 ok\r\n\r\n<h1> Hello java</h1>");
            out.flush();
            client.close();
    


        }
        // server.close();
    }
    
}
