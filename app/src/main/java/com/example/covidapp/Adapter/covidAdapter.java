package com.example.covidapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.covidapp.R;

import java.util.ArrayList;

public class covidAdapter extends BaseAdapter {

    private ArrayList<covid> covidList;
    private Context context;

    public covidAdapter(ArrayList<covid> covidList, Context context){
        this.covidList = covidList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.covidList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.covidList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.template, null);

            holder = new ViewHolder();

            holder.tv_activeCases =(TextView)convertView.findViewById(R.id.template_textview_active_cases);
            holder.tv_country =(TextView)convertView.findViewById(R.id.template_textview_country);
            holder.tv_lastUpdate =(TextView)convertView.findViewById(R.id.template_textview_last_update);
            holder.tv_newCases =(TextView)convertView.findViewById(R.id.template_textview_new_cases);
            holder.tv_newDeaths =(TextView)convertView.findViewById(R.id.template_textview_new_deaths);
            holder.tv_totalCases =(TextView)convertView.findViewById(R.id.template_textview_total_cases);
            holder.tv_totalDeaths =(TextView)convertView.findViewById(R.id.template_textview_total_deaths);
            holder.tv_totalRecovered =(TextView)convertView.findViewById(R.id.template_textview_total_recovered);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        covid covid = covidList.get(position);


            holder.tv_activeCases.setText("Active Cases: " + covid.getActive());
            holder.tv_country.setText(covid.getCountry());
            holder.tv_lastUpdate.setText("Last Update: " + covid.getLastUpdate());
            holder.tv_newDeaths.setText("New Deaths: " + covid.getNewDeaths());
            holder.tv_newCases.setText("New Cases: " + covid.getNewCases());
            holder.tv_totalRecovered.setText("Recovered: " + covid.getRecovered());
            holder.tv_totalDeaths.setText("Deaths: " + covid.getTotalDeaths());
            holder.tv_totalCases.setText("Total Cases: " + covid.getTotalCases());

            convertView.setTag(holder);
        return convertView;

    }


    private static class ViewHolder{
        public TextView tv_country, tv_activeCases,  tv_lastUpdate, tv_newCases, tv_newDeaths, tv_totalCases, tv_totalDeaths, tv_totalRecovered;
    }
}


