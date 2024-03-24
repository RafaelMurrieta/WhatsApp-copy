package com.murrydev.whatsap;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater minflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.minflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }
    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = minflater.inflate(R.layout.chats, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.onBind(mData.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView profilePhoto, statusMsg;
        TextView nametxt, time, msg, numbermsj;

        ViewHolder(View itemView){
            super(itemView);
            profilePhoto = itemView.findViewById(R.id.imageProfile);
            nametxt = itemView.findViewById(R.id.nameText);
            time = itemView.findViewById(R.id.time);
            msg = itemView.findViewById(R.id.msjTextView);
            numbermsj = itemView.findViewById(R.id.numberMnsj);
            statusMsg = itemView.findViewById(R.id.check);
        }

        void onBind(final ListElement item){
            int resourceId = context.getResources().getIdentifier(item.getProfile(), "drawable", context.getPackageName());
            if (resourceId != 0) {
                profilePhoto.setImageResource(resourceId);
            } else {
                profilePhoto.setImageResource(R.mipmap.defecto_imga);
            }
            nametxt.setText(item.getName());
            time.setText(item.getDates());
            msg.setText(item.getMsg());
            numbermsj.setText(item.getAlertMsg());
            statusMsg.setColorFilter(Color.parseColor(item.getChecked()), PorterDuff.Mode.SRC_IN);
        }

    }

}
