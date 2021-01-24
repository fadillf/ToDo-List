package com.example.todoapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.todoapps.adapter.TodoAdapter;
import com.example.todoapps.model.Todo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TodoAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Todo> todoArrayList;
    private Dialog dAddTodo;
    private FloatingActionButton fab;
    private EditText tvInputTodo;
    private Button btnAddTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initCustomDialog();
        initViews();

        todoArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rv_todo);
        adapter = new TodoAdapter(todoArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initCustomDialog(){
        dAddTodo = new Dialog(MainActivity.this);
        dAddTodo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dAddTodo.setContentView(R.layout.dialog);
        dAddTodo.setCancelable(true);

        tvInputTodo = dAddTodo.findViewById(R.id.tv_input_todo);
        btnAddTodo = dAddTodo.findViewById(R.id.btn_add_todo);
        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = tvInputTodo.getText().toString();
                addData(title, "test");
                tvInputTodo.setText("");
                dAddTodo.dismiss();
            }
        });
    }

    void initViews(){
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dAddTodo.show();
            }
        });
    }

    void addData(String title, String description){
        todoArrayList.add(new Todo(title, description));
    }
}