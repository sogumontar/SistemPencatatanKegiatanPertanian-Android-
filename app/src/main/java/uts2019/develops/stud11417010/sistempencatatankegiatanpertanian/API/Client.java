package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL="http://10.0.3.2/API/public/";
    private static  Client mInstance ;
    private Retrofit retrofit;
    private Client(){
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized  Client getInstance(){
        if(mInstance== null){
            mInstance=new Client();
        }
        return mInstance;
    }
    public API getApi(){
        return retrofit.create(API.class);
    }
}
