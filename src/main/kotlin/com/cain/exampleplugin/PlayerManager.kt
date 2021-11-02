package com.cain.exampleplugin

import com.cain.exampleplugin.Util.colored
import com.cain.exampleplugin.actor.Character
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.BaseComponent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.entity.Player

object PlayerManager {
    private val characters = mutableMapOf<Player, Character>()

    fun login(player: Player) {
        characters[player] = Character(player)
    }

    fun logout(player: Player) {
        characters.remove(player)
    }

    fun getCharacter(player: Player) =
        characters[player]
}