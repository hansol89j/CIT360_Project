package com.servlet.sandBox;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by hansoljeong on 2015. 11. 22..
 */
public class NastyClient {

    public static void main(String args[]){
        NastyClient client = new NastyClient();
        client.go();
    }

    private void go() {
        while(true){
            try{
                Scanner input = new Scanner(System.in);
                System.out.println("Enter the message to send to the server");
                String messageForServer = input.nextLine();

                //URL or Uniform Resource Locator and represents a resource on the World Wide Web, such as a Web page
                // or FTP directory. Since 8080 port was used, I will use 6060. I thought this is gonna work but, it
                // should be use 8080, the host number that was set up as default when I installed Tomcat.
                // Error message: java.net.ConnectException: Connection refused
                URL url = new URL("http://www.naver.com/23");

                //try to put the web address of the real web browser.
                // URL url = new URL("http://www.naver.com/json"); FileNotFoundException error message

                //URLConnection opens the inputStream & outputStream of URL.
                //After creating the URL, you can return the instance of URL via openConnection method.
                //openConnection(): returns HttpURLConnection() object
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();


                //setDoOutPut(): passes in true to denote that the connection will be used for output.
                // The default value is false because many types of URLs do not support being written to.
                //If it is false: java.net.ProtocolException: cannot write to a URLConnection if doOutput=false - call setDoOutput(true)
                connection.setDoOutput(true);//allows POST and PUT requests. If it is false then it is for using GET requests.
                JSONOutputStream outToServer = new JSONOutputStream(connection.getOutputStream());

                //Create new HashMap
                //If I put nulls, org.quickconnectfamily.json.JSONException: Invalid JSON String
                HashMap<String, Object> request = new HashMap<>();
                request.put("message", "hello");
                request.put("message", messageForServer);

                //Write out the hashMap with QCJSON writeObject method.
                outToServer.writeObject(request);

                JSONInputStream inFromServer = new JSONInputStream(connection.getInputStream());
                //Read  what I got back from the server.
                HashMap<String, Object> response = (HashMap<String, Object>) inFromServer.readObject();
                if (response.get("command").equals("Done")) {
                    System.out.println("Sent request: " + request + "and  got response  " + response);
                } else {
                    System.out.println("Oops. got " + response);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
