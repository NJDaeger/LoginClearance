package com.login.auth.java.commands.consolesubcmd;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.chat.Util;

public class ConReset {
	public static boolean reset(CommandSender sndr, String[] args) {
		if (Util.getConfig().getBoolean("password.AllowReset") == true) {
			if (args.length == 2) {
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					String sep = File.separator;
					File file = new File("plugins"+sep+"LoginClearance"+sep+"users"+sep+pl.getPlayer().getUniqueId()+".yml");
					YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
					if (pl.getName().equalsIgnoreCase(args[1])) {
						if (Util.getPConfig(pl).getString("Password") != null) {
							c.set("Password", null);
							c.set("CanCreateNew", true);
							try {
								c.save(file);
							} catch (IOException e) {
								e.printStackTrace();
							}
							pl.sendMessage(ChatColor.GRAY + "You have been granted access to change your password!");
							sndr.sendMessage(ChatColor.GRAY + "You granted " + ChatColor.GREEN + pl.getName() + ChatColor.GRAY + " access to change his password.");
							return true;
						}
						else CUtil.noPassword(sndr);
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
