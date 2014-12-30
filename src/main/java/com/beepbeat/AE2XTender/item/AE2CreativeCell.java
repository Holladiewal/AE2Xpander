package com.beepbeat.AE2XTender.item;



import appeng.items.storage.ItemCreativeStorageCell;

import com.beepbeat.AE2XTender.utility.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class AE2CreativeCell extends Item {
    //ItemCreativeStorageCell CreCell = new ItemCreativeStorageCell();




   public static Item CreCellItem = new ItemCreativeStorageCell();
   //public ItemStack CreCellItemStack = new ItemStack(CreCellItem);
   public static Item getItem(){ return CreCellItem;}
   public static ItemStack getCreCellItemStack(){return new ItemStack(new ItemCreativeStorageCell());}


   public static ItemStack SetThaumcraft(ItemStack itemstack) {

       /*short[] id = {4157, 4157, 4175, 4175};
       short[] damage = {0, 1, 2, 16};*/
       short[] id = new short[64];
       short[] damage = new short[64];
       id[0] = 4157; damage[0] = 0;
       id[1] = 4157; damage[1] = 1;
       id[2] = 4157; damage[2] = 2;
       id[3] = 4157; damage[3] = 16;

       return setNBTSet(itemstack, id, damage);

    }

   public static ItemStack setNBTSet(ItemStack itemStack, short[] id, short[] damage) {
       NBTTagCompound tag = new NBTTagCompound();
       NBTTagCompound list = new NBTTagCompound();


       for(int i = 0;(i <= 62) && (i < id.length);i++) {
           if (id[i] != 0) {
               NBTTagCompound numbered = new NBTTagCompound();
               numbered.setByte("Count", (byte) 1);
               numbered.setShort("Damage", damage[i]);
               numbered.setShort("id", id[i]);
               list.setTag("#" + i, numbered);
           }
           else {NBTTagCompound numbered = new NBTTagCompound(); list.setTag("#" + i, numbered);}


       }
       tag.setTag("list", list);
       /*NBTTagCompound tagfinal  = new NBTTagCompound();
       /tagfinal.setTag("tag", tag);*/
       itemStack.setTagCompound(tag);
       itemStack.getItem().setCreativeTab(CreativeTabs.tabMisc).setMaxStackSize(1);
       LogHelper.info(itemStack.getTagCompound().toString());

       return itemStack;



   }

}
