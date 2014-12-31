package com.beepbeat.AE2XTender.init;

import com.beepbeat.AE2XTender.handler.ConfigurationHandler;
import com.beepbeat.AE2XTender.item.AE2CreativeCell;
import com.beepbeat.AE2XTender.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public void init() {
        Item item1;
        item1 = new AE2CreativeCell().getItem()
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabMisc)
                .setUnlocalizedName("Item")
                .setContainerItem(AE2CreativeCell.getItem());
        ItemStack itemStack1 = new ItemStack((item1));

        //NBTHelper.initNBTTagCompound(itemStack1);
        itemStack1=AE2CreativeCell.SetThaumcraft(itemStack1);




        GameRegistry.registerItem(itemStack1.getItem(),"Item");
    }
}
