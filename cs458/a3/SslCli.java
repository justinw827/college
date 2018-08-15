import java.net.*;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
 
public class SslCli {
    // initialize socket and input output streams
    private SSLSocket        socket  = null;
    private BufferedReader   input   = null;
    private PrintWriter		 out     = null;
    private BufferedReader   serverOutput = null;
 
    // Constructor to put ip address and port
    public SslCli(String address, int port) {
        // establish a connection
        try {
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            socket = (SSLSocket) sslsocketfactory.createSocket(address, port);
            System.out.println("Connected");
 
            // Create buffered reader to get input from console
            input = new BufferedReader(new InputStreamReader(System.in));
 	
            // Sends output to the socket
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch(UnknownHostException u) {
            u.printStackTrace();
			System.err.println("Error connecting to server.");
        } catch(IOException i) {
            i.printStackTrace();
			System.err.println("Error connecting to server.");
        }
 
 

	    try {
	        // Get username
			System.out.println("Enter username.");
			String username = input.readLine();

			// Get password
			System.out.println("Enter password.");
			String password = input.readLine();

			// Send username and password to server; delimited with semicolon
	        out.println(username + ":" + password);

	        // Get response from server
	        serverOutput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        String response = "";
	        while ((response = serverOutput.readLine()) != null) {
	        	System.out.println(response);
	        }    

	        if (response == "OK") {
	        	System.out.println("the password is correct");
	        } else {
	        	System.out.println("the password is incorrect");
	        }

	    } catch(IOException e) {
	        e.printStackTrace();
			System.err.println("Error while reading input.");
	    }
         
        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch(IOException i) {
            System.out.println(i);
        }
    }
 
    public static void main(String[] args) {

        if (args.length != 2 ) {
            System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
            System.exit(0);
        }

        String address = args[0];
        int portNum = Integer.parseInt(args[1]);
        SslCli client = new SslCli(address, portNum);
    }
}