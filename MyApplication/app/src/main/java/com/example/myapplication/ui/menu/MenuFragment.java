package com.example.myapplication.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuFragment extends Fragment {

    ListView listView;
    ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] nama;
    String[] harga;
    String[] gambar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

        listView = (ListView) root.findViewById((R.id.list_view));
        ImageView imageView = (ImageView) root.findViewById((R.id.gambar_back));

//        Toolbar toolbar = (Toolbar) root.findViewById((R.id.toolbar_menu));

//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity().getBaseContext(),
                        MainActivity.class);

                getActivity().startActivity(i);
            }
        });

        gambar = new String[]{Integer.toString(R.drawable.ic_photo),Integer.toString(R.drawable.ic_photo),Integer.toString(R.drawable.ic_photo),Integer.toString(R.drawable.ic_photo)};
        nama = new String[]{"Americano","Ice Latte","Chocolate","Cappucino"};
        harga = new String[]{"Rp. 5.000","Rp. 7.500","Rp. 6.000","Rp. 8.000"};

        mylist = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i < nama.length; i++){
            map = new HashMap<String, String>();
            map.put("nama", nama[i]);
            map.put("harga", harga[i]);
            map.put("gambar", gambar[i]);
            mylist.add(map);
        }

        Adapter = new SimpleAdapter(getActivity().getBaseContext(), mylist, R.layout.layout_isi_lv,
                new String[]{"nama", "harga", "gambar"}, new int[]{R.id.nama, R.id.harga, R.id.gambar}) {
        };

        listView.setAdapter(Adapter);

        return root;
    }
}