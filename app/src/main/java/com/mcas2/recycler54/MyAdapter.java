package com.mcas2.recycler54;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> lDivisas;
    private LayoutInflater inflater;
    private TextView ultimaSeleccion;
    private int posicionUltimaSeleccion;

    MyAdapter(Context context, ArrayList<String> lDivisas) {
        this.lDivisas = lDivisas;
        this.inflater = LayoutInflater.from(context);
        posicionUltimaSeleccion = -1; //es importante marcarlo
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String divisa = lDivisas.get(position);
        holder.tvDivisa.setText(divisa);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView divisa = v.findViewById(R.id.tvDivisa);
                if (divisa == ultimaSeleccion){
                    posicionUltimaSeleccion = -1;
                    ultimaSeleccion = null;
                    divisa.setBackgroundColor(Color.WHITE);
                } else {
                    if (ultimaSeleccion!=null) ultimaSeleccion.setBackgroundColor(Color.WHITE);
                    divisa.setBackgroundColor(Color.BLUE);
                    posicionUltimaSeleccion = position;
                    ultimaSeleccion = divisa;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lDivisas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvDivisa;

        public ViewHolder(@NonNull View item) {
            super(item);
            tvDivisa = item.findViewById(R.id.tvDivisa);
        }
    }

    public int getElementoSeleccionado(){
        return this.posicionUltimaSeleccion;
    }

}
