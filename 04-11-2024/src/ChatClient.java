import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public void connectToServer(String ipAddress, int port) throws IOException
    {
        socket = new Socket(ipAddress,port);
        System.out.println("Connected to server!");

        out = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public void sendMessage(String message)
    {
        out.println(message);
    }

    public String receiveMessage() throws IOException
    {
        return in.readLine();
    }

    public void closeClient() throws IOException
    {
        in.close();
        out.close();
        socket.close();
    }
}
