package com.login.auth.java.commands.consolesubcmd;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.CommandSender;

import com.login.auth.java.util.permissions.Perm;

public class ConHelp {
	public static void noArgs(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/password create" + ChatColor.WHITE + " - Creates a new password.");
		sndr.sendMessage(ChatColor.GRAY + "/password decode" + ChatColor.WHITE + " - Can decode a players password.");
		sndr.sendMessage(ChatColor.GRAY + "/password options" + ChatColor.WHITE + " - Player login options.");
		sndr.sendMessage(ChatColor.GRAY + "/password override" + ChatColor.WHITE + " - Overrides a player.");
		sndr.sendMessage(ChatColor.GRAY + "/password reset" + ChatColor.WHITE + " - Resets a password.");
		sndr.sendMessage(ChatColor.GRAY + "/login" + ChatColor.WHITE + " - The login command.");
		sndr.sendMessage(ChatColor.GRAY + "/auth" + ChatColor.WHITE + " - Enables or disables the login feature");
		return;
	}
	public static void password1(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/password create <password>");
		sndr.sendMessage("     - This creates a new password.");
		sndr.sendMessage(ChatColor.GRAY + "/password decode <player>");
		sndr.sendMessage("     - Decodes a players password.");
		sndr.sendMessage(ChatColor.GRAY + "/password options <always/server>");
		sndr.sendMessage("     - Player login options.");
		sndr.sendMessage(ChatColor.GRAY + "/password override <player>");
		sndr.sendMessage("     - Allows a player to be logged in without logging in.");
		sndr.sendMessage(ChatColor.GRAY + "/password reset <player>");
		sndr.sendMessage("     - Ability to reset a player's password.");
		return;
	}
	public static void login1(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/login <password>");
		sndr.sendMessage("     - Logs in the command sender.");
		sndr.sendMessage("     - NOTE: If a player does not login, they wont be able to do much.");
		sndr.sendMessage(ChatColor.DARK_AQUA + "Permissions: " + ChatColor.GRAY + Perm.login.getName() + ", " + Perm.clearance.getName());
		return;
	}
	public static void auth1(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/auth <enable/disable>");
		sndr.sendMessage("     - Enables or disables the login feature.");
		sndr.sendMessage(ChatColor.DARK_AQUA + "Permissions: " + ChatColor.GRAY + Perm.enable.getName() + ", " + Perm.disable.getName() + ", " + Perm.clearance.getName());
		return;
	}
	public static void create(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/password create <password>");
		sndr.sendMessage("     - This command will create a password for you.");
		sndr.sendMessage("     - NOTE: If you already have a password then this command won't work!");
		sndr.sendMessage(ChatColor.DARK_AQUA + "Permissions: " + ChatColor.GRAY + Perm.create.getName() + ", " + Perm.clearance.getName());
		return;
	}
	public static void decode(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/password decode <player>");
		sndr.sendMessage("     - Ability to decode a player's password.");
		sndr.sendMessage("     - NOTE: If the player is opped or has specified permissions, then the person's password cannot be decoded.");
		sndr.sendMessage(ChatColor.DARK_AQUA + "Opt-out permissions: " + ChatColor.GRAY + Perm.protect.getName() + ", " + Perm.clearance.getName());
		sndr.sendMessage(ChatColor.DARK_AQUA + "Permissions: " + ChatColor.GRAY + Perm.decode.getName() + ", " + Perm.clearance.getName());
		return;
	}
	public static void options(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/password options <always/server>");
		sndr.sendMessage("     - Able to change when you login.");
		sndr.sendMessage("     - ALWAYS: Means you will always login whenever you join.");
		sndr.sendMessage("     - SERVER: Means you will login when the server makes you login.");
		sndr.sendMessage(ChatColor.DARK_AQUA + "Permissions: " + ChatColor.GRAY + Perm.options.getName() + ", " + Perm.clearance.getName());
		return;
	}
	public static void override(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/password override <player>");
		sndr.sendMessage("     - Makes the player login, without typing in a password.");
		sndr.sendMessage(ChatColor.DARK_AQUA + "Permissions: " + ChatColor.GRAY + Perm.override.getName() + ", " + Perm.clearance.getName());
		return;
	}
	public static void reset(CommandSender sndr) {
		sndr.sendMessage(ChatColor.DARK_AQUA + "===============LoginClearance===============");
		sndr.sendMessage(ChatColor.GRAY + "/password decode <player>");
		sndr.sendMessage("     - Resets a player's password.");
		sndr.sendMessage("     - NOTE: Player whos password was reset will no longer be able to do anything until they are logged in.");
		sndr.sendMessage("     - NOTE: If the player doesn't have a password, this command won't do anything.");
		sndr.sendMessage(ChatColor.DARK_AQUA + "Permissions: " + ChatColor.GRAY + Perm.reset.getName() + ", " + Perm.clearance.getName());
		return;
	}
}
