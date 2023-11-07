import java.net.*;
import java.io.*;
import java.util.*;
public class tcpfileclient{
public static void main(String[]args)throws Exception{
	 Socket s = new Socket("localhost",5678);
	  File file = new File("f2.txt");
	  FileInputStream fin = new FileInputStream(file);
	  OutputStream os  = s.getOutputStream();
	  byte[]b = new byte[1024];
	  int bytesRead;
	  while((bytesRead=fin.read(b))!=-1){
		  os.write(b,0,bytesRead);
	  }
	  System.out.println("File Sent");

	  fin.close();
	  os.close();
      s.close();
	}
}