package com.example.lks.Rest;



import com.example.lks.datauser.Model.GetNotes;
import com.example.lks.datauser.Model.PostPutDelNotes;
import com.example.lks.login.Login;
import com.example.lks.nilaikuis.PostPutDelNotess;
import com.example.lks.soal.GetSoal;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface ApiInterface {
    //Register
    @Multipart
    @POST("restapi.php")
    Call<PostPutDelNotes> postNotes(@Query("function") String function,
                                    @Part("tipe_user") RequestBody tipe_user,
                                    @Part("nama") RequestBody nama,
                                    @Part("alamat") RequestBody alamat,
                                    @Part("username") RequestBody username,
                                    @Part("telepon") RequestBody telepon,
                                    @Part("password") RequestBody password);
    //Login
    @FormUrlEncoded
    @POST("loginapi.php")
    Call<Login> loginResponse(
            @Field("username") String username,
            @Field("password") String password
    );
    //Ambil semua soal
    @GET("restapi_soal.php")
    Call<GetSoal> getSoal(@Query("function") String function);


    //masukin nilai
    @Multipart
    @POST("restapi.php")
    Call<PostPutDelNotess> postNotess(@Query("function") String function,
                                      @Part("id_user") RequestBody id_user,
                                      @Part("nilai") RequestBody nilai,
                                      @Part("benar") RequestBody benar,
                                      @Part("salah") RequestBody salah,
                                      @Part("kosong") RequestBody kosong,
                                      @Part("jawaban") RequestBody jawaban
    );

}
