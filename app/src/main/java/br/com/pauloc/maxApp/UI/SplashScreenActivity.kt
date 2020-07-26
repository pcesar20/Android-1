package br.com.pauloc.maxApp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.pauloc.maxApp.R
import br.com.pauloc.maxapp.UI.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            kotlin.run {
                this.startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        },3000)
    }
}
