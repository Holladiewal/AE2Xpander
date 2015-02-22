package com.beepbeat.AE2XTender.item;


import akka.io.Tcp;
import appeng.api.AEApi;
import com.beepbeat.AE2XTender.utility.ArrayUtil;
import com.beepbeat.AE2XTender.utility.LogHelper;
import com.beepbeat.AE2XTender.utility.MathUtil;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

import static com.beepbeat.AE2XTender.utility.AE2CellPreformatterHelper.setNBTSet;


public class VanillaCreativeCell  {
    public static ItemStack is1 = AEApi.instance().items().itemCellCreative.stack(1);
    public static ItemStack is2 = AEApi.instance().items().itemCellCreative.stack(1);
    public static List<String> blacklist = new ArrayList<String>(){};
    public static List<String> BlockswithMetaData = new ArrayList<String>();


    public static void createVanillaCell(EntityPlayer player) throws Exception {
        BlockswithMetaData.add("minecraft:wool");
        BlockswithMetaData.add(String.valueOf(16));

        blacklist.add("minecraft:powered_comparator");

        short[] id1 = new short[64];
        short[] damage1 = new short[64];

        short[] id2;
        short[] damage2;
        short[][] id = new short[10][64];
        short[][] damage = new short[10][64];

        
        /*id1 = new short[] {1,2,3,4,6,6,6,6,12,13,14,15,17,17,17,17,18,18,18,18,24,30,31,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,35,37,38,39,40,48,79,80,81,82,87,88,89,110,263,264,287,289,295,318,319,331,332,338,344};
        id2 = new short[] {348,352,363,365,367,368,369,370,372,375,384,388,391,392,399,406,2256,2257,2258,2259,2260,2261,2262,2263,2264,2265,2266,2267};

        damage1 = new short[]{0,0,0,0,0,1,2,3,0,0,0,0,0,1,2,3,0,1,2,3,0,0,0,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,};
        damage2 = new short[]{3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};*/


        //System.out.println(Block.blockRegistry.getKeys());
        List<Integer> LBlockIDs = new ArrayList<Integer>();
        for (int i = 0; i < Block.blockRegistry.getKeys().toArray().length; i++) {
            String s = Block.blockRegistry.getKeys().toArray()[i].toString();
            if (s.contains("minecraft:") && !blacklist.contains(s)) {
                LBlockIDs.add(Block.blockRegistry.getIDForObject(Block.blockRegistry.getKeys().toArray()[i]));
            }

        }
        /*DBG//for (int i = 0;i < LBlockNames.size();i++){
            System.out.println(LBlockNames.get(i));
            if (i % 15 == 0) {
                System.out.println();
            }
        }*/
       /* for (int i = 0;i < 64 && i < LBlockIDs.size();i++){
            id[1][i] = (short) Integer.parseInt(String.valueOf(LBlockIDs.get(i)));
            damage[1][i] = (short) 0;
            if (BlockswithMetaData.contains(Block.blockRegistry.getNameForObject(Block.blockRegistry.getObjectById(LBlockIDs.get(i))))){
                i++;
                int pos = ArrayUtil.findPos(BlockswithMetaData,Block.blockRegistry.getNameForObject(Block.blockRegistry.getObjectById(LBlockIDs.get(i))));
                for (int i1 = 0;i1 < Integer.parseInt(BlockswithMetaData.get(pos+1)) && i < 64;i++){
                    id[1][i] = (short) Integer.parseInt(String.valueOf(LBlockIDs.get(i)));
                    damage[1][i] = (short) i1;
                }
            }


        }*/
        for (int j = 0;j*64 < LBlockIDs.size() ;j++) {
            LogHelper.info("j="+j);
            LogHelper.info("LBLockIDs.size()="+LBlockIDs.size());
            for (int i = 0;i < 64 && i < LBlockIDs.size() - ((j+1)*64);i++){
                id[j][i] = (short) Integer.parseInt(String.valueOf(LBlockIDs.get(i)));
                damage[j][i] = (short) 0;
                if (BlockswithMetaData.contains(Block.blockRegistry.getNameForObject(Block.blockRegistry.getObjectById(LBlockIDs.get(i))))){
                    i++;
                    int pos = ArrayUtil.findPos(BlockswithMetaData,Block.blockRegistry.getNameForObject(Block.blockRegistry.getObjectById(LBlockIDs.get(i))));
                    for (int i1 = 0;i1 < Integer.parseInt(BlockswithMetaData.get(pos+1)) && i < 64;i++){
                        id[j][i] = (short) Integer.parseInt(String.valueOf(LBlockIDs.get(i)));
                        damage[j][i] = (short) i1;
                    }
                }


            }

            LogHelper.warn("Created Vanilla Cell " + String.valueOf(j+1)+" added to "+player.getDisplayName() + " with " + id[j].length + "item entries");
            //while(!player.inventory.inventoryChanged){}
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                LogHelper.fatal("Got Error while Sleeping this Thread;Report to Developer immediately!!!");
                //throw(new Exception("Fatal Error"));
            }
            if (player.inventory.hasItemStack(setNBTSet(is1, id[j], damage[j], "Vanilla " + String.valueOf(j + 1)))){
                LogHelper.warn("Inventory of "+player.getDisplayName()+" changed");
            }

        }
        for (int j=0;j < id.length && j < damage.length;j++) {
            player.inventory.addItemStackToInventory(setNBTSet(is1, id[j], damage[j], "Vanilla " + String.valueOf(j + 1)));
        }


    }
}
