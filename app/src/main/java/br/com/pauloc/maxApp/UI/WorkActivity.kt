package br.com.pauloc.maxApp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.pauloc.maxApp.R
import br.com.pauloc.maxApp.commons.servicos.Notificacao
import kotlinx.android.synthetic.main.activity_work.*

class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val navigationHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment?
        NavigationUI.setupWithNavController(bottom_nav, navigationHostFragment!!.navController)

        stopService(Intent(this, Notificacao::class.java))
    }

    override fun onResume() {
        super.onResume()
        stopService(Intent(this,Notificacao::class.java))
    }
}
