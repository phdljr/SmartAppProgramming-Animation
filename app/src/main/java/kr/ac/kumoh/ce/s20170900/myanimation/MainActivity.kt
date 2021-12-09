package kr.ac.kumoh.ce.s20170900.myanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import kr.ac.kumoh.ce.s20170900.myanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var scale: ScaleAnimation? = null
    private var translate: TranslateAnimation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        scale = ScaleAnimation(
            1F, 1F, 0F, (0..100).random().toFloat()/100F,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 1f
        )
        scale?.duration = 1000
        scale?.fillBefore = false
        scale?.fillAfter = true

        translate = TranslateAnimation(
            Animation.ABSOLUTE, 0F,
            Animation.ABSOLUTE, 0F,
            Animation.ABSOLUTE, 0F,
            Animation.ABSOLUTE, -50F,
        )
        translate?.duration = 1000
        translate?.fillBefore = false
        translate?.fillAfter = true

        binding.btnAnimate.setOnClickListener {
//            scale = ScaleAnimation(
//                1F, 1F, 0F, (0..100).random().toFloat()/100F,
//                Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 1f
//            )
//            scale?.duration = 1000
//            scale?.fillBefore = false
//            scale?.fillAfter = true

            val rotate = RotateAnimation(
                0F, (360..360*4).random().toFloat(),
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1f
            )

            rotate.duration = 3000
            rotate.fillBefore = false
            rotate.fillAfter = true
            binding.imageView1.startAnimation(rotate)
            binding.imageView2.startAnimation(scale)
            //binding.imageView2.startAnimation(translate)
        }
    }
}