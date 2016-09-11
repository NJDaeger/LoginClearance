package com.login.auth.java.util.chat;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.login.auth.java.util.permissions.Perm;

public class CUtil {
	public static void unknown(CommandSender s) { //Unknown command chapter
		s.sendMessage(ChatColor.RED + "Unknown command chapter.");
		return;
	}
	public static void noPerms(CommandSender s) { //No permission.
		s.sendMessage(ChatColor.RED + "You don't have permission to do that!");
		return;
	}
	public static void NEA(CommandSender s) { //Not enough arguments.
		s.sendMessage(ChatColor.RED + "Not enough arguments.");
		return;
	}
	public static void TMA(CommandSender s) { //Too many arguments
		s.sendMessage(ChatColor.RED + "Too many arguments.");
		return;
	}
	public static void PTS(CommandSender s) { //Password too short.
		s.sendMessage(ChatColor.RED + "Make your password longer!");
		return;
	}
	public static void onlyPlayers(CommandSender s) { //Invalid characters
		s.sendMessage(ChatColor.RED + "Only players can use this command!");
		return;
	}
	public static void hasPassword(CommandSender s) { //If the player has a password or not.
		s.sendMessage(ChatColor.RED + "You already have a password! If you want a new one contact a staff member with the permission to reset it.");
		return;
	}
	public static void unknownPlayer(CommandSender s) { //Unknown player.
		s.sendMessage(ChatColor.RED + "That player does not exist!");
		return;
	}
	public static void NRS(CommandSender s) { //Not allowed to reset.
		s.sendMessage(ChatColor.RED + "Your password cannot be reset unless authorized by a staff member!");
		return;
	}
	public static void PLI(CommandSender s, Player p) { //Logged in
		s.sendMessage(ChatColor.RED + "" + p.getName() + " is already logged in!");
		return;
	}
	public static void noPassword(CommandSender s) {
		s.sendMessage(ChatColor.RED + "That player does not currently have a password.");
		return;
	}
	public static void subdisabled(CommandSender s) {
		s.sendMessage(ChatColor.RED + "That subcommand is disabled.");
		return;
	}
	public static void disabled(CommandSender s) {
		s.sendMessage(ChatColor.RED + "That player's password is protected.");
	}
	public static void noPassword(Player p) {
		p.sendMessage(ChatColor.RED + "You don't have a password yet.");
	}
	public static void serverMessage(String message) {
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if (pl.hasPermission(Perm.clearance) || pl.isOp()) {
				pl.sendMessage(message);
				return;
			}
			return;
		}
	}
}
