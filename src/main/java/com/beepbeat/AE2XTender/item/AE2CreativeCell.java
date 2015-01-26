package com.beepbeat.AE2XTender.item;


import appeng.api.AEApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

import static net.minecraft.item.Item.getIdFromItem;
import static com.beepbeat.AE2XTender.utility.AE2CellPreformatterHelper.setNBTSet;

public class AE2CreativeCell  {

    public static void createToolDisk(EntityPlayer player) {
        ItemStack isTool = AEApi.instance().items().itemCellCreative.stack(1);
        short[] id = new short[21];
        short[] damage = new short[21];

        id[0] = (short) getIdFromItem(AEApi.instance().items().itemCertusQuartzAxe.item());
        id[1] = (short) getIdFromItem(AEApi.instance().items().itemCertusQuartzHoe.item());
        id[2] = (short) getIdFromItem(AEApi.instance().items().itemCertusQuartzShovel.item());
        id[3] = (short) getIdFromItem(AEApi.instance().items().itemCertusQuartzPick.item());
        id[4] = (short) getIdFromItem(AEApi.instance().items().itemCertusQuartzSword.item());
        id[5] = (short) getIdFromItem(AEApi.instance().items().itemCertusQuartzWrench.item());
        id[6] = (short) getIdFromItem(AEApi.instance().items().itemCertusQuartzKnife.item());

        id[7] = (short) getIdFromItem(AEApi.instance().items().itemNetherQuartzAxe.item());
        id[8] = (short) getIdFromItem(AEApi.instance().items().itemNetherQuartzHoe.item());
        id[9] = (short) getIdFromItem(AEApi.instance().items().itemNetherQuartzShovel.item());
        id[10] = (short) getIdFromItem(AEApi.instance().items().itemNetherQuartzPick.item());
        id[11] = (short) getIdFromItem(AEApi.instance().items().itemNetherQuartzSword.item());
        id[12] = (short) getIdFromItem(AEApi.instance().items().itemNetherQuartzWrench.item());
        id[13] = (short) getIdFromItem(AEApi.instance().items().itemNetherQuartzKnife.item());

        id[14] = (short) getIdFromItem(AEApi.instance().items().itemEntropyManipulator.item());
        id[15] = (short) getIdFromItem(AEApi.instance().items().itemWirelessTerminal.item());
        id[16] = (short) getIdFromItem(AEApi.instance().items().itemBiometricCard.item());
        id[17] = (short) getIdFromItem(AEApi.instance().items().itemChargedStaff.item());
        id[18] = (short) getIdFromItem(AEApi.instance().items().itemMassCannon.item());
        id[19] = (short) getIdFromItem(AEApi.instance().items().itemMemoryCard.item());
        id[20] = (short) getIdFromItem(AEApi.instance().items().itemNetworkTool.item());


        player.inventory.addItemStackToInventory(setNBTSet(isTool,id,damage,"AE2 Tools"));

    }
    public static void createCellDisk(EntityPlayer player) {

        ItemStack isCell = AEApi.instance().items().itemCellCreative.stack(1);
        short[] id = new short[10];
        short[] damage = new short[10];

        id[0] = (short) getIdFromItem(AEApi.instance().items().itemPortableCell.item());
        id[1] = (short) getIdFromItem(AEApi.instance().items().itemCellCreative.item());
        id[2] = (short) getIdFromItem(AEApi.instance().items().itemViewCell.item());
        id[3] = (short) getIdFromItem(AEApi.instance().items().itemCell1k.item());
        id[4] = (short) getIdFromItem(AEApi.instance().items().itemCell4k.item());
        id[5] = (short) getIdFromItem(AEApi.instance().items().itemCell16k.item());
        id[6] = (short) getIdFromItem(AEApi.instance().items().itemCell64k.item());
        id[7] = (short) getIdFromItem(AEApi.instance().items().itemSpatialCell2.item());
        id[8] = (short) getIdFromItem(AEApi.instance().items().itemSpatialCell16.item());
        id[9] = (short) getIdFromItem(AEApi.instance().items().itemSpatialCell128.item());

        player.inventory.addItemStackToInventory(setNBTSet(isCell, id, damage, "AE2 Storage Cells"));
    }
    public static void createBallDisk(EntityPlayer player) {

        try {
            ItemStack isBall = AEApi.instance().items().itemCellCreative.stack(1);
            player.addChatMessage(new ChatComponentText("Got a cell!"));

            short[] id = new short[34];
            short[] damage = new short[34];
            /*player.addChatMessage(new ChatComponentText("trying to get all paintballs..."));
            ItemStack[] itemStack = AEApi.instance().items().itemPaintBall.allStacks(1);
            player.addChatMessage(new ChatComponentText("got all paintballs!"));
            player.addChatMessage(new ChatComponentText("" + itemStack.length));
            player.addChatMessage(new ChatComponentText(itemStack.toString()));*/

        for(int i = 0;i<id.length;i++) { id[i] = (short) 4133;}
        for(int i = 0;i<17;i++) {damage[i] = (short) i;}
        for(int i = 0;i<17;i++) {damage[i+17] = (short) (i + 16 + 4);}
        player.inventory.addItemStackToInventory(setNBTSet(isBall, id, damage, "AE2 Paint Balls"));
        } catch (Exception e) {
            player.addChatMessage(new ChatComponentText("Looks like Paint Balls and/or Creative Cells are disabled"));
        }


    }



}
