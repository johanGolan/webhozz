package xyz.johannainggolan.webhozz.Responses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("token")
    String token=null;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
