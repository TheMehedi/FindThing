package com.themehedi.findthings.findPeopleActivity.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.themehedi.findthings.R;
import com.themehedi.findthings.utils.StaticMethod;

import java.util.ArrayList;
import java.util.List;

public class LocationSelectionFragment extends Fragment {

    private String value, division = "", district = "", area = "";
    private Spinner divisionSpinner, districtSpinner, areaSpinner;
    private ArrayList<String> divisions = new ArrayList<>();
    private ArrayList<String> districts = new ArrayList<>();
    private ArrayList<String> areas = new ArrayList<>();
    private ArrayList<String> divisionsId = new ArrayList<>();
    private ArrayList<String> districtsId = new ArrayList<>();
    private ArrayList<String> areasId = new ArrayList<>();
    private ArrayAdapter divisionAdapter, districtAdapter, areaAdapter;
    private Button submitBtn;

    public LocationSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_selection, container, false);

        initViews(view);


        Bundle bundle = this.getArguments();

        if(bundle != null){
            // handle your code here.
            value = bundle.getString("value");
        }

        divisions.add(0, "Choose Division");
        divisionsId.add(0, "0");

        districts.add(0, "Choose District");
        districtsId.add(0, "0");

        areas.add(0, "Choose Area");
        areasId.add(0, "0");


        for(int i = 1; i<=StaticMethod.divisionDataList.size(); i++){

            divisions.add(i, StaticMethod.divisionDataList.get(i-1).getDivisionTitle());
            divisionsId.add(i, StaticMethod.divisionDataList.get(i-1).getId());
        }

        divisionAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item, divisions);
        divisionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        divisionSpinner.setAdapter(divisionAdapter);


        districtAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item, districts);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtSpinner.setAdapter(districtAdapter);


        areaAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item, areas);
        areaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(areaAdapter);

        /*for(int i = 1; i<=StaticMethod.districtDataList.size(); i++){

            districts.add(i, StaticMethod.districtDataList.get(i-1).getDistrictTitle());
            districtsId.add(i, StaticMethod.districtDataList.get(i-1).getId());
        }

        for(int i = 1; i<=StaticMethod.areaDataList.size(); i++){

            areas.add(i, StaticMethod.areaDataList.get(i-1).getAreaTitle());
            areasId.add(i, StaticMethod.areaDataList.get(i-1).getId());
        }*/


        HandleAdapter();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!division.equals("") && !district.equals("") && !area.equals("")){

                    if(value.equals("1")){

                        RequestPeopleFragment.fromLocation = area + ", " + district + ", " + division;
                    }
                    else if(value.equals("2")){

                        RequestPeopleFragment.toLocation = area + ", " + district + ", " + division;
                    }

                    getActivity().onBackPressed();
                }
                else {

                    Toast.makeText(getContext(), "Please select all the field!", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return view;
    }

    private void HandleAdapter() {

        divisionAdapter.notifyDataSetChanged();
        divisionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //Toast.makeText(getContext(), "" + divisionsId.get(i) + divisions.get(i), Toast.LENGTH_SHORT).show();

                if(i>0){

                    division = divisions.get(i);
                    RequestPeopleFragment.divisionId = divisionsId.get(i);

                    districts.clear();
                    districtsId.clear();

                    districts.add(0, "Choose District");
                    districtsId.add(0, "0");

                    for(int j = 1; j<=StaticMethod.districtDataList.size(); j++){

                        if(divisionsId.get(i).equals(StaticMethod.districtDataList.get(j-1).getDivisionId())){

                            districts.add(StaticMethod.districtDataList.get(j-1).getDistrictTitle());
                            districtsId.add(StaticMethod.districtDataList.get(j-1).getId());
                        }

                    }


                    districtAdapter.notifyDataSetChanged();
                    districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



                            if(i>0) {

                                district = districts.get(i);
                                RequestPeopleFragment.districtId = districtsId.get(i);

                                areas.clear();
                                areasId.clear();

                                areas.add(0, "Choose Area");
                                areasId.add(0, "0");

                                for (int j = 1; j <= StaticMethod.areaDataList.size(); j++) {

                                    if (districtsId.get(i).equals(StaticMethod.areaDataList.get(j - 1).getDistrictId())) {

                                        areas.add(StaticMethod.areaDataList.get(j - 1).getAreaTitle());
                                        areasId.add(StaticMethod.areaDataList.get(j - 1).getId());
                                    }

                                }


                                areaAdapter.notifyDataSetChanged();
                                areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                        if(i>0) {

                                            area = areas.get(i);
                                            RequestPeopleFragment.areaId = areasId.get(i);
                                        }
                                        else {

                                            area = "";
                                            RequestPeopleFragment.areaId = "";
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> adapterView) {

                                        area = "";
                                        RequestPeopleFragment.areaId = "";
                                    }
                                });

                            }

                            else {

                                district = "";
                                RequestPeopleFragment.districtId = "";
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                            district = "";
                            RequestPeopleFragment.districtId = "";
                        }
                    });

                }
                else {

                    division = "";
                    RequestPeopleFragment.divisionId = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                division = "";
                RequestPeopleFragment.divisionId = "";
            }
        });


    }

    private void initViews(View view) {

        divisionSpinner = view.findViewById(R.id.divisionSpinner);
        districtSpinner = view.findViewById(R.id.districtSpinner);
        areaSpinner = view.findViewById(R.id.areaSpinner);
        submitBtn = view.findViewById(R.id.submitBtn);

    }
}