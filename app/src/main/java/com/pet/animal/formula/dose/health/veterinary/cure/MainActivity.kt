package com.pet.animal.formula.dose.health.veterinary.cure

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pet.animal.formula.dose.health.veterinary.cure.calculator.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        return when (item.itemId) {
            R.id.info -> {
                //val info = Intent(this, ApiActivity::class.java)
                //startActivity(planets)
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }
}