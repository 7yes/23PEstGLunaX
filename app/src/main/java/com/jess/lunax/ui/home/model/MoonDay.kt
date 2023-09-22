package com.jess.lunax.ui.home.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MoonDayData(
    val moonData:DayData,
    val dayDataCalendar:DayFromCalendar
)

data class DayData(val daysOld: Int,
                       val phase: String,
                       @DrawableRes val photo: Int,)

data class DayFromCalendar(val dayOfMonth:Int,
                           val month:String,
                           val year:String,
                           val weekDay:String)