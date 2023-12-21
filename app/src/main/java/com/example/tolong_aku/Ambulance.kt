package com.example.tolong_aku

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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

class Ambulance : AppCompatActivity() , View.OnClickListener {

    var modelMainList: MutableList<ModelMain> = ArrayList()
    lateinit var mapController: MapController
    lateinit var overlayItem: ArrayList<OverlayItem>

    private lateinit var inputNama: EditText
    private lateinit var inputNomor: EditText
    private lateinit var btnSave: Button
    private lateinit var database: DatabaseReference
    // komentar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambulance)

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

        inputNama = findViewById(R.id.nama) // Replace with the actual ID from your layout
        inputNomor = findViewById(R.id.nomor) // Replace with the actual ID from your layout
        btnSave = findViewById(R.id.button_tolong) // Replace with the actual ID from your layout
        database = FirebaseDatabase.getInstance("https://login-register-firebase-rpl-default-rtdb.asia-southeast1.firebasedatabase.app").getReference()

        btnSave.setOnClickListener {
            val contactId = database.push().key!!
            val namaValue = inputNama.text.toString().trim()
            val nomorValue = inputNomor.text.toString().trim()
            writeNewUser(contactId, namaValue, nomorValue)
            val moveIntent = Intent(this, Ambulance_lanjutan::class.java)
            startActivities(arrayOf(moveIntent))
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.imageButton -> {
                    val moveIntent = Intent(this, MainMenu::class.java)
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
                this@Ambulance,
                "Oops, ada yang tidak beres. Coba ulangi beberapa saat lagi.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    data class User(val nama: String? = null, val nomor: String? = null) {
        // Null default values create a no-argument default constructor, which is needed
        // for deserialization from a DataSnapshot.
    }

    fun writeNewUser(userId: String, nama: String, nomor: String?) {
        val user = User(nama, nomor)

        database.child("users").child(userId).setValue(user)
    }
}