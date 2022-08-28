package com.example.text001;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShowFragment extends Fragment {
    TextView textView;
    String name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!=null){
            name = bundle.getString("name");
        }
    }
    public static Fragment getShowFragment(String name){
        ShowFragment showFragment = new ShowFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        showFragment.setArguments(bundle);
        return showFragment;
    }
//
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show,null);
        textView = view.findViewById(R.id.fg_view);
        textView.setText(name);
        return view;
    }
}
