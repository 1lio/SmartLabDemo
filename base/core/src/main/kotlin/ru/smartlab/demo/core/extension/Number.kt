package ru.smartlab.demo.core.extension

// What number corresponds to % of the number
infix fun Int.correspondsNumber(percent: Int) = (this / (this / 100)) * (percent / 100)
infix fun Double.correspondsNumber(percent: Double) = (this / (this / 100)) * (percent / 100)
infix fun Float.correspondsNumber(percent: Float) = (this / (this / 100)) * (percent / 100)
infix fun Long.correspondsNumber(percent: Long) = (this / (this / 100)) * (percent / 100)

// Percent at Number
infix fun Int.percent(number: Int) = 100 * this / number
infix fun Double.percent(number: Double) = 100 * this / number
infix fun Float.percent(number: Float) = 100 * this / number
infix fun Long.percent(number: Long) = 100 * this / number

// Minus percent
infix fun Int.minusPercent(percent: Int) = this - ((this / 100) * percent)
infix fun Double.minusPercent(percent: Double) = this - ((this / 100) * percent)
infix fun Float.minusPercent(percent: Float) = this - ((this / 100) * percent)
infix fun Long.minusPercent(percent: Long) = this - ((this / 100) * percent)
