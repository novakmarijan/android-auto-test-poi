package com.example.androidautotestpoi.car

import android.content.Intent
import android.net.Uri
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.CarColor
import androidx.car.app.model.CarIcon
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template

class CarPoiScreen(carContext: CarContext) : Screen(carContext) {

    override fun onGetTemplate(): Template = PaneTemplate.Builder(
        Pane.Builder()
            .addRow(
                Row.Builder()
                .setTitle("Infinum")
                .addText("Strojarska 22")
                .setImage(CarIcon.APP_ICON)
                .build())
            .addAction(
                Action.Builder()
                    .setTitle("Navigate")
                    .setOnClickListener {
                        val intent = Intent().apply {
                            action = CarContext.ACTION_NAVIGATE
                            data = Uri.parse("geo:45.80413855557375, 15.989895154659681")
                        }
                        carContext.startCarApp(intent)
                        screenManager.pop()
                    }
                    .setBackgroundColor(CarColor.GREEN)
                    .build()
            )
            .addAction(
                Action.Builder()
                    .setTitle("Back")
                    .setOnClickListener {
                        screenManager.pop()
                    }
                    .build()
            )
            .build()
    )
        .setTitle("POI")
        .setHeaderAction(Action.BACK)
        .build()
}