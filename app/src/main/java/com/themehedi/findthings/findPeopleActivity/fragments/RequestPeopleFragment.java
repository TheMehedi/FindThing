package com.themehedi.findthings.findPeopleActivity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.themehedi.findthings.R;


public class RequestPeopleFragment extends Fragment {

    private TextView fromTv, toTv;
    public static String fromLocation = "";
    public static String toLocation = "";
    public static String divisionId = "", districtId = "", areaId = "";

    public RequestPeopleFragment() {
        // Required empty public constructor
        fromLocation = "";
        toLocation = "";
        divisionId = "";
        districtId = "";
        areaId = "";
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request_people, container, false);

        initViews(view);


        fromTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFragment(new LocationSelectionFragment(), "1");
            }
        });


        toTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openFragment(new LocationSelectionFragment(), "2");
            }
        });



        return view;
    }

    private void initViews(View view) {

        fromTv = view.findViewById(R.id.fromTv);
        toTv = view.findViewById(R.id.toTv);
    }


    @Override
    public void onStart() {
        super.onStart();

        if(fromLocation.length()>0){

            fromTv.setText(fromLocation);
        }
        if(toLocation.length()>0){

            toTv.setText(toLocation);
        }
    }

    private void openFragment(Fragment fragment, String value) {

        Bundle bundle = new Bundle();
        bundle.putString("value", value);

        fragment.setArguments(bundle);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, fragment)
                .addToBackStack(null)
                .commit();
    }
}