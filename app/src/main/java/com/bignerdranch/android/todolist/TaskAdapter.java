package com.bignerdranch.android.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView subname;
        public int ViewPosition;

        public ViewHolder (View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            subname = itemView.findViewById(R.id.item_subname);

        }

        public void bind(final Task task,final OnItemClickListener listener) {
            name.setText(task.getName());
            subname.setText(task.getSubname());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(task, getLayoutPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Task item,int pos);
    }

    private List<Task> mTaskList;
    private OnItemClickListener listener;

    public TaskAdapter(List<Task> taskList) {
        mTaskList = taskList;
    }

    public TaskAdapter(List<Task> taskList, OnItemClickListener listener) {
        mTaskList = taskList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View taskView = inflater.inflate(R.layout.task, parent, false);
        ViewHolder viewHolder = new ViewHolder(taskView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final TaskAdapter.ViewHolder holder, int position) {
        Task task = mTaskList.get(position);
        holder.bind(task, listener);
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}

