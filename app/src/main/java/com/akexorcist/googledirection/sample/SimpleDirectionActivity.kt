package com.akexorcist.googledirection.sample

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.akexorcist.googledirection.GoogleDirection
import com.akexorcist.googledirection.config.GoogleDirectionConfiguration
import com.akexorcist.googledirection.constant.TransportMode
import com.akexorcist.googledirection.model.Direction
import com.akexorcist.googledirection.model.Route
import com.akexorcist.googledirection.util.DirectionConverter
import com.akexorcist.googledirection.util.execute
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_simple_direction.*

class SimpleDirectionActivity : AppCompatActivity() {
    companion object {
        private const val serverKey = "YOUR_SERVER_KEY"
        private val origin = LatLng(37.7849569, -122.4068855)
        private val destination = LatLng(37.7814432, -122.4460177)
    }

    private var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_direction)

        buttonRequestDirection.setOnClickListener { requestDirection() }

        (supportFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment).getMapAsync { googleMap ->
            this.googleMap = googleMap
        }
    }

    private fun requestDirection() {
        showSnackbar(getString(R.string.direction_requesting))
        GoogleDirectionConfiguration.getInstance().isLogEnabled = BuildConfig.DEBUG
        GoogleDirection.withServerKey(serverKey)
            .from(origin)
            .to(destination)
            .transportMode(TransportMode.DRIVING)
            .execute(
                onDirectionSuccess = { direction -> onDirectionSuccess(direction) },
                onDirectionFailure = { t -> onDirectionFailure(t) }
            )
    }

    private fun onDirectionSuccess(direction: Direction?) {
        direction?.let {
            showSnackbar(getString(R.string.success_with_status, direction.status))
            if (direction.isOK) {
                val route = direction.routeList[0]
                googleMap?.addMarker(MarkerOptions().position(origin))
                googleMap?.addMarker(MarkerOptions().position(destination))
                val directionPositionList = route.legList[0].directionPoint
                googleMap?.addPolyline(
                    DirectionConverter.createPolyline(
                        this,
                        directionPositionList,
                        5,
                        Color.RED
                    )
                )
                setCameraWithCoordinationBounds(route)
                buttonRequestDirection.visibility = View.GONE
            } else {
                showSnackbar(direction.status)
            }
        } ?: run {
            showSnackbar(getString(R.string.success_with_empty))
        }
    }

    private fun onDirectionFailure(t: Throwable) {
        showSnackbar(t.message)
    }

    private fun setCameraWithCoordinationBounds(route: Route) {
        val southwest = route.bound.southwestCoordination.coordination
        val northeast = route.bound.northeastCoordination.coordination
        val bounds = LatLngBounds(southwest, northeast)
        googleMap?.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100))
    }

    private fun showSnackbar(message: String?) {
        message?.let {
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
        }
    }
}
