Finally, after weeks of programming and debugging, I have finally gotten a stable release of my new plugin. Login Clearance is a login plugin that makes people login on the server under certain circumstances. Here is a detailed walk-through of the commands and permissions. 

Source code: https://github.com/NJDaeger/LoginClearance 

Commands: 
/password create <password>
	-This command is used to create a new password for a player. Once created the player will need to log in with that exact password. 
	-Permissions: Clearance.create, Clearance.*, or Operators 

/password decode <player>
	-This command is used to decode either yours, or someone else's password in case you can't figure it out. 
	-Permissions: Clearance.decode, Clearance.*, or Operator's 
	-NOTE: Players that have the permissions: Clearance.*, Clearance.decode.protect, or Operator cannot be decoded. (they can decode their own passwords though) 

/password options <server OR always>
	-This command is to determine when you need to login with your password. So let's say I have it set to server, I will only need to login when the server tells me I need to. If I have it set to always then I will always login unless logging in is disabled. 
	-Permissions: Clearance.options, Clearance.*, or Operator's 

/password override <player>
	-If you don't have access to the decode command to give someone their password, then this is your next best bet to help them log in. When you use this you basically let the player login without needing to do the login command. This would also be useful for things like special guests if they don't want to log in or something. 
	-Permissions: Clearance.override, Clearance.*, or Operator's 

/password reset <player>
	-If you, or someone else, doesn't like their password then you can reset their password with this command. 
	-Permissions: Clearance.reset, Clearance.*, or Operator's 

/auth enable
	-If the logging in feature of the plugin is disabled, and you want it enabled again, then this command will let you do that in game, you could also do it in LoginClearance's config file as well. 
	-Permissions: Clearance.enable, Clearance.*, or Operator's 

/auth disable
	-If logging is enabled and you want it disabled, then this will do that for you, just like the enable subcommand, it can be done either in game or in the config. 
	-Permissions: Clearance.disable, Clearance.*, or Operator's 

/login <password>
	-The login command. 
	-Permissions: Clearance.login, Clearance.*, or Operator's 
	-NOTE: passwords are case sensitive. 

/lchelp [command] [subcommand]
	-A detailed, in-game walk-through of all the commands and permissions that come with the commands. 
	-Permissions: Clearance.help, Clearance.*, or Operator's 
	-NOTE: If you do something like "/lchelp password create" and you don't have permission for the create command, then you can't do the help command on it. 

Configuration: 

password: 
	AllowDecode: true ----- Enables or disables the decode command. 
	AllowReset: true ----- Enables or disables the reset command. 
	AllowOptions: true ----- Enables or disables the customizable player options. 
	AllowOverrides: true ----- Enables or disables the override command. 
	OppedPlayerLogin: true ----- This will determine if opped players have to log in. "AlwaysLogin" needs to be false, and the player must have his option set to "server" to see this take effect. 
login: 
	OnIpChanges: true ----- If true, the server checks if the player's IP changed from their last login. If it did then they need to login. 
	OnPlayernameChanges: true ----- If true, the server checks if the players name changed from their last login if it did then they need to login. 
	AlwaysLogin: false ----- If true, everyone who joins will need to login no matter what. 
	DisableLogin: false -----If true, then logging in is disabled, anyone can join without needing to make a password. 
loginAttempts: 
	LoginAttemptCounter: true ----- If true the server keeps track of how many times the player fails a login in a row. If it reaches 3 failed login attempts the player is kicked. If it reaches 10 then the player is banned until a staff member unbans the player. 

If you have any questions on how anything in this plugin works, then just comment or PM me and I will get back to you as quick as I can! I hope this plugin helps you keep your server safe. :)
