package xyz.johannainggolan.webhozz.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import xyz.johannainggolan.webhozz.Utilities.NetworkUtil;

public class NetworkClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit =
                    new Retrofit.Builder()
                            .baseUrl(NetworkUtil.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addConverterFactory(ScalarsConverterFactory.create())
                            .build();
        }
        return retrofit;
    }
}
