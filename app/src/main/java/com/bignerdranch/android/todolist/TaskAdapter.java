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

        public ViewHolder (View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            subname = itemView.findViewById(R.id.item_subname);
        }
    }

    private List<Task> mTaskList;

    public TaskAdapter(List<Task> taskList) {
        mTaskList = taskList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View taskView = inflater.inflate(R.layout.task, parent, false);
        ViewHolder viewHolder = new ViewHolder(taskView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, int position) {
        Task task = mTaskList.get(position);

        TextView name = holder.name;
        name.setText(task.getName());

        TextView subname = holder.subname;
        subname.setText(task.getSubname());
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}
