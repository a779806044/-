package com.seu.edu.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.UIManager;

import com.seu.edu.message.*;
public class Client {
	public Socket socket = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
	public Client() {
		try {
			socket = new Socket("localhost",4567);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois  = new ObjectInputStream(socket.getInputStream());
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void sendRequestToServer(RequestData rd) {
		try {
			oos.writeObject(rd);
			System.out.println("ºÚ÷±");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Object receiveDataFromServer() {
		Object obj = null;
		try {
			obj = ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
