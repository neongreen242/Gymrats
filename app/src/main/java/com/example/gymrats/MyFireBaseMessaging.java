package com.example.gymrats;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.parse.ParseUser;

import org.w3c.dom.Text;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyFireBaseMessaging extends FirebaseMessagingService {

    private RemoteMessage message;
    public static final String TAG = "FIREBASE MESSAGING";
    public static final String SEND_NOTIFICATION_URL = "https://fcm.googleapis.com/fcm/send";

    public MyFireBaseMessaging() {
    }

    @Override
    public void onMessageReceived(RemoteMessage message) {
        super.onMessageReceived(message);
        handleMessage(message);
        this.message = message;
        Log.e(TAG, "Received message"+ message.getNotification().getBody());
    }

    private void handleMessage(RemoteMessage message) {

        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext(),  message.getNotification().getBody(), Toast.LENGTH_LONG).show();

            }
        });

    }

    public static void sendNotification(String title, String body) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    MediaType mediaType = MediaType.parse("application/json");
                    String content = "{\n  \"to\":\"" + FirebaseMessaging.getInstance().getToken() + "\"," +
                            "\n  \"content_available\": true,\n  \"priority\": \"high\",\n  \"notification\": {\n " +
                            "\"title\": \"" + title + "\",\n      " +
                            "\"body\": \"" + body + "\"\n   }\n}" ;
                    RequestBody body = RequestBody.create(mediaType, content);
                    Request request = new Request.Builder()
                            .url(SEND_NOTIFICATION_URL)
                            .method("POST", body)
                            .addHeader("Content-Type", "application/json")
                            .addHeader("Authorization", "key=" + R.string.FIREBASE_API_KEY)
                            .build();
                    Response response = client.newCall(request).execute();
                } catch (Exception e) {
                    Log.e(TAG, "Problem with notifying", e);
                }
            }
        });
        thread.start();
    }

    public RemoteMessage getMessage() {
        return message;
    }
}



