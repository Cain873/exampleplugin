package com.cain.exampleplugin

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.player.PlayerJoinEvent

class Main : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        server.pluginManager.registerEvents(PlayerEvent, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}