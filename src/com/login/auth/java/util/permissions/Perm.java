package com.login.auth.java.util.permissions;

import org.bukkit.permissions.Permission;

public class Perm {
	public static Permission clearance = new Permission("clearance.*");
	public static Permission create = new Permission("clearance.create");
	public static Permission decode = new Permission("clearance.decode");
	public static Permission options = new Permission("clearance.options");
	public static Permission override = new Permission("clearance.override");
	public static Permission reset = new Permission("clearance.reset");
	public static Permission login = new Permission("clearance.login");
	public static Permission disable = new Permission("clearance.disable");
	public static Permission help = new Permission("clearance.help");
	public static Permission enable = new Permission("clearance.enable");
	public static Permission protect = new Permission("clearance.decode.protect");
	public static Permission all = new Permission("*");
}
