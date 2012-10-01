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
		
		String sprache1 = this.getConfig().getString("Config.Sprache.kreativ");
		String sprache2 = this.getConfig().getString("Config.Sprache.leave");
		String sprache3 = this.getConfig().getString("Config.Sprache.setspawnpoint");
		String sprache4 = this.getConfig().getString("Config.Sprache.setspawnpoint2");
		String sprache5 = this.getConfig().getString("Config.Sprache.help.setspawnpoint");
		String sprache6 = this.getConfig().getString("Config.Sprache.help.creativ");
		String sprache7 = this.getConfig().getString("Config.Sprache.help.leave");
		String sprache8 = this.getConfig().getString("Config.Sprache.help.wt/worldTp");
		
		Player p = (Player)sender;
		
		//Zum Spawnpoint teleportieren
		if(cmd.getName().equalsIgnoreCase("creativ")) {
			if(args.length == 0) {
				
				oldLocationList.put(p, p.getLocation());
				
				double locY = this.getConfig().getDouble("Config.World.spawn.Y");
				double locX = this.getConfig().getDouble("Config.World.spawn.X");
				double locZ = this.getConfig().getDouble("Config.World.spawn.Z");
				
				
				
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
		
		//Um hilfe von WolrTp zu bekommen
		if(cmd.getName().equalsIgnoreCase("worldtp")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "/setspawnpoint: " + ChatColor.AQUA + sprache5);
				p.sendMessage(ChatColor.RED + "/creativ: " + ChatColor.AQUA + sprache6);
				p.sendMessage(ChatColor.RED + "/worldtp or /wt: " + ChatColor.AQUA + sprache7);
				p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache8);
                
                return true;
            }
            else {
                return false;
            }
        }
		//Um hilfe von WolrTp zu bekommen
		if(cmd.getName().equalsIgnoreCase("wt")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "/setspawnpoint: " + ChatColor.AQUA + sprache5);
				p.sendMessage(ChatColor.RED + "/creativ: " + ChatColor.AQUA + sprache6);
				p.sendMessage(ChatColor.RED + "/worldtp or /wt: " + ChatColor.AQUA + sprache7);
				p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache8);
				
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
		this.getConfig().addDefault(path1, "Du wurdest Teleportiert");
		String path2 = "Config.Sprache.leave";
		this.getConfig().addDefault(path2, "Du wurdest zu deiner alten Position geported");
		String path3 = "Config.Sprache.setspawnpoint";
		this.getConfig().addDefault(path3, "Du hast den spawnpoint gesetzt.");
		String path4 = "Config.Sprache.setspawnpoint2";
		this.getConfig().addDefault(path4, "Gespeichert");
		String path5 = "Config.Sprache.help.setspawnpoint";
		this.getConfig().addDefault(path5, "Setzt den Spawn wo du mit /creativ hinkommst");
		String path6 = "Config.Sprache.help.creativ";
		this.getConfig().addDefault(path6, "Du kommst da hin wo du den spawn gesetzt hast");
		String path7 = "Config.Sprache.help.leave";
		this.getConfig().addDefault(path7, "Du verl�sst die 'Kreativ' Welt");
		String path8 = "Config.Sprache.help.wt/worldTp";
		this.getConfig().addDefault(path8, "Du bekommst hilfe �ber WorldTp");
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
}