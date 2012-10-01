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
		System.out.println("[WorldTp] Plugin aktiviert");
	
	}
	public void onDisable() {
		System.out.println("[WorldTp] Plugin deaktiviert");
		}
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		Player p = (Player)sender;
		
		//Zum Spawnpoint teleportieren
		if(cmd.getName().equalsIgnoreCase("kreativ")) {
			if(args.length == 0) {
				
				oldLocationList.put(p, p.getLocation());
				
				double locY = this.getConfig().getDouble("Config.World.spawn.Y");
				double locX = this.getConfig().getDouble("Config.World.spawn.X");
				double locZ = this.getConfig().getDouble("Config.World.spawn.Z");
				
				String sprache1 = this.getConfig().getString("Config.Sprache.kreativ");
				
				Location loc = new Location(getServer().getWorld(p.getWorld().getName()),locX, locY, locZ);
				p.getInventory().clear();
				p.setGameMode(GameMode.CREATIVE);
				p.teleport(loc);
				
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache1);
				
				return true;
			}else {
			return false;
			}
		}
		
		//Spawnpoint von der Welt setzen
		if(cmd.getName().equalsIgnoreCase("setspawnpoint")) {
			if(args.length == 0) {
                getConfig().set("Config.World.spawn.X", p.getLocation().getX());
                getConfig().set("Config.World.spawn.Y", p.getLocation().getY());
            	getConfig().set("Config.World.spawn.Z", p.getLocation().getZ());
                
            	p.sendMessage(ChatColor.RED + "[WorldTp] Du hast den spawnpoint gesetzt.");
                p.sendMessage(ChatColor.RED + "[WorldTp] Gespeichert!");
                
        		this.getConfig().options().copyDefaults(true);
        		this.saveConfig();
                
                return true;
            }
            else {
                return false;
            }
        }	
		
		//Um hilfe von WolrTp zu bekommen
		if(cmd.getName().equalsIgnoreCase("worldtp")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "/setspawnpoint:" + ChatColor.AQUA + " Setzt den Spawn wo du mit /kreativ hinkommst");
				p.sendMessage(ChatColor.RED + "/kreativ:" + ChatColor.AQUA + " Du kommst da hin wo du den spawn gesetzt hast");
				p.sendMessage(ChatColor.RED + "/worldtp or /wt:" + ChatColor.AQUA + " Du bekommst hilfe über WorldTp");
				p.sendMessage(ChatColor.RED + "/leave:" + ChatColor.AQUA + " Du verlässt die 'Kreativ' Welt");
                
                return true;
            }
            else {
                return false;
            }
        }
		//Um hilfe von WolrTp zu bekommen
		if(cmd.getName().equalsIgnoreCase("wt")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "/setspawnpoint:" + ChatColor.AQUA + " Setzt den Spawn wo du mit /kreativ hinkommst");
				p.sendMessage(ChatColor.RED + "/kreativ:" + ChatColor.AQUA + " Du kommst da hin wo du den spawn gesetzt hast");
				p.sendMessage(ChatColor.RED + "/worldtp or /wt:" + ChatColor.AQUA + " Du bekommst hilfe über WorldTp");
				p.sendMessage(ChatColor.RED + "/leave:" + ChatColor.AQUA + " Du verlässt die 'Kreativ' Welt");
				
				return true;
			}
			else {
				return false;
			}
		}
		//Aus der Welt zum alten Standpunkt teleportieren
		if(cmd.getName().equalsIgnoreCase("leave")) {
			if(args.length == 0) {
				
				if(oldLocationList.containsKey(p)) {
					
					p.teleport(oldLocationList.get(p));
					p.setGameMode(GameMode.SURVIVAL);	
					
					p.sendMessage(ChatColor.RED + "[WorldTp] Du bist zu deiner alten Position geported worden");

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
		this.getConfig().addDefault(path1, "Du wurdest Teleportiert");
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
}