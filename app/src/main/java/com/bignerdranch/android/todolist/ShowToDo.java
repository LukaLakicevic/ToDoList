package com.bignerdranch.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class ShowToDo extends AppCompatActivity {
    public TextView name;
    public TextView description;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_to_do);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.textView);
        description = findViewById(R.id.textView2);

        name.setText(DataHolder.getInstance().getTask().getName());
        description.setText(DataHolder.getInstance().getTask().getSubname());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.edit:
                Toast.makeText(ShowToDo.this, R.string.edit_cliked, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ShowToDo.this, NewToDoActivity.class));
                return true;
            default:
                Toast.makeText(ShowToDo.this, R.string.nothing, Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        name.setText(DataHolder.getInstance().getTask().getName());
        description.setText(DataHolder.getInstance().getTask().getSubname());
        DataHolder.getInstance().setTask2(new Task(DataHolder.getInstance().getTask().getName(),DataHolder.getInstance().getTask().getSubname()));
    }
}
