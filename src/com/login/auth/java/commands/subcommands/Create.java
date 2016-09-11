package com.login.auth.java.commands.subcommands;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.encrypt.Format;
import com.login.auth.java.util.permissions.Perm;

public class Create {
	public static boolean create(CommandSender sndr, String[] args) {
		Player p = (Player) sndr;
		String sep = File.separator;
		File file = new File("plugins"+sep+"LoginClearance"+sep+"users"+sep+p.getUniqueId()+".yml");
		YamlConfiguration c = YamlConfiguration.loadConfiguration(file);
		if (sndr.hasPermission(Perm.create) || sndr.isOp() || sndr.hasPermission(Perm.clearance) || sndr.hasPermission(Perm.all)) {
			if (args.length >= 2) {
				if (c.getBoolean("CanCreateNew") == true) {
					if (args[1].length() > 5) {
						int rand = new Random().nextInt(1000000000) + 100000;
						c.set("Type", rand);
						c.set("CanCreateNew", false);
						try {
							c.save(file);
						} catch (IOException e) {
							e.printStackTrace();
						}
						Format.encrypt(args[1], p);
						sndr.sendMessage(ChatColor.GRAY + "Your new password is " + ChatColor.GREEN + "" + args[1] + ChatColor.GRAY + ". If you want a new password contact a staff member with permission to reset yours!");
						sndr.sendMessage(ChatColor.GRAY + "To continue, type \"/login <Your Password>\" to login!");
						return true;
					}
					else CUtil.PTS(sndr);
					return true;
				}
				else CUtil.NRS(sndr);
				return true;
			}
			if (args.length > 2) {
				CUtil.TMA(sndr);
				return true;
			}
			else CUtil.NEA(sndr);
			return true;
		}
		else CUtil.noPerms(sndr);
		return true;	
	}
}
