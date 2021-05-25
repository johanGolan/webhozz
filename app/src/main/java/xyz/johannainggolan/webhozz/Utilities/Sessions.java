package xyz.johannainggolan.webhozz.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

import java.security.Key;

public class Sessions {
    private SharedPreferences prefs =null;
    private static Sessions instance=null;

    private Sessions(Context context){
        prefs = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }
    public static Sessions getInstance(Context context){
        if(instance==null) instance = new Sessions(context);
        return instance;
    }
    public void setToken(String token){
        //void itu artinya sudah bisa membalikan nilainnya sendiri
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KeyUtil.SESSION_TOKEN,token);
        editor.apply();
    }

    public String invokeToken(){
        return prefs.getString(KeyUtil.SESSION_TOKEN,"");
    }



}
