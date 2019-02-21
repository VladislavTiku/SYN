package com.example.fict;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class Parsing {
    private String Val;
    private String Val2;

    public String getVal2() {
        return Val2;
    }

    String getVal() {
        return Val;
    }




    // Повертає Значення температури
    void getLastValues(String resp, int id) {
        try {
            JSONObject myrespones = new JSONObject(resp);
            JSONArray jsonArray = myrespones.getJSONArray("data");
            JSONObject jsonObject = new JSONObject(jsonArray.getString(id));
            Val = jsonObject.getString("logvalue");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception r) {
            r.getMessage();
        }
    }

    void gethistory(String resp){
        try{
            JSONObject myrespones = new JSONObject(resp);
            JSONArray jsonArray = myrespones.getJSONArray("data");
            Val2 = jsonArray.getString(0);
        }catch (JSONException e){
            e.printStackTrace();
        }catch (Exception r){
            r.getMessage();
        }

    }
}
