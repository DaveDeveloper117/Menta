package com.davedev.menta;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapterPlant extends RecyclerView.Adapter<ListAdapterPlant.ViewHolder> {
    private List<ListElementPlant> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapterPlant(List<ListElementPlant> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }
    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapterPlant.ViewHolder onCreateViewHolder(ViewGroup parent, int  viewType){
        View view = mInflater.inflate(R.layout.list_plants, null);
        return  new ListAdapterPlant.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterPlant.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public  void setItems(List<ListElementPlant> items) { mData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView plantImageView;
        TextView titlePlant, descPlant, carePlant, heightPlant, humidityPlant, tempPlant;

        ViewHolder(View itemView){
            super(itemView);

            plantImageView = itemView.findViewById(R.id.plantImage);
            titlePlant = itemView.findViewById(R.id.titlePlant);
            descPlant = itemView.findViewById(R.id.descPlant);
            carePlant = itemView.findViewById(R.id.supportPlant);
            heightPlant = itemView.findViewById(R.id.infoHeight);
            humidityPlant = itemView.findViewById(R.id.infoHumidity);
            tempPlant = itemView.findViewById(R.id.infoTemperature);
        }

        void  bindData(final ListElementPlant item){
            plantImageView.setImageDrawable();
            //TODO bindData investigar como agregar imagenes video min 23:57
        }
    }
}
