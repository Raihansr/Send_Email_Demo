package com.example.rsr23.sendemaildemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button send = findViewById(R.id.send_btn);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Send_Email();
            }
        });

    }

    private void Send_Email() {

        final String From = "sender@gmail.com";  /* Set Sender Email Address */
        final String Password = "senderPassword";  /* Set Sender Email Password */
        final String To = "receiver@email.com";  /* Set Receiver Email Address */
        final String Subject = "Send Email Demo";
        final String Message = "Write Your Message";

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    GMailSender sender = new GMailSender(From, Password);
                    sender.sendMail(Subject, Message, From, To);

                    Log.d("TAG","Email Sent");

                }
                catch (Exception e) {
                    Log.e("TAG", e.getMessage(), e);
                }
            }

        }).start();
    }
}
