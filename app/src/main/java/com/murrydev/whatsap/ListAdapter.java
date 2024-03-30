package com.murrydev.whatsap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
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
        ImageView profilePhoto, statusMsg,setImg;
        TextView nametxt, time, msg, numbermsj;

        ViewHolder(View itemView){
            super(itemView);
            profilePhoto = itemView.findViewById(R.id.imageProfile);
            nametxt = itemView.findViewById(R.id.nameText);
            time = itemView.findViewById(R.id.time);
            msg = itemView.findViewById(R.id.msjTextView);
            numbermsj = itemView.findViewById(R.id.numberMnsj);
            statusMsg = itemView.findViewById(R.id.check);
            setImg = itemView.findViewById(R.id.set);
        }


        @SuppressLint("ResourceAsColor")
        void onBind(final ListElement item){
            Log.d("ListElementItem", String.valueOf(item));
            time.setText(item.getDates());
            int resourceId = context.getResources().getIdentifier(item.getProfile(), "drawable", context.getPackageName());
            if (resourceId != 0) {
                profilePhoto.setImageResource(resourceId);
            } else {
                profilePhoto.setImageResource(R.mipmap.defecto_imga);
            }
            String alrtMsj = item.getAlertMsg();
            if ("set".equals(alrtMsj)) {
                Drawable drawable = ContextCompat.getDrawable(itemView.getContext(), R.drawable.setmsj);
                numbermsj.setBackground(drawable);
                int widthPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, itemView.getResources().getDisplayMetrics());
                int heightPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, itemView.getResources().getDisplayMetrics());
                numbermsj.getLayoutParams().width = widthPixels;
                numbermsj.getLayoutParams().height = heightPixels;
                numbermsj.requestLayout();
                setImg.setVisibility(View.GONE);
            } else if(alrtMsj == null){
                numbermsj.setVisibility(View.GONE);
                statusMsg.setVisibility(View.GONE);
            }else{
                TypedArray typedArray = context.obtainStyledAttributes(new int[]{R.attr.ovaloColorMsg});
                int msjcol = typedArray.getColor(0,0);
                typedArray.recycle();
                time.setTextColor(msjcol);
                numbermsj.setText(alrtMsj);

            }
            String imgeset = item.getSetImg();
            if (imgeset == null){
                setImg.setVisibility(View.GONE);
            }
            statusMsg.setColorFilter(Color.parseColor(item.getChecked()), PorterDuff.Mode.SRC_IN);
            nametxt.setText(item.getName());
            msg.setText(item.getMsg());
        }

    }

}
