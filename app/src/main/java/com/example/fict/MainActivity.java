package com.example.fict;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    String RESPONES = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Animation();
        TextView textView = findViewById(R.id.get);
            textView.setText("--");
    }


    public void Animation(){
        final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation animAlpha1 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation animAlpha2 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation animAlpha3 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation animAlpha4 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        final Animation animAlpha5 = AnimationUtils.loadAnimation(this, R.anim.alpha);

        ImageButton btnAlpha = findViewById(R.id.Humidity);
        btnAlpha.setOnClickListener(new Button.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha);
                TextView textView = findViewById(R.id.get);
                textView.setText("96%");


            }

        });

        btnAlpha.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Humidity.class);
                startActivity(intent);
                return true;
            }
        });
        //----------------------------------------------------------------------------

        ImageButton btnAlpha1 = findViewById(R.id.Light);
        btnAlpha1.setOnClickListener(new Button.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha1);
                TextView textView = findViewById(R.id.get);
                textView.setText("30 lux");
            }
        });

        btnAlpha1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Light.class);
                startActivity(intent);
                return true;
            }
        });

//---------------------------------------------------------------------------------------------

        ImageButton btnAlpha2 = findViewById(R.id.Smoke);
        btnAlpha2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha2);
                TextView textView = findViewById(R.id.get);
                textView.setText("9%");

            }
        });
        btnAlpha2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Gas.class);
                startActivity(intent);
                return true;
            }
        });

        ImageButton btnAlpha3 = findViewById(R.id.Temperature);
        btnAlpha3.setOnClickListener(new Button.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha3);
               // Response("");
               // Parsing parsing = new Parsing();
               // parsing.getLastValues(RESPONES,1);
                TextView textView = findViewById(R.id.get);
                textView.setText("--");
            }
        });
        btnAlpha3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Humidity.class);

                startActivity(intent);
                return true;
            }
        });

        ImageButton btnAlpha4 = findViewById(R.id.Snow);
        btnAlpha4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha4);
                TextView textView = findViewById(R.id.get);
                textView.setText("0%");
            }
        });
        btnAlpha4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Humidity.class);

                startActivity(intent);
                return true;
            }
        });

        ImageButton btnAlpha5 = findViewById(R.id.Rain);
        btnAlpha5.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(animAlpha5);
                TextView textView = findViewById(R.id.get);
                textView.setText("0%");

            }
        });
        btnAlpha5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Humidity.class);

                startActivity(intent);
                return true;
            }
        });

    }



    @SuppressLint("StaticFieldLeak")
    public void Response (final  String url) {
        final AsyncTask connection_error_ = new AsyncTask<Void, Void, ResponseBody>() {
            @SuppressLint("ShowToast")
            @Override
            protected ResponseBody doInBackground(Void... voids) {
                OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(url)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                     RESPONES  = response.body().string();

                } catch (final IOException e) {
                    runOnUiThread(new Runnable() {
                        @SuppressLint("LongLogTag")
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Oops " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (final Exception e) {
                    e.getStackTrace();
                }
                return  null;
            }

        }.execute();

    }
}
