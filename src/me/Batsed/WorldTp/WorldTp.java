package me.Batsed.WorldTp;


import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldTp extends JavaPlugin {
	
	public Config config;
	PluginDescriptionFile descFile = this.getDescription();
	
	private static String ordner = "plugins/WorldTp/saves";

	public void onEnable() {
		createConfig();
		System.out.println("[WorldTp] Plugin by Batsed");
		config = new Config(new File(ordner + File.separator + "Saves.yml"));
        config.setDefaults();
        Config.save();
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		String sprache1 = this.getConfig().getString("Config.language.Wt");
		String sprache2 = this.getConfig().getString("Config.language.Leave");
		String sprache3 = this.getConfig().getString("Config.language.Setspawnpoint");
		String sprache4 = this.getConfig().getString("Config.language.Setspawnpoint2");
		String sprache9 = this.getConfig().getString("Config.language.error.NoArgument");
		String sprache10 = this.getConfig().getString("Config.language.error.TooManyArgument");
		String sprache11 = this.getConfig().getString("Config.language.error.NoWarpPoint");
		String sprache5 = this.getConfig().getString("Config.language.Help.Setspawnpoint");
		String sprache6 = this.getConfig().getString("Config.language.Help.Wt");
		String sprache7 = this.getConfig().getString("Config.language.Help.Leave");
		String sprache8 = this.getConfig().getString("Config.language.Help.WorldTp");
		String sprache12 = this.getConfig().getString("Config.language.error.error");
		String sprache13 = this.getConfig().getString("Config.language.error.ConfigError");
		String sprache14 = this.getConfig().getString("Config.language.error.GamemodeCreativeError");
		String sprache15 = this.getConfig().getString("Config.language.error.SaveInventoryError");
		String sprache16 = this.getConfig().getString("Config.language.info");
		String sprache17 = this.getConfig().getString("Config.language.BlockLeave");
		String sprache18 = this.getConfig().getString("Config.language.error.ClearInventoryError");
		String sprache19 = this.getConfig().getString("Config.language.error.activateCommandInvbackError");
		String sprache20 = this.getConfig().getString("Config.language.error.noPremmissions");
		String sprache21 = this.getConfig().getString("Config.language.Help.Invback");
		String sprache22 = this.getConfig().getString("Config.language.error.TeleportToAnOtherWarp");
		String sprache23 = this.getConfig().getString("Config.language.NoError");
		String sprache24 = this.getConfig().getString("Config.language.error.BlockInvback");
		String sprache25 = this.getConfig().getString("Config.language.error.DoubleWarp");
		String sprache26 = this.getConfig().getString("Config.language.error.InvackFalse");
		String sprache27 = this.getConfig().getString("Config.language.error.DoubleInv");
		String sprache28 = this.getConfig().getString("Config.language.error.BlockCommand");
		String sprache29 = this.getConfig().getString("Config.language.error.WarpName");
		String sprache30 = this.getConfig().getString("Config.language.error.DoubleWarpTp");
		String sprache31 = this.getConfig().getString("Config.language.error.NoWarp");
		String sprache32 = this.getConfig().getString("Config.language.ConfigReload");
		String sprache33 = this.getConfig().getString("Config.language.error.ClearInvByCommanderror");
		String sprache34 = this.getConfig().getString("Config.language.Help.WtInfo");
		String sprache35 = this.getConfig().getString("Config.language.Help.WtList");
		String sprache36 = this.getConfig().getString("Config.language.Help.WtFinderror");
		String sprache37 = this.getConfig().getString("Config.language.error.WarpError");
		String sprache38 = this.getConfig().getString("Config.language.SearchErrors");
		String sprache39 = this.getConfig().getString("Config.language.error.loadInvByCommandLeaveerror");
		String sprache40 = this.getConfig().getString("Config.language.error.ClearInvByCommanderror");
		String sprache41 = this.getConfig().getString("Config.language.error.activateCommandLeave");
		
		//Saves Config
		Config.configuration.set(Config.Backup + "language.error.GamemodeCreativeError", sprache14);
		Config.configuration.set(Config.Backup + "language.error.SaveInventoryError", sprache15);
		Config.configuration.set(Config.Backup + "language.error.ClearInventoryError", sprache18);
		Config.configuration.set(Config.Backup + "language.error.activateCommandInvbackError", sprache19);
		Config.configuration.set(Config.Backup + "language.error.TeleportToAnOtherWarp", sprache22);
		Config.configuration.set(Config.Backup + "language.error.NoError", sprache23);
		Config.configuration.set(Config.Backup + "language.SearchErrors", sprache38);
		Config.configuration.set(Config.Backup + "language.error.loadInvByCommandLeave", sprache39);
		Config.configuration.set(Config.Backup + "language.error.ClearInvByCommanderror", sprache40);
		Config.configuration.set(Config.Backup + "language.error.activateCommandLeave", sprache41);
		Config.configuration.set(Config.Backup + "language.error.ConfigError", sprache13);
		Config.save();
		
		//OldLocation Config
		
		Player p = (Player)sender;
			
		//Zum Spawnpoint teleportieren
		//Teleporting to the spawn point
		if(cmd.getName().equalsIgnoreCase("wt")) {
			if(args.length < 1) {
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
				return false;
			}
			String spawnpoint = (args[0]);						    				    
			//Anfang command "/wt info"	    
			if (spawnpoint.equalsIgnoreCase("info")) {
				if(p.hasPermission("worldtp.info")) {
					//Fehlerüberprpfung "info"
					if(args.length < 2) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
						p.sendMessage("usage: <wt> <info> <warpname>");
						return false;
					}
					if(args.length > 2) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache10);
						p.sendMessage("usage: <wt> <info> <warpname>");
						return false;
					}
					//Hauptquellcode "info"
					String warpname = (args[1]);
				    		
					String clearinvbycommand = this.getConfig().getString("Config."+ warpname +".ClearInvByCommand");
					String saved = this.getConfig().getString("Config."+ warpname +".SaveInventory");
					String game = this.getConfig().getString("Config."+ warpname +".GamemodeCreative");
					String clearinv = this.getConfig().getString("Config."+ warpname +".ClearInventory");
					String invback = this.getConfig().getString("Config."+ warpname +".activateCommandInvback");
					String activateinvback = this.getConfig().getString("Config."+ warpname+".activateCommandInvback");
					String loadinvbycommandleave = this.getConfig().getString("Config."+ warpname +".loadInvByCommandLeave");
					String activateCommandLeave = this.getConfig().getString("Config."+ warpname +".activateCommandLeave");
						    
					if(game == null) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache11);
						return false;
					}
					p.sendMessage(ChatColor.RED + "[WorldTp] ClearInvByCommand = " + ChatColor.AQUA + clearinvbycommand);
					p.sendMessage(ChatColor.RED + "[WorldTp] SaveInventory = " + ChatColor.AQUA + saved);
					p.sendMessage(ChatColor.RED + "[WorldTp] GamemodeCreative = " + ChatColor.AQUA + game);
					p.sendMessage(ChatColor.RED + "[WorldTp] ClearInventory = " + ChatColor.AQUA + clearinv);
					p.sendMessage(ChatColor.RED + "[WorldTp] activateCommandInvback = " + ChatColor.AQUA + invback);
					p.sendMessage(ChatColor.RED + "[WorldTp] activateCommandInvback = " + ChatColor.AQUA + activateinvback);
					p.sendMessage(ChatColor.RED + "[WorldTp] loadInvByCommandLeave = " + ChatColor.AQUA + loadinvbycommandleave);
					p.sendMessage(ChatColor.RED + "[WorldTp] activateCommandLeave = " + ChatColor.AQUA + activateCommandLeave);
					
					return true;
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return true;
				}
				
			}
			
			//Anfang Command "/wt reload"
			if(spawnpoint.equalsIgnoreCase("reload")) {
				if(p.hasPermission("worldtp.reload")) {
				
					//Fehlerüberprüfung
					if(args.length < 1) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
						return false;
					}
					if(args.length > 1) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache10);
						return false;
					}
					//Hauptquellcode "/wt reload"
					this.saveConfig();
					reloadConfig();
					Config.save();
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache32);
					return true;
					
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return true;
				}
			}
			if(spawnpoint.equalsIgnoreCase("list")) {
				if(p.hasPermission("worldtp.list")) {
					String warps = Config.configuration.getString(Config.NewWarp);
					int zahl = Config.configuration.getInt(Config.rechner);
					
					if(warps == null) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache31);
						return true;
					}
					if(zahl == 1) {
						p.sendMessage(ChatColor.RED + "[WorldTp] ** " + zahl + " Warp **");
					}
					if(!(zahl == 1)) {
						p.sendMessage(ChatColor.RED + "[WorldTp] ** " + zahl + " Warps **");
					}					
					p.sendMessage(ChatColor.RED + "[WorldTp] " + warps);
					return true;
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return true;
				}
			}
			if(spawnpoint.equalsIgnoreCase("finderror")) {
				if(p.hasPermission("worldtp.finderror")) {
					int zahl = Config.configuration.getInt(Config.rechner);
					if(zahl == 0) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache23);
						return true;
					}
					backupConfigReload(p);
					return new FindError(cmd, args, p).Error();
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return true;
				}
			}
			//Anfang Command "/wt"
			else{
				if(p.hasPermission("worldtp.wt")) { 
					String PlayerName = p.getName();
					String WarpCache = Config.configuration.getString(Config.WarpCachePoint + PlayerName);
					
					String spawnName = Config.configuration.getString(Config.oldLoc + PlayerName + ".LastSpawnPoint");
					if(spawnName == null) {
						String AnotherWarpOn = this.getConfig().getString("Config."+ spawnpoint +".TeleportToAnOtherWarp");
						Config.configuration.set(Config.TrueCachePoint + PlayerName, AnotherWarpOn);
						Config.save();
					}
					if(spawnName == "asdi") {
						String AnotherWarpOn = this.getConfig().getString("Config."+ spawnpoint +".TeleportToAnOtherWarp");
						Config.configuration.set(Config.TrueCachePoint + PlayerName, AnotherWarpOn);
						Config.save();
					}
					if(!(spawnName == "asdi")) {
						if(!(spawnName == null)) {
							String AnotherWarpOn = this.getConfig().getString("Config."+ WarpCache +".TeleportToAnOtherWarp");	
							Config.configuration.set(Config.TrueCachePoint + PlayerName, AnotherWarpOn);
							Config.save();
						}
					}
					
					String saved = this.getConfig().getString("Config."+ spawnpoint +".SaveInventory");
					String game = this.getConfig().getString("Config."+ spawnpoint +".GamemodeCreative");
					String clearinv = this.getConfig().getString("Config."+ spawnpoint +".ClearInventory");
					String invback = this.getConfig().getString("Config."+ spawnpoint +".activateCommandInvback");
					String AnotherWarp = Config.configuration.getString(Config.oldLoc + PlayerName + ".AnotherWarp");
					String DoubleWarp = Config.configuration.getString(Config.oldLoc + PlayerName + ".doubleWarp");
					    
					double locY = this.getConfig().getDouble("Config."+ spawnpoint +".spawn.Y");
					double locX = this.getConfig().getDouble("Config."+ spawnpoint +".spawn.X");
					double locZ = this.getConfig().getDouble("Config."+ spawnpoint +".spawn.Z");													
					
					//Fehler überprüfung
					if(args.length < 1) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
						p.sendMessage("usage: <wt> <warpname>");
						return false;
					}
					if(args.length > 1) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache10);
						p.sendMessage("usage: <wt> <warpname>");
						return false;
					}
					if(locX == 0) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache11);
						return false;
					}					
					if(game.length() > 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache37);
						System.out.println("[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache14);
						return false;
					}
					if(game.length() < 4) {
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache37);
						System.out.println("[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache14);
						return false;
					}
					if(saved.length() > 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache37);
						System.out.println("[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache15);
						return false;
					}
					if(saved.length() < 4) {
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache37);
						System.out.println("[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache15);
						return false;
					}
					if(clearinv.length() > 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache37);
						System.out.println("[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache18);
				    	return false;
					}
				    if(clearinv.length() < 4) {
				    	p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache37);
				    	System.out.println("[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache18);
				    	return false;
				    }
				    if(invback.length() > 5) {
				    	p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache37);
				    	System.out.println("[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache19);
				    	return false;
				    }
				    if(invback.length() < 4) {
				    	p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache37);
				    	System.out.println("[WorldTp] Spawnpoint '" + spawnpoint + "' " + sprache19);
				    	return false;
				    }			
				    //hauptquellcode "wt"
				    Location loc = new Location(getServer().getWorld(p.getWorld().getName()),locX, locY, locZ);
				    String AnotherWarpPoint = Config.configuration.getString(Config.TrueCachePoint + PlayerName);

				    if(AnotherWarpPoint.length() == 5) {
				    	if(AnotherWarp == "asdn") {
				    		p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache30);
				    		return true;
				    	}
				    }
				    
				    if(AnotherWarpPoint.length() == 5) {
				    	if(!(AnotherWarp == "asdn")) {
				    		Config.configuration.set(Config.oldLoc + PlayerName + ".AnotherWarp", "asdn");
				    		Config.save();
				    	}
				    }
				    
				    if(!(DoubleWarp == "doubleWarpOn")) {
				    	Config.OldPlayerLocName(p, spawnpoint);				    	
				    }

				    Config.DoubleWarp(p);
				    
				    Config.OldPlayerInvbackDoubleFine(p);
				    Config.TeleportToWarp(p);				    
				    
				    p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache1);
				    
				    p.teleport(loc);
				    
				    if(game.length() == 4) {
				    	p.setGameMode(GameMode.CREATIVE);
				    }
				    if(saved.length() == 4) {  
				    	return new InventoryManager(cmd, args, p, clearinv).saveToFile(p);
				    }
				    if(clearinv.length() == 4) {
				    	return new InventoryManager(cmd, args, p, clearinv).clearInventory(p);
				    }
				    Config.configuration.set(Config.WarpCachePoint + PlayerName, spawnpoint);
				    Config.save();
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return false;
				}
			}
		}
		
		//Spawnpoint von der Welt setzen
		//Defining the spawn point for the creative world
		if(cmd.getName().equalsIgnoreCase("setspawnpoint")) {
			if(p.hasPermission("worldtp.setspawnpoint")) {
				if(args.length < 3) {
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
					return false;
				}
				if(args.length > 3) {
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache10);
					return false;
				}
				if(args.length == 3) {
					String spawnName = (args[0]);
					String save = (args[1]);
					String game = (args[2]);
					
					//Fehlerüberprüfung
					if(spawnName.equalsIgnoreCase("info")) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache29);
						return true;
					}
					if(spawnName.equalsIgnoreCase("reload")) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache29);
						return true;
					}
					if(spawnName.equalsIgnoreCase("list")) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache29);
						return true;
					}
					if(spawnName.equalsIgnoreCase("asdi")) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache29);
						return true;
					}
					if(spawnName.equalsIgnoreCase("finderror")) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache29);
						return true;
					}
					getConfig().set("Config."+ spawnName +".spawn.X", p.getLocation().getX());
					getConfig().set("Config."+ spawnName +".spawn.Y", p.getLocation().getY());
					getConfig().set("Config."+ spawnName +".spawn.Z", p.getLocation().getZ());
            		getConfig().get("Config."+ spawnName +".activateCommandLeave");
            		this.getConfig().set("Config."+ spawnName +".activateCommandLeave", true);
            		Config.configuration.set(Config.Backup + spawnName +".activateCommandLeave", true);
            		getConfig().get("Config."+ spawnName +".ClearInvByCommand");
					this.getConfig().set("Config."+ spawnName +".ClearInvByCommand", true);
					Config.configuration.set(Config.Backup + spawnName +".ClearInvByCommand", true);
					getConfig().get("Config."+ spawnName +".TeleportToAnOtherWarp");
					this.getConfig().set("Config."+ spawnName +".TeleportToAnOtherWarp", true);
					Config.configuration.set(Config.Backup + spawnName +".TeleportToAnOtherWarp", true);
					Config.WarpUp(spawnName);
				
	            	if (save.equalsIgnoreCase("nosave")) {
						getConfig().get("Config."+ spawnName +".SaveInventory");
						this.getConfig().set("Config."+ spawnName +".SaveInventory", false);
						Config.configuration.set(Config.Backup + spawnName +".SaveInventory", false);
						getConfig().get("Config."+ spawnName +".activateCommandInvback");
						this.getConfig().set("Config."+ spawnName +".activateCommandInvback", true);
						Config.configuration.set(Config.Backup + spawnName +".activateCommandInvback", true);
						getConfig().get("Config."+ spawnName +".ClearInventory");
						this.getConfig().set("Config."+ spawnName +".ClearInventory", false);
						Config.configuration.set(Config.Backup + spawnName +".ClearInventory", false);
						getConfig().get("Config."+ spawnName +".loadInvByCommandLeave");
						this.getConfig().set("Config."+ spawnName +".loadInvByCommandLeave", false);
						Config.configuration.set(Config.Backup + spawnName +".loadInvByCommandLeave", false);
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache3);
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnName + "', '" + save + "' " + sprache16 + " '" + game + "'");
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache4);					
						this.getConfig().options().copyDefaults(true);
						this.saveConfig();
						Config.save();
					}
	            	if (save.equalsIgnoreCase("withsave")) {
						getConfig().get("Config."+ spawnName +".SaveInventory");
						this.getConfig().set("Config."+ spawnName +".SaveInventory", true);
						Config.configuration.set(Config.Backup + spawnName + ".SaveInventory", true);
						getConfig().get("Config."+ spawnName +".activateCommandInvback");
						this.getConfig().set("Config."+ spawnName +".activateCommandInvback", false);
						Config.configuration.set(Config.Backup + spawnName + ".activateCommandInvback", false);
						getConfig().get("Config."+ spawnName +".ClearInventory");
						this.getConfig().set("Config."+ spawnName +".ClearInventory", true);
						Config.configuration.set(Config.Backup + spawnName + ".ClearInventory", true);
						getConfig().get("Config."+ spawnName +".loadInvByCommandLeave");
						this.getConfig().set("Config."+ spawnName +".loadInvByCommandLeave", true);
						Config.configuration.set(Config.Backup + spawnName + ".loadInvByCommandLeave", true);
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache3);
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnName + "', '" + save + "' " + sprache16 + " '" + game + "'");
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache4);
	                
						this.getConfig().options().copyDefaults(true);
						this.saveConfig();
						Config.save();
	            	}
	            	
	            	if(game.equalsIgnoreCase("1")) {
	            		getConfig().get("Config."+ spawnName +".GamemodeCreative");
						this.getConfig().set("Config."+ spawnName +".GamemodeCreative", true);
						Config.configuration.set(Config.Backup + spawnName + ".GamemodeCreative", true);
						this.getConfig().options().copyDefaults(true);
						this.saveConfig();
						Config.save();
						return true;
					}
					
					if(game.equalsIgnoreCase("0")) {
						getConfig().get("Config."+ spawnName +".GamemodeCreative");
						this.getConfig().set("Config."+ spawnName +".GamemodeCreative", false);
						Config.configuration.set(Config.Backup + spawnName + ".GamemodeCreative", false);
						this.getConfig().options().copyDefaults(true);
						this.saveConfig();
						Config.save();
						return true;	
						
					}else{
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache12);
						return false;
					}
				}else {
					return false;
				}
			}else{
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
				return true;
			}
		}
		//Um hilfe von WorldTp zu bekommen
		//Getting help from WorldTP
		if(cmd.getName().equalsIgnoreCase("worldtp")) {
			if(p.hasPermission("worldtp.worldtp")) {
					if(args.length == 0) {
						p.sendMessage(ChatColor.RED + "/setspawnpoint: " + ChatColor.AQUA + sprache5);
						p.sendMessage(ChatColor.RED + "/wt: " + ChatColor.AQUA + sprache6);
						p.sendMessage(ChatColor.RED + "/worldtp: " + ChatColor.AQUA + sprache8);
						p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache7);
						p.sendMessage(ChatColor.RED + "/invback: " + ChatColor.AQUA + sprache21);
						p.sendMessage(ChatColor.RED + "/wt info: " + ChatColor.AQUA + sprache34);
						p.sendMessage(ChatColor.RED + "/wt list: " + ChatColor.AQUA + sprache35);
						p.sendMessage(ChatColor.RED + "/wt finderror: " + ChatColor.AQUA + sprache36);
                
						return true;
					}else {
						return false;
					}
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("clearinv")) {
				if(p.hasPermission("worldtp.clearinv")) {
					
					String PlayerName = p.getName();
					String spawnName = Config.configuration.getString(Config.oldLoc + PlayerName + ".LastSpawnPoint");
					String clearinvByCommand = this.getConfig().getString("Config."+ spawnName +".ClearInvByCommand");
					String clearinv = this.getConfig().getString("Config."+ spawnName +".ClearInventory");
						
					//Fehler Überprüfung
					if(clearinvByCommand.length() > 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint "+ spawnName + " " + sprache33);
							return false;
					}
					if(clearinvByCommand.length() < 4) {
							p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint "+ spawnName + " " + sprache33);
							return false;
					}
						
					//hauptquellcode
					if(clearinvByCommand.length() == 4) {
						return new InventoryManager(cmd, args, p, clearinv).clearInventory(p);
					}
					if(clearinvByCommand.length() == 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache28);
						return true;
					}
					
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return false;
				}
		}
		
		//Gibt dein Inventar zurück
		if(cmd.getName().equalsIgnoreCase("invback")) {
			if(p.hasPermission("worldtp.invback")) {
				if(args.length == 0){
					String PlayerName = p.getName();
					String spawnName = Config.configuration.getString(Config.oldLoc + PlayerName + ".LastSpawnPoint");
					String spawnNameError = Config.configuration.getString(Config.oldLoc + PlayerName + ".LastSpawnPointError");
					String clearinv = this.getConfig().getString("Config."+ spawnName +".ClearInventory");
					String invback = this.getConfig().getString("Config."+ spawnName +".activateCommandInvback");
				
					if(invback.length() == 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache26);
						return true;
					}
					if(spawnNameError == "asdf") {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache27);
						return true;
					}
					Config.OldPlayerInvbackDouble(p);
					Config.OldPlayerInvback(p);
					Config.save();
					if(invback.length() == 4) {
						return new InventoryManager(cmd, args, p, clearinv).loadFromFile(p);
					}
					return true;
				}
			}else{
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
				return true;
			}
		}	
		//Aus der Welt zum alten Standpunkt teleportieren
		//Teleporting from the world to the old place
		if(cmd.getName().equalsIgnoreCase("leave")) {
			if(p.hasPermission("worldtp.leave")) {
				if(args.length == 0) {
					String PlayerName = p.getName();
					String spawnName = Config.configuration.getString(Config.oldLoc + PlayerName + ".LastSpawnPoint");					
					String clearinv = this.getConfig().getString("Config."+ spawnName +".ClearInventory");
					String loadInvByLeave = this.getConfig().getString("Config."+ spawnName +".loadInvByCommandLeave");
					String leave = this.getConfig().getString("Config."+ spawnName +".activateCommandLeave");
					String another = Config.configuration.getString(Config.oldLoc + PlayerName + ".AnotherWarp");
					String s = "asdi";
					
					if(spawnName == "asde") {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache24);
						return true;
					}
					if(s == spawnName) {
						p.sendMessage(ChatColor.RED + "[WorldTP] " + sprache25);
						return true;
					}
						
					if(leave.length() == 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache17);
						return false;
					}
					
					if(!(spawnName == "asdi")) {
						Config.OldPlayerLeave(p);
						Config.save();
					}
					
					Config.TeleportToWarpLeave(p);
					Config.DoubleWarpOff(p);
					
			    	double LocX = Config.configuration.getDouble(Config.oldLoc + PlayerName + ".spawn.X");
					double LocY = Config.configuration.getDouble(Config.oldLoc + PlayerName + ".spawn.Y");
					double LocZ = Config.configuration.getDouble(Config.oldLoc + PlayerName + ".spawn.Z");
						
					Location loc = new Location(getServer().getWorld(p.getWorld().getName()),LocX, LocY, LocZ);
						
					p.teleport(loc);
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache2);
					GameMode gamemode = p.getGameMode();
					if(gamemode == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
					
					if(loadInvByLeave.length() == 4) {
						return new InventoryManager(cmd, args, p, clearinv).loadFromFile(p);
					}
					if(another == "asdn") {
						Config.configuration.set(Config.oldLoc + PlayerName + ".AnotherWarp", "asdm");
						Config.save();
					}
					return true;
				}else {
					return false;
				}
			}else{
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
				return true;
			}
		}
		return true;
		
	}
    public Config getConfiguration() {
		return config;
    }
	
	public boolean backupConfigReload(Player p) {				
		
			int zahl = Config.configuration.getInt(Config.rechner);
			int anzahl = Config.configuration.getInt(Config.ErrorCache);
			int anzahlG = anzahl + 1;
			String SpawnName = Config.configuration.getString(Config.WarpNumber + anzahlG);
			Config.configuration.set(Config.ErrorCache, anzahlG);
		
			String clearinvbycommand = this.getConfig().getString("Config."+ SpawnName +".ClearInvByCommand");
			String saved = this.getConfig().getString("Config."+ SpawnName +".SaveInventory");
			String game = this.getConfig().getString("Config."+ SpawnName +".GamemodeCreative");
			String clearinv = this.getConfig().getString("Config."+ SpawnName +".ClearInventory");
			String AnotherWarp = this.getConfig().getString("Config."+ SpawnName +".TeleportToAnOtherWarp");
			String activateinvback = this.getConfig().getString("Config."+ SpawnName+".activateCommandInvback");
			String loadinvbycommandleave = this.getConfig().getString("Config."+ SpawnName +".loadInvByCommandLeave");
			String activateCommandLeave = this.getConfig().getString("Config."+ SpawnName +".activateCommandLeave");
			
			Config.configuration.set(Config.Backup + SpawnName +".ClearInvByCommand", clearinvbycommand);
			Config.configuration.set(Config.Backup + SpawnName +".SaveInventory", saved);
			Config.configuration.set(Config.Backup + SpawnName +".GamemodeCreative", game);
			Config.configuration.set(Config.Backup + SpawnName +".ClearInventory", clearinv);
			Config.configuration.set(Config.Backup + SpawnName +".TeleportToAnOtherWarp", AnotherWarp);
			Config.configuration.set(Config.Backup + SpawnName +".activateCommandInvback", activateinvback);
			Config.configuration.set(Config.Backup + SpawnName +".loadInvByCommandLeave", loadinvbycommandleave);
			Config.configuration.set(Config.Backup + SpawnName +".activateCommandLeave", activateCommandLeave);
			Config.save();
		
		    //Schleife
		    if(!(anzahlG == zahl)) {
		    	backupConfigReload(p);	    	
				return true;
		    }		
			if(anzahlG == zahl) {				
				Config.configuration.set(Config.ErrorCache, 0);
				return true;		
			}
		return false;
	}
		
	public void createConfig() {
		
		//language
		String path1 = "Config.language.Wt";
		this.getConfig().addDefault(path1, "Du hast dich teleportiert");
		String path2 = "Config.language.Leave";
		this.getConfig().addDefault(path2, "Du hast dich zu deiner alten Position geportet");
		String path3 = "Config.language.Setspawnpoint";
		this.getConfig().addDefault(path3, "Du hast den Spawnpoint gesetzt");
		String path17 = "Config.language.BlockLeave";
		this.getConfig().addDefault(path17, "Leave ist für diese Warp deaktiviert");
		String path4 = "Config.language.Setspawnpoint2";
		this.getConfig().addDefault(path4, "Gespeichert");
		String path16 = "Config.language.info";
		this.getConfig().addDefault(path16, "im Gamemode");
		String path23 = "Config.language.NoError";
		this.getConfig().addDefault(path23, "Keine Errors gefunden");
		String path32 = "Config.language.ConfigReload";
		this.getConfig().addDefault(path32, "Config aktualisiert");
		String path38 = "Config.language.SearchErrors";
		this.getConfig().addDefault(path38, "suche nach Fehlern in Warp:");
		
		//errors
		String path9 = "Config.language.error.NoArgument";
		this.getConfig().addDefault(path9, "Zu wenig Argumente");
		String path10 = "Config.language.error.TooManyArgument";
		this.getConfig().addDefault(path10, "Zu viele Argumente");
		String path11 = "Config.language.error.NoWarpPoint";
		this.getConfig().addDefault(path11, "Warppoint exestiert nicht");
		String path12 = "Config.language.error.error";
		this.getConfig().addDefault(path12, "Deine Eingabe ist nicht korrekt");
		String path13 = "Config.language.error.ConfigError";
		this.getConfig().addDefault(path13, "Die WorldTp Config hat einen Fehler");
		String path14 = "Config.language.error.GamemodeCreativeError";
		this.getConfig().addDefault(path14, "hat in der Config bei GamemodeCreative einen Fehler");
		String path15 = "Config.language.error.SaveInventoryError";
		this.getConfig().addDefault(path15, "hat in der Config bei SaveInventory einen Fehler");
		String path18 = "Config.language.error.ClearInventoryError";
		this.getConfig().addDefault(path18, "hat in der Config bei ClearInventory einen Fehler");
		String path19 = "Config.language.error.activateCommandInvbackError";
		this.getConfig().addDefault(path19, "hat in der Config bei activateCommandInvback einen Fehler");
		String path22 = "Config.language.error.TeleportToAnOtherWarp";
		this.getConfig().addDefault(path22, "hat in der Config bei TeleportToAnOtherWarp einen Fehler");
		String path20 = "Config.language.error.noPremmissions";
		this.getConfig().addDefault(path20, "Du hast keine Rechte um dies auszuführen");
		String path24 = "Config.language.error.BlockInvback";
		this.getConfig().addDefault(path24, "Da du /invback gemacht hast, kannst du dich nicht mehr zurückporten");
		String path25 = "Config.language.error.DoubleWarp";
		this.getConfig().addDefault(path25, "Du kannst dich nur einmal zurück warpen");
		String path26 = "Config.language.error.InvackFalse";
		this.getConfig().addDefault(path26, "Kommando 'invback' für diesen Spawnpoint deaktieviert");
		String path27 = "Config.language.error.DoubleInv";
		this.getConfig().addDefault(path27, "Kommando '/invback' schonmal benutzt");
		String path28 = "Config.language.error.BlockCommand";
		this.getConfig().addDefault(path28, "Für diesen spawn ist der Befehl nicht erlaubt");
		String path29 = "Config.language.error.WarpName";
		this.getConfig().addDefault(path29, "Der Name ist als Warp nicht erlaubt");
		String path30 = "Config.language.error.DoubleWarpTp";
		this.getConfig().addDefault(path30, "Mehrmals Warpen ist nicht erlaubt");
		String path31 = "Config.language.error.NoWarp";
		this.getConfig().addDefault(path31, "Keine Warps verfügbar");
		String path33 = "Config.language.error.ClearInvByCommanderror";
		this.getConfig().addDefault(path33, "hat in der Config bei ClearInvByCommand einen Fehler");
		String path37 = "Config.language.error.WarpError";
		this.getConfig().addDefault(path37, "beinhaltet Fehler. Wenden sie sich bitte an den Administrator");
		String path39 = "Config.language.error.loadInvByCommandLeaveerror";
		this.getConfig().addDefault(path39, "hat in der Config bei loadInvByCommandLeave einen Fehler.");
		String path40 = "Config.language.error.ClearInvByCommanderror";
		this.getConfig().addDefault(path40, "hat in der Config bei ClearInvByCommand einen Fehler.");
		String path41 = "Config.language.error.activateCommandLeave";
		this.getConfig().addDefault(path41, "hat in der Config bei activateCommandLeave einen Fehler");
				
		//help
		String path5 = "Config.language.Help.Setspawnpoint";
		this.getConfig().addDefault(path5, "Setzt den spawnpoint den du mit dem Kommando '/wt' erreichst");
		String path6 = "Config.language.Help.Wt";
		this.getConfig().addDefault(path6, "Damit portest du dich zu einem Spawnpoint");
		String path7 = "Config.language.Help.Leave";
		this.getConfig().addDefault(path7, "Damit kehrst du zu deinem alten Standpunkt zurück");
		String path8 = "Config.language.Help.WorldTp";
		this.getConfig().addDefault(path8, "Hilfe über WorldTp");
		String path21 = "Config.language.Help.Invback";
		this.getConfig().addDefault(path21, "Gibt dein Inventar zurück");
		String path34 = "Config.language.Help.WtInfo";
		this.getConfig().addDefault(path34, "Gibt infos über dein Spawn");
		String path35 = "Config.language.Help.WtList";
		this.getConfig().addDefault(path35, "Gibt verfügbare Warps an");
		String path36 = "Config.language.Help.WtFinderror";
		this.getConfig().addDefault(path36, "Sucht fehler in der Config");
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
}