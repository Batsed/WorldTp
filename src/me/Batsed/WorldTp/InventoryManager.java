package me.Batsed.WorldTp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
 
public class InventoryManager
{
	String clearinv;
	Command cmd;
	String[] args;
	Player p;
	
	public InventoryManager(Command cmd, String[] args, Player p, String clearinv) {
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.clearinv = clearinv;
	}
	static String EXT = ".inv";			
	private File dir;
	private Map<Player, ItemStack[]> items;
	private Map<Player, ItemStack[]> armor;
 
	//public InventoryManager()
	//	this.dir = new File("plugins/WorldTp/saves/inventories");
	//  this.dir.mkdir();

	//	this.items = new HashMap<Player, ItemStack[]>();
	//	this.armor = new HashMap<Player, ItemStack[]>();
	//}

	public boolean storeInventory(Player p)
	{
		if ((this.items.containsKey(p)) && (this.armor.containsKey(p))) {
			return false;
		}

		PlayerInventory inv = p.getInventory();
		ItemStack[] memItems = inv.getContents();
		ItemStack[] memArmor = inv.getArmorContents();
		this.items.put(p, memItems);
		this.armor.put(p, memArmor);

		saveToFile(p);
		clearInventory(p);
		return true;
	}

	public boolean restoreInventory(Player p)
	{
		ItemStack[] memItems = (ItemStack[])this.items.remove(p);
		ItemStack[] memArmor = (ItemStack[])this.armor.remove(p);

		if ((memItems != null) && (memArmor != null)) {
			PlayerInventory inv = p.getInventory();

			inv.setContents(memItems);
			inv.setArmorContents(memArmor);

			new File(this.dir, p.getName() + EXT).delete();

			return true;
		}

		return loadFromFile(p);
	}

	public boolean clearInventory(Player p)
	{
		PlayerInventory inv = p.getInventory();
		inv.clear();
		inv.setHelmet(null);
		inv.setChestplate(null);
		inv.setLeggings(null);
		inv.setBoots(null);
		return true;
	}

	public boolean saveToFile(Player p) {
		File file = new File(this.dir, p.getName() + EXT);
		if (file.exists()) {
			return true;
		}
		try
		{
			SerializableInventory inv = new SerializableInventory(p.getInventory());
 
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(inv);
			oos.close();
			if(this.clearinv.length() == 4) {
				return clearInventory(p);
				
			}
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean loadFromFile(Player p)
	{
		File file = new File(this.dir, p.getName() + EXT);
 
		if (!file.exists()) {
			return true;
		}
		try
		{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
 
			Object o = ois.readObject();
			ois.close();

			SerializableInventory inv = (SerializableInventory)o;
      SerializableInventory.loadContents(p, inv);

      file.delete();
 
      return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}return false;
	}

	public static boolean hasEmptyInventory(Player p)
	{
		ItemStack[] inventory = p.getInventory().getContents();
		ItemStack[] armor = p.getInventory().getArmorContents();
		
		for (ItemStack stack : inventory) {
			if (stack != null) {
				return false;
			}
		}

		for (ItemStack stack : armor) {
			if (stack.getTypeId() != 0) {
				return false;
			}
		}
		return true;
	}
 
	public static boolean restoreFromFile(WorldTp plugin, Player p)
	{
		File dir = new File(plugin.getDataFolder(), "inventories");

		File file = new File(dir, p.getName() + EXT);

		if (!file.exists()) {
			return false;
		}
		try
		{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
 
			Object o = ois.readObject();
			ois.close();
 
			SerializableInventory inv = (SerializableInventory)o;
			SerializableInventory.loadContents(p, inv);
 
			file.delete();
			
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}return false;
	}
}