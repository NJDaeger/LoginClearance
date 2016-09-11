package com.login.auth.java.commands.consolesubcmd;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.chat.Util;
import com.login.auth.java.util.encrypt.Format;
import com.login.auth.java.util.permissions.Perm;

public class ConDecode {
	public static boolean decode(CommandSender sndr, String[] args) {
		Player pl = Bukkit.getPlayer(args[1]);
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
		if (pl == null) {
			CUtil.unknownPlayer(sndr);
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
		sndr.sendMessage(ChatColor.GRAY + pl.getName() + "'s password is " + ChatColor.GREEN + Format.decrypt(Util.getPConfig(pl).getString("Password"), pl) + ChatColor.GRAY + ".");
		return true;
	}
}