package me.Batsed.WorldTp;

 
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

@SuppressWarnings("unused")
public class SerializableItem
implements Serializable
{
	private static final long serialVersionUID = -2855528738291283052L;
	private int id;
	private int amount;
	private short damage;
	private Byte data;
	private Map<Integer, Integer> enchantments;
	

	@SuppressWarnings("rawtypes")
	private SerializableItem(ItemStack stack)
	{
		this.id = stack.getTypeId();
		this.amount = stack.getAmount();
		this.damage = stack.getDurability();
		
		MaterialData md = stack.getData();
		this.data = (md == null ? null : Byte.valueOf(md.getData()));

		this.enchantments = new HashMap<Integer, Integer>();
		for (Map.Entry entry : stack.getEnchantments().entrySet())
		this.enchantments.put(Integer.valueOf(((Enchantment)entry.getKey()).getId()), (Integer) entry.getValue());
	}
	public ItemStack toItemStack()
	{
		ItemStack stack = new ItemStack(this.id, this.amount, this.damage, this.data);

		if (!this.enchantments.isEmpty()) {
			for (@SuppressWarnings("rawtypes") Map.Entry entry : this.enchantments.entrySet()) {
				stack.addUnsafeEnchantment(Enchantment.getById(((Integer)entry.getKey()).intValue()), ((Integer)entry.getValue()).intValue());
			}
		}

		return stack;
	}

	public static SerializableItem parseSerializableItem(ItemStack stack) {
		if (stack == null) {
			return null;
		}

		return new SerializableItem(stack);
	}
}