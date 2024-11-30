package com.example.snowflakes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.AsyncTask
import kotlin.random.Random
import android.os.Build
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi

data class Snowflake(var x: Float, var y: Float,
                     val velocity: Float, val radius: Float, val color: Int)
lateinit var snow: Array<Snowflake>
val paint = Paint()
var h = 1000; var w = 1000

open class SnowFlakes(ctx: Context) : View(ctx) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //процесс отрисовки приложения
        canvas.drawColor(Color.rgb(21, 3, 46))

        for (s in snow) {
            paint.color = s.color
            canvas.drawCircle(s.x, s.y, s.radius, paint)
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        h = bottom - top; w = right - left
        val r = Random(0)
//        r.nextFloat()
        snow = Array(100) { Snowflake(x = r.nextFloat() * w, y =  r.nextFloat() * h,
            velocity = 5 + 10 * r.nextFloat(), radius = 30 + 10 * r.nextFloat(),
            Color.rgb(200 + r.nextInt(56), 200 + r.nextInt(56),
                200 + r.nextInt(56)))
        }
    }

    fun moveSnowflakes() {
        for (s in snow) {
            val horizontalSpeed = 5f
            val speedFactor = if (s.y > h / 1.3) {
                0.4f
            } else {
                1.0f
            }
            s.y += s.velocity * speedFactor
            s.x += horizontalSpeed

            if (s.y > h) {
                s.y -= h
            }
            if (s.x > w) {
                s.x = 0f
            }
        }
        invalidate()
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        moveSnowflakes()
//        moveTask = MoveTask(this)
//        moveTask.execute(100)
        return true

    }
//    class MoveTask(val s: SnowFlakes) : AsyncTask<Int, Int, Int>() {
//        // https://developer.alexanderklimov.ru/android/theory/asynctask.php
//        override fun doInBackground(vararg params: Int?): Int {
//            val delay = params[0] ?: 200 // если задерка не задана
//            while (true) {
//                Thread.sleep(delay.toLong())
//                s.moveSnowflakes()
//            }
//            return 0
//        }
//    }
}