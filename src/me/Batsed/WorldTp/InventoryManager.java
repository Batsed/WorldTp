package me.Batsed.WorldTp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
 
public class InventoryManager
{
	
	Command cmd;
	String[] args;
	Player p;
	
	public InventoryManager(Command cmd, String[] args, Player p) {
		this.cmd = cmd;
		this.args = args;
		this.p = p;
	}
				
private static String EXT = ".inv";
/*     */   private File dir;
/*     */   private Map<Player, ItemStack[]> items;
/*     */   private Map<Player, ItemStack[]> armor;
/*     */ 
/*     */   public InventoryManager(WorldTp arena)
/*     */   {
/*  21 */     this.dir = new File(WorldTp.getPlugin().getDataFolder(), "inventories");
/*  22 */     this.dir.mkdir();
/*     */ 
/*  24 */     this.items = new HashMap<Player, ItemStack[]>();
/*  25 */     this.armor = new HashMap<Player, ItemStack[]>();
/*     */   }
/*     */ 
/*     */   public boolean storeInventory(Player p)
/*     */   {
/*  34 */     if ((this.items.containsKey(p)) && (this.armor.containsKey(p))) {
/*  35 */       return false;
/*     */     }
/*     */ 
/*  39 */     PlayerInventory inv = p.getInventory();
/*  40 */     ItemStack[] memItems = inv.getContents();
/*  41 */     ItemStack[] memArmor = inv.getArmorContents();
/*  42 */     this.items.put(p, memItems);
/*  43 */     this.armor.put(p, memArmor);
/*     */ 
/*  46 */     saveToFile(p);
/*  47 */     clearInventory(p);
/*  48 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean restoreInventory(Player p)
/*     */   {
/*  59 */     ItemStack[] memItems = (ItemStack[])this.items.remove(p);
/*  60 */     ItemStack[] memArmor = (ItemStack[])this.armor.remove(p);
/*     */ 
/*  63 */     if ((memItems != null) && (memArmor != null)) {
/*  64 */       PlayerInventory inv = p.getInventory();
/*     */ 
/*  66 */       inv.setContents(memItems);
/*  67 */       inv.setArmorContents(memArmor);
/*     */ 
/*  69 */       new File(this.dir, p.getName() + EXT).delete();
/*     */ 
/*  71 */       return true;
/*     */     }
/*     */ 
/*  75 */     return loadFromFile(p);
/*     */   }
/*     */ 
/*     */   public boolean clearInventory(Player p)
/*     */   {
/*  83 */     PlayerInventory inv = p.getInventory();
/*  84 */     inv.clear();
/*  85 */     inv.setHelmet(null);
/*  86 */     inv.setChestplate(null);
/*  87 */     inv.setLeggings(null);
/*  88 */     inv.setBoots(null);
			return true;
/*     */   }
/*     */ 
/*     */   public boolean saveToFile(Player p) {
/*  92 */     File file = new File(this.dir, p.getName() + EXT);
/*  95 */     if (file.exists()) {
/*  96 */       return true;
/*     */     }
/*     */     try
/*     */     {
/* 100 */       SerializableInventory inv = new SerializableInventory(p.getInventory());
/*     */ 
/* 102 */       FileOutputStream fos = new FileOutputStream(file);
/* 103 */       ObjectOutputStream oos = new ObjectOutputStream(fos);
/*     */ 
/* 105 */       oos.writeObject(inv);
/* 106 */       oos.close();
/*     */ 
/* 108 */       return clearInventory(p);
/*     */     }
/*     */     catch (Exception e) {
/* 111 */       e.printStackTrace();
/* 112 */     }return false;
/*     */   }
/*     */ 
/*     */   public boolean loadFromFile(Player p)
/*     */   {
/* 117 */     File file = new File(this.dir, p.getName() + EXT);
/*     */ 
/* 120 */     if (!file.exists()) {
/* 121 */       return true;
/*     */     }
/*     */     try
/*     */     {
/* 125 */       FileInputStream fis = new FileInputStream(file);
/* 126 */       ObjectInputStream ois = new ObjectInputStream(fis);
/*     */ 
/* 128 */       Object o = ois.readObject();
/* 129 */       ois.close();
/*     */ 
/* 131 */       SerializableInventory inv = (SerializableInventory)o;
/* 132 */       SerializableInventory.loadContents(p, inv);
/*     */ 
/* 134 */       file.delete();
/*     */ 
/* 136 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/* 139 */       e.printStackTrace();
/* 140 */     }return false;
/*     */   }
/*     */ 
/*     */   public static boolean hasEmptyInventory(Player p)
/*     */   {
/* 145 */     ItemStack[] inventory = p.getInventory().getContents();
/* 146 */     ItemStack[] armor = p.getInventory().getArmorContents();
/*     */ 
/* 149 */     for (ItemStack stack : inventory) {
/* 150 */       if (stack != null) {
/* 151 */         return false;
/*     */       }
/*     */     }
/*     */ 
/* 155 */     for (ItemStack stack : armor) {
/* 156 */       if (stack.getTypeId() != 0) {
/* 157 */         return false;
/*     */       }
/*     */     }
/* 160 */     return true;
/*     */   }
/*     */ 
/*     */   public static boolean restoreFromFile(WorldTp plugin, Player p)
/*     */   {
/* 170 */     File dir = new File(plugin.getDataFolder(), "inventories");
/*     */ 
/* 172 */     File file = new File(dir, p.getName() + EXT);
/*     */ 
/* 175 */     if (!file.exists()) {
/* 176 */       return false;
/*     */     }
/*     */     try
/*     */     {
/* 180 */       FileInputStream fis = new FileInputStream(file);
/* 181 */       ObjectInputStream ois = new ObjectInputStream(fis);
/*     */ 
/* 183 */       Object o = ois.readObject();
/* 184 */       ois.close();
/*     */ 
/* 186 */       SerializableInventory inv = (SerializableInventory)o;
/* 187 */       SerializableInventory.loadContents(p, inv);
/*     */ 
/* 189 */       file.delete();
/*     */ 
/* 191 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/* 194 */       e.printStackTrace();
/* 195 */     }return false;
/*     */   }
/*     */ }

/* Location:           C:\Users\Batsed\AppData\Local\Temp\Rar$DRa0.732\
 * Qualified Name:     com.garbagemule.MobArena.util.inventory.InventoryManager
 * JD-Core Version:    0.6.0
 */