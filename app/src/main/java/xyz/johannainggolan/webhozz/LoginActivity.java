package xyz.johannainggolan.webhozz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.johannainggolan.webhozz.Model.LoginDataModel;
import xyz.johannainggolan.webhozz.Networking.NetworkClient;
import xyz.johannainggolan.webhozz.Networking.NetworkingInterface;
import xyz.johannainggolan.webhozz.Responses.LoginResponse;
import xyz.johannainggolan.webhozz.Utilities.KeyUtil;
import xyz.johannainggolan.webhozz.Utilities.MessageUtil;
import xyz.johannainggolan.webhozz.Utilities.Sessions;
import xyz.johannainggolan.webhozz.Utilities.ValueUtil;

public class LoginActivity extends AppCompatActivity {

    AppCompatEditText edEmail, edPassword = null; // memory di garbage collector java runtime tidak berat
    AppCompatButton btnSignin,btnForgotPassword = null;
    NetworkingInterface networkService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String varEmail = edEmail.getText().toString().trim();
                String varPass  = edPassword.getText().toString().trim();
                validationSignin(varEmail,varPass);
            }
        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToForgotPassword = new Intent(LoginActivity.this,ForgotActivity.class);
                startActivity(goToForgotPassword);
            }
        });
    }

    private void initView(){
        networkService = NetworkClient.getClient().create(NetworkingInterface.class); // constructor
        edEmail = findViewById(R.id.edt_email);
        edPassword = findViewById(R.id.edt_password);
        btnSignin = findViewById(R.id.btn_signin);
        btnForgotPassword = findViewById(R.id.btn_forgot_password);
    }

    private void validationSignin(String varEmail, String varPassword){
        if(varEmail.equals("") && varPassword.equals("")){
            shoutMessage(MessageUtil.NO_INPUT_EMAILPASSWORD);
        }
        else if(varEmail.equals("")){
            shoutMessage(MessageUtil.NO_INPUT_EMAIL);
        }
        else if(varPassword.equals("")){
            shoutMessage(MessageUtil.NO_INPUT_PASSWORD);
        }
        else{
            //sudah data yang valid
            LoginDataModel loginDataModel = new LoginDataModel(varEmail,varPassword);

            //jadiin raw data
            try {
                Map<String,Object> data=new HashMap<>();
                data.put(KeyUtil.JSON_OBJECT_EMAIL,loginDataModel.getEmail());
                data.put(KeyUtil.JSON_OBJECT_PASSWORD,loginDataModel.getPassword());

                Call<LoginResponse> callAuth = networkService.getDataAuth(data);
                //asynchoronous untuk memanggil service api

                callAuth.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Log.d("trace-jsonurl", call.request().url().toString());
                        if(response.code()==200){
                             Log.d("trace-datalogin", response.body().toString());
                            ValueUtil.shoutMessage(LoginActivity.this,"Berhasil authentikasi");
                            handleIntent(varEmail,varPassword);
                        }
                        else{
                           // Sessions.getInstance(LoginActivity.this).setToken("abcdabcd");
                            ValueUtil.shoutMessage(LoginActivity.this,"Data tidak valid");
                            //handleIntent(varEmail,varPassword);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        ValueUtil.shoutMessage(LoginActivity.this,t.getMessage());
                    }
                });


            }
            catch (Exception e){
                //log ke server khusus
                e.printStackTrace();
            }

            //handleIntent(varEmail,varPassword);
        }
    }

    private void shoutMessage(String message){
        Toast.makeText(this, message == null ? "" : message, Toast.LENGTH_SHORT).show();
    }

    private void handleIntent(String varEmail, String varPass){
        /*Intent intentToHome = new Intent(LoginActivity.this, HomeActivity.class);
        intentToHome.putExtra(KeyUtil.SAVED_EMAIL, varEmail);
        intentToHome.putExtra(KeyUtil.SAVED_PASSWORD, varPass);
        startActivity(intentToHome);
        finish();
        */

        /*Intent intentToData = new Intent(LoginActivity.this, KendaraanActivity.class);
        startActivity(intentToData);
        finish();*/

       /* Intent intentToData = new Intent(LoginActivity.this, PhotosActivity.class);
        startActivity(intentToData);
        finish();*/

        Intent intentToData = new Intent(LoginActivity.this, ForgotActivity.class);
        startActivity(intentToData);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!Sessions.getInstance(LoginActivity.this).invokeToken().isEmpty()){
            Intent gotoHome = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(gotoHome);
        }
    }
}