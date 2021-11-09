package com.senseen.stellioApi;

import com.senseen.stellioApi.models.*;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.List;

public interface StellioApi {

    @GET("/ngsi-ld/v1/entities/{id}")
    @NotNull
    Call<ResponseBody> getEntityById(@Path("id")String id, @HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities")
    @NotNull
    Call<ResponseBody> getEntitiesByType(@Query ("type") String type, @HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities?type=Person")
    @NotNull
    Call<List<PersonJson>> getListEntitiesPerson(@HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities?type=AgriCrop")
    @NotNull
    Call<List<AgriCropJson>> getListEntitiesAgriCrop(@HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities?type=AgriCropRecord")
    @NotNull
    Call<List<AgriCropRecordJson>> getListEntitiesAgriCropRecord(@HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities?type=Device")
    @NotNull
    Call<List<DeviceJson>> getListEntitiesDevice(@HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities/{id}")
    @NotNull
    Call<PersonJson> getEntityPersonById(@Path("id")String id, @HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities/{id}")
    @NotNull
    Call<AgriCropJson> getEntityAgriCropById(@Path("id")String id, @HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities/{id}")
    @NotNull
    Call<AgriCropRecordJson> getEntityAgriCropRecordById(@Path("id")String id, @HeaderMap HashMap<String,String> headers);

    @GET("/ngsi-ld/v1/entities/{id}")
    @NotNull
    Call<DeviceJson> getEntityDeviceById(@Path("id")String id, @HeaderMap HashMap<String,String> headers);

    @POST("/ngsi-ld/v1/entities")
    @NotNull
    Call<ResponseBody> createEntity(@HeaderMap HashMap<String,String> headers, @Body RequestBody body);

    @PATCH("/ngsi-ld/v1/entities/{id}/attrs")
    @NotNull
    Call<ResponseBody> patchEntity(@Path("id")String id, @HeaderMap HashMap<String,String> headers, @Body RequestBody body);

    @POST("/ngsi-ld/v1/entities/{id}/attrs")
    @NotNull
    Call<ResponseBody> putEntity(@Path("id")String id, @HeaderMap HashMap<String,String> headers, @Body RequestBody body);

    @DELETE("/ngsi-ld/v1/entities/{id}")
    @NotNull
    Call<ResponseBody> deleteEntity(@Path("id")String id, @HeaderMap HashMap<String,String> headers);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/auth/realms/stellio/protocol/openid-connect/token")
    @NotNull
    Call<Token> connexion(@Body RequestBody body);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/auth/realms/stellio/protocol/openid-connect/token")
    @NotNull
    Call<Token> connexionWithCode(@Body RequestBody body);


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("/auth/realms/stellio/protocol/openid-connect/token")
    @NotNull
    Call<Token> refreshToken(@Body RequestBody body);

    @POST("/auth/realms/stellio/protocol/openid-connect/userinfo")
    @NotNull
    Call<String> getUserInfos(@Header("Authorization") String accessToken);

}
