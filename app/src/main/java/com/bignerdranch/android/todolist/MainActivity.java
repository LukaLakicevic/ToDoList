package com.bignerdranch.android.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Task> taskList;
    public Button add_text;
    public EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskList = new ArrayList<Task>();

        text = findViewById(R.id.added_text);
        add_text = findViewById(R.id.add_button);

        RecyclerView recycler = findViewById(R.id.list_recycler);
        final TaskAdapter adapter = new TaskAdapter(taskList);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        add_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = text.getText().toString();
                name = name.trim();
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                taskList.add(new Task(name, name));
                adapter.notifyItemInserted(taskList.size()-1);
                text.setText("");
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.create:

                Toast.makeText(MainActivity.this, R.string.create_cliked, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(MainActivity.this, R.string.delete_cliked, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_all:
                Toast.makeText(MainActivity.this, R.string.delete_all_cliked, Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(MainActivity.this, R.string.nothing, Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }
}
