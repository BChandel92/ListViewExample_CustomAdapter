package com.example.aditichandel.listviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aditi CHANDEL on 03-07-2017.
 */

public class CustomAdapter extends BaseAdapter{

    private final Activity context;
    private final ArrayList<String> web;
    private final ArrayList<Integer> imageId;
    boolean[] itemchecked;

    public CustomAdapter(Activity context, ArrayList<String> web, ArrayList<Integer> imageId) {
        this.context = context;
        this.web = web;
        this.imageId = imageId;
        itemchecked=new boolean[web.size()];
    }
    public void remove(int position){
        web.remove(web.get(position));
      //  imageId.remove(ImageId.get(position));
    }
    private static class ViewHolder
    {
        TextView txtCountryname;
        ImageView imagecountry;
        CheckBox  check;
    }

    @Override
    public int getCount() {
        return web.size();
    }

    @Override
    public Object getItem(int position) {
        return web.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listiview_layout, null);
            holder = new ViewHolder();

            holder.txtCountryname = (TextView) convertView
                    .findViewById(R.id.txt);
            holder.imagecountry=(ImageView)convertView.findViewById(R.id.img);
            holder.check = (CheckBox) convertView
                    .findViewById(R.id.simpleCheckBox);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        holder.txtCountryname.setText(web.get(position));
        holder.check.setChecked(false);
        if (itemchecked[position])
            holder.check.setChecked(true);
        else
            holder.check.setChecked(false);

        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (holder.check.isChecked())
                    itemchecked[position] = true;
                else
                    itemchecked[position] = false;
            }
        });
        return null;
    }
}
