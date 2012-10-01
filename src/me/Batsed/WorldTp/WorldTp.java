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
		//activate plugin
		System.out.println("[WorldTp] Plugin aktiviert");
	
	}
	public void onDisable() {
		//deactivate plugin
		System.out.println("[WorldTp] Plugin deaktiviert");
		}
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		String sprache1 = this.getConfig().getString("Config.Sprache.kreativ");
		String sprache2 = this.getConfig().getString("Config.Sprache.leave");
		String sprache3 = this.getConfig().getString("Config.Sprache.setspawnpoint");
		String sprache4 = this.getConfig().getString("Config.Sprache.setspawnpoint2");
		String sprache5 = this.getConfig().getString("Config.Sprache.help.setspawnpoint");
		String sprache6 = this.getConfig().getString("Config.Sprache.help.creative");
		String sprache7 = this.getConfig().getString("Config.Sprache.help.leave");
		String sprache8 = this.getConfig().getString("Config.Sprache.help.wt/worldTp");
		
		Player p = (Player)sender;
		
		//Zum Spawnpoint teleportieren/Teleporting to the spawn point
		if(cmd.getName().equalsIgnoreCase("creative")) {
			if(args.length == 0) {
				
				oldLocationList.put(p, p.getLocation());
				
				double locY = this.getConfig().getDouble("Config.World.spawn.Y");
				double locX = this.getConfig().getDouble("Config.World.spawn.X");
				double locZ = this.getConfig().getDouble("Config.World.spawn.Z");
				
				
				
				Location loc = new Location(getServer().getWorld(p.getWorld().getName()),locX, locY, locZ);
				p.getInventory().clear();
				p.setGameMode(GameMode.creative);
				p.teleport(loc);
				
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache1);
				
				return true;
			}else {
			return false;
			}
		}
		
		//Spawnpoint von der Welt setzen/Defining the spawn point for the creative world
		if(cmd.getName().equalsIgnoreCase("setspawnpoint")) {
			if(args.length == 0) {
                getConfig().set("Config.World.spawn.X", p.getLocation().getX());
                getConfig().set("Config.World.spawn.Y", p.getLocation().getY());
            	getConfig().set("Config.World.spawn.Z", p.getLocation().getZ());
                
            	p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache3);
                p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache4);
                
        		this.getConfig().options().copyDefaults(true);
        		this.saveConfig();
                
                return true;
            }
            else {
                return false;
            }
        }	
		
		//Um hilfe von WorldTp zu bekommen/Getting help from WorldTP
		if(cmd.getName().equalsIgnoreCase("worldtp")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "/setspawnpoint: " + ChatColor.AQUA + sprache5);
				p.sendMessage(ChatColor.RED + "/creative: " + ChatColor.AQUA + sprache6);
				p.sendMessage(ChatColor.RED + "/worldtp or /wt: " + ChatColor.AQUA + sprache7);
				p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache8);
                
                return true;
            }
            else {
                return false;
            }
        }
		//Um hilfe von WorldTp zu bekommen/Getting help from WorldTP
		if(cmd.getName().equalsIgnoreCase("wt")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "/setspawnpoint: " + ChatColor.AQUA + sprache5);
				p.sendMessage(ChatColor.RED + "/creative: " + ChatColor.AQUA + sprache6);
				p.sendMessage(ChatColor.RED + "/worldtp or /wt: " + ChatColor.AQUA + sprache7);
				p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache8);
				
				return true;
			}
			else {
				return false;
			}
		}
		//Aus der Welt zum alten Standpunkt teleportieren/Teleporting from the world to the old place
		if(cmd.getName().equalsIgnoreCase("leave")) {
			if(args.length == 0) {
				
				if(oldLocationList.containsKey(p)) {
					
					p.teleport(oldLocationList.get(p));
					p.setGameMode(GameMode.SURVIVAL);	
					
					p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache2);

					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	public HashMap<Player, Location> oldLocationList = new HashMap<Player, Location>();

		public void loadConfig(){
		String patchY = "Config.World.spawn.Y";
		this.getConfig().addDefault(patchY, 0);
		String patchX = "Config.World.spawn.X";
		this.getConfig().addDefault(patchX, 0);
		String patchZ = "Config.World.spawn.Z";
		this.getConfig().addDefault(patchZ, 0);
		String path1 = "Config.Sprache.kreativ";
		//You have been teleported
		this.getConfig().addDefault(path1, "Du wurdest Teleportiert");
		String path2 = "Config.Sprache.leave";
		//Yo have been teleported back to your old position
		this.getConfig().addDefault(path2, "Du wurdest zu deiner alten Position geported");
		String path3 = "Config.Sprache.setspawnpoint";
		//You have defined the spawnpoint
		this.getConfig().addDefault(path3, "Du hast den spawnpoint gesetzt.");
		String path4 = "Config.Sprache.setspawnpoint2";
		//Saved
		this.getConfig().addDefault(path4, "Gespeichert");
		String path5 = "Config.Sprache.help.setspawnpoint";
		//Sets the spawn point you reach with /creative
		this.getConfig().addDefault(path5, "Setzt den Spawn wo du mit /creative hinkommst");
		String path6 = "Config.Sprache.help.creative";
		//You go to the spawn point you set
		this.getConfig().addDefault(path6, "Du kommst da hin wo du den spawn gesetzt hast");
		String path7 = "Config.Sprache.help.leave";
		//You leave the creative world
		this.getConfig().addDefault(path7, "Du verlässt die 'Kreativ' Welt");
		String path8 = "Config.Sprache.help.wt/worldTp";
		//Read the help for WorldTP
		this.getConfig().addDefault(path8, "Du bekommst hilfe über WorldTp");
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
}