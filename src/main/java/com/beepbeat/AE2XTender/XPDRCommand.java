package com.beepbeat.AE2XTender;


import appeng.api.AEApi;
import appeng.api.IAppEngApi;
import appeng.api.util.AEItemDefinition;
import appeng.util.item.AEItemStack;
import com.beepbeat.AE2XTender.item.AE2CreativeCell;
import com.beepbeat.AE2XTender.item.ThaumcraftCreativeCell;
import com.beepbeat.AE2XTender.item.VanillaCreativeCell;
import com.beepbeat.AE2XTender.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
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
        if (parameters.length == 0 || parameters[0].equals("help")) {
            player.addChatMessage(new ChatComponentText("Usage: '/xpdr <SetID>'"));
            player.addChatMessage(new ChatComponentText("Available Sets: vanilla, AE tools, AE balls, AE cells, tc"));
        }
        else if (parameters.length >= 1 && parameters[0].toLowerCase().equals("vanilla")) {
            VanillaCreativeCell.createVanillaCell(player);
        }
        else if (parameters.length >= 1 && parameters[0].toLowerCase().equals("test")) {

        }
        else if (parameters.length >= 1 && parameters[0].toLowerCase().equals("ae")) {
            if (parameters.length >= 2 && parameters[1].toLowerCase().equals("tools")) {
                AE2CreativeCell.createToolDisk(player);
            }
            if (parameters.length >= 2 && parameters[1].toLowerCase().equals("balls")) {
                AE2CreativeCell.createBallDisk(player);
            }
            if (parameters.length >= 2 && parameters[1].toLowerCase().equals("cells")) {
                AE2CreativeCell.createCellDisk(player);
            }
        }
        else if (parameters.length >= 1 && parameters[0].toLowerCase().equals("tc")) {
            ThaumcraftCreativeCell.createThaumcraftItemCell(player);
        }
    }

}
