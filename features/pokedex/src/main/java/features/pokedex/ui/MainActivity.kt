package features.pokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import features.pokedex.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}