package com.example.aditichandel.listviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
ListView list;
    Button btn,btnadd;
    private EditText filtertext;
    CustomAdapter adapter;

    ArrayList<String> data = new ArrayList<String>();
    ArrayList<Model> model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new ArrayList<Model>();
        model.add(new Model("india", R.drawable.nationalflag5));
        model.add(new Model("Pakistan", R.drawable.nationalflag));
        model.add(new Model("Sri Lanka", R.drawable.nationalflag3));
        model.add(new Model("China", R.drawable.nationalflag4));
        model.add(new Model("Bangladesh", R.drawable.nationalflag2));
        model.add(new Model("Nepal", R.drawable.nationalflag6));
        model.add(new Model("Afghanistan", R.drawable.nationalflag7));
        model.add(new Model("North Korea", R.drawable.europe));
        model.add(new Model("South Korea", R.drawable.download));


        adapter = new CustomAdapter(MainActivity.this, model);
        list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);
        btn = (Button) findViewById(R.id.btn_New);
       /// btnadd=(Button)findViewById(R.id.btn_add);
        filtertext = (EditText) findViewById(R.id.edit_text);
        //onclick listener for btn add
//        btnadd.setOnClickListener(new View.OnClickListener()
//        {
//
//            @Override
//            public void onClick(View v) {
//                model.add(new Model("Germany", R.drawable.download));
//                adapter.notifyDataSetChanged();
//            }
//        });
        //onclick listener for btn delete
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                boolean[] itemCheckLocal = adapter.getCheckedBooleanArray();
                int boolSize = itemCheckLocal.length;
                for (int i = boolSize - 1; i >= 0; i--) {
                    if (itemCheckLocal[i]) {
                        model.remove(i);
                    }
                }
                adapter.refreshItemcheck();
                adapter.notifyDataSetChanged();

            }
        });
        filtertext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String text = filtertext.getText().toString().toLowerCase(Locale.getDefault());
//                adapter.filter(text);
//                adapter.notifyDataSetChanged();

                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    }



