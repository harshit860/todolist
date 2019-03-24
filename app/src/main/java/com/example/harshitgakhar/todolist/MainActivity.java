package com.example.harshitgakhar.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {


    private EditText itemt;
    private Button btn;
    private ListView itemlist;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemt = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_btn);
        itemlist = findViewById(R.id.item_list);
 items = Filehelper.readData(this);

 adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
 itemlist.setAdapter(adapter);
  btn.setOnClickListener(this);
itemlist.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                String itementered = itemt.getText().toString();
                adapter.add(itementered);
                itemt.setText("");
                Filehelper.writedata(items,this);
                Toast.makeText(this  ,"item added",Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show();
    }
}
