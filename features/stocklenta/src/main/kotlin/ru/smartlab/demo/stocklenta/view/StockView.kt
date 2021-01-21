package ru.smartlab.demo.stocklenta.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

/** Feed popular exchange instruments
 * Topline indicators news example https://chr.rbc.ru/
 *
 * =============================================
 * ..] [USD Ex. 37.36 ↓ -0.75%] [IMOEX  3486 ↑ +...
 * _____________________________________________
 * =============================================
 *
 * */

// или просто использовать движущийся текст)

class StockView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null) :
    View(context, attr) {

    companion object {
        const val DEF_LAYOUT_HEIGHT = 80
        const val DEF_TEXT_SIZE = 18f
        const val DEF_SPACING_SIZE = 8f

        const val DEF_BACKGROUND_COLOR = Color.WHITE
        const val DEF_TITLE_TEXT_COLOR = Color.BLACK
        const val DEF_TYPE_TEXT_COLOR = Color.DKGRAY
        const val DEF_UP_PRICE_COLOR = Color.GREEN
        const val DEF_DOWN_PRICE_COLOR = Color.RED

        const val ANIMATION_SPEED = 1f
        const val USE_BOTTOM_DIVIDER = true
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }


    private fun drawBackground(canvas: Canvas) {

    }


    private fun addSubView() {}

    private fun removeView() {}

}
