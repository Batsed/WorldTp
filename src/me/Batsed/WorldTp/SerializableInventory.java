package me.Batsed.WorldTp;


import java.io.Serializable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class SerializableInventory
implements Serializable
{
	private static final long serialVersionUID = 5816986232508437560L;
	private SerializableItem[] items;
	private SerializableItem[] armor;
	
	public SerializableInventory(PlayerInventory inv)
	{
		ItemStack[] stackItems = inv.getContents();
		ItemStack[] stackArmor = inv.getArmorContents();

		this.items = new SerializableItem[stackItems.length];
		this.armor = new SerializableItem[stackArmor.length];

		for (int i = 0; i < stackItems.length; i++) {
			this.items[i] = SerializableItem.parseSerializableItem(stackItems[i]);
		}

		for (int i = 0; i < stackArmor.length; i++)
			this.armor[i] = SerializableItem.parseSerializableItem(stackArmor[i]);
	}
 
	public SerializableInventory(Inventory inv)
	{
		ItemStack[] stacks = inv.getContents();
		this.items = new SerializableItem[stacks.length];
 
		for (int i = 0; i < stacks.length; i++)
		this.items[i] = SerializableItem.parseSerializableItem(stacks[i]);
  }

	public ItemStack[] getItems()
	{
		ItemStack[] result = new ItemStack[this.items.length];
		for (int i = 0; i < this.items.length; i++) {
			result[i] = (this.items[i] == null ? null : this.items[i].toItemStack());
		}
		return result;
	}

	public ItemStack[] getArmor() {
		ItemStack[] result = new ItemStack[this.armor.length];
		for (int i = 0; i < this.armor.length; i++) {
			result[i] = (this.armor[i] == null ? null : this.armor[i].toItemStack());
		}
		return result;
	}
 
	public static void loadContents(Player p, SerializableInventory inv) {
		if (inv == null) {
			return;
		}
		p.getInventory().setContents(inv.getItems());
		p.getInventory().setArmorContents(inv.getArmor());
	}
 
	public static void loadContents(Inventory chestInv, SerializableInventory inv) {
		if (inv == null) {
			return;
		}
		chestInv.setContents(inv.getItems());
	}
}