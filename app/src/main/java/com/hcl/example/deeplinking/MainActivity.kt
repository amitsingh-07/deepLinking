package com.hcl.example.deeplinking


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            // Get the Intent that started this activity
                val intent = intent

                // Check if the Intent has data (i.e., the deep link URL)
                //example://gizmos?param1=value1&param2=value2"
        /*adb shell am start -W -a android.intent.action.VIEW -d "example://gizmos?param1=I9/JcwAsPVyaFg4yIgIDfg==&param2=value2" com.hcl.example.deeplinking*/
                if (intent?.data != null) {
                // Retrieve the complete URL from the Intent
                    val completeUrl: String? = intent.data.toString()
                    // Get a reference to the TextView widget
                    val urlTextView = findViewById<TextView>(R.id.urlTextView)

                    // Set the text of the TextView to the complete URL
                    urlTextView.text = "Deep Link URL: $completeUrl"

                // Now you can use the completeUrl string as needed
                // For example, you can display it in a toast
                    showToast("Deep Link URL: $completeUrl")

                    // Handle the parameters
                    val param1: String? = intent.data?.getQueryParameter("param1")
                    val decodedParam1: String? = Uri.decode(param1)
                    val param2: String? = intent.data?.getQueryParameter("param2")

                // Use the parameters as needed
                   // showToast("Parameter 1: $param1")
                    showToast("Parameter 1: $decodedParam1")
                    showToast("parameter2: $param2")
                }
            }

            private fun showToast(message: String) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }
