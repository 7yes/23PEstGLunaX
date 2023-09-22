package com.jess.lunax.domain

import com.jess.lunax.R
import com.jess.lunax.ui.home.model.DayData
import javax.inject.Inject

class DaysInfoProvider @Inject constructor() {

    val data = listOf<DayData>(
        DayData(
            0, getPhase(0), R.drawable.luna00
        ),
        DayData(
            1, getPhase(1), R.drawable.luna01
        ),
        DayData(
            2, getPhase(2), R.drawable.luna02
        ),
        DayData(
            3, getPhase(3), R.drawable.luna03
        ),
        DayData(
            4, getPhase(4), R.drawable.luna04
        ),
        DayData(
            5, getPhase(5), R.drawable.luna05
        ),
        DayData(
            6, getPhase(6), R.drawable.luna06
        ),
        DayData(
            7, getPhase(7), R.drawable.luna07
        ),
        DayData(
            8, getPhase(8), R.drawable.luna08
        ),
        DayData(
            9, getPhase(9), R.drawable.luna09
        ),
        DayData(
            10, getPhase(10), R.drawable.luna10
        ),
        DayData(
            12, getPhase(12), R.drawable.luna11
        ),
        DayData(
            13, getPhase(13), R.drawable.luna12
        ),
        DayData(
            14, getPhase(14), R.drawable.luna13
        ),
        DayData(
            15, getPhase(15), R.drawable.luna14
        ),
        DayData(
            16, getPhase(16), R.drawable.luna15
        ),
        DayData(
            17, getPhase(17), R.drawable.luna16
        ),
        DayData(
            18, getPhase(18), R.drawable.luna17
        ),
        DayData(
            19, getPhase(19), R.drawable.luna18
        ),
        DayData(
            20, getPhase(20), R.drawable.luna19
        ),
        DayData(
            21, getPhase(21), R.drawable.luna20
        ),
        DayData(
            22, getPhase(22), R.drawable.luna21
        ),
        DayData(
            23, getPhase(23), R.drawable.luna22
        ),
        DayData(
            24, getPhase(24), R.drawable.luna23
        ),
        DayData(
            25, getPhase(25), R.drawable.luna24
        ),
        DayData(
            26, getPhase(26), R.drawable.luna25
        ),
        DayData(
            27, getPhase(27), R.drawable.luna26
        ),
        DayData(
            28, getPhase(28), R.drawable.luna27
        )
    )

}

private fun getPhase(daysOld: Int): String = when (daysOld) {
    0 -> "Luna Nueva"
    in 1..6 -> "Luna Creciente"
    7 -> "Cuarto Creciente"
    in 8..13 -> "Gibosa Creciente"
    14 -> "Luna Llena"
    in 15..20 -> "Gibosa Menguante"
    21 -> "Cuarto Menguante"
    in 22..28 -> "Luna Menguante"
    else -> "error"
}
