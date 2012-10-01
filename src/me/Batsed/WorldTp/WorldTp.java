package me.Batsed.WorldTp;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;

public class WorldTp extends JavaPlugin {
	
	ItemStack item;
	CardboardBox cardboardBox;
	
	
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
				
				cardboardBox = new CardboardBox(item);
				oldLocationList.put(p, p.getLocation());
				
				double locY = this.getConfig().getDouble("Config.World.spawn.Y");
				double locX = this.getConfig().getDouble("Config.World.spawn.X");
				double locZ = this.getConfig().getDouble("Config.World.spawn.Z");
				
				Location loc = new Location(getServer().getWorld(p.getWorld().getName()),locX, locY, locZ);
				p.getInventory().clear();
				p.setGameMode(GameMode.CREATIVE);
				p.teleport(loc);
				
				p.sendMessage(ChatColor.RED + "[WorldTp] Du wurdest Teleportiert");
				
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
					item = cardboardBox.unbox();	
					
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
	
	 
	public static final HashMap<Player, Location> Enchantments = null;
	public HashMap<CardboardEnchantment, Integer> map = new HashMap<CardboardEnchantment, Integer>();
	public Map<Enchantment, Integer> enchantments = item.getEnchantments();
	
	
	public class CardboardEnchantment {
	 
	    private final int id;
	 
	    public CardboardEnchantment(Enchantment enchantment) {
	        this.id = enchantment.getId();
	    }
	 
	    public Enchantment unbox() {
	        return Enchantment.getById(this.id);
	    }
	}
	
	public class CardboardBox {
		private final int type, amount;
	    private final short damage;
	    private final byte data;

	    private HashMap<CardboardEnchantment, Integer> enchants;
	
	    public CardboardBox(ItemStack item) {
	 	this.type = item.getTypeId();
	   	this.amount = item.getAmount();
	   	this.damage = item.getDurability();
	   	this.data = item.getData().getData();
 
	    	
 
	   	for(Enchantment enchantment : enchantments.keySet()) {
	   		map.put(new CardboardEnchantment(enchantment), enchantments.get(enchantment));
	   	}
 
	   	this.enchants = map;
	    }
 
	    public ItemStack unbox() {
	    	ItemStack item = new ItemStack(type, amount, damage, data);
 
	    	HashMap<Enchantment, Integer> map = new HashMap<Enchantment, Integer>();
 
	    	for(CardboardEnchantment cEnchantment : enchants.keySet()) {
	    		map.put(cEnchantment.unbox(), enchants.get(cEnchantment));
	    	}
 
	    	item.addUnsafeEnchantments(map);

    	return item;
	    }
	}
	
	private void loadConfig(){
		String patchY = "Config.World.spawn.Y";
		this.getConfig().addDefault(patchY, 0);
		String patchX = "Config.World.spawn.X";
		this.getConfig().addDefault(patchX, 0);
		String patchZ = "Config.World.spawn.Z";
		this.getConfig().addDefault(patchZ, 0);
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
}