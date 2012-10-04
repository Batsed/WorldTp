/*    */ package me.Batsed.WorldTp;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ public class SerializableInventory
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 5816986232508437560L;
/*    */   private SerializableItem[] items;
/*    */   private SerializableItem[] armor;
/*    */ 
/*    */   public SerializableInventory(PlayerInventory inv)
/*    */   {
/* 17 */     ItemStack[] stackItems = inv.getContents();
/* 18 */     ItemStack[] stackArmor = inv.getArmorContents();
/*    */ 
/* 20 */     this.items = new SerializableItem[stackItems.length];
/* 21 */     this.armor = new SerializableItem[stackArmor.length];
/*    */ 
/* 23 */     for (int i = 0; i < stackItems.length; i++) {
/* 24 */       this.items[i] = SerializableItem.parseSerializableItem(stackItems[i]);
/*    */     }
/*    */ 
/* 27 */     for (int i = 0; i < stackArmor.length; i++)
/* 28 */       this.armor[i] = SerializableItem.parseSerializableItem(stackArmor[i]);
/*    */   }
/*    */ 
/*    */   public SerializableInventory(Inventory inv)
/*    */   {
/* 33 */     ItemStack[] stacks = inv.getContents();
/* 34 */     this.items = new SerializableItem[stacks.length];
/*    */ 
/* 36 */     for (int i = 0; i < stacks.length; i++)
/* 37 */       this.items[i] = SerializableItem.parseSerializableItem(stacks[i]);
/*    */   }
/*    */ 
/*    */   public ItemStack[] getItems()
/*    */   {
/* 42 */     ItemStack[] result = new ItemStack[this.items.length];
/* 43 */     for (int i = 0; i < this.items.length; i++) {
/* 44 */       result[i] = (this.items[i] == null ? null : this.items[i].toItemStack());
/*    */     }
/* 46 */     return result;
/*    */   }
/*    */ 
/*    */   public ItemStack[] getArmor() {
/* 50 */     ItemStack[] result = new ItemStack[this.armor.length];
/* 51 */     for (int i = 0; i < this.armor.length; i++) {
/* 52 */       result[i] = (this.armor[i] == null ? null : this.armor[i].toItemStack());
/*    */     }
/* 54 */     return result;
/*    */   }
/*    */ 
/*    */   public static void loadContents(Player p, SerializableInventory inv) {
/* 58 */     if (inv == null) {
/* 59 */       return;
/*    */     }
/*    */ 
/* 62 */     p.getInventory().setContents(inv.getItems());
/* 63 */     p.getInventory().setArmorContents(inv.getArmor());
/*    */   }
/*    */ 
/*    */   public static void loadContents(Inventory chestInv, SerializableInventory inv) {
/* 67 */     if (inv == null) {
/* 68 */       return;
/*    */     }
/*    */ 
/* 71 */     chestInv.setContents(inv.getItems());
/*    */   }
/*    */ }

/* Location:           C:\Users\Batsed\AppData\Local\Temp\Rar$DRa0.732\
 * Qualified Name:     com.garbagemule.MobArena.util.inventory.SerializableInventory
 * JD-Core Version:    0.6.0
 */