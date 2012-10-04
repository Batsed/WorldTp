/*    */ package me.Batsed.WorldTp;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class InventoryUtils
/*    */ {
/*    */   public static SerializableItem parseItemStack(ItemStack stack)
/*    */   {
/* 11 */     return SerializableItem.parseSerializableItem(stack);
/*    */   }
/*    */ 
/*    */   public static SerializableItem[] parseItemStacks(ItemStack[] stacks) {
/* 15 */     SerializableItem[] items = new SerializableItem[stacks.length];
/*    */ 
/* 17 */     for (int i = 0; i < items.length; i++) {
/* 18 */       items[i] = parseItemStack(stacks[i]);
/*    */     }
/*    */ 
/* 21 */     return items;
/*    */   }
/*    */ 
/*    */   public static List<ItemStack> extractAll(int id, List<ItemStack> items) {
/* 25 */     List<ItemStack> result = new ArrayList<ItemStack>();
/*    */ 
/* 27 */     for (ItemStack stack : items) {
/* 28 */       if (stack.getTypeId() == id) {
/* 29 */         result.add(stack);
/*    */       }
/*    */     }
/*    */ 
/* 33 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\Users\Batsed\AppData\Local\Temp\Rar$DRa0.732\
 * Qualified Name:     com.garbagemule.MobArena.util.inventory.InventoryUtils
 * JD-Core Version:    0.6.0
 */