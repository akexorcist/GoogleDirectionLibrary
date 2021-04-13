package com.akexorcist.googledirection.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akexorcist.googledirection.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSimple.setOnClickListener { goToSimpleDirection() }
        binding.buttonTransit.setOnClickListener { goToTransitDirection() }
        binding.buttonAlternative.setOnClickListener { goToAlternativeDirection() }
        binding.buttonWaypoints.setOnClickListener { goToWaypointsDirection() }
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
