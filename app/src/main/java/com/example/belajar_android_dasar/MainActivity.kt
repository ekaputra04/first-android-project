package com.example.belajar_android_dasar

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.belajar_android_dasar.ui.theme.BelajarandroiddasarTheme

class MainActivity : ComponentActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

    private fun checkFingerPrint() {
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            Log.i("feature", "Feature fingerprint ON")
        } else {
            Log.i("feature", "Feature fingerprint OFF")
        }
    }

    private fun checkPlatformVersion() {
        Log.i("sdk", Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            Log.i("sdk", "disable feature, because version sdk is lower than 31")
        } else {
            Log.i("sdk", "enable feature")
        }
    }

    private fun printHello(name: String) {
        Log.i("debug", name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.hello_world)

        initComponents()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener {
            Log.d("eka", "This is debug log")
            Log.i("eka", "This is info log")
            Log.w("eka", "This is warning log")
            Log.e("eka", "This is error log")

            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("eka", it)
            }

            Log.i("valueResources", resources.getInteger(R.integer.maxPage).toString())
            Log.i("valueResources", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("valueResources", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("valueResources", resources.getColor(R.color.black, theme).toString())

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.purple_200, theme))

//            membaca file external
            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readLine() }

            Log.i("assetJson", json)

//            Raw resources
            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readLine() }

            Log.i("rawResources", sample)

            checkFingerPrint()
            checkPlatformVersion()
            val firstName = "Eka"
            printHello(firstName)
        }
    }
}
