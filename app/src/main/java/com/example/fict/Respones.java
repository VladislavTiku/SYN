package com.example.fict;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
class Respones {
    private static final String TAG = "myLogs";
    private String RESPONES;
    private  String sensorlist = "http://13.53.149.166/sensorlist.php";


    String getRESPONES() {
        return RESPONES;
    }

    private void setRESPONES(String RESPONES) {
        this.RESPONES = RESPONES;
    }




    @SuppressLint("StaticFieldLeak")
    void Resp(final int bid, final int rid ) {

        final AsyncTask connection_error_ = new AsyncTask<Void, Void, ResponseBody>() {
            @Override
            protected ResponseBody doInBackground(Void... voids) {
                OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(sensorlist+"?bid="+bid+"&rid="+rid)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    setRESPONES(response.body().string());
                    Log.d(TAG,getRESPONES());

                } catch (final IOException e) {
                    new Runnable() {
                        @Override
                        public void run() {
                            Log.e(sensorlist, "Connection Error ", e);
                        }
                    };
                } catch (final Exception e) {
                    e.getStackTrace();
                }
                return  null;
            }

        }.execute();

    }
}
