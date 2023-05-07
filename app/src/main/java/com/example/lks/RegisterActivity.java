package com.example.lks;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lks.Rest.ApiClient;
import com.example.lks.Rest.ApiInterface;
import com.example.lks.datauser.Model.PostPutDelNotes;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtUsername, edtTelepon, edtPassword;
    Button btSubmit;

    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Identifikasi Komponen Action Bar
        // String actionBarTitle;
        // actionBarTitle = "Tambah";
        // getSupportActionBar().setTitle(actionBarTitle);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Identifikasi Komponen Form
        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtAlamat = (EditText) findViewById(R.id.edt_alamat);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtTelepon = (EditText) findViewById(R.id.edt_telepon);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btSubmit = (Button) findViewById(R.id.btn_submit);

        // Definisi API
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        // Fungsi Tombol Simpan
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    // Simpan Data
    private void saveData(){
        final String tipe_user = "User";

        Call<PostPutDelNotes> postHerosCall = mApiInterface.postNotes("insert_user",
                RequestBody.create(MediaType.parse("text/plain"), tipe_user),
                RequestBody.create(MediaType.parse("text/plain"), edtNama.getText().toString()),
                RequestBody.create(MediaType.parse("text/plain"), edtAlamat.getText().toString()),
                RequestBody.create(MediaType.parse("text/plain"), edtUsername.getText().toString()),
                RequestBody.create(MediaType.parse("text/plain"), edtTelepon.getText().toString()),
                RequestBody.create(MediaType.parse("text/plain"), edtPassword.getText().toString()));
        postHerosCall.enqueue(new Callback<PostPutDelNotes>() {
            @Override
            public void onResponse(Call<PostPutDelNotes> call, Response<PostPutDelNotes> response) {
                //jika username yang hendak didaftarkan sudah ada
                String message = response.body().getMessage();
                if (!message.equals("Username Sudah Ada")) {

                    finish();
                    startActivity(new Intent(RegisterActivity.this, register_confirm.class));
                }else{
                    //buat kalo data sudah ada
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    // Set the message show for the Alert time

                    builder.setMessage("Username sudah terdaftar!");
                    // Set Alert Title
                    builder.setTitle("Daftar Akun Gagal");
                    // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                    builder.setCancelable(false);

                    // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                    builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                        // When the user click yes button then app will close
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    });
                    // Create the Alert dialog
                    AlertDialog alertDialog = builder.create();
                    // Show the Alert Dialog box
                    alertDialog.show();
                }

            }

            @Override
            public void onFailure(Call<PostPutDelNotes> call, Throwable t) {
                Log.d("RETRO", "ON FAILURE : " + t.getMessage());
                Log.d("RETRO", "ON FAILURE : " + t.getCause());
                Toast.makeText(getApplicationContext(), "Error, entry data", Toast.LENGTH_LONG).show();
            }
        });
    }

    // Menu Kembali Ke Home
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}