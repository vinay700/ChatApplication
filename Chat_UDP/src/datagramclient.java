import java.net.*;
import java.io.*;
class datagramclient
{
  public static DatagramSocket ds;
  public static byte buffer[] = new byte[1024];
  public static int clientport = 789, serverport = 790;
  public static void main(String args[]) throws Exception
  {
    ds = new DatagramSocket(clientport);
    System.out.println("Client is waiting for server to send data");
    System.out.println("Press ctrl c to come to the dos prompt");
    while(true)
    {
      DatagramPacket p = new DatagramPacket(buffer,buffer.length);
      ds.receive(p);
      String message = new String(p.getData(),0,p.getLength());
      System.out.println(message);
    }
  }
}
