package com.example.newapplication


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class RiceViewModel : ViewModel() {

    private val miniCatPricePerKg = 90
    private val normalPricePerKg = 60
    private val dailyConsumptionPerKg = 0.5 // 1 kg for 2 days

    private val _dailyCost = MutableLiveData<Pair<Int, Int>>()
    val dailyCost: LiveData<Pair<Int, Int>> = _dailyCost

    fun calculateDailyCost() {
        val miniCatDaily = (miniCatPricePerKg * dailyConsumptionPerKg).toInt()
        val normalDaily = (normalPricePerKg * dailyConsumptionPerKg).toInt()
        _dailyCost.value = Pair(miniCatDaily, normalDaily)
    }

    fun calculateCostForDays(days: Int): Pair<Int, Int> {
        val miniCatTotal = (miniCatPricePerKg * dailyConsumptionPerKg * days).toInt()
        val normalTotal = (normalPricePerKg * dailyConsumptionPerKg * days).toInt()
        return Pair(miniCatTotal, normalTotal)
    }
}
