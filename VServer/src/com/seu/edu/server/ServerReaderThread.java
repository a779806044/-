package com.seu.edu.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


import com.seu.edu.message.RequestData;

public class ServerReaderThread extends Thread{
	private Socket socket;
	ObjectOutputStream oos = null;
	public ServerReaderThread(Socket socket) {
		this.socket = socket;
		try {
			oos = new  ObjectOutputStream(socket.getOutputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			boolean f = true;
			RequestData reqData = null;
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
}
	public void sendDataToClient(RequestData rd){
	    try {
	    	oos.writeObject(rd);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
   	 
	}
}w4