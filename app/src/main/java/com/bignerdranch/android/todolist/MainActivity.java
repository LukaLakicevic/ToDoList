package com.bignerdranch.android.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Task> taskList;
    public Button addButton;
    public Toolbar toolbar;
    public RecyclerView recycler;
    public TaskAdapter adapter;
    public DataHolder holder = DataHolder.getInstance();
    public TaskAdapter.OnItemClickListener listener;
    public int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsById();

        prepareActionBar();

        prepareRecyclerView();

        setActionListeners();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (holder.getTask() != null) {
            if (holder.getDhPosition() < holder.getDhPositionMax()) {
                taskList.set(holder.getDhPosition()-1, holder.getTask2());
                adapter.notifyItemChanged(holder.getDhPosition()-1);
                holder.setTask(null);
                holder.setTask2(null);
                // taskList.remove(holder.getDhPosition());
                //  taskList.add(holder.getDhPosition(), holder.getTask());
            }
            else {
                taskList.add(holder.getTask());
                // taskList.sort();
                adapter.notifyItemInserted(taskList.size() - 1);
                holder.setTask(null);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

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

    public void findViewsById() {

        toolbar = findViewById(R.id.toolbar);
        recycler = findViewById(R.id.list_recycler);
        addButton = findViewById(R.id.add_button);
    }

    public void prepareRecyclerView() {

        taskList = new ArrayList<Task>();

        listener = new TaskAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Task item,int pos) {
                position = pos;
                holder.setTask(item);
                holder.setDhPosition(item.getPosition());
                startActivity(new Intent(MainActivity.this,ShowToDo.class));
            }
        };

        adapter = new TaskAdapter(taskList, listener);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void prepareActionBar() {

        setSupportActionBar(toolbar);
    }

    public void setActionListeners() {

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.setTask(null);
                Toast.makeText(MainActivity.this, "Going to NTDA", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,NewToDoActivity.class));
            }
        });

    }
}
