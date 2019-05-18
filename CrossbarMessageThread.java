//CrossbarMessageThread.java
import java.net.*;  
import java.io.*;
public class CrossbarMessageThread extends Thread {
    protected Socket socket;

    public CrossbarMessageThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        try{
        DataInputStream din=new DataInputStream(socket.getInputStream());  
    DataOutputStream dout=new DataOutputStream(socket.getOutputStream());  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="";  
while(!str.equals("stop")){ 
str=din.readUTF();  
String[] split = str.split(";");
System.out.println(str);  
int out_index = Integer.parseInt(split[1])-1;
System.out.println(split[1]);
//str2=br.readLine();  
DataOutputStream rdout = new DataOutputStream(((Socket)CrossbarServer.reciever_sockets[out_index]).getOutputStream());
rdout.writeUTF(split[0]);  
rdout.flush(); 
}
socket.close();
}catch(Exception e){
    System.out.println(e);
}
    }
}
