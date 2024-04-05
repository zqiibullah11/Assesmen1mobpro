package org.d3if3053.assesmen1mobpro

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var txtHasil: TextView
    var nilai = ""
    var operasi = ""
    var hasil = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtHasil = findViewById(R.id.txtHasil)
    }

    fun tombolAngkaClick(view: View) {
        val btn = view as TextView
        nilai += btn.text.toString()
        txtHasil.text = nilai
    }

    fun tombolOperasiClick(view: View) {
        val btn = view as TextView
        operasi = btn.text.toString()
        nilai = ""
    }

    fun tombolSamadenganClick(view: View) {
        if (nilai != "") {
            val angka = nilai.toDouble()
            when (operasi) {
                "+" -> hasil += angka
                "-" -> hasil -= angka
                "*" -> hasil *= angka
                "/" -> {
                    if (angka != 0.0) {
                        hasil /= angka
                    } else {
                        txtHasil.text = "Error"
                        return
                    }
                }
            }
            txtHasil.text = hasil.toString()
            nilai = ""
        }
    }

    fun tombolClearClick(view: View) {
        nilai = ""
        operasi = ""
        hasil = 0.0
        txtHasil.text = "0"
    }
}
