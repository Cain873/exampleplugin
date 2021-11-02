package com.cain.exampleplugin

import org.bukkit.ChatColor

object Util {
    fun String.colored() =
        ChatColor.translateAlternateColorCodes('&', this)
}