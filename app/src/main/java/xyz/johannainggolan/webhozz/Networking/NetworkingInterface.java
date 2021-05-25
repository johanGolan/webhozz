package xyz.johannainggolan.webhozz.Networking;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import xyz.johannainggolan.webhozz.Model.LoginDataModel;
import xyz.johannainggolan.webhozz.Model.PhotosModel;
import xyz.johannainggolan.webhozz.Responses.LoginResponse;
import xyz.johannainggolan.webhozz.Utilities.NetworkUtil;

public interface NetworkingInterface {
    @GET(NetworkUtil.ROUTING_PHOTOS)
    Call<List<PhotosModel>> getPhotosFromServer();

    @Headers("Content-Type: application/json")
    @POST(NetworkUtil.ROUTING_AUTHENTICATION)
    Call<LoginResponse> getDataAuth( @Body Map<String,Object> dataLogin);


}
