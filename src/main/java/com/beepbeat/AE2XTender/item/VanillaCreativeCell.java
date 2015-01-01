package com.beepbeat.AE2XTender.item;


import appeng.api.AEApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.beepbeat.AE2XTender.utility.AE2CellPreformatterHelper.setNBTSet;


public class VanillaCreativeCell  {
    public static ItemStack is1 = AEApi.instance().items().itemCellCreative.stack(1);
    public static ItemStack is2 = AEApi.instance().items().itemCellCreative.stack(1);


    public static void createVanillaCell(EntityPlayer player)
    {
        short[] id1;
        short[] damage1;

        short[] id2;
        short[] damage2;

        
        id1 = new short[] {1,2,3,4,6,6,6,6,12,13,14,15,17,17,17,17,18,18,18,18,24,30,31,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,37,38,39,40,48,79,80,81,82,87,88,89,110,263,264,287,289,295,318,319,331,332,338,344};
        id2 = new short[] {348,352,363,365,367,368,369,370,372,375,384,388,391,392,399,406,2256,2257,2258,2259,2260,2261,2262,2263,2264,2265,2266,2267};

        damage1 = new short[]{0,0,0,0,0,1,2,3,0,0,0,0,0,1,2,3,0,1,2,3,0,0,0,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,};
        damage2 = new short[]{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        player.inventory.addItemStackToInventory(setNBTSet(is1, id1, damage1, "Vanilla 1"));
        player.inventory.addItemStackToInventory(setNBTSet(is2, id2, damage2, "Vanilla 2"));

    }


}
