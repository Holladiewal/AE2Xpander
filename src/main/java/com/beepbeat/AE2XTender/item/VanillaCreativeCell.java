package com.beepbeat.AE2XTender.item;


import appeng.api.config.FuzzyMode;
import appeng.api.implementations.items.IStorageCell;
import appeng.api.storage.data.IAEItemStack;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class VanillaCreativeCell  {

    public static ItemStack createVanillaCell(ItemStack is)
    {
        short[] id = new short[64];
        short[] damage = new short[64];
        id[0] = 1; damage[0] = 0;
        return setNBTSet(is, id, damage);
    }

    public static ItemStack setNBTSet(ItemStack itemStack, short[] id, short[] damage) {
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagCompound list = new NBTTagCompound();


        for (int i = 0; (i <= 62) && (i < id.length); i++) {
            if (id[i] != 0) {
                NBTTagCompound numbered = new NBTTagCompound();
                numbered.setByte("Count", (byte) 1);
                numbered.setShort("Damage", damage[i]);
                numbered.setShort("id", id[i]);
                list.setTag("#" + i, numbered);
            } else {
                NBTTagCompound numbered = new NBTTagCompound();
                list.setTag("#" + i, numbered);
            }
            tag.setTag("list", list);
            itemStack.setTagCompound(tag);


        }
        return itemStack;
    }
}
