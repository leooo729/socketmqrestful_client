package com.example.jms_demo_2.tcpSocket;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void sendRequest(String request) throws Exception {
        try {

                Socket socket = new Socket("localhost", 1010);

                OutputStream outputStream = socket.getOutputStream(); //發送
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
                bw.write(request);
                bw.newLine();
                bw.flush();
//=============================================================================取得response

                BufferedReader response = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = "";

                while ((str = response.readLine()) != null) {
                    System.out.println(str);
                }
                socket.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
//  {"requestType":"get","request":{}}
//  {"requestType":"search","request":{"id":"MGI20221026100346363"}}
//  {"requestType":"create","request":{"cmNo":"3","kacType":"1","bankNo":"003","ccy":"TWD","pvType":"1","bicaccNo":"0000000","accAmt":[{"acc":"1","amt":1000},{"acc":"2","amt":700}],"ctName":"Leo","ctTel":"26262626"}}
//  {"requestType":"update","id":"MGI20221026100346363","request":{"cmNo":"3","kacType":"1","bankNo":"003","ccy":"TWD","pvType":"1","bicaccNo":"0000000","accAmt":[{"acc":"1","amt":500},{"acc":"2","amt":656}],"ctName":"Leo","ctTel":"26262626"}}
//  {"requestType":"delete","request":{"id":"MGI20221021162139283"}}
