package com.cain.exampleplugin

import com.cain.exampleplugin.PlayerManager.login
import com.cain.exampleplugin.Util.colored
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent

object PlayerEvent : Listener {
    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.joinMessage = "こんにちは、&1${event.player.displayName}&rさん".colored()
        login(event.player)
    }

    @EventHandler
    fun onBreak(event: PlayerInteractEvent) {
        if (event.action == Action.LEFT_CLICK_BLOCK) {
            event.clickedBlock?.breakNaturally()
            PlayerManager.getCharacter(event.player)?.let {
                it.attribute.miningExp += 1
                it.source.spigot().sendMessage(
                    ChatMessageType.ACTION_BAR,
                    TextComponent("MiningExp: &a${it.attribute.miningExp}".colored())
                )
            }
        }
    }
}
