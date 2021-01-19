package com.innodroid.castshortcut

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (launch("android.settings.WIFI_DISPLAY_SETTINGS") ||
                launch("com.samsung.wfd.LAUNCH_WFD_PICKER_DLG") ||
                launch("android.settings.CAST_SETTINGS")) {
            finish()
            return
        }

        setContentView(R.layout.activity_main)
    }

    private fun launch(action: String): Boolean {
        return try {
            startActivity(Intent(action))
            true
        } catch (ex: ActivityNotFoundException) {
            false
        }
    }
}
