package com.login.auth.java.commands.subcommands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.chat.Util;
import com.login.auth.java.util.permissions.Perm;

public class Override {
	public static boolean override(CommandSender sndr, String[] args) {
		Player player = (Player) sndr;
		sndr.sendMessage(player.getName());
		if (sndr.hasPermission(Perm.override) || sndr.isOp() || sndr.hasPermission(Perm.clearance) || sndr.hasPermission(Perm.all)) {
			if (Util.getConfig().getBoolean("password.AllowOverrides") == true) {
				if (args.length == 2) {
					if (args[1] != sndr.getName()) {
						for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
							if (pl.getName().equalsIgnoreCase(args[1]) && pl.isOnline()) {
								if (!Util.isLogged(pl)) {
									Util.setLogged(pl, true);
									pl.sendMessage(ChatColor.GRAY + sndr.getName() + " has logged you in.");
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
					else if (!Util.isLogged(player)) {
						Util.setLogged(player, true);
						sndr.sendMessage(ChatColor.GRAY + "You exempted login.");
						return true;
					}
					else CUtil.PLI(sndr, player); 
					return true;
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
		else CUtil.noPerms(sndr);
		return true;
	}
}
