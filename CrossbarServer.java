//CrossbarServer.java

import java.net.*;  
import java.io.*;
import java.util.Scanner;
public class CrossbarServer{
	static Socket[] sender_sockets, reciever_sockets;

	public static void main(String[] args){
		sender_sockets = new Socket[10];
		reciever_sockets = new Socket[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of Senders:");
		int s = sc.nextInt();
		System.out.println("Enter the no. of Recievers:");
		int r = sc.nextInt();
		try{
		ServerSocket ss = new ServerSocket(5679);
		for(int i=0; i<s; i++){
			Socket sa = ss.accept();
			sender_sockets[i]=sa;
			System.out.println("Got a sender connection");
			new CrossbarMessageThread(sa).start();
		}
		for(int i=0; i<r; i++){
			Socket sa = ss.accept();
			reciever_sockets[i]=sa;
			System.out.println("Got a reciever connection");
			new CrossbarMessageThread(sa).start();
		}
		ss.close();
	}catch(Exception  e){
		System.out.println(e.getMessage());
	}
	}
}