package com.sommayah.practiceproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.sommayah.practiceproject.R.id.imageView;

/**
 * Created by sommayahsoliman on 11/22/16.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Item> mItemList;

    public ItemAdapter(Context context, ArrayList<Item> itemList) {
        mContext = context;
        mItemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(mItemList.get(position).getName());
        String url = mItemList.get(position).getImage();
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.ic_menu_camera)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        if(mItemList != null)
            return mItemList.size();
        else
            return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);
           mTextView = (TextView) itemView.findViewById(R.id.info_text);
            mImageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
