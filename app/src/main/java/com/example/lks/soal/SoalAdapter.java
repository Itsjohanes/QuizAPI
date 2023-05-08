package com.example.lks.soal;

import static android.content.ContentValues.TAG;
import static com.example.lks.QuizActivity.kunci;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lks.Config;
import com.example.lks.QuizActivity;
import com.example.lks.R;

import java.util.HashMap;
import java.util.List;

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.ListViewHolder> {




    private List<Soal> mSoalList;




    private OnItemClickCallback onItemClickCallback;


    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public SoalAdapter(List<Soal> list){

        this.mSoalList= list;


    }

    @NonNull
    @Override
    public SoalAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.soal_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoalAdapter.ListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        try{



            holder.soal.setText(mSoalList.get(position).getSoal());
            holder.a.setText(mSoalList.get(position).getOpsi_a());
            holder.b.setText(mSoalList.get(position).getOpsi_b());
            holder.c.setText(mSoalList.get(position).getOpsi_c());
            holder.d.setText(mSoalList.get(position).getOpsi_d());

            QuizActivity.kunci.put(mSoalList.get(position).getId_soal(),mSoalList.get(position).getKunci());
            //Inisialisasi awal untuk jawaban
            QuizActivity.jawaban.put(mSoalList.get(position).getId_soal(),"NULL");


            //opsinya
            holder.a.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    QuizActivity.jawaban.put(mSoalList.get(position).getId_soal(), holder.a.getText().toString());

                }
            });


            holder.b.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    QuizActivity.jawaban.put(mSoalList.get(position).getId_soal(), holder.b.getText().toString());

                }
            });

            holder.c.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    QuizActivity.jawaban.put(mSoalList.get(position).getId_soal(), holder.c.getText().toString());

                }
            });

            holder.d.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    QuizActivity.jawaban.put(mSoalList.get(position).getId_soal(), holder.d.getText().toString());

                }
            });

            holder.e.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    QuizActivity.jawaban.put(mSoalList.get(position).getId_soal(), holder.e.getText().toString());

                }
            });



        }catch (Exception ex){
            Log.d("This is Exception",ex.toString());
        }

    }


    @Override
    public int getItemCount() {
        return mSoalList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView soal;
        RadioButton a, b, c, d, e;
        RadioGroup radioGroup;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            soal = itemView.findViewById(R.id.soal);
            radioGroup = itemView.findViewById(R.id.pilihan);
            a = itemView.findViewById(R.id.pilihanA);
            b = itemView.findViewById(R.id.pilihanB);
            c = itemView.findViewById(R.id.pilihanC);
            d = itemView.findViewById(R.id.pilihanD);
            e = itemView.findViewById(R.id.pilihanE);
        }
    }


    public interface OnItemClickCallback {
        void onItemClicked(Soal data);
    }
}
