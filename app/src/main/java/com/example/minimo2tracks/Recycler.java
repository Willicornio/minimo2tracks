package com.example.minimo2tracks;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.support.v7.widget.RecyclerView;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> implements View.OnClickListener {

    private Activity activity;
    private View.OnClickListener listener;

    @Override
    public void onClick(View v) {
        if (listener != null){

            listener.onClick(v);
        }

    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    //private Context context;

    public Recycler(Activity activity) {
        this.lista = new ArrayList<>();
        this.activity = activity;

        //this.context = context;
    }

    private List<Tracks> lista;

    public void rellenarLista(List<Tracks> todostracks){
        lista.addAll(todostracks);
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemtrack, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Tracks track = lista.get(i);

        viewHolder.idtrack.setText(track.getId());
        viewHolder.title.setText(track.getTitle());
        viewHolder.singer.setText(track.getSingle());
        viewHolder.idtrack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(activity.getApplicationContext(),segundoActivity.class);
                mIntent.putExtra("trackId",track.getId());
                activity.startActivity(mIntent);
                                                  }
                                              });

        //Picasso.with(context).load(element.getMunicipiEscut()).into(viewHolder.escutMuncipi);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ConstraintLayout constraintLayout; //esto no se usa, pero el Vera sabrá más que tu, payaso
        private TextView idtrack;
        private TextView title;
        private TextView singer;
        private Activity activity;
        private View.OnClickListener listener;

        public ViewHolder(View v){
            super(v);
            constraintLayout = v.findViewById(R.id.constraintLayout); //Esto es el id del ConstraitLayout que hay que ponerlo donde "ConstariLayout" ID"
            idtrack = v.findViewById(R.id.idtrack);
            title = v.findViewById(R.id.title);
            singer = v.findViewById(R.id.singer);

        }


    }
}
