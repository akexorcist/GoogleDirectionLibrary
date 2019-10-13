package com.akexorcist.googledirection.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSimple.setOnClickListener { goToSimpleDirection() }
        buttonTransit.setOnClickListener { goToTransitDirection() }
        buttonAlternative.setOnClickListener { goToAlternativeDirection() }
        buttonWaypoints.setOnClickListener { goToWaypointsDirection() }
    }

    private fun goToSimpleDirection() {
        openActivity(SimpleDirectionActivity::class.java)
    }

    private fun goToTransitDirection() {
        openActivity(TransitDirectionActivity::class.java)
    }

    private fun goToAlternativeDirection() {
        openActivity(AlternativeDirectionActivity::class.java)
    }

    private fun goToWaypointsDirection() {
        openActivity(WaypointsDirectionActivity::class.java)
    }

    private fun openActivity(cs: Class<*>) {
        startActivity(Intent(this, cs))
    }
}
