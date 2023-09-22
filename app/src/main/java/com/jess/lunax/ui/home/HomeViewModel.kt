package com.jess.lunax.ui.home

import android.icu.util.Calendar
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jess.lunax.domain.DaysInfoProvider
import com.jess.lunax.ui.home.model.DayFromCalendar
import com.jess.lunax.ui.home.model.MoonDayData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val provider: DaysInfoProvider) : ViewModel() {
    private val _todayMoon = MutableLiveData<MoonDayData>()
    val todayMoon: LiveData<MoonDayData> = _todayMoon
    private val c = Calendar.getInstance()
    val ca = Calendar.getInstance()

    companion object{
        const val DAY_IN_MILIS = 86400000
    }

    fun getDataFromDate(offset: Int) {
        ca.timeInMillis = c.timeInMillis + offset * DAY_IN_MILIS
        val daysOld = calculateDaysOld(ca.get(Calendar.YEAR), ca.get(Calendar.DAY_OF_YEAR))
        _todayMoon.value = fetchData(daysOld)
    }

    private fun fetchData(daysOld: Int): MoonDayData {

        val data1 = provider.data[daysOld % 28]
        val data2 = DayFromCalendar(
            ca.get(Calendar.DAY_OF_MONTH),
            getMonth(ca.get(Calendar.MONTH)),
            ca.get(Calendar.YEAR).toString(),
            getDayOfTheWeek(ca.get(Calendar.DAY_OF_WEEK))
        )
        return MoonDayData(data1, data2)
    }

    private fun getMonth(month: Int): String = when (month) {
        0 -> "Ene"
        1 -> "Feb"
        2 -> "Mar"
        3 -> "Abr"
        4 -> "May"
        5 -> "jun"
        6 -> "Jul"
        7 -> "Ago"
        8 -> "Sep"
        9 -> "Oct"
        10 -> "Nov"
        else -> "Dic"
    }

    private fun getDayOfTheWeek(day: Int): String =
        when (day) {
            1 -> "Dom"
            2 -> "Lun"
            3 -> "Mar"
            4 -> "Mie"
            5 -> "Jue"
            6 -> "Vie"
            else -> "Sab"
        }

    //
    private fun calculateDaysOld(year: Int, daysOfYear: Int): Int {
        val totalDays = (year - 2023) * 365 + daysOfYear - 21.6
        if (totalDays > 403) totalDays + 1
        val daysDouble = totalDays / 29.5
        val daysInt = daysDouble.toInt()
        val portion = daysDouble - daysInt
        val daysPortionDouble = portion * 29.5
        return daysPortionDouble.toInt()
    }
}