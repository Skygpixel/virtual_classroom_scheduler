package com.example.classschedule;


import android.content.Intent;
import android.os.Bundle;
import  androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class fragment_sch_thursday extends Fragment {


    private View _view;
    private db_helper helper;
    private adapter_schedule sch_objs;
    private ListView ls_view;


    public fragment_sch_thursday() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sch_thursday, container, false);
        this._view = view;
        ((ListView)_view.findViewById(R.id.thursday_sch_list)).setOnItemClickListener(new clickListener_list_schedule());
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

        if (this.helper == null)
            this.helper = new db_helper(getActivity(), null, null, 1);


        ArrayList<object_schedule> schedules = this.helper.getSchedule_day("Thursday");
        if (schedules != null) {
            ((LinearLayout)_view.findViewById(R.id.thu_notice)).setVisibility(View.GONE);
            this.sch_objs = new adapter_schedule(getContext(), schedules);
        }
        else
        {
            ((LinearLayout)_view.findViewById(R.id.thu_notice)).setVisibility(View.VISIBLE);
            this.sch_objs = null;
        }


        this.ls_view = ((ListView) _view.findViewById(R.id.thursday_sch_list));

        this.ls_view.setAdapter(this.sch_objs);

    }
}