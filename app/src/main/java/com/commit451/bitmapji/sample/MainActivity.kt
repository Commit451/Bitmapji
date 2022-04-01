package com.commit451.bitmapji.sample

import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.commit451.bitmapji.Bitmapji
import com.commit451.bitmapji.sample.databinding.ActivityMainBinding
import com.github.jinatonic.confetti.ConfettiManager
import com.github.jinatonic.confetti.ConfettiSource
import com.github.jinatonic.confetti.ConfettoGenerator
import com.github.jinatonic.confetti.confetto.BitmapConfetto
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val size = resources.getDimensionPixelSize(R.dimen.bitmap_size)
        val bitmap = Bitmapji.create(
            this,
            "❤️",
            size.toFloat()
        )
        binding.image.setImageBitmap(bitmap)
        binding.buttonConfetti.setOnClickListener {
            val velocity = resources.getDimensionPixelOffset(R.dimen.confetti_velocity)
                .toFloat()
            val deviation = resources.getDimensionPixelOffset(R.dimen.confetti_velocity_deviation)
                .toFloat()
            val confettoGenerator = ConfettoGenerator {
                BitmapConfetto(bitmap)
            }
            val source = ConfettiSource(0, -size, binding.confetti.width, -size)
            val confettiManager = ConfettiManager(this, confettoGenerator, source, binding.confetti)
                .setVelocityX(0f, 0f)
                .setVelocityY(velocity, deviation)
                .setRotationalVelocity(45f, 60f)
                .setTTL(TimeUnit.SECONDS.toMillis(3))
                .enableFadeOut(LinearInterpolator())
            confettiManager.setNumInitialCount(10)
                .setEmissionDuration(0)
                .animate()
        }
    }
}
