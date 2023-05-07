package com.example.lks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks.Rest.ApiClient;
import com.example.lks.Rest.ApiInterface;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardProfileActivity extends AppCompatActivity implements View.OnClickListener {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static DashboardProfileActivity ma;
    TextView etName, etTelepon, etAlamat;
    Button  btLogout;
    SessionManager sessionManager;
    String  name, telepon, alamat;
    ImageView btDashMenu, btDashProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_profile);
        sessionManager = new SessionManager(DashboardProfileActivity.this);
        if (!sessionManager.isLoggedIn()) {
            moveToLogin();
        }


        etName = findViewById(R.id.p_nama);
        etTelepon = findViewById(R.id.p_telepon);
        etAlamat = findViewById(R.id.p_alamat);
        btLogout = findViewById(R.id.btn_logout);
        btDashMenu= findViewById(R.id.btdashquiz);
        btDashProfile = findViewById(R.id.btdashprofile);

        name = sessionManager.getUserDetail().get(SessionManager.NAME);
        telepon = sessionManager.getUserDetail().get(SessionManager.TELEPON);
        alamat = sessionManager.getUserDetail().get(SessionManager.ALAMAT);



        etName.setText(name);
        etTelepon.setText(telepon);
        etAlamat.setText(alamat);



        btDashProfile.setOnClickListener(this);
        btDashMenu.setOnClickListener(this);



        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                moveToLogin();
            }
        });


    }

    private void moveToLogin() {
        Intent intent = new Intent(DashboardProfileActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btdashprofile) {
            Intent dashboardprofile = new Intent(DashboardProfileActivity.this, DashboardProfileActivity.class);
            startActivity(dashboardprofile);

        }
        else if (v.getId()== R.id.btdashquiz) {

            Intent quiz = new Intent(DashboardProfileActivity.this, QuizActivity.class);
            startActivity(quiz);


        }
    }
}