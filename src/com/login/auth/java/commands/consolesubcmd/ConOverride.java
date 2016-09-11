package com.login.auth.java.commands.consolesubcmd;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.chat.Util;

public class ConOverride {
	public static boolean override(CommandSender sndr, String[] args) {
		if (Util.getConfig().getBoolean("password.AllowOverrides") == true) {
			if (args.length == 2) {
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					if (pl.getName().equalsIgnoreCase(args[1]) && pl.isOnline()) {
						if (!Util.isLogged(pl)) {
							Util.setLogged(pl, true);
							sndr.sendMessage(ChatColor.GRAY + "Player " + ChatColor.GREEN + "" + pl.getName() + ChatColor.GRAY + " is now logged in.");
							return true;
						}
						else CUtil.PLI(sndr, pl);
						return true;
					}
					else CUtil.unknownPlayer(sndr);
					return true;
				}
			}
			if (args.length > 2) {
				CUtil.TMA(sndr);
				return true;
			}
			else CUtil.NEA(sndr);
			return true;
		}
		else CUtil.subdisabled(sndr);
		return true;
	}
}
