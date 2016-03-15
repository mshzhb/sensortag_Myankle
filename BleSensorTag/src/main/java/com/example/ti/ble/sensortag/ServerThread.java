package com.example.ti.ble.sensortag;



import android.util.Log;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
/**
 * Created by mshzhb on 2016-03-02.
 */
public class ServerThread extends Thread {
    ServerSocket sock;
    Socket s;
    public ServerThread(ServerSocket s)
    {
        sock =s ;
    }
    public void run()
    {

        while(true)
        {

            try{
                s = sock.accept();
                Log.d("Mshzhb","connected");
                break;
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }





        while (true) {
            try {
                OutputStream out = s.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeUTF(String.valueOf(SensorTagMovementProfile.BN));
                Log.d("Mshzhb","BN: "+String.valueOf(SensorTagMovementProfile.BN));
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}