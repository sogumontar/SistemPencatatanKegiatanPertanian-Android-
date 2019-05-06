package uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import uts2019.develops.stud11417010.sistempencatatankegiatanpertanian.Model.Hasil;

public interface API {
   
    @POST("createuser")
    Call<ResponseBody> createuser(
            @Field("nama")String nama,
            @Field("kelas")String kelas,
            @Field("nim")String nim
    );


    @GET("hasil")
    Call<Hasil> getUser(
    );
}
