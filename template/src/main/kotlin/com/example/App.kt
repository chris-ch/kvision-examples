package com.example

import pl.treksoft.kvision.hmr.ApplicationBase
import pl.treksoft.kvision.i18n.DefaultI18nManager
import pl.treksoft.kvision.i18n.I18n
import pl.treksoft.kvision.panel.Root
import pl.treksoft.kvision.require

object App : ApplicationBase {

    private lateinit var root: Root

    override fun start(state: Map<String, Any>) {
        I18n.manager =
                DefaultI18nManager(mapOf("pl" to require("./messages-pl.json"), "en" to require("./messages-en.json")))

        root = Root("kvapp") {
            // TODO
        }
    }

    override fun dispose(): Map<String, Any> {
        root.dispose()
        return mapOf()
    }

    val css = require("./css/kvapp.css")
}
