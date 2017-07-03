package com.example.aditichandel.listviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
ListView list;
    Button btn;
    CustomAdapter adapter;
    ArrayList<String> data = new ArrayList<String>();
    boolean[] itemchecked;
    String [] countries = new String[]{
            "india","Pakistan","Sri Lanka","China","Bangladesh","Nepal","Afghanistan","North Korea","South Korea"
                                 };
     ArrayList<Integer> flag=new ArrayList<Integer>();
    Integer flagdata[]=
             {
                    R.drawable.nationalflag5,
                    R.drawable.nationalflag,
                     R.drawable.nationalflag3,
                     R.drawable.nationalflag4,
                     R.drawable.nationalflag2,
                     R.drawable.nationalflag6,
                     R.drawable.nationalflag7,
                     R.drawable.europe,
                     R.drawable.download,
                     R.drawable.south_american_country
                                                  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Collections.addAll(data,countries);
        Collections.addAll(flag,flagdata);
        adapter = new CustomAdapter(MainActivity.this,data,flag);
        list=(ListView)findViewById(R.id.list_view);
        //list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);


        btn=(Button)findViewById(R.id.btn_New);
        //onclick listener for btn
        btn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"You have clicked on delete button",Toast.LENGTH_SHORT).show();
                final String TAG="Hello";
                Log.e(TAG,"((((((((((((((((((((I shouldn't be here");

                //SparseBooleanArray checkedItemPositions = list.getCheckedItemPositions();
                int itemCount = list.getCount();
               // int si=checkedItemPositions.size();
               // Toast.makeText(getApplicationContext(),"You have clicked on delete button",Toast.LENGTH_SHORT).show();

                for(int i=0; i <itemCount; i++){
                    if(itemchecked[i]){
                        int postion=i;
                       adapter.remove(postion);
                        --i;
                    }
                    adapter.notifyDataSetChanged();
                }
               // checkedItemPositions.clear();


            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CheckBox cb=(CheckBox)findViewById(R.id.simpleCheckBox);
        cb.performClick();
        if(cb.isChecked())
        {
            itemchecked[position]=true;
        }
        else if(!cb.isChecked())
        {
            itemchecked[position]=false;
        }

    }
}
