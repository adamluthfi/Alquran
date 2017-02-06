package com.abc.al_quran.adapterAlquran;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abc.al_quran.R;
import com.abc.al_quran.data.SuratAlquran;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Gerbage on 1/16/2017.
 */

public class MyadapterAlquran extends RecyclerView.Adapter<MyadapterAlquran.ViewHolder> {

    private List<SuratAlquran>suratAlquranList;
    private Context activity;

    public MyadapterAlquran(List<SuratAlquran>suratAlquranList,Context activity){
        this.suratAlquranList = suratAlquranList;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.custom_view;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem,parent,shouldAttachToParentImmediately);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("ar","EG"));
        String sDistance = numberFormat.format(suratAlquranList.get(position).no_ayat);
        holder.tvAyat.setText(suratAlquranList.get(position).ayat);
        holder.tvSurat.setText(suratAlquranList.get(position).surat);
        holder.tvNo.setText(sDistance);
    }

    @Override
    public int getItemCount() {
        return suratAlquranList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvAyat;
        private TextView tvSurat;
        private TextView tvNo;
        public ViewHolder(View itemView) {
            super(itemView);
            tvAyat = (TextView)itemView.findViewById(R.id.text_Arab);
            tvSurat = (TextView)itemView.findViewById(R.id.text_penjelasan);
            tvNo = (TextView)itemView.findViewById(R.id.no_ayat);
        }
    }
}
