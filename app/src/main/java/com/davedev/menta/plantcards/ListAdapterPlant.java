package com.davedev.menta.plantcards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.davedev.menta.R;

import java.util.List;

public class ListAdapterPlant extends RecyclerView.Adapter<ListAdapterPlant.ViewHolder> {
    private List<ListElementPlant> mData;
    private final LayoutInflater mInflater;
    private final Context context;
    final ListAdapterPlant.OnItemClickListener listener;

    public void setFilteredList(List<ListElementPlant> filteredList){
        this.mData = filteredList;
        notifyDataSetChanged();
    }

    public interface  OnItemClickListener{
        void onItemClick(ListElementPlant item);
    }

    public ListAdapterPlant(List<ListElementPlant> itemList, Context context, ListAdapterPlant.OnItemClickListener listener){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;

    }
    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapterPlant.ViewHolder onCreateViewHolder(ViewGroup parent, int  viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_plants, null, false);
        return  new ListAdapterPlant.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapterPlant.ViewHolder holder, final int position){
        holder.plantCardView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_start_transition));
        holder.bindData(mData.get(position));
    }

    public  void setItems(List<ListElementPlant> items) { mData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView plantCardView;
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
            plantCardView = itemView.findViewById(R.id.plantCardView);
        }

        void  bindData(final ListElementPlant item){
            plantImageView.setImageResource(item.getImagePlant());
            titlePlant.setText(item.getNamePlant());
            descPlant.setText(item.getDescriptionPlant());
            carePlant.setText(item.getSupportPlant());
            heightPlant.setText(item.getHeightPlant());
            humidityPlant.setText(item.getHumidityPlant());
            tempPlant.setText(item.getTemperaturePlant());
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}
