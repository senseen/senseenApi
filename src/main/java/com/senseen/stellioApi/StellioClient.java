package com.senseen.stellioApi;

import com.senseen.stellioApi.adapter.AgriCropAdapter;
import com.senseen.stellioApi.adapter.AgriCropRecordAdapter;
import com.senseen.stellioApi.adapter.DeviceAdapter;
import com.senseen.stellioApi.adapter.PersonAdapter;
import com.senseen.stellioApi.models.*;
import com.squareup.moshi.Moshi;
import kotlin.jvm.Synchronized;
import okhttp3.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StellioClient {
    private static  String baseUrl = null;
    private static  String connexionUrl = null;
    private static StellioClient stellioClient = null;
    private StellioApi stellioApi=null;
    private Retrofit retrofit = null;
    private HashMap<String,String> hashMap =null;
    private RequestBody body = null;
    private String accessToken=null;
    private String refreshAccessToken = null;
    private int expireIn ;
    private int refreshExpireIn;
    private int connexionTime;
    private Token token=null;
    Logger logger = null;

    public StellioClient(String connexionUrl, String baseUrl){
        this.connexionUrl=connexionUrl;
        this.baseUrl=baseUrl;
    }

    private Retrofit buildRetrofit(String baseUrl){
        Moshi moshi = new Moshi.Builder().build();
        MoshiConverterFactory moshiConverterFactory = MoshiConverterFactory.create(moshi);
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                //.addConverterFactory(JacksonConverterFactory.create())
                //.addConverterFactory(moshiConverterFactory)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    @Synchronized
    private Retrofit getRetrofit(String baseUrl){
        synchronized (this){
            if(retrofit==null){
                retrofit=buildRetrofit(baseUrl);
            }
            else if (!retrofit.baseUrl().equals(baseUrl)){
                retrofit=buildRetrofit(baseUrl);
            }
            return retrofit;
        }
    }

    private StellioApi getApi(String baseUrl){
        synchronized (this){
            if(stellioApi==null){
                stellioApi=getRetrofit(baseUrl).create(StellioApi.class);
            }
            else if (!retrofit.baseUrl().equals(baseUrl)){
                stellioApi=getRetrofit(baseUrl).create(StellioApi.class);
            }
            return stellioApi;
        }
    }

    //Permet de se connecter au sso avec client_id et client_secret
    public String connexion(String clientId, String clientSecret) throws IOException {
        body = getBodyConnexion(clientId,clientSecret);

        Call<Token> req = getApi(connexionUrl).connexion(body);
        Response<Token> res =req.execute();
        token=res.body();
        if(res.isSuccessful()){
            return res.message();
        }
        else{
            Logger.getLogger("connexion").log(Level.WARNING,res.errorBody().string());
            return res.errorBody().string();
        }
    }

    //Permet de se connecter au sso en echange d'un code
    public String connexionWithCode(String clientId, String clientSecret, String code, String redirectUri) throws IOException {
        body = getBodyConnexionWithCode(clientId,clientSecret, code, redirectUri);

        Call<Token> req = getApi(connexionUrl).connexionWithCode(body);
        Response<Token> res =req.execute();
        token=res.body();
        if(res.isSuccessful()){
            return res.message();
        }
        else{
            Logger.getLogger("connexion").log(Level.WARNING,res.errorBody().string());
            return res.errorBody().string();
        }
    }

    public String refreshToken(String clientId, String clientSecret) throws IOException {
        body = getBodyRefreshToken(clientId, clientSecret);

        Call<Token> req = getApi(connexionUrl).refreshToken(body);
        Response<Token> res =req.execute();
        token=res.body();
        if(res.isSuccessful()){
            return res.message();
        }
        else{
            Logger.getLogger("connexion").log(Level.WARNING,res.errorBody().string());
            return res.errorBody().string();
        }
    }

    public String getUserInfos() throws IOException {
        Call<String> req = getApi(connexionUrl).getUserInfos("Bearer "+token.getAccess_token());
        Response<String> res =req.execute();
        if(res.isSuccessful()){
            return res.body();
        }
        else{
            Logger.getLogger("connexion").log(Level.WARNING,res.errorBody().string());
            return res.errorBody().string();
        }
    }

    public Token getToken() throws IOException {
        return token;
    }

    public void setToken(String accessToken, String refreshToken, int expireIn, int refreshExpireIn) throws IOException {
        token = new Token(accessToken, refreshToken, expireIn, refreshExpireIn);
    }

    //permet de creer entity
    public String createEntity(String mainObject) throws IOException {
        hashMap=getHeadersCreate();
        body = RequestBody.create(mainObject, MediaType.get("application/json"));
        Call<ResponseBody> req = getApi(baseUrl).createEntity(hashMap,body);
        Response<ResponseBody> res = req.execute();

        if(res.isSuccessful()){
            return String.valueOf(res.code());
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return String.valueOf(res.code());
        }
    }

    //permet de patch entity
    public String patchEntity(String id, String mainObject) throws IOException {
        hashMap=getHeadersCreate();
        body = RequestBody.create(mainObject, MediaType.get("application/json"));
        Call<ResponseBody> req = getApi(baseUrl).patchEntity(id, hashMap, body);
        Response<ResponseBody> res = req.execute();

        if(res.isSuccessful()){
            return String.valueOf(res.code());
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return String.valueOf(res.code());
        }
    }

    //permet de put entity (addAttribut)
    public String putEntity(String id, String mainObject) throws IOException {
        hashMap=getHeadersCreate();
        body = RequestBody.create(mainObject, MediaType.get("application/json"));
        Call<ResponseBody> req = getApi(baseUrl).putEntity(id, hashMap, body);
        Response<ResponseBody> res = req.execute();

        if(res.isSuccessful()){
            return String.valueOf(res.code());
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return String.valueOf(res.code());
        }
    }

    //permet de delete entity
    public String deleteEntity(String id, String mainObject) throws IOException {
        hashMap=getHeaders();
        //body = RequestBody.create(mainObject, MediaType.get("application/json"));
        Call<ResponseBody> req = getApi(baseUrl).deleteEntity(id, hashMap);
        Response<ResponseBody> res = req.execute();

        if(res.isSuccessful()){
            return String.valueOf(res.code());
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return String.valueOf(res.code());
        }
    }


    //permet de retourner toutes les entités par rapport à un type
    public String getEntitiesByType(String query) throws IOException {
        hashMap=getHeaders();

        Call<ResponseBody> req = getApi(baseUrl).getEntitiesByType(query,hashMap);
        Response<ResponseBody> res = req.execute();

        if(res.isSuccessful()){
            return res.body().string();
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return res.toString();
        }
    }

    //permet de retourner toutes les entités Person sous forme de list
    public List<Person> getListEntitiesPerson() throws IOException {
        hashMap=getHeaders();

        Call<List<PersonJson>> req = getApi(baseUrl).getListEntitiesPerson(hashMap);
        Response<List<PersonJson>> res = req.execute();

        if(res.isSuccessful()){
            List<Person> list = new ArrayList<>(getListPerson(res.body()));
            return list;
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return null;
        }
    }

    //permet de retourner toutes les entités AgriCrop sous forme de list
    public List<AgriCrop> getListEntitiesAgriCrop() throws IOException {
        hashMap=getHeaders();

        Call<List<AgriCropJson>> req = getApi(baseUrl).getListEntitiesAgriCrop(hashMap);
        Response<List<AgriCropJson>> res = req.execute();

        if(res.isSuccessful()){
            List<AgriCrop> list = new ArrayList<>(getListAgriCrop(res.body()));
            return list;
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return null;
        }
    }

    //permet de retourner toutes les entités AgriCropRecord sous forme de list
    public List<AgriCropRecord> getListEntitiesAgriCropRecord() throws IOException {
        hashMap=getHeaders();

        Call<List<AgriCropRecordJson>> req = getApi(baseUrl).getListEntitiesAgriCropRecord(hashMap);
        Response<List<AgriCropRecordJson>> res = req.execute();

        if(res.isSuccessful()){
            List<AgriCropRecord> list = new ArrayList<>(getListAgriCropRecord(res.body()));
            return list;
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return null;
        }
    }

    //permet de retourner toutes les entités Device sous forme de list
    public List<Device> getListEntitiesDevice() throws IOException {
        hashMap=getHeaders();

        Call<List<DeviceJson>> req = getApi(baseUrl).getListEntitiesDevice(hashMap);
        Response<List<DeviceJson>> res = req.execute();

        if(res.isSuccessful()){
            List<Device> list = new ArrayList<>(getListDevice(res.body()));
            return list;
        }
        else{
            Logger.getLogger("entitiesType").log(Level.WARNING,res.errorBody().string());
            return null;
        }
    }

    //permet de retourner une entité par rapport à un id
    public String getEntityById(String id) throws IOException {
        hashMap=getHeaders();
        Call<ResponseBody> req = getApi(baseUrl).getEntityById(id,hashMap);
        Response<ResponseBody> res = req.execute();

        if(res.isSuccessful()){
            return res.body().string();
        }
        else{
            Logger.getLogger("getEntityPersonById").log(Level.WARNING,res.errorBody().string());
            return res.errorBody().string();
        }
    }

    //permet de retourner l'entité Person par rapport à un id
    public Person getEntityPersonById(String id) throws IOException {
        hashMap=getHeaders();
        Call<PersonJson> req = getApi(baseUrl).getEntityPersonById(id,hashMap);
        Response<PersonJson> res = req.execute();

        if(res.isSuccessful()){
            Person person = new PersonAdapter().personFromJson(res.body());
            return person;
        }
        else{
            Logger.getLogger("getEntityPersonById").log(Level.WARNING,res.errorBody().string());
           // Log.i("Retrofit Error", String.valueOf(res.errorBody()));
            return null;
        }
    }

    //permet de retourner l'entité AgriCrop par rapport à un id
    public AgriCrop getEntityAgriCropById(String id) throws IOException {
        hashMap=getHeaders();
        Call<AgriCropJson> req = getApi(baseUrl).getEntityAgriCropById(id,hashMap);
        Response<AgriCropJson> res = req.execute();

        if(res.isSuccessful()){
            AgriCrop agriCrop = new AgriCropAdapter().agriCropFromJson(res.body());
            return agriCrop;
        }
        else{
            Logger.getLogger("getEntityPersonById").log(Level.WARNING,res.errorBody().string());
            // Log.i("Retrofit Error", String.valueOf(res.errorBody()));
            return null;
        }
    }


    //permet de retourner l'entité AgriCropRecord par rapport à un id
    public AgriCropRecord getEntityAgriCropRecordById(String id) throws IOException {
        hashMap=getHeaders();
        Call<AgriCropRecordJson> req = getApi(baseUrl).getEntityAgriCropRecordById(id,hashMap);
        Response<AgriCropRecordJson> res = req.execute();

        if(res.isSuccessful()){
            AgriCropRecord agriCropRecord = new AgriCropRecordAdapter().agriCropRecordFromJson(res.body());
            return agriCropRecord;
        }
        else{
            Logger.getLogger("getEntityPersonById").log(Level.WARNING,res.errorBody().string());
            // Log.i("Retrofit Error", String.valueOf(res.errorBody()));
            return null;
        }
    }

    //permet de retourner l'entité person par rapport à un id
    public Device getEntityDeviceById(String id) throws IOException {
        hashMap=getHeaders();
        Call<DeviceJson> req = getApi(baseUrl).getEntityDeviceById(id,hashMap);
        Response<DeviceJson> res = req.execute();

        if(res.isSuccessful()){
            Device device = new DeviceAdapter().deviceFromJson(res.body());
            return device;
        }
        else{
            Logger.getLogger("getEntityPersonById").log(Level.WARNING,res.errorBody().string());
            // Log.i("Retrofit Error", String.valueOf(res.errorBody()));
            return null;
        }
    }

    private RequestBody getBodyConnexion(String clientId, String clientSecret){
        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type","client_credentials")
                .add("client_id",clientId)
                .add("client_secret",clientSecret)
                .build();
        return requestBody;
    }



    private RequestBody getBodyConnexionWithCode(String clientId, String clientSecret, String code, String redirectUri){
        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type","authorization_code")
                .add("client_id",clientId)
                .add("client_secret",clientSecret)
                .add("code", code)
                .add("redirect_uri",redirectUri)
                .build();
        return requestBody;
    }

    private RequestBody getBodyRefreshToken(String clientId, String clientSecret){
        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type", "refresh_token")
                .add("client_id", clientId)
                .add("client_secret", clientSecret)
                .add("refresh_token", token.getRefresh_token())
                .build();
        return requestBody;
    }

    private HashMap<String,String> getHeaders(){
        hashMap=new HashMap<>();
        hashMap.put("Authorization", "Bearer "+token.getAccess_token());
        hashMap.put("Link", "<https://raw.githubusercontent.com/senseen/ngsild-api-data-models/main/jsonld-contexts/scanSmartMeter-compound.jsonld>; rel=http://www.w3.org/ns/json-ld#context; type=application/json");
        return hashMap;
    }

    private HashMap<String,String> getHeadersCreate(){
        hashMap=new HashMap<>();
        hashMap.put("Authorization", "Bearer "+token.getAccess_token());
        hashMap.put("Content-Type", "application/ld+json");
        return hashMap;
    }

    private HashMap<String,String> getHeadersPatch(){
        hashMap=new HashMap<>();
        hashMap.put("Authorization", "Bearer "+token.getAccess_token());
        hashMap.put("Content-Type", "application/ld+json");
        hashMap.put("Link", "<https://raw.githubusercontent.com/senseen/ngsild-api-data-models/main/jsonld-contexts/scanSmartMeter-compound.jsonld>; rel=http://www.w3.org/ns/json-ld#context; type=application/json");
        return hashMap;
    }

    public List<Person> getListPerson(List<PersonJson> personJsonList){
        List<Person> personList = new ArrayList<>();
        for(int i=0;i<personJsonList.size();i++){
            personList.add(new PersonAdapter().personFromJson(personJsonList.get(i)));
        }
        return personList;
    }

    public List<AgriCrop> getListAgriCrop(List<AgriCropJson> agriCropJsonList){
        List<AgriCrop> agriCropList = new ArrayList<>();
        for(int i=0;i<agriCropJsonList.size();i++){
            agriCropList.add(new AgriCropAdapter().agriCropFromJson(agriCropJsonList.get(i)));
        }
        return agriCropList;
    }

    public List<AgriCropRecord> getListAgriCropRecord(List<AgriCropRecordJson> agriCropRecordJsonList){
        List<AgriCropRecord> agriCropRecordList = new ArrayList<>();
        for(int i=0;i<agriCropRecordJsonList.size();i++){
            agriCropRecordList.add(new AgriCropRecordAdapter().agriCropRecordFromJson(agriCropRecordJsonList.get(i)));
        }
        return agriCropRecordList;
    }

    public List<Device> getListDevice(List<DeviceJson> deviceJsonList){
        List<Device> deviceList = new ArrayList<>();
        for(int i=0;i<deviceJsonList.size();i++){
            deviceList.add(new DeviceAdapter().deviceFromJson(deviceJsonList.get(i)));
        }
        return deviceList;
    }

}
