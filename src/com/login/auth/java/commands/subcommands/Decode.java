package com.login.auth.java.commands.subcommands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.chat.Util;
import com.login.auth.java.util.encrypt.Format;
import com.login.auth.java.util.permissions.Perm;

public class Decode {
	
	
	
	public static boolean decode(CommandSender sndr, String[] args) {
		if (sndr.hasPermission(Perm.clearance) || sndr.hasPermission(Perm.decode) || sndr.isOp()) {
			Player p = (Player) sndr;
			if (Util.getConfig().getBoolean("password.AllowDecode") != true) {
				CUtil.subdisabled(sndr);
				return true;
			}
			if (args.length < 2) {
				CUtil.NEA(sndr);
				return true;
			}
			if (args.length > 2) {
				CUtil.TMA(sndr);
				return true;
			}
			for (Player pl : Bukkit.getOnlinePlayers()) {
				if (!pl.getName().equalsIgnoreCase(args[1])) {
					continue;
				}
				else {
					if (sndr.getName().equalsIgnoreCase(args[1])) {
						sndr.sendMessage(ChatColor.GRAY + "Your password is " + ChatColor.GREEN + Format.decrypt(Util.getPConfig(p).getString("Password"), p) + ChatColor.GRAY + ".");
						return true;
					}
					if (pl.hasPermission(Perm.protect) || pl.isOp() || pl.hasPermission(Perm.clearance)) {
						CUtil.disabled(sndr);
						return true;
					}
					if (Util.getPConfig(pl).getString("Password") == null) {
						CUtil.noPassword(sndr);
						return true;
					}
					else {
						sndr.sendMessage(ChatColor.GRAY + pl.getName() + "'s password is " + ChatColor.GREEN + Format.decrypt(Util.getPConfig(pl).getString("Password"), pl) + ChatColor.GRAY + ".");
						return true;
					}
				}
			}
		}	
		else CUtil.noPerms(sndr);
		return true;
	}
}