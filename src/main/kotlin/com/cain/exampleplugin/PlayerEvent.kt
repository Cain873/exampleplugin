package com.cain.exampleplugin

import com.cain.exampleplugin.PlayerManager.addLevel
import com.cain.exampleplugin.PlayerManager.registerPlayer
import com.cain.exampleplugin.Util.colored
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.player.PlayerJoinEvent

object PlayerEvent : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.joinMessage = "こんにちは、&1${event.player.displayName}&rさん".colored()
        registerPlayer(event.player)
    }
    @EventHandler
    fun onBreak(event: PlayerInteractEvent) {
        if(event.action == Action.LEFT_CLICK_BLOCK) {
            event.clickedBlock?.breakNaturally()
            addLevel(event.player, 1)
        }
    }
}
