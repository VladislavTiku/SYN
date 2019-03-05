package com.example.fict;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
class Parsing {


    private String RESPONES;
    private static final String TAG = "myLogs";
    private int id;
    private String value;

    void setRESPONES(String RESPONES) {
        this.RESPONES = RESPONES;
    }
    private void setValue(String value) {
        this.value = value;
    }
    private int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }
/*
Light ID=6
 */
String getLightLastValue(){
        getLastValueSensor(6);
        return value;
}
String getTemperatureLastValue(){
        getLastValueSensor(1);
        return value;
}
String getHumidityLastValue(){
        getLastValueSensor(2);
        return value;
}

/*
@ Лайтовий парсинг. Потому что уже следующие датчики
    будут розмещены в других аудиториях и нужно будет парсить запрос @roomlist
    и @sensorlist чтобы коректно отображать данные.




    getTemperarureLastValue return a last value, in a paramets were includes
    @ID and @RESPONES. It's not responsability but efficiently
 */


    private void getLastValueSensor(int id){
        if (RESPONES !=null) {
            try {
                JSONObject jsonObject = new JSONObject(RESPONES);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                for (int i = 0; i <=jsonArray.length()+1; i++) {
                    JSONObject jsonObject1 = new JSONObject(jsonArray.getString(i));
                    setId(jsonObject1.getInt("id"));
                    Log.d(TAG,"ID на итерации "+i+" = "+getId());
                    if(getId()==id){
                        setValue(jsonObject1.getString("logvalue"));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else {
            setValue("Empty set");

        }
    }

}
