package com.example.androidautotestpoi.car

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session

class CarPoiSession : Session() {

    override fun onCreateScreen(intent: Intent): Screen = CarPoiScreen(carContext)
}