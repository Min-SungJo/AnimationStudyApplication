package com.example.animationstudyapplication

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHeart = findViewById<Button>(R.id.btnHeart)
        val btnConfetti = findViewById<Button>(R.id.btnConfetti)
        val animHeart = findViewById<LottieAnimationView>(R.id.animHeart)
        val animHeartGray = findViewById<LottieAnimationView>(R.id.animHeartGray)
        val animConfetti = findViewById<LottieAnimationView>(R.id.animConfetti)

        var booleanHeart:Boolean=false

        btnHeart.setOnClickListener {
            Log.d("button","Click!")

            if(booleanHeart==false) {
                booleanHeart = true
                animHeart.visibility=View.VISIBLE
                animHeartGray.visibility=View.INVISIBLE
                // animation custom
                val animator = ValueAnimator
                    .ofFloat(0f, 1f) // 0f ~1f -> animation 시작과 끝지점(0%~100%) 설정
                    .setDuration(1000) // 지속시간 1초

                animator.addUpdateListener {
                    animHeart.setProgress(
                        it.getAnimatedValue() as Float
                    )
                }
                animator.start()
            }else{
                booleanHeart =false
                animHeart.visibility=View.INVISIBLE
                animHeartGray.visibility=View.VISIBLE
                // animation custom
                val animator = ValueAnimator
                    .ofFloat(0f, 1f) // 0f ~1f -> animation 시작과 끝지점(0%~100%) 설정
                    .setDuration(1000) // 지속시간 1초

                animator.addUpdateListener {
                    animHeartGray.setProgress(
                        it.getAnimatedValue() as Float
                    )
                }
                animator.start()
            }
        }
        btnConfetti.setOnClickListener {
            Log.d("button","Click!")

            // animation custom
            val animator = ValueAnimator
                .ofFloat(0f,1f) // 0f ~1f -> animation 시작과 끝지점(0%~100%) 설정
                .setDuration(1000) // 지속시간 1초

            animator.addUpdateListener {
                animConfetti.setProgress(
                    it.getAnimatedValue() as Float
                )
            }
            animator.start()
        }
    }
}