// A Java program for a Client
import java.net.*;
import java.io.*;
import java.math.*;
import java.util.*;

public class ClientTCP
{
	// initialize socket and input output streams
	private Socket socket		 = null;
	private DataInputStream input = null;
	private DataInputStream in	 = null;
	private DataOutputStream out	 = null;

	// constructor to put ip address and port
	public ClientTCP(String address, int port)
	{
		// establish a connection
		try
		{
			socket = new Socket(address, port);
			System.out.println("Connected");

			// takes input from terminal
			input = new DataInputStream(System.in);

			in = new DataInputStream(socket.getInputStream());
				
			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch(UnknownHostException u)
		{
			System.out.println(u);
		}
		catch(IOException i)
		{
			System.out.println(i);
		}

		Scanner sc = new Scanner(System.in);
		String a = "";
		String b = "";

			System.out.print("Enter Sting 1: ");  
			a= sc.next();  
			System.out.print("Enter String 2: ");  
			b= sc.next();
				
			System.out.println("Sending Both Strings to Server");
			try
			{
			    out.writeUTF(a);
			    out.writeUTF(b);
			}
			catch(IOException i)
			{
			    System.out.println(i);
			}
			
		// close the connection
		try
		{
			System.out.println("Closing connection");
			input.close();
			out.close();
			socket.close();
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		ClientTCP client = new ClientTCP("127.0.0.1", 5000);
	}
}
