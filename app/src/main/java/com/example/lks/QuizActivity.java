package com.example.lks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lks.Rest.ApiClient;
import com.example.lks.Rest.ApiInterface;
import com.example.lks.soal.GetSoal;
import com.example.lks.soal.Soal;
import com.example.lks.soal.SoalAdapter;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private SoalAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static HashMap<String,String> kunci;
    public static HashMap<String,String> jawaban;

    private TextView quiz;
    private TextView profile;
    private  Button simpan;

    public int jumlahSoalFix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz  = findViewById(R.id.quiz);
        profile = findViewById(R.id.profile);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);


        quiz.setOnClickListener(this);
        profile.setOnClickListener(this);

        //deklarasi untuk hashmap
        kunci = new HashMap<>();
        jawaban = new HashMap<>();


        simpan = findViewById(R.id.btn_simpan);
        simpan.setOnClickListener(this);


        //pasang recycle view
        data();

    }
    public void data(){
        try{
            Call<GetSoal> CoffeeCall = mApiInterface.getSoal("get_soal");
            CoffeeCall.enqueue(new Callback<GetSoal>() {
                @Override
                public void onResponse(Call<GetSoal> call, Response<GetSoal>
                        response) {
                    List<Soal> SoalList = response.body().getListSoal();
                    Log.d("Retrofit Get", "Jumlah Barang : " +
                            String.valueOf(SoalList.size()));
                    jumlahSoalFix = SoalList.size();

                    SoalAdapter listBarangAdapter = new SoalAdapter(SoalList);
                    mRecyclerView.setItemViewCacheSize(SoalList.size());
                    mRecyclerView.setAdapter(listBarangAdapter);

                    //Onclick
                    listBarangAdapter.setOnItemClickCallback(new SoalAdapter.OnItemClickCallback() {
                        @Override
                        //biar pas diklik tidak error
                        public void onItemClicked(Soal data) {
                            Log.d("Soal","here");
                        }
                    });
                }
                @Override
                public void onFailure(Call<GetSoal> call, Throwable t) {
                    Log.e("Retrofit Get", t.toString());
                }
            });
        }catch(Exception ex){

        }finally {
            Log.d("Ga ada eksepsi","cius g ada");
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.profile) {
            Intent dashboardprofile = new Intent(QuizActivity.this, DashboardProfileActivity.class);
            startActivity(dashboardprofile);

        }
        else if (v.getId()== R.id.quiz) {

            Intent quiz = new Intent(QuizActivity.this, QuizActivity.class);
            startActivity(quiz);


        }else if (v.getId()== R.id.btn_simpan) {

            String kuncii = "";
            String jawabann = "";
            for (String i : kunci.keySet()) {
                kuncii = kuncii +   i + " " + kunci.get(i) + " ";

            }
            Log.d("kunci",kuncii);
            for (String i : jawaban.keySet()) {
                jawabann = jawabann + jawaban.get(i) + ",";

            }

            Intent quiz = new Intent(QuizActivity.this, HasilKuis.class);
            quiz.putExtra("Kunci",kunci);
            quiz.putExtra("Jawaban",jawaban);
            quiz.putExtra("IsiJawaban",jawabann);
            quiz.putExtra("JumlahSoal",jumlahSoalFix);
            startActivity(quiz);
        }
    }
}