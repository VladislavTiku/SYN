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
import com.example.fict.activity.Gas;
import com.example.fict.activity.Humidity;
import com.example.fict.activity.Light;
import com.example.fict.activity.Temperature;


public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "myLogs";

    public TextView MainViewBord;



    private static  String TEMPEARTURE;
    private static String LOGDATE;
    private static String MOVE;
    private static String LIGHT ;
    private static String HUMIDITY ;

    private ImageButton humidity;
    ImageButton light;
    ImageButton gas;
    ImageButton temperature;
    ImageButton fire;
    ImageButton motion;





    public static String getHUMIDITY() {
        return HUMIDITY; }
    public static String getMOVE() {
        return MOVE;
    }
    public static String getTEMPEARTURE() {
        return TEMPEARTURE;
    }

    public static String getLIGHT() { return LIGHT; }
    public static String getLOGDATE() { return LOGDATE;  }

    public static void setHUMIDITY(String HUMIDITY) { MainActivity.HUMIDITY = HUMIDITY; }
    public static void setMOVE(String MOVE) {
        MainActivity.MOVE = MOVE;
    }

    public static void setTEMPEARTURE(String TEMPEARTURE) { MainActivity.TEMPEARTURE = TEMPEARTURE; }
    public static void setLOGDATE(String LOGDATE) {
        MainActivity.LOGDATE = LOGDATE;
    }
    public static void setLIGHT(String LIGHT) {
        MainActivity.LIGHT = LIGHT;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new getRespounes().execute();
        Animation();

        MainViewBord = findViewById(R.id.get);
        MainViewBord.setText("--");

    }



/*
{@param #getRespounes}
 */

/*
Смотреть asynctask lifecycle схема - - - - - - - (https://www.google.com/url?sa=i&source=images&cd=
&cad=rja&uact=8&ved=2ahUKEwj5heCtzevgAhVLxaYKHe4BAtoQjRx6BAgBEAQ&url=http%3A%2F%2Fprogrammerguru.com%2
Fandroid-tutorial%2Fwhat-is-asynctask-in-android%2F&psig=AOvVaw1ZcMtzsL_f1dtHIjtYYtJE&ust=1551896026619499)
 */

    @SuppressLint("StaticFieldLeak")
    class getRespounes extends AsyncTask<Void,Integer,Void> {
        Respones respones = new Respones();
        Parsing parsing = new Parsing();


        //1. Отправить запрос  получить Json
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            respones.Resp(1,1);



        }
        // 3. Показать температтуру
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            setTEMPEARTURE(parsing.getTemperatureLastValue());
            setLIGHT(parsing.getLightLastValue());
            setHUMIDITY(parsing.getHumidityLastValue());

        }

        // Что то делать при отправке запроса
        //Пока нечего, потому что запрос простой
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }
        // 2. Поместить ответ @RESPONES c класса
        // запроса на сервер @Respones в класс парсинга @Parsing
        @Override
        protected Void doInBackground(Void... voids) {
            parsing.setRESPONES(respones.getRESPONES());
            return null;
        }
    }


// FIXME: 05.03.2019 

/*
This method provides that i'm cancer
 */
void getDefoltIconsForButtons(){
        humidity.setImageResource(R.drawable.huminity_background);
        light.setImageResource(R.drawable.light_background);
        temperature.setImageResource(R.drawable.temperature_background);
        gas.setImageResource(R.drawable.gas_background);
        fire.setImageResource(R.drawable.fire_background);
        motion.setImageResource(R.drawable.motion_background);
}





    public void Animation(){
        final Animation onClickAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        humidity = findViewById(R.id.Humidity);
        light = findViewById(R.id.Light);
        temperature= findViewById(R.id.Temperature);
        gas = findViewById(R.id.Gas);
        fire = findViewById(R.id.Fire);
        motion = findViewById(R.id.Move);


/*
                        Humidity
 */
        humidity.setOnClickListener(new Button.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                view.startAnimation(onClickAnimation);
                getDefoltIconsForButtons();
                humidity.setImageResource(R.drawable.himinity_color);
                MainViewBord.setText(getHUMIDITY());


            }

        });

        humidity.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Humidity.class);
                startActivity(intent);
                return true;
            }
        });

/*
                            Light
 */
       // Drawable new_imaage = getRespounes().getDra
        light.setOnClickListener(new Button.OnClickListener(){


            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                view.startAnimation(onClickAnimation);
                MainViewBord.setText(getLIGHT());
                getDefoltIconsForButtons();
                light.setImageResource(R.drawable.light_color);



            }
        });

        light.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Light.class);
                startActivity(intent);
                return true;
            }
        });
//                              Gas
//---------------------------------------------------------------------------------------------

        gas.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(onClickAnimation);
                getDefoltIconsForButtons();
                gas.setImageResource(R.drawable.gas_color);
                MainViewBord.setText("Error");

                Toast.makeText(getApplicationContext(),"This sensor is in development",Toast.LENGTH_SHORT).show();

            }
        });
        gas.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Gas.class);
                startActivity(intent);
                return true;
            }
        });

        temperature.setOnClickListener(new Button.OnClickListener(){

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                view.startAnimation(onClickAnimation);
                MainViewBord.setText(getTEMPEARTURE());
                getDefoltIconsForButtons();
                temperature.setImageResource(R.drawable.temperature_color);


            }
        });
        temperature.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Temperature.class);
                startActivity(intent);
                return true;
            }
        });

        fire.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(onClickAnimation);
                getDefoltIconsForButtons();
                fire.setImageResource(R.drawable.fire_color);
                MainViewBord.setText("--");

            }
        });
        fire.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Humidity.class);
                startActivity(intent);
                return true;
            }
        });

        motion.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                view.startAnimation(onClickAnimation);
                getDefoltIconsForButtons();
                motion.setImageResource(R.drawable.motion_color);
                MainViewBord.setText("Move");

            }
        });
        motion.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent  = new Intent(MainActivity.this, Humidity.class);
                startActivity(intent);
                return true;
            }
        });

    }
}