package com.example.myapplication2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var layout:LinearLayout
    private lateinit var trgb: TextView
    private lateinit var seekRed: SeekBar
    private lateinit var seekGreen: SeekBar
    private lateinit var seekBlue: SeekBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.layout = findViewById(R.id.background)
        this.trgb = findViewById(R.id.Trgb)
        this.seekRed = findViewById(R.id.r)
        this.seekGreen = findViewById(R.id.g)
        this.seekBlue = findViewById(R.id.b)

        this.seekRed.setOnSeekBarChangeListener(OnChange())
        this.seekGreen.setOnSeekBarChangeListener(OnChange())
        this.seekBlue.setOnSeekBarChangeListener(OnChange())

    }

    inner class OnChange: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar:SeekBar?, progress:Int, fromUser: Boolean){

            //layout.setBackgroundColor(Color.rgb(seekRed.progress, seekGreen.progress,seekBlue.progress))
            layout.setBackgroundColor(Color.rgb(seekRed.progress, seekGreen.progress,seekBlue.progress))
            var formato = String.format("#%02X%02X%02X", seekRed.progress, seekGreen.progress, seekBlue.progress)
            trgb.text = formato
            //trgb.text = "# "+seekRed.progress.toString()+""+seekGreen.progress.toString()+""+seekBlue.progress.toString()

        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {

        }
    }


}