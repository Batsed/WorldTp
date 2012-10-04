/*    */ package me.Batsed.WorldTp;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.material.MaterialData;
/*    */ 
/*    */ @SuppressWarnings("unused")
public class SerializableItem
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -2855528738291283052L;
/*    */   private int id;
/*    */   private int amount;
/*    */   private short damage;
/*    */   private Byte data;
/*    */   private Map<Integer, Integer> enchantments;
/*    */ 
/*    */   
@SuppressWarnings("rawtypes")
private SerializableItem(ItemStack stack)
/*    */   {
/* 23 */     this.id = stack.getTypeId();
/* 24 */     this.amount = stack.getAmount();
/* 25 */     this.damage = stack.getDurability();
/*    */ 
/* 27 */     MaterialData md = stack.getData();
/* 28 */     this.data = (md == null ? null : Byte.valueOf(md.getData()));
/*    */ 
/* 30 */     this.enchantments = new HashMap<Integer, Integer>();
/* 31 */     for (Map.Entry entry : stack.getEnchantments().entrySet())
/* 32 */       this.enchantments.put(Integer.valueOf(((Enchantment)entry.getKey()).getId()), (Integer) entry.getValue());
/*    */   }
/*    */ 
/*    */   public ItemStack toItemStack()
/*    */   {
/* 37 */     ItemStack stack = new ItemStack(this.id, this.amount, this.damage, this.data);
/*    */ 
/* 39 */     if (!this.enchantments.isEmpty()) {
/* 40 */       for (@SuppressWarnings("rawtypes") Map.Entry entry : this.enchantments.entrySet()) {
/* 41 */         stack.addUnsafeEnchantment(Enchantment.getById(((Integer)entry.getKey()).intValue()), ((Integer)entry.getValue()).intValue());
/*    */       }
/*    */     }
/*    */ 
/* 45 */     return stack;
/*    */   }
/*    */ 
/*    */   public static SerializableItem parseSerializableItem(ItemStack stack) {
/* 49 */     if (stack == null) {
/* 50 */       return null;
/*    */     }
/*    */ 
/* 53 */     return new SerializableItem(stack);
/*    */   }
/*    */ }

/* Location:           C:\Users\Batsed\AppData\Local\Temp\Rar$DRa0.732\
 * Qualified Name:     com.garbagemule.MobArena.util.inventory.SerializableItem
 * JD-Core Version:    0.6.0
 */