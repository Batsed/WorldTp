package me.Batsed.WorldTp;


import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldTp extends JavaPlugin {
	
	public language Language;
	public Config config;
	public File dir;
	public File folder;
	public int WarpAnzahl;
	PluginDescriptionFile descFile = this.getDescription();
	
	private static String ordner = "plugins/WorldTp/saves";
	private static String Languagepfad = "plugins/WorldTp";
	
	public void onEnable() {
		createConfig();																					//Standart Configuration
		System.out.println("[WorldTp] Plugin by Batsed");												//Programmierer
		config = new Config(new File(ordner + File.separator + "Saves.yml"));							//Speicherungspfad von der "Saves Configuration"
		dir = new File("plugins/WorldTp/saves/inventories");											//Ordner f�r Survival Inventare
		folder = new File("plugins/WorldTp/saves/Creative Inventories");								//Ordner f�r Creative Inventare
		dir.mkdir();																					//Befehl um ordner zu erstellen
		folder.mkdir();																					//Befehl um ordner zu erstellen
        config.setDefaults();																			//Ruft Defaults f�r den ersten start beim Plugin auf
        Config.save();																					//Speichert die "Saves Configuration"
        
        Language = new language(new File(Languagepfad + File.separator + "language.yml"));			    //Speicherungspfad von der "Saves Configuration"											//Ordner f�r Survival Inventare																				//Befehl um ordner zu erstellen
        Language.setDefaults();																			//Ruft Defaults f�r den ersten start beim Plugin auf
        language.save();
        this.reloadFolders();
        
        WarpAnzahl = Config.configuration.getInt(Config.warpzahl);
		if (WarpAnzahl == 1) {
			System.out.println("[WorldTp] Load " + WarpAnzahl + " Warp!");
		}
		if (WarpAnzahl > 1) {
			System.out.println("[WorldTp] Load " + WarpAnzahl + " Warps!");
		}				
        
        if (WarpAnzahl == 1) {
			System.out.println("[WorldTp] " + WarpAnzahl + " Warp loaded");		
		}
		if (WarpAnzahl > 1) {
			System.out.println("[WorldTp] " + WarpAnzahl + " Warps loaded");		
		}
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		String sprache1 = language.Lconfiguration.getString(language.normal + "Wt");
		String sprache2 = language.Lconfiguration.getString(language.normal + "Leave");
		String sprache3 = language.Lconfiguration.getString(language.normal + "Setspawnpoint");
		String sprache4 = language.Lconfiguration.getString(language.normal + "Setspawnpoint2");
		String sprache9 = language.Lconfiguration.getString(language.error + "NoArgument");
		String sprache10 = language.Lconfiguration.getString(language.error + "TooManyArgument");
		String sprache11 = language.Lconfiguration.getString(language.error + "NoWarpPoint");
		String sprache5 = language.Lconfiguration.getString(language.help + "Setspawnpoint");
		String sprache6 = language.Lconfiguration.getString(language.help + "Wt");
		String sprache7 = language.Lconfiguration.getString(language.help + "Leave");
		String sprache8 = language.Lconfiguration.getString(language.help + "WorldTp");
		String sprache12 = language.Lconfiguration.getString(language.error + "error");
		String sprache13 = language.Lconfiguration.getString(language.error + "ConfigError");
 		String sprache14 = language.Lconfiguration.getString(language.error + "GamemodeCreativeError");
		String sprache15 = language.Lconfiguration.getString(language.error + "SaveInventoryError");
		String sprache16 = language.Lconfiguration.getString(language.normal + "info");
		String sprache17 = language.Lconfiguration.getString(language.normal + "BlockLeave");
		String sprache18 = language.Lconfiguration.getString(language.error + "ClearInventoryError");
		String sprache19 = language.Lconfiguration.getString(language.error + "activateCommandInvbackError");
		String sprache20 = language.Lconfiguration.getString(language.error + "noPremmissions");
		String sprache21 = language.Lconfiguration.getString(language.help + "Invback");
		String sprache22 = language.Lconfiguration.getString(language.error + "TeleportToAnOtherWarp");
		String sprache23 = language.Lconfiguration.getString(language.normal + "NoError");
		String sprache24 = language.Lconfiguration.getString(language.error + "BlockInvback");
		String sprache25 = language.Lconfiguration.getString(language.error + "DoubleWarp");
		String sprache26 = language.Lconfiguration.getString(language.error + "InvbackFalse");
		String sprache27 = language.Lconfiguration.getString(language.error + "DoubleInv");
		String sprache28 = language.Lconfiguration.getString(language.error + "BlockCommand");
		String sprache29 = language.Lconfiguration.getString(language.error + "WarpName");
		String sprache30 = language.Lconfiguration.getString(language.error + "DoubleWarpTp");
		String sprache31 = language.Lconfiguration.getString(language.error + "NoWarp");
		String sprache32 = language.Lconfiguration.getString(language.normal + "ConfigReload");
		String sprache33 = language.Lconfiguration.getString(language.error + "ClearInvByCommanderror");
		String sprache34 = language.Lconfiguration.getString(language.help + "WtInfo");
		String sprache35 = language.Lconfiguration.getString(language.help + "WtList");
		String sprache36 = language.Lconfiguration.getString(language.help + "WarpError");
		String sprache37 = language.Lconfiguration.getString(language.error + "WarpError");
		String sprache38 = language.Lconfiguration.getString(language.normal + "SearchErrors");
		String sprache39 = language.Lconfiguration.getString(language.error + "loadInvByCommandLeaveerror");
		String sprache40 = language.Lconfiguration.getString(language.error + "ClearInvByCommanderror");
		String sprache41 = language.Lconfiguration.getString(language.error + "activateCommandLeave");
		String sprache42 = language.Lconfiguration.getString(language.normal + "SpawnInfo");
		String sprache43 = language.Lconfiguration.getString(language.normal + "WarpDeleted");
		String sprache44 = language.Lconfiguration.getString(language.normal + "deleted");
		String sprache45 = language.Lconfiguration.getString(language.error + "BlockMisspelling");
		String sprache46 = language.Lconfiguration.getString(language.help + "ClearInv");
		String sprache47 = language.Lconfiguration.getString(language.help + "WtReload");
		String sprache48 = language.Lconfiguration.getString(language.help + "WtDelete");
		String sprache49 = language.Lconfiguration.getString(language.error + "FoundNoInventory");
		String sprache50 = language.Lconfiguration.getString(language.error + "NoLeavePoint");
		String sprache51 = language.Lconfiguration.getString(language.error + "NoPoint");
		
		
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
		Config.configuration.set(Config.Backup + "language.error.notFound", sprache51);
		Config.save();		
		
		Player p = (Player)sender;

		if(cmd.getName().equalsIgnoreCase("wt")) {
			if(args.length < 1) {
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
				return false;
			}
			String spawnpoint = (args[0]);						    				    
			//Anfang command "/wt info"	    
			if(spawnpoint.equalsIgnoreCase("info")) {										
				if(p.hasPermission("worldtp.info")) {
					//Fehler�berprpfung "info"
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
					String TeleportToAnOtherWarp = this.getConfig().getString("Config."+ warpname +".TeleportToAnOtherWarp");
					String activateinvback = this.getConfig().getString("Config."+ warpname+".activateCommandInvback");
					String loadinvbycommandleave = this.getConfig().getString("Config."+ warpname +".loadInvByCommandLeave");
					String activateCommandLeave = this.getConfig().getString("Config."+ warpname +".activateCommandLeave");
					String deleted = this.getConfig().getString("Config."+ warpname +".delete");
						    
					if(game == null) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache11);
						return false;
					}
					p.sendMessage(ChatColor.RED + "[WorldTp] " + ChatColor.AQUA + sprache42 + " '" + warpname + "'");
					if(deleted.equalsIgnoreCase("true")) {
						p.sendMessage(ChatColor.RED + "[WorldTP] " + ChatColor.AQUA + sprache43);
					}
					p.sendMessage(ChatColor.RED + "[WorldTp] ClearInvByCommand = " + ChatColor.AQUA + clearinvbycommand);
					p.sendMessage(ChatColor.RED + "[WorldTp] SaveInventory = " + ChatColor.AQUA + saved);
					p.sendMessage(ChatColor.RED + "[WorldTp] GamemodeCreative = " + ChatColor.AQUA + game);
					p.sendMessage(ChatColor.RED + "[WorldTp] ClearInventory = " + ChatColor.AQUA + clearinv);
					p.sendMessage(ChatColor.RED + "[WorldTp] TeleportToAnOtherWarp = " + ChatColor.AQUA + TeleportToAnOtherWarp);
					p.sendMessage(ChatColor.RED + "[WorldTp] activateCommandInvback = " + ChatColor.AQUA + activateinvback);
					p.sendMessage(ChatColor.RED + "[WorldTp] loadInvByCommandLeave = " + ChatColor.AQUA + loadinvbycommandleave);
					p.sendMessage(ChatColor.RED + "[WorldTp] activateCommandLeave = " + ChatColor.AQUA + activateCommandLeave);
					if(deleted.equalsIgnoreCase("false")) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache44 + "= " + ChatColor.AQUA + deleted);
					}
					
					return true;
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return true;
				}
				
			}
			
			//Anfang Command "/wt reload"
			if(spawnpoint.equalsIgnoreCase("reload")) {
				if(p.hasPermission("worldtp.reload")) {
				
					//Fehler�berpr�fung
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
					int zahl = Config.configuration.getInt(Config.warpzahl);
					
					if(warps == null) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache31);
						return true;
					}
					if(zahl == 0) {
						p.sendMessage(ChatColor.RED + "[WorldTP] " + sprache31);
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
			if(spawnpoint.equalsIgnoreCase("delete")) {
				if(p.hasPermission("worldtp.delete")) {
					if(args.length < 2) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
						p.sendMessage("usage: <wt> <delete> <warpname>");
						return true;
					}
					if(args.length > 2) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache10);
						p.sendMessage("usage: <wt> <delete> <warpname>");
						return true;
					}
					if(args.length == 2) {
						String warpname = (args[1]);
						
						this.getConfig().set("Config."+ warpname +".delete", "true");					
						this.saveConfig();
						return new FindWarp(cmd, args, p).warpNumber(warpname);												
					}
				}else{
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache20);
					return true;
				}
			}
			
			//Anfang Command "/wt"
			else{
				if(p.hasPermission("worldtp.wt")) { 
					
					String PlayerName = p.getName();
					String TeleportMessage = this.getConfig().getString("Config.Global.TeleportMessage");
					Config.configuration.getString(Config.WarpCachePoint + PlayerName);
					String WarpDelete = this.getConfig().getString("Config."+ spawnpoint +".delete");
					String spawnName = Config.configuration.getString(Config.oldLoc + PlayerName + ".LastSpawnPoint");
					String world = this.getConfig().getString("Config." + spawnpoint +".world");
					String warping = this.getConfig().getString("Config." + spawnpoint +".TeleportToAnOtherWarp");
					
					String F2 = this.getConfig().getString("Config."+ spawnpoint +".spawn.F");
					double F = this.getConfig().getDouble("Config."+ spawnpoint +".spawn.F");
					double locY = this.getConfig().getDouble("Config."+ spawnpoint +".spawn.Y");
					double locX = this.getConfig().getDouble("Config."+ spawnpoint +".spawn.X");
					double locZ = this.getConfig().getDouble("Config."+ spawnpoint +".spawn.Z");
					
					if(F2 == null) {
						F = 0;
					}
					float locF = (float) F;
					
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
					if(WarpDelete.length() == 4) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache11);					
						return false;
					}					
					if(spawnName == null) {
						String AnotherWarpOn = this.getConfig().getString("Config."+ spawnpoint +".TeleportToAnOtherWarp");
						Config.configuration.set(Config.TrueCachePoint + PlayerName, AnotherWarpOn);
						Config.save();
					}
					
					String saved = this.getConfig().getString("Config."+ spawnpoint +".SaveInventory");
					String game = this.getConfig().getString("Config."+ spawnpoint +".GamemodeCreative");
					String clearinv = this.getConfig().getString("Config."+ spawnpoint +".ClearInventory");
					String invback = this.getConfig().getString("Config."+ spawnpoint +".activateCommandInvback");
					Config.configuration.getString(Config.oldLoc + PlayerName + ".AnotherWarp");
					
					//Fehler �berpr�fung								
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
				    Location loc = new Location(getServer().getWorld(world), locX, locY, locZ);
				    loc.setYaw(locF);
				    Config.configuration.getString(Config.TrueCachePoint + PlayerName);
				    int BugZahl = Config.configuration.getInt(Config.BugZahlCache + "." + PlayerName);
				    String BugZahl2 = Config.configuration.getString(Config.BugZahlCache + "." + PlayerName);				    
				    String blockTp = Config.configuration.getString(Config.blockwarpPoint + PlayerName);
				    String leaveOn = this.getConfig().getString("Config."+ spawnpoint +".SaveLeavepointAfterTp");
				    String loadCreativeInv = this.getConfig().getString("Config."+ spawnpoint +".loadCreativeInv");
				    
				    if(p.isInsideVehicle() == true) {
				    	if(BugZahl2 == null) {
				    		Config.configuration.set(Config.BugZahlCache + "." + PlayerName, 4);
				    		p.sendMessage(ChatColor.RED + "[WorldTp] 'Pferdeteleportieren' bugt manschmal rum. Man kann dann nicht mehr aufs Pferd oder das Pferd ist weg. Einfach relog machen! ");
				    		p.sendMessage(ChatColor.RED + "[WorldTp] Diese Meldung wird dir noch 4 mal angezeigt!");
				    		Config.save();
				    	}
				    }
				    if(p.isInsideVehicle() == true) {
				    		if(!(BugZahl == 0)) {
				    			int BugZahl3 = BugZahl - 1;
				    			Config.configuration.set(Config.BugZahlCache + "." + PlayerName, BugZahl3);					    							    
				    			p.sendMessage(ChatColor.RED + "[WorldTp] 'Pferdeteleportieren' bugt manschmal rum. Man kann dann nicht mehr aufs Pferd oder das Pferd ist weg. Einfach relog machen!");
				    			if(BugZahl3 == 0) {
				    				p.sendMessage(ChatColor.RED + "[WorldTp] Diese Meldung wird dir nun nicht mehr angezeigt. Dieser bug wird aber demn�chst gefixed");
				    			}else{
				    				p.sendMessage(ChatColor.RED + "[WorldTp] Diese Meldung wird dir noch " + BugZahl3 + " mal angezeigt!");
				    			}
				    			Config.save();
				    	}
				    }
				    if(blockTp == null) {
				    	if(warping.length() == 5) {
				    		Config.configuration.set(Config.blockwarpPoint + PlayerName, "blockWarpOn");
				    		Config.save();
				    	}
				    	if(warping.length() == 4) {
				    		Config.configuration.set(Config.blockwarpPoint + PlayerName, "blockWarpOff");
				    		Config.save();
				    	}
				    }
				    
				    if(!(blockTp == null)) {
				    	if(blockTp.equalsIgnoreCase("blockWarpOn")) {
					    	p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache30);
					    	return true;
					    }
				    }				    				    
				    
					if(warping.length() == 5) {
						Config.configuration.set(Config.blockwarpPoint + PlayerName, "blockWarpOn");
						Config.save();
					}
				    
				    if(leaveOn.length() == 4) {
				    	Config.OldPlayerLocName(p, spawnpoint);
				    }				    				    					    

				    Config.DoubleWarp(p);
				    
				    Config.OldPlayerInvbackDoubleFine(p);
				    Config.TeleportToWarp(p);				    
				    
				    if(TeleportMessage.length() == 4) {
				    	p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache1);
				    }
				    
				    if(p.isInsideVehicle() == true) {
				    	LivingEntity theHorse = (LivingEntity) p.getVehicle();
				    	theHorse.eject();
				    	theHorse.teleport(loc);	
				    	p.teleport(loc);
				    	//theHorse.setPassenger(p);
				    }
				    
				    if(!(p.isInsideVehicle() == true)) {
				    	p.teleport(loc);
				    }
				    
				    if(game.length() == 4) {
				    	p.setGameMode(GameMode.CREATIVE);
				    }
				    if(saved.length() == 4) {  
				    	InventoryManager.saveToFile(p);
				    }
				    if(!(loadCreativeInv.length() == 4)) {
				    	if(clearinv.length() == 4) {
					    	InventoryManager.clearInventory(p);
					    }
				    }				    
				    if(loadCreativeInv.length() == 4) {		
				    	InventoryManager.clearInventory(p);
				    	CreativeInventoryManager.loadFromFile(p);
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
		if(cmd.getName().equalsIgnoreCase("setwt")) {
			if(p.hasPermission("worldtp.setwt")) {				
				if(args.length > 3) {
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache10);
					p.sendMessage("usage: /<command> <warpname> <withsave/nosave> <gamemodenumber 0/1> or");
					p.sendMessage("usage: /<command> <warpname>");
					return false;
				}							
				
				if(args.length == 0) {
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
					p.sendMessage("usage: /<command> <warpname> <withsave/nosave> <gamemodenumber 0/1> or");
					p.sendMessage("usage: /<command> <warpname>");
					return false;
				}
				if(args.length == 2) {
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache9);
					p.sendMessage("usage: /<command> <warpname> <withsave/nosave> <gamemodenumber 0/1> or");
					p.sendMessage("usage: /<command> <warpname>");
					return false;
				}
				
				String spawnName = (args[0]);								
				String save = null;
				String game = null;
				if(args.length > 2) {
					save = (args[1]);
					game = (args[2]);	
				}											
				
				//Fehler�berpr�fung
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
				if(spawnName.equalsIgnoreCase("delete")) {
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache29);
					return true;
				}
				getConfig().set("Config."+ spawnName +".spawn.X", p.getLocation().getX());
				getConfig().set("Config."+ spawnName +".spawn.Y", p.getLocation().getY());
				getConfig().set("Config."+ spawnName +".spawn.Z", p.getLocation().getZ());
				getConfig().set("Config."+ spawnName +".spawn.F", p.getLocation().getYaw());
        		getConfig().get("Config."+ spawnName +".activateCommandLeave");
        		this.getConfig().set("Config."+ spawnName +".activateCommandLeave", true);
        		Config.configuration.set(Config.Backup + spawnName +".activateCommandLeave", true);
        		getConfig().get("Config."+ spawnName +".ClearInvByCommand");
				this.getConfig().set("Config."+ spawnName +".ClearInvByCommand", true);
				Config.configuration.set(Config.Backup + spawnName +".ClearInvByCommand", true);
				getConfig().get("Config."+ spawnName +".TeleportToAnOtherWarp");
				this.getConfig().set("Config."+ spawnName +".TeleportToAnOtherWarp", true);
				this.getConfig().set("Config."+ spawnName +".delete", false);
				Config.configuration.set(Config.Backup + spawnName +".TeleportToAnOtherWarp", true);
				this.getConfig().set("Config."+ spawnName +".SaveLeavepointAfterTp", true);
				this.getConfig().set("Config."+ spawnName +".BlockLeaveAfterCommandInvback", false);
				String world = p.getLocation().getWorld().getName();
				this.getConfig().set("Config."+ spawnName +".world", world);
				
            	if(args.length == 1) {            	            		
					getConfig().get("Config."+ spawnName +".SaveInventory");
					this.getConfig().set("Config."+ spawnName +".SaveInventory", false);
					Config.configuration.set(Config.Backup + spawnName +".SaveInventory", false);
					getConfig().get("Config."+ spawnName +".activateCommandInvback");
					this.getConfig().set("Config."+ spawnName +".activateCommandInvback", true);
					Config.configuration.set(Config.Backup + spawnName +".activateCommandInvback", false);
					getConfig().get("Config."+ spawnName +".ClearInventory");
					this.getConfig().set("Config."+ spawnName +".ClearInventory", false);
					Config.configuration.set(Config.Backup + spawnName +".ClearInventory", false);
					getConfig().get("Config."+ spawnName +".loadInvByCommandLeave");
					this.getConfig().set("Config."+ spawnName +".loadInvByCommandLeave", false);
					Config.configuration.set(Config.Backup + spawnName +".loadInvByCommandLeave", false);
					getConfig().get("Config."+ spawnName +".GamemodeCreative");
					this.getConfig().set("Config."+ spawnName +".GamemodeCreative", false);
					Config.configuration.set(Config.Backup + spawnName + ".GamemodeCreative", false);
					this.getConfig().set("Config."+ spawnName +".SaveCreativeInv", false);
					this.getConfig().set("Config."+ spawnName +".loadCreativeInv", false);
					this.getConfig().options().copyDefaults(true);
					
					String editWarp = this.getConfig().getString("Config."+ spawnName +".SaveInventory");
					
					if(!("false".equalsIgnoreCase(editWarp))) {
						if(!("true".equalsIgnoreCase(editWarp))) {
							Config.WarpUp(spawnName);	
						}
					}
					
					if(!("true".equalsIgnoreCase(editWarp))) {
						if(!("false".equalsIgnoreCase(editWarp))) {
							Config.WarpUp(spawnName);	
						}
					}
					
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache3);
					p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint " + spawnName + ", 'nosave' " + sprache16 + " survival");
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache4);												
					this.saveConfig();
					Config.save();
					return true;
            	}
				
            	if(args.length > 2) {   
            		//Fehler�berpr�fung
	            	if(!(game.equalsIgnoreCase("1"))) {
	            		if(!(game.equalsIgnoreCase("0"))) {
	            			p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache12);
							p.sendMessage("usage: /<command> <warpname> <withsave/nosave> <gamemodenumber 0/1> or");
							p.sendMessage("usage: /<command> <warpname>");
							return false;
	            		}
	            	}
	            	if(!(game.equalsIgnoreCase("0"))) {
	            		if(!(game.equalsIgnoreCase("1"))) {
	            			p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache12);
							p.sendMessage("usage: /<command> <warpname> <withsave/nosave> <gamemodenumber 0/1> or");
							p.sendMessage("usage: /<command> <warpname>");
							return false;
	            		}
	            	}
	            	if(!(save.equalsIgnoreCase("nosave"))) {
	            		if(!(save.equalsIgnoreCase("withsave"))) {
	            			p.sendMessage(ChatColor.RED + "[WorldTP] '" + save + "' " + sprache45);
							p.sendMessage("usage: /<command> <warpname> <withsave/nosave> <gamemodenumber 0/1> or");
							p.sendMessage("usage: /<command> <warpname>");
							return false;
	            		}
	            	}
	            	if(!(save.equalsIgnoreCase("withsave"))) {
	            		if(!(save.equalsIgnoreCase("nosave"))) {
	            			p.sendMessage(ChatColor.RED + "[WorldTP] '" + save + "' " + sprache45);
							p.sendMessage("usage: /<command> <warpname> <withsave/nosave> <gamemodenumber 0/1> or");
							p.sendMessage("usage: /<command> <warpname>");
	            			return false;
	            		}
	            	}
	            	
	            	//Hauptquellcode "setwt"
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
						this.getConfig().set("Config."+ spawnName +".SaveCreativeInv", false);
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
						this.getConfig().set("Config."+ spawnName +".ClearInventory", false);
						Config.configuration.set(Config.Backup + spawnName + ".ClearInventory", true);
						getConfig().get("Config."+ spawnName +".loadInvByCommandLeave");
						this.getConfig().set("Config."+ spawnName +".loadInvByCommandLeave", true);
						Config.configuration.set(Config.Backup + spawnName + ".loadInvByCommandLeave", true);
						this.getConfig().set("Config."+ spawnName +".SaveCreativeInv", true);						
						this.getConfig().options().copyDefaults(true);
						this.saveConfig();
						Config.save();
	            	}	 	            	
	            	if(game.equalsIgnoreCase("1")) {
	            		getConfig().get("Config."+ spawnName +".GamemodeCreative");
						this.getConfig().set("Config."+ spawnName +".GamemodeCreative", true);
						Config.configuration.set(Config.Backup + spawnName + ".GamemodeCreative", true);
						this.getConfig().set("Config."+ spawnName +".loadCreativeInv", true);
						Config.WarpUp(spawnName);	
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache3);
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnName + "', '" + save + "' " + sprache16 + " '" + game + "'");
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache4); 
						this.getConfig().options().copyDefaults(true);
						this.saveConfig();
						Config.save();
						return true;
					}
					
					if(game.equalsIgnoreCase("0")) {
						getConfig().get("Config."+ spawnName +".GamemodeCreative");
						this.getConfig().set("Config."+ spawnName +".GamemodeCreative", false);
						Config.configuration.set(Config.Backup + spawnName + ".GamemodeCreative", false);
						this.getConfig().set("Config."+ spawnName +".loadCreativeInv", false);
						Config.WarpUp(spawnName);
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache3);
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint '" + spawnName + "', '" + save + "' " + sprache16 + " '" + game + "'");
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache4); 
						this.getConfig().options().copyDefaults(true);
						this.saveConfig();
						Config.save();
						return true;	
						
					}else{
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache12);
						p.sendMessage("usage: /<command> <warpname> <withsave/nosave> <gamemodenumber 0/1> or");
						p.sendMessage("usage: /<command> <warpname>");
						return false;
					}
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
						p.sendMessage(ChatColor.RED + "/setwt: " + ChatColor.AQUA + sprache5);
						p.sendMessage(ChatColor.RED + "/wt: " + ChatColor.AQUA + sprache6);
						p.sendMessage(ChatColor.RED + "/worldtp: " + ChatColor.AQUA + sprache8);
						p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache7);
						p.sendMessage(ChatColor.RED + "/invback: " + ChatColor.AQUA + sprache21);
						p.sendMessage(ChatColor.RED + "/clearinv: " + ChatColor.AQUA + sprache46);
						p.sendMessage(ChatColor.RED + "/wt reload: " + ChatColor.AQUA + sprache47);
						p.sendMessage(ChatColor.RED + "/wt info: " + ChatColor.AQUA + sprache34);
						p.sendMessage(ChatColor.RED + "/wt list: " + ChatColor.AQUA + sprache35);
						p.sendMessage(ChatColor.RED + "/wt finderror: " + ChatColor.AQUA + sprache36);
						p.sendMessage(ChatColor.RED + "/wt delete: " + ChatColor.AQUA + sprache48);
                
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
					this.getConfig().getString("Config."+ spawnName +".ClearInventory");
					this.getConfig().getString("Config."+ spawnName +".loadCreativeInv");
						
					//Fehler �berpr�fung
					if(clearinvByCommand.length() > 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint "+ spawnName + " " + sprache33);
							return false;
					}
					if(clearinvByCommand.length() < 4) {
							p.sendMessage(ChatColor.RED + "[WorldTp] Spawnpoint "+ spawnName + " " + sprache33);
							return false;
					}
						
					//hauptquellcode vom Kommando "/clearinv"
					if(clearinvByCommand.length() == 4) {
						InventoryManager.clearInventory(p);
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
		
		//Gibt dein Inventar zur�ck
		if(cmd.getName().equalsIgnoreCase("invback")) {
			if(p.hasPermission("worldtp.invback")) {
				if(args.length == 0){
					String PlayerName = p.getName();
					String spawnName = Config.configuration.getString(Config.oldLoc + PlayerName + ".LastSpawnPoint");
					String spawnNameError = Config.configuration.getString(Config.oldLoc + PlayerName + ".LastSpawnPointError");
					this.getConfig().getString("Config."+ spawnName +".ClearInventory");
					String invback = this.getConfig().getString("Config."+ spawnName +".activateCommandInvback");
					String invDoubleBlock = this.getConfig().getString("Config."+ spawnName +".BlockLeaveAfterCommandInvback");
					this.getConfig().getString("Config."+ spawnName +".loadCreativeInv");
					
					if(invback == null) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache49);
						return true;
					}
					//�berpr�ft ob das Kommando in der Config f�r den jeweiligen Spawn deaktiviert wurde.
					if(invback.length() == 5) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache26);
						return true;
					}
					//Guckt ob das Kommando "/invback" schonmal benutzt wurde.					
					if(spawnNameError == "DoubleInvbackOn") {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache27);
						return true;
					}
					//Gibt an, dass das Kommando "/invack" schonmal benutzt wurde.
					Config.OldPlayerInvbackDouble(p);
					Config.save();
					
					//Ruft aus der Config ab, ob nach benutzung des Kommandos Invback, das Kommando "/leave" geblockt werden soll.
					if(invDoubleBlock.length() == 4) {						
						Config.OldPlayerInvback(p);
						Config.save();
					}					
					if(invback.length() == 4) {
						InventoryManager.loadFromFile(p);
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
					String DoubleInvback = Config.configuration.getString(Config.oldLoc + PlayerName + ".DoubleInvback");
					this.getConfig().getString("Config."+ spawnName +".ClearInventory");
					String loadInvByLeave = this.getConfig().getString("Config."+ spawnName +".loadInvByCommandLeave");
					String leave = this.getConfig().getString("Config."+ spawnName +".activateCommandLeave");
					String another = Config.configuration.getString(Config.oldLoc + PlayerName + ".AnotherWarp");
					String TeleportMessageBack = this.getConfig().getString("Config.Global.TeleportMessageBack");
					String world = Config.configuration.getString(Config.oldPoint + PlayerName + ".world");
					String blockTp = Config.configuration.getString(Config.blockwarpPoint + PlayerName);
					String SaveCreativeInv = this.getConfig().getString("Config."+ spawnName +".SaveCreativeInv");
					this.getConfig().getString("Config."+ spawnName +".loadCreativeInv");
					
					if(blockTp.equalsIgnoreCase("blockWarpOn")) {
						Config.configuration.set(Config.blockwarpPoint + PlayerName, "blockWarpOff");
						Config.save();
					}
					String F2 = Config.configuration.getString(Config.oldLoc + PlayerName + ".spawn.F");
					
					double F = Config.configuration.getDouble(Config.oldLoc + PlayerName + ".spawn.F");
					double LocX = Config.configuration.getDouble(Config.oldLoc + PlayerName + ".spawn.X");
					double LocY = Config.configuration.getDouble(Config.oldLoc + PlayerName + ".spawn.Y");
					double LocZ = Config.configuration.getDouble(Config.oldLoc + PlayerName + ".spawn.Z");
					
					if(F2 == null) {
						F = 0;
					}
					float locF = (float) F;
					
					Location loc = new Location(getServer().getWorld(world) ,LocX, LocY, LocZ);
					loc.setYaw(locF);
					
					//Fehler�berpr�fungen
										
					if(world == null) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache50);
						return true;
					}
					if(LocX == 0) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache50);
						return true;
					}
					if(spawnName == null) {						
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache50);
						return true;
					}
					if(leave == null) {						
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache50);
						return true;
					}
					if(loadInvByLeave == null) {						
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache50);
						return true;
					}
					
					//�berpr�ft ob das "Creative Inventar" gespeichert werden soll.
					if(SaveCreativeInv.length() == 4) {
						CreativeInventoryManager.saveToFile(p);
					}
					
					//Hauptquellcode "/leave"
					String s = "asdi";										
					
					//Blocken wenn Invback benutzt wurde
					if(DoubleInvback == "DoubleInvbackOn") {
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
					
					if(p.isInsideVehicle() == true) {
				    	LivingEntity theHorse = (LivingEntity) p.getVehicle();
				    	theHorse.eject();
				    	p.teleport(loc);
				    	theHorse.teleport(loc);							    	
				    	//theHorse.setPassenger(p);
				    }
					
					if(!(p.isInsideVehicle() == true)) {
						p.teleport(loc);
					}
					
					if(TeleportMessageBack.length() == 4) {
						p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache2);
					}
					
					GameMode gamemode = p.getGameMode();
					if(gamemode == GameMode.CREATIVE) {
						p.setGameMode(GameMode.SURVIVAL);
					}
					
					if(loadInvByLeave.length() == 4) {
						InventoryManager.loadFromFile(p);
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

	public void reloadFolders() {
		dir = new File("plugins/WorldTp/saves/inventories");
		folder = new File("plugins/WorldTp/saves/Creative Inventories");
		dir.mkdir();
		folder.mkdir();
	}

	public Config getConfiguration() {
		return config;		
    }
	
	public language LgetConfiguration() {
		return Language;
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
		
		//Gobal
		String path42 = "Config.Global.TeleportMessage";
		this.getConfig().addDefault(path42, true);
		String path43 = "Config.Global.TeleportMessageBack";
		this.getConfig().addDefault(path43, true);
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
}