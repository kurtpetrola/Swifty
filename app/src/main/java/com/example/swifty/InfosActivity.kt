package com.example.swifty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout

class InfosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        // 1. Setup the Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // 2. Get the CollapsingToolbarLayout instance
        val collapsingToolbar: CollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar)

        // 3. Get the data from the intent
        val bundle: Bundle? = intent.extras
        val heading = bundle?.getString("heading") ?: "Info Details"
        val infos = bundle?.getString("infos")

        // 4. Set the title on the CollapsingToolbarLayout
        // This makes the title appear large at the bottom when expanded.
        collapsingToolbar.title = heading

        // 5. Enable the Up (back) button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 6. Set the main body text in the ScrollView's TextView
        val mainSwift: TextView = findViewById(R.id.infos)
        mainSwift.text = infos
    }

    // 7. Handle the Up (back) button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}