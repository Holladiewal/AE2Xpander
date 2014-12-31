package com.beepbeat.AE2XTender;


import com.beepbeat.AE2XTender.item.AE2CreativeCell;
import com.beepbeat.AE2XTender.utility.LogHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;

public class XPDRCommand extends CommandBase
{

    @Override
    public String getCommandName() {
        return "xpdr";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "For help see:\n/xpdr help";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] parameters) {
        EntityPlayer player = (EntityPlayer) sender;

                if (parameters.length == 0) {player.addChatMessage(new ChatComponentText("Usage: '/xpdr getSet <SetID>'"));}

                 if (parameters[0].equals("getSet")) {
                    if (parameters.length >= 2){
                        if (parameters[1].equals("tc") && parameters[2] == null) {
                            ItemStack ItemsToDrop = AE2CreativeCell.SetThaumcraft(new ItemStack(new AE2CreativeCell()));
                            LogHelper.info("NBT after Command:" + ItemsToDrop.getTagCompound().toString());

                            EntityItem dropItem = new EntityItem(player.getEntityWorld(), player.posX, player.posY, player.posZ, ItemsToDrop);
                            dropItem.delayBeforeCanPickup = 0;
                            player.getEntityWorld().spawnEntityInWorld(dropItem);

                            //player.dropItem(ItemsToDrop.getItem().setUnlocalizedName("Creative Cell:tc").setMaxStackSize(1), 1);
                            if (parameters[2] != null) {
                                player.addChatMessage(new ChatComponentText("Creating Set 'tc'"));
                                ItemStack tmpStack = player.inventory.getStackInSlot(Integer.parseInt(parameters[2]));
                                player.inventory.addItemStackToInventory(AE2CreativeCell.SetThaumcraft(tmpStack));
                            }


                        }

                    }
                else {player.addChatMessage(new ChatComponentText("Missing Arguments"));}
                }
                else if (sender instanceof EntityPlayer) {
                     player.addChatMessage(new ChatComponentText("Usage: '/xpdr getSet <SetID>'"));


                 }



    }
}
