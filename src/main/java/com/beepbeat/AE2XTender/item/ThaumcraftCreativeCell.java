package com.beepbeat.AE2XTender.item;


import appeng.api.AEApi;
import com.beepbeat.AE2XTender.utility.AE2CellPreformatterHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ItemApi;

import static net.minecraft.item.Item.*;


public class ThaumcraftCreativeCell {
    static ItemStack Cell = AEApi.instance().items().itemCellCreative.stack(1);

    public static void createThaumcraftItemCell(EntityPlayer player) {
        short[] id = new short[64];
        short[] damage = new short[64];

        id[0]  = (short) getIdFromItem(ItemApi.getItem("itemBathSalts", 0).getItem());
        id[1]  = (short) getIdFromItem(ItemApi.getItem("itemThaumometer", 0).getItem());
        id[2]  = (short) getIdFromItem(ItemApi.getItem("itemBottleTaint", 0).getItem());
        id[3]  = (short) getIdFromItem(ItemApi.getItem("itemBucketDeath", 0).getItem());
        id[4]  = (short) getIdFromItem(ItemApi.getItem("itemBucketPure", 0).getItem());
      //id[5]  = (short) getIdFromItem(ItemApi.getItem("itemCrystalEssence", 0).getItem());
        id[5]  = (short) getIdFromItem(ItemApi.getItem("itemInkwell", 0).getItem());
        id[6]  = (short) getIdFromItem(ItemApi.getItem("itemLootbag", 0).getItem());
        id[6]  = (short) getIdFromItem(ItemApi.getItem("itemManaBean", 0).getItem());
        id[7]  = (short) getIdFromItem(ItemApi.getItem("itemNugget", 0).getItem());
      //id[8]  = (short) getIdFromItem(ItemApi.getItem("itemNuggetEdible", 0).getItem());
        id[8]  = (short) getIdFromItem(ItemApi.getItem("itemTripleMeatTreat", 0).getItem());
        id[9]  = (short) getIdFromItem(ItemApi.getItem("itemWispEssence", 0).getItem());
        id[10] = (short) getIdFromItem(ItemApi.getItem("itemZombieBrain", 0).getItem());
        id[11] = (short) getIdFromItem(ItemApi.getItem("itemThaumonomicon", 0).getItem());
        id[12] = (short) getIdFromItem(ItemApi.getItem("itemShard", 0).getItem());
        id[13] = (short) getIdFromItem(ItemApi.getItem("itemGoggles", 0).getItem());
        id[14] = (short) getIdFromItem(ItemApi.getItem("itemGolemBell", 0).getItem());
        id[15] = (short) getIdFromItem(ItemApi.getItem("itemGolemCore", 0).getItem());
        id[16] = (short) getIdFromItem(ItemApi.getItem("itemGolemUpgrade", 0).getItem());
        id[17] = (short) getIdFromItem(ItemApi.getItem("itemGolemDecoration", 0).getItem());
      //id[18] = (short) getIdFromItem(ItemApi.getItem("itemFlyingCarpet", 0).getItem());
        id[18] = (short) getIdFromItem(ItemApi.getItem("itemResource", 0).getItem());
        id[19] = (short) getIdFromItem(ItemApi.getItem("itemHandMirror", 0).getItem());




        player.inventory.addItemStackToInventory(AE2CellPreformatterHelper.setNBTSet(Cell, id, damage, "Thaumcraft Item and Resources(?)" ));



    }



}
