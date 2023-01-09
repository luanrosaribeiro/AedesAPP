package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;


public class Notificacao {

// Method to send Notifications from server to client end.
    public final static String AUTH_KEY_FCM = "AAAAarpoDWo:APA91bGxO7g8nWS1_zNhSZ5r8q4hGlPnV1KAul81tCQDKnd28jEenOBR520NgltGayNHkPKruRTa4bd1Oa130Xe5ta673iQ--NvINEL1nje3Fwu-jmXiTVDvWENugA_R0TpSn_-X52Ii";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    public static void pushFCMNotification(final String DeviceIdKey, final Integer body) throws Exception {

                BufferedReader in = null;

                String authKey = AUTH_KEY_FCM;   // You FCM AUTH key
                String FMCurl = API_URL_FCM;

                URL url = null;
                try {
                    url = new URL(FMCurl);
                } catch (MalformedURLException e) {
                    
                    e.printStackTrace();
                }
                HttpURLConnection conn = null;
                try {
                    conn = (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }

                conn.setUseCaches(false);
                conn.setDoInput(true);
                conn.setDoOutput(true);

                try {
                    conn.setRequestMethod("POST");
                } catch (ProtocolException e) {
                    
                    e.printStackTrace();
                }
                conn.setRequestProperty("Authorization", "key=" + authKey);
                conn.setRequestProperty("Content-Type", "application/json");

                JSONObject json = new JSONObject();
                try {
                    json.put("to", DeviceIdKey.trim());
                } catch (JSONException e) {
                    
                    e.printStackTrace();
                }
                JSONObject info = new JSONObject();
                try {
                    info.put("body", body); // Notification body
                } catch (JSONException e) {
                    
                    e.printStackTrace();
                }
                try {
                    json.put("notification", info);
                } catch (JSONException e) {
                    
                    e.printStackTrace();
                }

                OutputStreamWriter wr = null;
                try {
                    wr = new OutputStreamWriter(conn.getOutputStream());
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
                try {
                    wr.write(json.toString());
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
                try {
                    wr.flush();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
                try {
                    conn.getInputStream();
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }

               
            }
       

}
