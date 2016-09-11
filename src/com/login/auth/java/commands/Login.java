package com.login.auth.java.commands;

import java.util.Date;
import java.util.Set;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.chat.Util;
import com.login.auth.java.util.encrypt.Format;
import com.login.auth.java.util.permissions.Perm;

public class Login implements CommandExecutor, BanList{
	Plugin plugin = Bukkit.getPluginManager().getPlugin("LoginClearance");
	public boolean onCommand(CommandSender sndr, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("login") && sndr instanceof Player) {
			Player p = (Player) sndr;
			if (sndr.hasPermission(Perm.login) || sndr.isOp() || sndr.hasPermission(Perm.clearance) || sndr.hasPermission(Perm.all)) {
				if (Util.getPConfig(p).getBoolean("CanCreateNew") != true) {
					if (args.length == 1) {
						if (Util.isLogged(p) != true) {
							String pass = "";
							pass += Format.decrypt(Util.getPConfig(p).getString("Password"), p);
							if (args[0].matches(pass)) {
								Util.setLogged(p, true);
								sndr.sendMessage(ChatColor.GRAY + "Login: " + ChatColor.GREEN + "SUCCESSFUL");
								sndr.sendMessage(ChatColor.GRAY + "Welcome back, " + sndr.getName() + "!");
								Util.resetAtt(p);
								return true;
							}
							else {
								if (Util.getConfig().getBoolean("loginAttempts.LoginAttemptCounter") == true) {
									Util.counter(p);
									int kick = Util.getConfig().getInt("loginAttempts.KickAfter") - Util.getPConfig(p).getInt("Attempts");
									int ban = Util.getConfig().getInt("loginAttempts.BanAfter") - Util.getPConfig(p).getInt("Attempts");
									if (kick > 0) {
										sndr.sendMessage(ChatColor.GRAY + "Login: " + ChatColor.RED + "UNSUCCESSFUL");
										sndr.sendMessage(ChatColor.GRAY + "You have " + kick + " attempts until you are kicked.");
										return true;
									}
									else if (kick <= 0) {
										if (kick == 0) {
											p.kickPlayer(ChatColor.RED + "Incorrect password.");
											return true;
										}
										else if (kick < 0) {
											if (ban > 0) {
												sndr.sendMessage(ChatColor.GRAY + "Login: " + ChatColor.RED + "UNSUCCESSFUL");
												sndr.sendMessage(ChatColor.GRAY + "You have " + ban + " attempts until you are banned.");
												return true;
											}
											else if (ban <= 0) {
												if (ban == 0) {
													Bukkit.getBanList(Type.NAME).addBan(sndr.getName(), ChatColor.RED + "Incorrect password", null, null);
													p.kickPlayer(ChatColor.RED + "Incorrect password. If you want too get unbanned, talk to a staff member!");
													return true;
												}
											}
										}
									}
									/*
									 * chr\eck og \\f the plqyer has a pq\assword
									 */
								}
								else sndr.sendMessage(ChatColor.GRAY + "Login: " + ChatColor.RED + "UNSUCCESSFUL");
								return true;
							}
						}
						else CUtil.PLI(sndr, p);
						return true;
					}
					if (args.length > 1) {
						CUtil.TMA(sndr);
						return true;
					}
					else CUtil.NEA(sndr);
					return true;
				}
				else CUtil.noPassword(p);
				return true;
			}	
			else CUtil.noPerms(sndr);
			return true;
		}
		else CUtil.onlyPlayers(sndr);
		return true;
	}
	public BanEntry addBan(String arg0, String arg1, Date arg2, String arg3) {
		return null;
	}
	public Set<BanEntry> getBanEntries() {
		return null;
	}
	public BanEntry getBanEntry(String arg0) {
		return null;
	}
	public boolean isBanned(String arg0) {
		return false;
	}
	public void pardon(String arg0) {
		
	}
}
