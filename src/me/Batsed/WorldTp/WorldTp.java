package me.Batsed.WorldTp;

import java.util.HashMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;

public class WorldTp extends JavaPlugin {
	
	
	PluginDescriptionFile descFile = this.getDescription();

	public void onEnable() {
		loadConfig();
		System.out.println("[WorldTp] Plugin by Batsed");
		System.out.println("[WorldTp] activate plugin");
	}
	
	public void onDisable() {
		System.out.println("[WorldTp] deactivate plugin");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		String sprache1 = this.getConfig().getString("Config.Sprache.creative");
		String sprache2 = this.getConfig().getString("Config.Sprache.leave");
		String sprache3 = this.getConfig().getString("Config.Sprache.setspawnpoint");
		String sprache4 = this.getConfig().getString("Config.Sprache.setspawnpoint2");
		String sprache5 = this.getConfig().getString("Config.Sprache.help.setspawnpoint");
		String sprache6 = this.getConfig().getString("Config.Sprache.help.creative");
		String sprache7 = this.getConfig().getString("Config.Sprache.help.leave");
		String sprache8 = this.getConfig().getString("Config.Sprache.help.wt/worldTp");
		
		Player p = (Player)sender;
		
		//Zum Spawnpoint teleportieren
		//Teleporting to the spawn point
		if(cmd.getName().equalsIgnoreCase("wt")) {
			if(args.length < 1) {
				p.sendMessage(ChatColor.RED + "[WorldTp] Zu wenig Argumente angegeben");
				return false;
			}
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "[WorldTp] Zu viele Argumente angegeben");
				return false;
			}
			if(args.length == 1) {
				String Spawnpoint = (args[0]);		
				
				double locY = this.getConfig().getDouble("Config."+ Spawnpoint +".spawn.Y");
			    double locX = this.getConfig().getDouble("Config."+ Spawnpoint +".spawn.X");
			    double locZ = this.getConfig().getDouble("Config."+ Spawnpoint +".spawn.Z");
			    
			    if(locX == 0) if(locY == 0) if(locZ == 0) {
			    	p.sendMessage(ChatColor.RED + "Warppoint nicht vorhanden");
			    	return false;
			    }
			   
			    oldLocationList.put(p, p.getLocation());
			    
			    Location loc = new Location(getServer().getWorld(p.getWorld().getName()),locX, locY, locZ);
				
			    p.setGameMode(GameMode.CREATIVE);
			    
				p.teleport(loc);
				
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache1);
				return new InventoryManager(cmd, args, p).saveToFile(p);
				
			}else{
				return false;
			}
		}
	
		//Spawnpoint von der Welt setzen
		//Defining the spawn point for the creative world
		if(cmd.getName().equalsIgnoreCase("setspawnpoint")) {
			if(args.length < 1) {
				p.sendMessage(ChatColor.RED + "[WorldTp] Zu wenig Argumente");
				return false;
				
			}
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "[WorldTp] Zu viele Argumente");
			}
			if(args.length == 1) {
				String spawnName = (args[0]);
				getConfig().set("Config."+ spawnName +".spawn.X", p.getLocation().getX());
                getConfig().set("Config."+ spawnName +".spawn.Y", p.getLocation().getY());
            	getConfig().set("Config."+ spawnName +".spawn.Z", p.getLocation().getZ());
                
            	p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache3);
                p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache4);
                
                this.getConfig().options().copyDefaults(true);
        		this.saveConfig();
                
        		return true;
			}else {
				return false;
			}
		}	
		
		//Um hilfe von WorldTp zu bekommen
		//Getting help from WorldTP
		if(cmd.getName().equalsIgnoreCase("worldtp")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "/setspawnpoint: " + ChatColor.AQUA + sprache5);
				p.sendMessage(ChatColor.RED + "/creative: " + ChatColor.AQUA + sprache6);
				p.sendMessage(ChatColor.RED + "/worldtp or /wt: " + ChatColor.AQUA + sprache8);
				p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache7);
                
				return true;
			}else {
				return false;
            }
		}
		
		//Aus der Welt zum alten Standpunkt teleportieren
		//Teleporting from the world to the old place
		if(cmd.getName().equalsIgnoreCase("leave")) {
			if(args.length == 0) {
				if(oldLocationList.containsKey(p)) {
					
					p.teleport(oldLocationList.get(p));
					p.setGameMode(GameMode.SURVIVAL);	
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache2);
					
					return new InventoryManager(cmd, args, p).loadFromFile(p);
				}else {
					return false;
				}
				
			}
			return false;
		}
		return false;
	}
	public HashMap<Player, Location> oldLocationList = new HashMap<Player, Location>();

	public void loadConfig(){
		String path1 = "Config.Sprache.creative";
		this.getConfig().addDefault(path1, "You have been teleported");
		String path2 = "Config.Sprache.leave";
		this.getConfig().addDefault(path2, "You have been teleported back to your old position");
		String path3 = "Config.Sprache.setspawnpoint";
		this.getConfig().addDefault(path3, "You have defined the spawnpoint");
		String path4 = "Config.Sprache.setspawnpoint2";
		this.getConfig().addDefault(path4, "Saved");
		String path5 = "Config.Sprache.help.setspawnpoint";
		this.getConfig().addDefault(path5, "Sets the spawn point you reach with /creative");
		String path6 = "Config.Sprache.help.creative";
		this.getConfig().addDefault(path6, "You go to the spawn point you set");
		String path7 = "Config.Sprache.help.leave";
		this.getConfig().addDefault(path7, "You leave the creative world");
		String path8 = "Config.Sprache.help.wt/worldTp";
		this.getConfig().addDefault(path8, "Read the help for WorldTP");
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	
		
		
	}
	public static JavaPlugin getPlugin() {
		// TODO Auto-generated method stub
		return null;
	}
		
}