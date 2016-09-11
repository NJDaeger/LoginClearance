package com.login.auth.java.commands.subcommands;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.chat.Util;
import com.login.auth.java.util.permissions.Perm;

public class Options {
	public static boolean options(CommandSender sndr, String[] args) {
		Player p = (Player) sndr;
		String sep = File.separator;
		File file = new File("plugins"+sep+"LoginClearance"+sep+"users"+sep+p.getUniqueId()+".yml");
		YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
		if (sndr.hasPermission(Perm.options) || sndr.isOp() || sndr.hasPermission(Perm.clearance) || sndr.hasPermission(Perm.all)) {
			if (Util.getConfig().getBoolean("password.AllowOptions") == true) {
				if (args.length >= 2) {
					if (args[1].equals("always") || args[1].equals("server")) {
						c.set("Options", args[1]);
						try {
							c.save(file);
						} catch (IOException e) {
							e.printStackTrace();
						}
						if (c.getString("Options").equals("always")) {
							sndr.sendMessage(ChatColor.GRAY + "Option is now set too: " + ChatColor.GREEN + "ALWAYS" + ChatColor.GRAY + ". You will login whenever you join.");
							return true;
						}
						if (c.getString("Options").equals("server")) {
							sndr.sendMessage(ChatColor.GRAY + "Option is now set too: " + ChatColor.GREEN + "SERVER" + ChatColor.GRAY + ". You will login whenever the server makes you.");
							return true;
						}
					}
					else CUtil.unknown(sndr);
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
