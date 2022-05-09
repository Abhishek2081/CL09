// A Java program for a Server
import java.net.*;
import java.io.*;

public class ServerTCP
{
	//initialize socket and input stream
	private Socket		 socket = null;
	private ServerSocket server = null;
	// private DataInputStream in	 = null;
	// private DataOutputStream out	 = null;

	// constructor with port
	public ServerTCP(int port)
	{
		// starts server and waits for a connection
		try
		{
			server = new ServerSocket(port);
			System.out.println("Server started");
			
			int i =1;
	        while (true) {
	            try {
	            	System.out.println("Waiting for a client ...");

	    			socket = server.accept();
	    			System.out.println("Client "+i+" accepted");
	                
	                ServerThread st = new ServerThread(socket,"Client "+String.valueOf(i));
	                i++;
	                st.start();
	            } catch (Exception e) {
	                System.out.println("connetion error");
	            }
	        }
		}
		catch(IOException i)
		{
			System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		ServerTCP server = new ServerTCP(5000);
	}
}


class ServerThread extends Thread{
	String a = "";
	String b = "";
    DataInputStream in = null;
    DataOutputStream out = null;
    Socket socket = null;
    String clientnum = "";
    public ServerThread(Socket s, String clientnum) {
        socket = s;
        this.clientnum= clientnum; 
    }
    
    public void run() {
    	try {
    		
    		in = new DataInputStream(socket.getInputStream());
    		out = new DataOutputStream(socket.getOutputStream());

    		a = in.readUTF();
			b = in.readUTF();
			
			if( numberOfVowels(a) == numberOfVowels(b)){
				System.out.println("Vowel Count Matches");
			}
			else{
				System.out.println("Vowel Count does not Match");
			}
    		
    	} catch (IOException ie) {
            System.out.println("socket close error");
        }
    }

	public int numberOfVowels(String s){
		int num = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
				num++;
			}
		}
		return num;
	}
}
