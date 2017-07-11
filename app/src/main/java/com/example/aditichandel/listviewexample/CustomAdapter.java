package com.example.aditichandel.listviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aditi CHANDEL on 03-07-2017.
 */

public class CustomAdapter extends BaseAdapter implements Filterable{

    private final Activity context;
    private final ArrayList<Model> model;
    boolean[] itemchecked;
    List<Model> modellist=null;
    CustomFilter mCustomfilter;

    public CustomAdapter(Activity context,ArrayList<Model> model){
        this.context = context;

        this.modellist=model;
        this.model=new ArrayList<Model>();
        this.model.addAll(modellist);
        itemchecked=new boolean[model.size()];
    }
    public boolean[] getCheckedBooleanArray(){
       return itemchecked;
    }

    public void refreshItemcheck(){
        itemchecked=new boolean[model.size()];
    }

    @Override
    public Filter getFilter() {
        if(mCustomfilter==null)
            mCustomfilter=new CustomFilter();
        return mCustomfilter;
    }

    private static class ViewHolder
    {
        TextView txtCountryname;
        ImageView imagecountry;
        CheckBox  check;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int position) {
        return modellist.get(position);
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

        Glide.with(this.context).load( modellist.get(position).getImageId()).transform(new CircleTransform(context)).into(holder.imagecountry);
        holder.txtCountryname.setText(modellist.get(position).getWeb());
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
        return convertView;
    }
    private class CustomFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // Create a FilterResults object
            FilterResults results = new FilterResults();
            // If the constraint (search string/pattern) is null
            // or its length is 0, i.e., its empty then
            // we just set the `values` property to the
            // original contacts list which contains all of them
            if (constraint == null || constraint.length() == 0) {
                results.values = modellist;
                results.count = modellist.size();
            }
            else {
                // Some search copnstraint has been passed
                // so let's filter accordingly
                ArrayList<Model> filteredContacts = new ArrayList<Model>();

                // We'll go through all the contacts and see
                // if they contain the supplied string
                for (Model c : modellist) {
                    if (c.getWeb().toUpperCase().contains( constraint.toString().toUpperCase() )) {
                        // if `contains` == true then add it
                        // to our filtered list
                        filteredContacts.add(c);
                    }
                }

                // Finally set the filtered values and size/count
                results.values = filteredContacts;
                results.count = filteredContacts.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            modellist = (ArrayList<Model>) results.values;
            notifyDataSetChanged();
        }
    }
//    public void filter(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        modellist.clear();
//        if (charText.length() == 0) {
//            modellist.addAll(model);
//        }
//        else
//        {
//            for (Model wp : model)
//            {
//                if (wp.getWeb().toLowerCase(Locale.getDefault()).contains(charText))
//                {
//                    modellist.add(wp);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }
}
