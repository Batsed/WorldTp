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

public class CreativeInventoryManager {
	String loadCreativeInv;
	static String clearinv;
	Command cmd;
	String[] args;
	Player p;
	
	public CreativeInventoryManager(Command cmd, String[] args, Player p, String clearinv, String loadCreativeInv) {
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		CreativeInventoryManager.clearinv = clearinv;
		this.loadCreativeInv = loadCreativeInv;
	}

	private static String dir = "plugins/WorldTp/saves/Creative Inventories";
	static String EXT = ".inv";
	private static Map<Player, ItemStack[]> items;
	private static Map<Player, ItemStack[]> armor;

	public static void storeInventory(Player p)
	{
		if ((CreativeInventoryManager.items.containsKey(p)) && (CreativeInventoryManager.armor.containsKey(p))) {
			return;
		}

		PlayerInventory inv = p.getInventory();
		ItemStack[] memItems = inv.getContents();
		ItemStack[] memArmor = inv.getArmorContents();
		CreativeInventoryManager.items.put(p, memItems);
		CreativeInventoryManager.armor.put(p, memArmor);

		CreativeInventoryManager.saveToFile(p);
		CreativeInventoryManager.clearInventory(p);
		return;
	}

	public static void restoreInventory(Player p)
	{
		ItemStack[] memItems = (ItemStack[])CreativeInventoryManager.items.remove(p);
		ItemStack[] memArmor = (ItemStack[])CreativeInventoryManager.armor.remove(p);

		if ((memItems != null) && (memArmor != null)) {
			PlayerInventory inv = p.getInventory();

			inv.setContents(memItems);
			inv.setArmorContents(memArmor);

			new File(CreativeInventoryManager.dir, p.getName() + EXT).delete();

			return;
		}
		CreativeInventoryManager.loadFromFile(p);
		return;
	}

	public static void clearInventory(Player p)
	{
		PlayerInventory inv = p.getInventory();
		inv.clear();
		inv.setHelmet(null);
		inv.setChestplate(null);
		inv.setLeggings(null);
		inv.setBoots(null);
		return;
	}

	public static void saveToFile(Player p) {
		File file = new File(CreativeInventoryManager.dir, p.getName() + EXT);
		if (file.exists()) {
			return;
		}
		try
		{
			SerializableInventory inv = new SerializableInventory(p.getInventory());
 
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(inv);
			oos.close();
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	public static void loadFromFile(Player p)
	{
		File file = new File(CreativeInventoryManager.dir, p.getName() + EXT);
 
		if (!file.exists()) {
			return;
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
 
      return;
		}
		catch (Exception e) {
			e.printStackTrace();
		}return;
	}

	public static void hasEmptyInventory(Player p)
	{
		ItemStack[] inventory = p.getInventory().getContents();
		ItemStack[] armor = p.getInventory().getArmorContents();
		
		for (ItemStack stack : inventory) {
			if (stack != null) {
				return;
			}
		}

		for (ItemStack stack : armor) {
			if (stack.getTypeId() != 0) {
				return;
			}
		}
		return;
	}
 
	public static void restoreFromFile(WorldTp plugin, Player p)
	{
		File dir = new File(plugin.getDataFolder(), "inventories");

		File file = new File(dir, p.getName() + EXT);

		if (!file.exists()) {
			return;
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
			
			return;
		}
		catch (Exception e) {
			e.printStackTrace();
		}return;
	}
}
