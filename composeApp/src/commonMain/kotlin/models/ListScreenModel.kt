package models

import cafe.adriel.voyager.core.model.ScreenModel
import components.sampleItems

class ListScreenModel : ScreenModel {

    val items = sampleItems

    override fun onDispose() {
        println("ScreenModel: dispose list")
    }
}