package com.bignerdranch.android.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewToDoActivity extends MainActivity {

    public EditText textTitle;
    public EditText textDescription;
    public Button buttonSave;
    public DataHolder holder = DataHolder.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do);

//        findViewsById();

        textTitle = findViewById(R.id.input_title);
        textDescription = findViewById(R.id.input_description);
        buttonSave = findViewById(R.id.button_save);

        prepareActionBar();

        prepareRecyclerView();

        if (holder.getTask() != null) {

            textTitle.setText(holder.getTask().getName());
            textDescription.setText(holder.getTask().getSubname());
        }

        //    setLukaListeners();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = textTitle.getText().toString();
                title = title.trim();

                String description = textDescription.getText().toString();
                description = description.trim();

                if (title.equals(""))
                    Toast.makeText(NewToDoActivity.this, "Enter the title", Toast.LENGTH_SHORT).show();

                else if (description.equals(""))
                    Toast.makeText(NewToDoActivity.this, "Enter the description", Toast.LENGTH_SHORT).show();

                else {
                    title = title.substring(0, 1).toUpperCase() + title.substring(1);
                    description = description.substring(0, 1).toUpperCase() + description.substring(1);
                    if (holder.getTask()==null) {
                        holder.setDhPositionMax(holder.getDhPositionMax() + 1);
                        holder.setTask(new Task(title, description));
                        holder.getTask().setPosition(holder.getDhPositionMax());
                        holder.setDhPosition(holder.getTask().getPosition());
                        finish();
                    }
                    else {
                        holder.setTask(new Task(title, description));
                        holder.getTask().setPosition(holder.getDhPosition());
                        finish();
                    }
                }
            }
        });
    }
}