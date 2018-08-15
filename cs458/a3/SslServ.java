import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import java.security.MessageDigest;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class SslServ {

	//initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
 
    // constructor with port
    public SslServ(int port) {
        // starts server and waits for a connection
        try {
            // Create a SSL Server Socket Factory
            SSLServerSocketFactory sslServerSocketFactory = 
                (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();

            // Create a SSL Server Socket with SSL Socket Factory 
            server = sslServerSocketFactory.createServerSocket(port);
            System.out.println("SSL Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
            System.out.println("Client accepted");
 
            // out.println("string") sends a string over the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            try { 
                // Buffered reader for socket input
                BufferedReader br = 
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

                String line = br.readLine();
                
                String[] tokens = line.split(":");
                String username = tokens[0]; // Get username
                String password = tokens[1]; // Get password

                // Open file with name "password.txt"
                File file = new File("password.txt");
                FileReader fr;
                BufferedReader brFile; // Buffered reader for file

                // Password file format
                // <user ID> <hashed password> <date and time when the password is stored>
                String idCheck = "";
                String fileLine = "";
                String storedPW = "";
                String date = ""; // Date and time
                try {
                    fr = new FileReader(file);
                    brFile = new BufferedReader(fr);
                     // Look for matching username in password file
                    while (idCheck != username && fileLine != null) {
                        fileLine = brFile.readLine();
                        String[] tokens2 = fileLine.split(" ");
                        storedPW = tokens2[1]; // Store password
                        date = tokens2[2]; // Store date and time
                        idCheck = tokens2[0];
                    }
                } catch (FileNotFoundException e) {
                    System.err.println("Error opening file.");
                    e.printStackTrace();
                }

                // Hash password with MD5
                String hashtext = hashMD5(password);

                System.out.println(hashtext);

                if (idCheck == username) {
                    if (hashtext == storedPW) {
                        out.println("OK");
                    } else {
                        out.println("Incorrect");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error while reading from socket.");
            }

            System.out.println("Closing connection");
 
            // close connection
            socket.close();
        } catch(IOException e) {
            e.printStackTrace();
            System.err.println("Error using socket.");
        }
    }

    private String hashMD5(String textIn) {
        // Hash password from client
        String hashtext = "";
        try {
            String plaintext = textIn;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(plaintext.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            hashtext = bigInt.toString(16); // Hashed password as string
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32 ) {
                hashtext = "0"+hashtext;
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error running MD5.");
            e.printStackTrace();
        }

        return hashtext;
    }
 
    public static void main(String[] args) {

    	if (args.length != 1 ) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 1 argumnet.");
			System.exit(0);
		}

		int portNum = Integer.parseInt(args[0]);

        SslServ server = new SslServ(portNum);
    }
}