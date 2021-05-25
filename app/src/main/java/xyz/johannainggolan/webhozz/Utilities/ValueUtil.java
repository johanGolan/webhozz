package xyz.johannainggolan.webhozz.Utilities;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;

import xyz.johannainggolan.webhozz.R;

public class ValueUtil {

    public static String showValueifNull(String value){
        if(value.isEmpty() || value==null){
            return "-";
        }
        else{
            return value;
        }
    }

    public static void shoutMessage(Context context,String message){
        Toast.makeText(context, message == null ? "" : message, Toast.LENGTH_SHORT).show();
    }

    public static void setImageFromUrl(Context context, String urlImage, AppCompatImageView imageView){
        Glide.with(context)
                .load(urlImage)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

}
