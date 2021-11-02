package com.cain.exampleplugin

import com.cain.exampleplugin.Util.colored
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.entity.Player
import org.w3c.dom.Text
import kotlin.math.min

object PlayerManager {
    private val playerLevels: MutableMap<Player, Int> = mutableMapOf()

    fun registerPlayer(player: Player) {
        playerLevels[player] = 0
    }

    fun addLevel(player: Player, amount: Int) {
        playerLevels[player] = playerLevels[player]?.plus(amount) ?: 0
        var exp = playerLevels[player] ?: 0
        var miningLevel = 1
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("MiningExp: &a${exp}".colored()))
        if(exp == 1000) {
            miningLevel++
            player.spigot().sendMessage(ChatMessageType.CHAT, TextComponent("&9=================================================".colored()))
            player.spigot().sendMessage(ChatMessageType.CHAT, TextComponent("&bMiningLevelが&a1&b上がりました（現在&a${miningLevel}&bレベル）".colored()))
            player.spigot().sendMessage(ChatMessageType.CHAT, TextComponent("&9=================================================".colored()))
            exp -= 1000
        }
    }
}