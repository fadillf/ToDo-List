package com.example.todoapps.adapter;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoapps.R;
import com.example.todoapps.model.Todo;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private ArrayList<Todo> dataList;

    public TodoAdapter(ArrayList<Todo> dataList){
        this.dataList = dataList;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.todo_item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        holder.tvItem.setText(dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItem;
        CardView btnItem;
        CheckBox cbItem;

        public TodoViewHolder(final View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
            btnItem = (CardView) itemView.findViewById(R.id.todo_item);
            cbItem = (CheckBox) itemView.findViewById(R.id.cb_item);
            cbItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b){
                        tvItem.setTextColor(Color.parseColor("#999999"));
                        tvItem.setPaintFlags(tvItem.getPaintFlags() ^ Paint.STRIKE_THRU_TEXT_FLAG);
                    }else{
                        tvItem.setTextColor(Color.parseColor("#4c5158"));
                        tvItem.setPaintFlags(tvItem.getPaintFlags() ^ Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                }
            });
        }
    }
}
