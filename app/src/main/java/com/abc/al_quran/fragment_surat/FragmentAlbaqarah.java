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
import com.abc.al_quran.Surat.Surat_albaqarah;
import com.abc.al_quran.Surat.Surat_alfatihah;
import com.abc.al_quran.adapterAlquran.MyadapterAlquran;
import com.abc.al_quran.data.SuratAlquran;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerbage on 1/16/2017.
 */

public class FragmentAlbaqarah extends Fragment {

    private RecyclerView listItem;
    private List<SuratAlquran> suratAlquranList = new ArrayList<SuratAlquran>();
    private MyadapterAlquran myadapterAlquran;
    private Surat_albaqarah albaqarah;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        myadapterAlquran = new MyadapterAlquran(suratAlquranList,activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        albaqarah = new Surat_albaqarah();
        additem();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_albaqarah, container, false);
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
            JSONObject jsonObject = new JSONObject(String.valueOf(albaqarah.sb));
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
