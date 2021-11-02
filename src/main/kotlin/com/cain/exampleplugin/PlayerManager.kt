package com.cain.exampleplugin

import com.cain.exampleplugin.Util.colored
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.entity.Player

object PlayerManager {
    private val playerLevels: MutableMap<Player, Int> = mutableMapOf()

    fun registerPlayer(player: Player) {
        playerLevels[player] = 0
    }

    fun addLevel(player: Player, amount: Int) {
        playerLevels[player] = playerLevels[player]?.plus(amount) ?: 0
        val exp = playerLevels[player] ?: 0
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("MiningExp: &a${exp}".colored()))
    }
}