package com.example.agendamentodeconsultri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import javax.xml.transform.Result;

import static android.media.CamcorderProfile.get;

public class AgendaAdapter<FilterResults> extends BaseAdapter implements Filterable {
    private Context context;
    private ArrayList<Agendamento> list;
    CustomFIlter filter;
    ArrayList<Agendamento> filterList;


    public AgendaAdapter(Context context, ArrayList<Agendamento> list) {
        this.context = context;
        this.list = list;
        this.filterList= list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        TextView nome = null;
        TextView data = null;
        TextView hora = null;
        TextView nomeM = null;
        TextView celular = null;
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.adapter_view_layout, viewGroup, false);

        if (convertView == null) {

            celular = (TextView) view.findViewById(R.id.tsc);
            nome = (TextView) view.findViewById(R.id.tsn);
            nomeM = (TextView) view.findViewById(R.id.tsm);
            hora = (TextView) view.findViewById(R.id.tsh);
            data = (TextView) view.findViewById(R.id.tsd);
        } else {
            view = convertView;
        }
        Agendamento agendamento = list.get(i);
        celular.setText(agendamento.getNumero());
        nome.setText(agendamento.getNomeCliente());
        nomeM.setText(agendamento.getNomeDoutor());
        hora.setText(agendamento.getHora());
        data.setText(agendamento.getData());


        return view;
    }

    @Override
    public Filter getFilter() {
        if(filter == null){
            filter=new CustomFIlter();
        }

        return filter;
    }

    class CustomFIlter extends Filter{
        public  Object FilterListener;
        Agendamento agendamento = new Agendamento();
        FilterResults results=new FilterResults();

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            ArrayList<Agendamento> filters=new ArrayList<>();

            for(int i=0;i<filterList.size();i++){
                CharSequence constraint = null;
                if((filterList).get(i).getNomeCliente().toUpperCase().contains(constraint)){

                    Agendamento p=new Agendamento(filterList.get(i).getNomeCliente());
                    filters.add(p);

                }else {
                    results.count=filters.size();
                    results.values=filters;

                }
                results.count=filters.size();
                results.values=filters;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
          Agendamento  agendamento= (Agendamento) results.values;
            notifyDataSetChanged();
        }
    }



        }