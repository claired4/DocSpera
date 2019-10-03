package com.example.clairedong.docspera;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by clairedong on 10/2/19.
 */

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder>{

    List<ColorItem> colorItems;
    private Context context;

    public ColorAdapter(List<ColorItem> colorItems, Context context) {
        this.colorItems = colorItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ColorItem colorItem = colorItems.get(position);

        holder.textViewName.setText(colorItem.getName());
        holder.textViewCategory.setText(colorItem.getCategory());
        if (colorItem.getType() != null) {
            holder.textViewType.setText(colorItem.getType());
        }
    }

    @Override
    public int getItemCount() {
        return colorItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewCategory;
        public TextView textViewType;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewCategory = (TextView) itemView.findViewById(R.id.textViewCategory);
            textViewType = (TextView) itemView.findViewById(R.id.textViewType);
        }
    }
}
