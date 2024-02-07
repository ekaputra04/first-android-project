package com.example.belajar_android_dasar

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class GameActivity : Activity() {

    lateinit var computerImageView: ImageView
    lateinit var batuImageButton: ImageButton
    lateinit var guntingImageButton: ImageButton
    lateinit var kertasImageButton: ImageButton
    lateinit var resultImageView: ImageView

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        batuImageButton = findViewById(R.id.batuImageButton)
        guntingImageButton = findViewById(R.id.guntingImageButton)
        kertasImageButton = findViewById(R.id.kertasImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

    private fun initListener() {
        batuImageButton.setOnClickListener { startGame("batu") }
        guntingImageButton.setOnClickListener { startGame("gunting") }
        kertasImageButton.setOnClickListener { startGame("kertas") }
    }

    private fun startGame(option: String) {
        val computerOption = Game.pickRandomOption()

        computerImageView.setImageResource(Game.pickDrawable(computerOption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.seri)
            Game.isWin(
                option,
                computerOption
            ) -> resultImageView.setImageResource(R.drawable.menang)

            else -> resultImageView.setImageResource(R.drawable.kalah)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.game)

        initComponents()
        initListener()
    }
}