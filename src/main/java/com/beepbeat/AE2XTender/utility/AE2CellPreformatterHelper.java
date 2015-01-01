package com.beepbeat.AE2XTender.utility;


import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class AE2CellPreformatterHelper {

    public static ItemStack setNBTSet(ItemStack itemStack, short[] id, short[] damage, String name) {
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagCompound list = new NBTTagCompound();
        NBTTagCompound display = new NBTTagCompound();


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
            display.setString("Name", name);

            tag.setTag("list", list);
            tag.setInteger("RepairCost",2);
            tag.setTag("display",display);
            itemStack.setTagCompound(tag);


        }
        return itemStack;
    }
}
