package com.example.aditichandel.listviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
public class CustomList extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> web;
    private final Integer[] imageId;


    public CustomList(Activity context, ArrayList<String> web, Integer[] imageId) {
        super(context, R.layout.listiview_layout, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listiview_layout, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        CheckBox check   =(CheckBox)rowView.findViewById(R.id.simpleCheckBox);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        Glide.with(this.getContext()).load(imageId[position]).transform(new CircleTransform(context)).into(imageView);
        txtTitle.setText(web.get(position));
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        rowView.setTag(check);
        return rowView;
    }
}
