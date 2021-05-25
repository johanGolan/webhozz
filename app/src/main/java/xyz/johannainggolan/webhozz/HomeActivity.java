package xyz.johannainggolan.webhozz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import xyz.johannainggolan.webhozz.Utilities.KeyUtil;

public class HomeActivity extends AppCompatActivity {

    //Databinding

    //variable object view TextView
    TextView tvNumberPlate, tvNameOwner = null;
    TextView tvLocation, tvBodyNumber = null;

    Bundle args = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menjalankan view activity_main
        setContentView(R.layout.activity_main);
        //deklarasi
        initView();
        //mengisi text di dalam textview
        setValueTextview();
    }

    //Method yang mempunyai tugas untuk mengumpulkan variable view
    //private = Indetifier dari method tersebut untuk tidak dapat di akses oleh class lain
    private void initView(){
        args = getIntent().getExtras();
        tvNumberPlate = findViewById(R.id.tvNumberPlate);
        tvNameOwner = findViewById(R.id.tvNameOwner);
        tvLocation = findViewById(R.id.tvLocation);
        tvBodyNumber = findViewById(R.id.tvBodyNumber);
    }

    private void setValueTextview(){
        if(args!=null){
            tvNumberPlate.setText(args.getString(KeyUtil.SAVED_EMAIL));
            tvNameOwner.setText(args.getString(KeyUtil.SAVED_PASSWORD));
        }
        tvLocation.setText("Denpasar");
        tvBodyNumber.setText("CHGN23984729847");
    }

}