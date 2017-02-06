package com.abc.al_quran.fragment_surat;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abc.al_quran.R;
import com.abc.al_quran.Surat.Surat_alimran;
import com.abc.al_quran.Surat.Surat_almaidah;
import com.abc.al_quran.adapterAlquran.MyadapterAlquran;
import com.abc.al_quran.data.SuratAlquran;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerbage on 1/19/2017.
 */

public class FragmentAlmaidah extends Fragment {
    private RecyclerView listItem;
    private List<SuratAlquran> suratAlquranList = new ArrayList<SuratAlquran>();
    private MyadapterAlquran myadapterAlquran;
    private Surat_almaidah almaidah;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        myadapterAlquran = new MyadapterAlquran(suratAlquranList,activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        almaidah = new Surat_almaidah();
        additem();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_almaidah, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listItem = (RecyclerView)view.findViewById(R.id.rv_surat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        listItem.setLayoutManager(linearLayoutManager);
        listItem.setHasFixedSize(true);
        listItem.setAdapter(myadapterAlquran);
    }

    private void additem(){
        try{
            JSONObject jsonObject = new JSONObject(String.valueOf(almaidah.sb));
            JSONArray jsonArray = jsonObject.getJSONArray("quran-simple");
            for (int i = 0; i<jsonArray.length(); i++){
                JSONObject data = jsonArray.getJSONObject(i);
                suratAlquranList.add(new SuratAlquran(data.getString("verse"),data.getString("mean"),data.getInt("ayah")));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
