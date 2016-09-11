package com.login.auth.java.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.login.auth.java.util.chat.CUtil;
import com.login.auth.java.util.chat.Util;
import com.login.auth.java.util.permissions.Perm;

public class Auth implements CommandExecutor{
	Plugin plugin = Bukkit.getPluginManager().getPlugin("LoginClearance");
	public boolean onCommand(CommandSender sndr, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("auth") && sndr instanceof Player) {
			if (sndr.hasPermission(Perm.disable) || sndr.hasPermission(Perm.clearance) || sndr.isOp()) {
				if (args.length > 1) {
					CUtil.TMA(sndr);
					return true;
				}
				if (args.length < 1) {
					CUtil.NEA(sndr);
					return true;
				}
				if (args[0].equalsIgnoreCase("disable") || args[0].equalsIgnoreCase("off")) {
					if (Util.getConfig().getBoolean("login.DisableLogin") == true) {
						sndr.sendMessage(ChatColor.RED + "Logging in is already disabled. If you want to enable it do \"/auth enable\".");
						return true;
					}
					else {
						sndr.sendMessage(ChatColor.GRAY + "You " + ChatColor.GREEN + "DISABLED" + ChatColor.GRAY + " player logins.");
						CUtil.serverMessage(ChatColor.GRAY + "Player login is now " + ChatColor.GREEN + "DISABLED" + ChatColor.GRAY + ".");
						Util.getConfig().set("login.DisableLogin", true);
						plugin.saveConfig();
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("on")) {
					if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
						sndr.sendMessage(ChatColor.RED + "Logging in is already enabled. If you want to disable it do \"/auth disable\".");
						return true;
					}
					else {
						sndr.sendMessage(ChatColor.GRAY + "You " + ChatColor.GREEN + "ENABLED" + ChatColor.GRAY + " player logins.");
						CUtil.serverMessage(ChatColor.GRAY + "Player login is now " + ChatColor.GREEN + "ENABLED" + ChatColor.GRAY + ".");
						Util.getConfig().set("login.DisableLogin", true);
						plugin.saveConfig();
						return true;
					}
				}
				
			}
			
			/*
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("disable")) {
					if (sndr.hasPermission(Perm.disable) || sndr.hasPermission(Perm.clearance) || sndr.isOp()) {
						if (Util.getConfig().getBoolean("login.DisableLogin") == true) {
							sndr.sendMessage(ChatColor.RED + "Logging in is already disabled. If you want to enable it do \"/auth enable\".");
							return true;
						}
						else if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
							sndr.sendMessage(ChatColor.GRAY + "You " + ChatColor.GREEN + "DISABLED" + ChatColor.GRAY + " player logins.");
							Util.getConfig().set("login.DisableLogin", true);
							plugin.saveConfig();
							return true;
						}
					}
					else CUtil.noPerms(sndr);
					return true;
				}
				else if (args[0].equalsIgnoreCase("enable")) {
					if (sndr.hasPermission(Perm.enable) || sndr.hasPermission(Perm.clearance) || sndr.isOp()) {
						if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
							sndr.sendMessage(ChatColor.RED + "Logging in is already enabled. If you want to disable it do \"/auth disable\".");
							return true;
						}
						else if (Util.getConfig().getBoolean("login.DisableLogin") == true) {
							sndr.sendMessage(ChatColor.GRAY + "You " + ChatColor.GREEN + "ENABLED" + ChatColor.GRAY + " player logins.");
							Util.getConfig().set("login.DisableLogin", false);
							plugin.saveConfig();
							return true;
						}
					}
					else CUtil.noPerms(sndr);
					return true;
				}
				else CUtil.unknown(sndr);
				return true;
			}
			else if (args.length > 1) {
				CUtil.TMA(sndr);
				return true;
			}
			else CUtil.NEA(sndr);
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("auth") && !(sndr instanceof Player)) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("disable")) {
					if (Util.getConfig().getBoolean("login.DisableLogin") == true) {
						sndr.sendMessage(ChatColor.RED + "Logging in is already disabled. If you want to enable it do \"/auth enable\".");
						return true;
					}
					else if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
						sndr.sendMessage(ChatColor.GRAY + "You " + ChatColor.GREEN + "DISABLED" + ChatColor.GRAY + " player logins.");
						Util.getConfig().set("login.DisableLogin", true);
						plugin.saveConfig();
						return true;
					}
				}
				else if (args[0].equalsIgnoreCase("enable")) {
					if (Util.getConfig().getBoolean("login.DisableLogin") == false) {
						sndr.sendMessage(ChatColor.RED + "Logging in is already enabled. If you want to disable it do \"/auth disable\".");
						return true;
					}
					else if (Util.getConfig().getBoolean("login.DisableLogin") == true) {
						sndr.sendMessage(ChatColor.GRAY + "You " + ChatColor.GREEN + "ENABLED" + ChatColor.GRAY + " player logins.");
						Util.getConfig().set("login.DisableLogin", false);
						plugin.saveConfig();
						return true;
					}
				}
				else CUtil.unknown(sndr);
				return true;
			}
			else if (args.length > 1) {
				CUtil.TMA(sndr);
				return true;
			}
			else CUtil.NEA(sndr);
			return true;*/
		}
		return true;
		
	}
}
