//CrossbarSenderClient.java
import java.net.*;  
import java.io.*;  
import java.util.*;
class CrossbarSenderClient{  
public static void main(String args[])throws Exception{  
	//Delete localhost and enter the server ip address
Socket s=new Socket("172.20.10.2",5679);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2="";  
String client_name = null;
Scanner sc = new Scanner(System.in);
client_name = sc.nextLine();
System.out.println("Now start sending your messages:");
while(!str.equals("stop")){  
str=br.readLine();  
dout.writeUTF(client_name+":"+str);  
dout.flush();  
}  
  
dout.close();  
s.close();  
}}  
