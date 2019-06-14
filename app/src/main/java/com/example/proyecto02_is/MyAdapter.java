package com.example.proyecto02_is;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Turno> list;
    private int layout;

    public MyAdapter(Context context, List<Turno> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Turno getItem(int position){
        return list.get(position);
    }

    @Override
    public long getItemId(int id){
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup){

        ViewHolder vh;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.id = (TextView) convertView.findViewById(R.id.textViewID);
            vh.nombre = (TextView) convertView.findViewById(R.id.textViewNombre);
            vh.jornada = (TextView) convertView.findViewById(R.id.textViewJornada);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
        Turno currentCar = list.get(position);
        vh.id.setText(currentCar.getID()+"");
        vh.nombre.setText("        "+currentCar.getNombre());
        vh.jornada.setText("\n"+"        "+currentCar.getJornada());
        return convertView;
    }

    public class ViewHolder{
        TextView id;
        TextView nombre;
        TextView jornada;
    }
}

