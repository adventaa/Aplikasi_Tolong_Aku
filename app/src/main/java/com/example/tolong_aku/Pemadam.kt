package com.example.tolong_aku

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapController
import org.osmdroid.views.overlay.OverlayItem
import java.io.IOException
import java.nio.charset.StandardCharsets

class Pemadam : AppCompatActivity() , View.OnClickListener {

    var modelMainList: MutableList<ModelMain> = ArrayList()
    lateinit var mapController: MapController
    lateinit var overlayItem: ArrayList<OverlayItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemadam)

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))

        val geoPoint = GeoPoint(-6.3035467, 106.8693513)
        val mapView: org.osmdroid.views.MapView = findViewById(R.id.mapView)
        mapView.setMultiTouchControls(true)
        mapView.controller.animateTo(geoPoint)
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        mapView.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)

        mapController = mapView.controller as MapController
        mapController.setCenter(geoPoint)
        mapController.zoomTo(15)

        getLocationMarker()

        val buttonClick: ImageButton = findViewById(R.id.imageButton)
        buttonClick.setOnClickListener(this)

        val buttonClick2: Button = findViewById(R.id.button_tolong)
        buttonClick2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.imageButton -> {
                    val moveIntent = Intent(this, MainMenu::class.java)
                    startActivities(arrayOf(moveIntent))
                }

                R.id.button_tolong -> {
                    val moveIntent = Intent(this, Pemadam_lanjutan::class.java)
                    startActivities(arrayOf(moveIntent))
                }
            }
        }
    }

    //get lat long
    private fun getLocationMarker() {
        try {
            val stream = assets.open("sample_maps.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            val strContent = String(buffer, StandardCharsets.UTF_8)
            try {
                val jsonObject = JSONObject(strContent)
                val jsonArrayResult = jsonObject.getJSONArray("results")
                for (i in 0 until jsonArrayResult.length()) {
                    val jsonObjectResult = jsonArrayResult.getJSONObject(i)
                    val modelMain = ModelMain()
                    modelMain.strName = jsonObjectResult.getString("name")
                    modelMain.strVicinity = jsonObjectResult.getString("vicinity")

                    //get lat long
                    val jsonObjectGeo = jsonObjectResult.getJSONObject("geometry")
                    val jsonObjectLoc = jsonObjectGeo.getJSONObject("location")
//                    modelMain.latLoc = jsonObjectLoc.getDouble("lat")
//                    modelMain.longLoc = jsonObjectLoc.getDouble("lng")
                    modelMainList.add(modelMain)
                }
//                initMarker(modelMainList)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        } catch (ignored: IOException) {
            Toast.makeText(
                this@Pemadam,
                "Oops, ada yang tidak beres. Coba ulangi beberapa saat lagi.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}