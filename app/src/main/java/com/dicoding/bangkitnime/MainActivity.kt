package com.dicoding.bangkitnime

import android.content.Intent
import android.media.RouteListingPreference.Item
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKarakter: RecyclerView
    private val list = ArrayList<Karakter>()

    private fun showSelectedHero(hero: Karakter) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKarakter = findViewById(R.id.rv_karakter)
        rvKarakter.setHasFixedSize(true)

        list.addAll(getListKarakter())
        showRecyclerList()

    }
    /////////////
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_list -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    //////////

    //bbuat nampilin tampilan menu ke main activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun getListKarakter(): ArrayList<Karakter>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listKarakter = ArrayList<Karakter>()
        for (i in dataName.indices){
            val karakter = Karakter(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listKarakter.add(karakter)
        }
        return listKarakter
    }
    private fun showRecyclerList() {
        rvKarakter.layoutManager = LinearLayoutManager(this)
        val listKarakterAdapter = ListKarakterAdapater(list)
        rvKarakter.adapter = listKarakterAdapter

        listKarakterAdapter.setOnItemClickCallback(object : ListKarakterAdapater.OnItemClickCallback{
            override fun onItemClicked(data: Karakter) {
                showSelectedHero(data)
            }
        })
    }
}