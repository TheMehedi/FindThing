package com.themehedi.findthings.findPeopleActivity.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

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
import com.themehedi.findthings.utils.SessionManager;
import com.themehedi.findthings.utils.StaticMethod;

public class FindPeopleActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private FloatingActionButton myLocationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_people);

        myLocationBtn = findViewById(R.id.myLocationBtn);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if(!Places.isInitialized()){

            Places.initialize(getApplicationContext(), BuildConfig.MAPS_API_KEY);
        }

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
            myLocationBtn.setVisibility(View.VISIBLE);
            getMyLocationData();
        }
        else {

            myLocationBtn.setVisibility(View.GONE);

            LatLng defaultLocation = new LatLng(23.802563562596756, 90.40970039543369);
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(defaultLocation, 7);
            mMap.clear();
            mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLocation));
            mMap.animateCamera(cameraUpdate);
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
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==1) {

            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted. Continue the action or workflow
                // in your app.

                myLocationBtn.setVisibility(View.VISIBLE);
                getMyLocationData();

            } else {
                // Explain to the user that the feature is unavailable because
                // the features requires a permission that the user has denied.
                // At the same time, respect the user's decision. Don't link to
                // system settings in an effort to convince the user to change
                // their decision.
            }

        }
    }
}