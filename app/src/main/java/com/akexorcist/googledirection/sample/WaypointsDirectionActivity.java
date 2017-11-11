package com.akexorcist.googledirection.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.akexorcist.googledirection.DirectionCallback;
import com.akexorcist.googledirection.GoogleDirection;
import com.akexorcist.googledirection.config.GoogleDirectionConfiguration;
import com.akexorcist.googledirection.constant.TransportMode;
import com.akexorcist.googledirection.model.Direction;
import com.akexorcist.googledirection.model.Leg;
import com.akexorcist.googledirection.model.Route;
import com.akexorcist.googledirection.model.Step;
import com.akexorcist.googledirection.util.DirectionConverter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Akexorcist on 11/10/2017 AD.
 */

public class WaypointsDirectionActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback, DirectionCallback {
    private Button btnRequestDirection;
    private GoogleMap googleMap;
    private String serverKey = "YOUR_SERVER_KEY";
    private LatLng origin = new LatLng(41.8838111, -87.6657851);
    private LatLng destination = new LatLng(41.900689, -87.6487378);
    private List<LatLng> waypoints = Arrays.asList(
            new LatLng(41.8764273, -87.6555114),
            new LatLng(41.8911366, -87.647443)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transit_direction);

        btnRequestDirection = findViewById(R.id.btn_request_direction);
        btnRequestDirection.setOnClickListener(this);

        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_request_direction) {
            requestDirection();
        }
    }

    public void requestDirection() {
        Snackbar.make(btnRequestDirection, "Direction Requesting...", Snackbar.LENGTH_SHORT).show();
        GoogleDirectionConfiguration.getInstance().setLogEnabled(true);
        GoogleDirection.withServerKey(serverKey)
                .from(origin)
                .to(destination)
                .transportMode(TransportMode.DRIVING)
                .waypoints(waypoints)
                .execute(this);
    }

    @Override
    public void onDirectionSuccess(Direction direction, String rawBody) {
        Snackbar.make(btnRequestDirection, "Success with status : " + direction.getStatus(), Snackbar.LENGTH_SHORT).show();
        if (direction.isOK()) {
            Route route = direction.getRouteList().get(0);
            int legCount = route.getLegList().size();
            for (int index = 0; index < legCount; index++) {
                Leg leg = route.getLegList().get(index);
                googleMap.addMarker(new MarkerOptions().position(leg.getStartLocation().getCoordination()));
                if (index == legCount - 1) {
                    googleMap.addMarker(new MarkerOptions().position(leg.getEndLocation().getCoordination()));
                }
                List<Step> stepList = leg.getStepList();
                ArrayList<PolylineOptions> polylineOptionList = DirectionConverter.createTransitPolyline(this, stepList, 5, Color.RED, 3, Color.BLUE);
                for (PolylineOptions polylineOption : polylineOptionList) {
                    googleMap.addPolyline(polylineOption);
                }
            }
            setCameraWithCoordinationBounds(route);
            btnRequestDirection.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDirectionFailure(Throwable t) {
        Snackbar.make(btnRequestDirection, t.getMessage(), Snackbar.LENGTH_SHORT).show();
    }

    private void setCameraWithCoordinationBounds(Route route) {
        LatLng southwest = route.getBound().getSouthwestCoordination().getCoordination();
        LatLng northeast = route.getBound().getNortheastCoordination().getCoordination();
        LatLngBounds bounds = new LatLngBounds(southwest, northeast);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));
    }
}
