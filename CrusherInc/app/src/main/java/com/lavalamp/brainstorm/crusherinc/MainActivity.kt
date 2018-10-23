package com.lavalamp.brainstorm.crusherinc

import android.app.FragmentManager
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        nav_view.getMenu().getItem(0).isChecked = true;
        val fragmentManager: FragmentManager = fragmentManager
        fragmentManager.beginTransaction().replace(R.id.content_frame, ImageFragment()).commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragmentManager: FragmentManager = fragmentManager
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_upgrade -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, UpgradeFragment()).commit()
            }
            R.id.nav_contracts -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, ContractsFragment()).commit()
            }
            R.id.nav_dashboard -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, DashboardFragment()).commit()
            }
            R.id.nav_shop -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, ShopFragment()).commit()
            }
            R.id.nav_image -> {
                fragmentManager.beginTransaction().replace(R.id.content_frame, ImageFragment()).commit()
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}

