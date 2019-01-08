// A simple DatagramSocket and DatagramPacket server
import java.net.*;
import java.io.*;
class datagramserver
{
  public static DatagramSocket ds;
  public static int clientport = 789,serverport = 790;
  public static void main(String args[]) throws Exception
  {
    byte buffer[] = new byte[1024];
    ds = new DatagramSocket(serverport);
    BufferedReader dis = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Server waiting for input");
    InetAddress ia = InetAddress.getLocalHost(); 
    while(true)
    {
      String str = dis.readLine();
      if((str == null) || (str.equals("end")))
        break;
        buffer = str.getBytes();
        ds.send(new DatagramPacket(buffer,str.length(),ia,clientport));
     }
   }
 }

