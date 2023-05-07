package com.example.lks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lks.Rest.ApiClient;
import com.example.lks.Rest.ApiInterface;
import com.example.lks.nilaikuis.PostPutDelNotess;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HasilKuis extends AppCompatActivity implements View.OnClickListener {


    private Button back;
    ApiInterface mApiInterface;
    public static int benar,salah,kosong,score;
    public String IsiJawaban;
    SessionManager SessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);
        SessionManager = new SessionManager(HasilKuis.this);
        HashMap<String, String> jawaban = (HashMap<String, String>) getIntent().getSerializableExtra("Jawaban");
        HashMap<String, String> kunci = (HashMap<String, String>) getIntent().getSerializableExtra("Kunci");
        IsiJawaban = (String) getIntent().getSerializableExtra("IsiJawaban");
        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);


        salah = 0;
        kosong = 0;

        int jumlah = kunci.size();
        benar = jumlah;
        Log.d("Jumlah",Integer.toString(jumlah));
        for (String i : kunci.keySet()) {
            if(jawaban.get(i).equals("NULL") == true){
                kosong++;
                benar--;
            }else if(jawaban.get(i).equals(kunci.get(i)) == false){
                salah++;
                benar--;
            }

        }

        Log.d("Benar", Integer.toString(benar));
        Log.d("Salah",Integer.toString(salah));
        Log.d("Kosong",Integer.toString(kosong));
        score = (benar * 100/jumlah) ;

        nilai.setText(Integer.toString(score));
        hasil.setText("Jawaban Benar :"+benar +"\nJawaban Salah :"+ salah + "\nJawaban Kosong : " + kosong);

        back = findViewById(R.id.btn_kembali);

        back.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btn_kembali){
            save();



        }
    }
    public void save(){

        Call<PostPutDelNotess> postHerosCall = mApiInterface.postNotess("insert_hasil",
                RequestBody.create(MediaType.parse("text/plain"), SessionManager.getUserDetail().get(SessionManager.USER_ID) ),
                RequestBody.create(MediaType.parse("text/plain"), Integer.toString(this.score) ),
                RequestBody.create(MediaType.parse("text/plain"),   Integer.toString(this.benar)),
                RequestBody.create(MediaType.parse("text/plain"), Integer.toString(this.salah)),
                RequestBody.create(MediaType.parse("text/plain"), Integer.toString(this.kosong)),
                RequestBody.create(MediaType.parse("text/plain"), this.IsiJawaban));



        postHerosCall.enqueue(new Callback<PostPutDelNotess>() {
            @Override
            public void onResponse(Call<PostPutDelNotess> call, Response<PostPutDelNotess> response) {
                //MainActivity.ma.showData();
                finish();
                startActivity(new Intent(HasilKuis.this,QuizActivity.class));

            }

            @Override
            public void onFailure(Call<PostPutDelNotess> call, Throwable t) {
                Log.d("RETRO", "ON FAILURE : " + t.getMessage());
                Log.d("RETRO", "ON FAILURE : " + t.getCause());
                Toast.makeText(getApplicationContext(), "Error, entry data", Toast.LENGTH_LONG).show();
            }
        });
    }
}