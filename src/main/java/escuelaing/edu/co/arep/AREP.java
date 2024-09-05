package escuelaing.edu.co.arep;

/**
 * @author Camilo Murcia 
 */
import java.io.*;
import java.net.*;
import java.util.concurrent.*;
 
public class AREP {
    private static AREP instance;
    private static final int PORT = 35000;
    public static String WEB_ROOT;
    private boolean running = false;

    
     /**
     * Method to get the instance of the HttpServer class.
     * 
     * @return The instance of the HttpServer class.
     */
    public static AREP getInstance(){
        if(instance == null){
            instance = new AREP();
        }
        return instance;
    }

     /**
     * Method to start the server.
     * 
     * @throws IOException        If an I/O error occurs.
     * @throws URISyntaxException If the URI is invalid.
     */
    public void start() throws IOException, URISyntaxException  {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(PORT);

        running = true;
        while (running) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new ClientHandler(clientSocket));
        }
    }

    public boolean isRunning(){
        return running;
    }

    public void setStaticFileLocation(String webRoot){
        WEB_ROOT = webRoot;
    }
}
 
