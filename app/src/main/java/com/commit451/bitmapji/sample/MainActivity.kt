package com.commit451.bitmapji.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.commit451.bitmapji.Bitmapji
import com.github.jinatonic.confetti.ConfettiManager
import com.github.jinatonic.confetti.ConfettiSource
import com.github.jinatonic.confetti.ConfettoGenerator
import com.github.jinatonic.confetti.confetto.BitmapConfetto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val size = resources.getDimensionPixelSize(R.dimen.bitmap_size)
        val bitmap = Bitmapji.create(
            this,
            "\uD83D\uDD25" + "❤️",
            size.toFloat()
        )
        image.setImageBitmap(bitmap)
        buttonConfetti.setOnClickListener {
            val velocitySlow = resources.getDimensionPixelOffset(R.dimen.default_velocity_slow)
                .toFloat()
            val velocityNormal = resources.getDimensionPixelOffset(R.dimen.default_velocity_normal)
                .toFloat()
            val confettoGenerator = ConfettoGenerator {
                BitmapConfetto(bitmap)
            }
            val source = ConfettiSource(0, -size, confetti.width, -size)
            val confettiManager = ConfettiManager(this, confettoGenerator, source, confetti)
                .setVelocityX(0f, velocitySlow)
                .setVelocityY(velocityNormal, velocitySlow)
                .setRotationalVelocity(180f, 90f)
                .setTouchEnabled(true)
            confettiManager.setNumInitialCount(20)
                .setEmissionDuration(0)
                .animate()
        }
    }
}
