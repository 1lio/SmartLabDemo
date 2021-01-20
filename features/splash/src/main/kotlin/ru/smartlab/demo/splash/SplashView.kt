package ru.smartlab.demo.splash

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.AnimatedVectorDrawable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat

/** == SplashView ==

LinearLayout
- ImageView(Logo)
- Text
- Loader
 */

class SplashView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null) :
    FrameLayout(context, attr) {

    private lateinit var logo: AppCompatImageView

    init {
        configureRoot()
        configureLogo()
        merge()
    }

    private fun configureRoot() {

        // Включаем поддержку векторных ресурсов
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        // По умолчанию тема центрует без учета статус бара, делаем сдвиг снизу
        val margin = context.resources.getDimensionPixelOffset(R.dimen.margin_form)

        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT).apply {
            setMargins(0, 0, 0, margin)
            gravity = Gravity.CENTER
        }

    }

    private fun configureLogo() {
        val animVector =
            ContextCompat.getDrawable(context, R.drawable.logo) as AnimatedVectorDrawable

        logo = AppCompatImageView(context).apply {
            setImageDrawable(animVector)
        }

        animVector.start()
    }

    private fun merge() {
        addView(logo)


        val linearLayout = LinearLayout(context).apply {

            orientation = VERTICAL
            gravity = Gravity.BOTTOM
            setPadding(0, 0, 0, 300)

            addView(TextView(context).apply {
                val tempString = "SMART-LAB"

                gravity = Gravity.CENTER
                textSize = 20f

                val spanString = SpannableString(tempString)
                spanString.setSpan(StyleSpan(Typeface.BOLD), 0, spanString.length, 0)

                text = spanString
                setPadding(0, 100, 0, 0)


            })

            addView(TextView(context).apply {
                text = "Мы делаем деньги на бирже"
                gravity = Gravity.CENTER
                textSize = 16f
            })

        }

        addView(linearLayout)

    }

}
