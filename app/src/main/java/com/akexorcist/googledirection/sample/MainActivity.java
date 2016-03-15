package com.akexorcist.googledirection.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_simple).setOnClickListener(this);
        findViewById(R.id.btn_transit).setOnClickListener(this);
        findViewById(R.id.btn_waypoints).setOnClickListener(this);
        findViewById(R.id.btn_alternative).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_simple) {
            goToSimpleDirection();
        } else if (id == R.id.btn_transit) {
            goToTransitDirection();
        }else if (id==R.id.btn_waypoints){
            goToWaypointsDirection();
        }else if (id == R.id.btn_alternative) {
            goToAlternativeDirection();
        }
    }

    public void goToSimpleDirection() {
        openActivity(SimpleDirectionActivity.class);
    }

    public void goToTransitDirection() {
        openActivity(TransitDirectionActivity.class);
    }

    public void goToWaypointsDirection() {
        openActivity(WaypointsDirectionActivity.class);
    }

    public void goToAlternativeDirection() {
        openActivity(AlternativeDirectionActivity.class);
    }

    public void openActivity(Class<?> cs) {
        startActivity(new Intent(this, cs));
    }
}
