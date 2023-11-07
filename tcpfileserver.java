import java.net.*;
import java.io.*;
import java.util.*;

public class tcpfileserver{
public static void main(String[]args)throws Exception{
	ServerSocket ss = new ServerSocket(5678);
	 Socket s = ss.accept();
	   InputStream is  = s.getInputStream();
	  FileOutputStream fos = new FileOutputStream("f2.txt");
	  byte[]b = new byte[1024];
	  int bytesRead;
	  while((bytesRead=is.read(b))!=-1){
		  fos.write(b,0,bytesRead);
	  }
	  System.out.println("File Recieved !");
	  fos.close();
	  is.close();
	  ss.close();
	}
}