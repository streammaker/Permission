package com.example.permissionx

import android.content.Intent
import android.content.PeriodicSync
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.librarylzf.PermissionX

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            PermissionX.request(this, android.Manifest.permission.CALL_PHONE) {
                allGranted , deniedList ->
                if (allGranted) {
                    call()
                } else {
                    Toast.makeText(this, "You denied ${deniedList}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = (Uri.parse("tel:10086"))
            startActivity(intent)
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}