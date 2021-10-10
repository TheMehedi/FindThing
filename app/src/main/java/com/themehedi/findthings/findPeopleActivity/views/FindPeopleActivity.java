package com.themehedi.findthings.findPeopleActivity.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.themehedi.findthings.BuildConfig;
import com.themehedi.findthings.R;
import com.themehedi.findthings.datamodels.AreaDataModel;
import com.themehedi.findthings.datamodels.DistrictDataModel;
import com.themehedi.findthings.datamodels.DivisionDataModel;
import com.themehedi.findthings.findPeopleActivity.fragments.RequestPeopleFragment;
import com.themehedi.findthings.findPeopleActivity.models.FindPeopleModel;
import com.themehedi.findthings.findPeopleActivity.presenters.FindPresenter;
import com.themehedi.findthings.findPeopleActivity.presenters.FindPresenterInterface;
import com.themehedi.findthings.utils.CommonMethods;
import com.themehedi.findthings.utils.SessionManager;
import com.themehedi.findthings.utils.StaticMethod;

import java.util.List;

public class FindPeopleActivity extends AppCompatActivity implements FindPresenterInterface, OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private FloatingActionButton myLocationBtn;
    private FindPresenter findPresenter;
    private CommonMethods commonMethods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_people);

        initViews();

        openFragment(new RequestPeopleFragment());

        /*if(!Places.isInitialized()){

            Places.initialize(getApplicationContext(), BuildConfig.MAPS_API_KEY);
        }*/

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        myLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getMyLocationData();
            }
        });
    }

    private void initViews() {

        myLocationBtn = findViewById(R.id.myLocationBtn);

        findPresenter = new FindPresenter(FindPeopleActivity.this, this);
        commonMethods = new CommonMethods(FindPeopleActivity.this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

    }

    private boolean requestLocationPermission() {

        if (ContextCompat.checkSelfPermission(FindPeopleActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)  == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(FindPeopleActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)  == PackageManager.PERMISSION_GRANTED) {
            // You can use the API that requires the permission.

            return true;
        } else {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

            return false;
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (requestLocationPermission()){

            if(commonMethods.isOnline()){

                if(StaticMethod.divisionDataList.size()>0){

                    myLocationBtn.setVisibility(View.VISIBLE);
                    getMyLocationData();
                }
                else {

                    findPresenter.Division();
                }

            }
            else {

                Toast.makeText(getApplicationContext(), "Please enable a stable internet!", Toast.LENGTH_SHORT).show();
            }

            /*myLocationBtn.setVisibility(View.VISIBLE);
            getMyLocationData();*/
        }
        else {

            myLocationBtn.setVisibility(View.GONE);

            /*LatLng defaultLocation = new LatLng(23.802563562596756, 90.40970039543369);
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(defaultLocation, 7);
            mMap.clear();
            mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLocation));
            mMap.animateCamera(cameraUpdate);*/
        }

    }


    @SuppressLint("MissingPermission")
    private void getMyLocationData() {

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            mMap.clear();
                            // Add a marker in Sydney and move the camera
                            LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(myLocation, 15);

                            /*mMap.addMarker(new MarkerOptions()
                                    .position(myLocation)
                                    .title("Hello"));
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
                            mMap.animateCamera(cameraUpdate);*/

                            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.marker);
                            MarkerOptions markerOptions = new MarkerOptions();
                            markerOptions.position(myLocation);
                            markerOptions.title(SessionManager.getStringValue(StaticMethod.NAME, FindPeopleActivity.this)); //Here Total Address is address which you want to show on marker
                            markerOptions.icon(icon);
                            //markerOptions.getPosition();
                            mMap.addMarker(markerOptions).showInfoWindow();
                            //marker.showInfoWindow();
                            mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
                            mMap.animateCamera(cameraUpdate);
                        }
                    }
                });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted. Continue the action or workflow
                // in your app.

                if(commonMethods.isOnline()){

                    findPresenter.Division();
                }
                else {

                    Toast.makeText(getApplicationContext(), "Please enable a stable internet!", Toast.LENGTH_SHORT).show();
                }

            } else {
                // Explain to the user that the feature is unavailable because
                // the features requires a permission that the user has denied.
                // At the same time, respect the user's decision. Don't link to
                // system settings in an effort to convince the user to change
                // their decision.

                Toast.makeText(getApplicationContext(), "You have to enable location to use this service!", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }

        }
    }

    private void openFragment(Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainContainer, fragment)
                .commit();
    }


    @Override
    public void onDivisionResponse(DivisionDataModel divisionDataModel) {

        StaticMethod.divisionDataList.clear();
        StaticMethod.divisionDataList.addAll(divisionDataModel.getData());

        findPresenter.District();
    }

    @Override
    public void onDivisionError(String errMessage) {

        Toast.makeText(getApplicationContext(), errMessage, Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    public void onDistrictResponse(DistrictDataModel districtDataModel) {

        StaticMethod.districtDataList.clear();
        StaticMethod.districtDataList.addAll(districtDataModel.getData());

        findPresenter.Area();
    }

    @Override
    public void onDistrictError(String errMessage) {

        Toast.makeText(getApplicationContext(), errMessage, Toast.LENGTH_SHORT).show();
        onBackPressed();
    }

    @Override
    public void onAreaResponse(AreaDataModel areaDataModel) {

        StaticMethod.areaDataList.clear();
        StaticMethod.areaDataList.addAll(areaDataModel.getData());

        myLocationBtn.setVisibility(View.VISIBLE);
        getMyLocationData();
    }

    @Override
    public void onAreaError(String errMessage) {

        Toast.makeText(getApplicationContext(), errMessage, Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}