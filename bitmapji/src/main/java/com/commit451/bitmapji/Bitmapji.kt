package com.commit451.bitmapji

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.util.TypedValue
import android.widget.TextView
import androidx.annotation.Px

/**
 * Allows you to load an emoji as a Bitmap! See [create].
 */
object Bitmapji {

    /**
     * Create a bitmap given the emoji.
     * @param context The context
     * @param emoji An emoji (or any String, really)
     * @param size The size to make the bitmap. The largest size possible is 93dp (not sure why).
     */
    @JvmStatic
    fun create(context: Context, emoji: String, @Px size: Float): Bitmap {
        val captureView = CaptureTextView(context, size)
        return captureView.capture(emoji)
    }

    @SuppressLint("AppCompatCustomView")
    private class CaptureTextView internal constructor(context: Context, var size: Float) : TextView(context) {

        fun capture(emoji: String?): Bitmap {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
            // Otherwise it is semi-transparent
            setTextColor(Color.BLACK)
            text = emoji
            measure(
                MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
                MeasureSpec.makeMeasureSpec(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
            )
            layout(0, 0, measuredWidth, measuredHeight)
            val b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val c = Canvas(b)
            draw(c)
            return b
        }
    }
}
