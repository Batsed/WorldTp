package me.Batsed.WorldTp;

import java.io.File;
import java.util.HashMap;




import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;

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
	@SuppressWarnings("null")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		String sprache1 = this.getConfig().getString("Config.Sprache.kreativ");
		String sprache2 = this.getConfig().getString("Config.Sprache.leave");
		String sprache3 = this.getConfig().getString("Config.Sprache.setspawnpoint");
		String sprache4 = this.getConfig().getString("Config.Sprache.setspawnpoint2");
		String sprache5 = this.getConfig().getString("Config.Sprache.help.setspawnpoint");
		String sprache6 = this.getConfig().getString("Config.Sprache.help.creative");
		String sprache7 = this.getConfig().getString("Config.Sprache.help.leave");
		String sprache8 = this.getConfig().getString("Config.Sprache.help.wt/worldTp");
		
		Inventory inv2 = null;
		JavaPlugin plugin = null;
		World World = null;
		Player p = (Player)sender;
		//Zum Spawnpoint teleportieren/Teleporting to the spawn point
		if(cmd.getName().equalsIgnoreCase("creative")) {
			if(args.length == 0) {
				
				oldLocationList.put(p, p.getLocation());
				
				double locY = this.getConfig().getDouble("Config.World.spawn.Y");
				double locX = this.getConfig().getDouble("Config.World.spawn.X");
				double locZ = this.getConfig().getDouble("Config.World.spawn.Z");
				
				
				for (ItemStack stack : inv2.getContents()) {
				    if (stack == null) continue;
				}
				savePlayerInv();
					
					File playerInvConfigFile = new File(plugin.getDataFolder() + File.separator + "players" + File.separator + p.getName(), "inventory.yml");
					FileConfiguration pInv = YamlConfiguration.loadConfiguration(playerInvConfigFile);
					PlayerInventory inv = p.getInventory();
					int i = 0;
					
					for (ItemStack stack1 : inv.getContents()) {
						//increment integer
						i++;
						String startInventory = World.getName() + ".inv." + Integer.toString(i);
						
						//save inv
						pInv.set(startInventory + ".amount", stack1.getAmount());
						pInv.set(startInventory + ".durability", Short.toString(stack1.getDurability()));
						pInv.set(startInventory + ".type", stack1.getTypeId());
						//pInv.set(startInventory + ".enchantment", stack.getEnchantments());
						//TODO add enchant saveing 
				        }

					i = 0;
					for (ItemStack armor : inv.getArmorContents()){
						i++;
						String startArmor = World.getName() + ".armor." + Integer.toString(i);

						//save armor
						pInv.set(startArmor + ".amount", armor.getAmount());
						pInv.set(startArmor + ".durability", armor.getDurability());
						pInv.set(startArmor + ".type", armor.getTypeId());
						//pInv.set(startArmor + ".enchantment", armor.getEnchantments());
					}

					//save exp
					if (p.getExp() != 0) {
						pInv.set(World.getName() + ".exp", p.getExp());
					}
				
				
				Location loc = new Location(getServer().getWorld(p.getWorld().getName()),locX, locY, locZ);
				p.getInventory().clear();
				p.setGameMode(GameMode.CREATIVE);
				p.teleport(loc);
				
				p.sendMessage(ChatColor.RED + "[WorldTp] " + sprache1);
				
				return true;
				
				} else{ 
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
				p.sendMessage(ChatColor.RED + "/worldtp or /wt: " + ChatColor.AQUA + sprache8);
				p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache7);
                
                return true;
            }
            else {
                return false;
            }
        }
		//Um hilfe von WorldTp zu bekommen / Getting help from WorldTP
		if(cmd.getName().equalsIgnoreCase("wt")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "/setspawnpoint: " + ChatColor.AQUA + sprache5);
				p.sendMessage(ChatColor.RED + "/creative: " + ChatColor.AQUA + sprache6);
				p.sendMessage(ChatColor.RED + "/worldtp or /wt: " + ChatColor.AQUA + sprache8);
				p.sendMessage(ChatColor.RED + "/leave: " + ChatColor.AQUA + sprache7);
				
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

	private void savePlayerInv() {
		// TODO Auto-generated method stub
		
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
}