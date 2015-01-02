package com.beepbeat.AE2XTender;


import com.beepbeat.AE2XTender.item.AE2CreativeCell;

import com.beepbeat.AE2XTender.proxy.IProxy;
import com.beepbeat.AE2XTender.reference.Reference;
import com.beepbeat.AE2XTender.utility.LogHelper;
import com.beepbeat.AE2XTender.utility.NBTHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

import static cpw.mods.fml.common.Mod.EventHandler;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class AE2XTender
{
    public static Item item1;

    @Mod.Instance(Reference.MOD_ID)
    public static AE2XTender instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {/*
        item1 = new AE2CreativeCell().getItem()
                .setMaxStackSize(64)
                .setCreativeTab(CreativeTabs.tabMisc)
                .setUnlocalizedName("Item")
                .setContainerItem(AE2CreativeCell.getItem());
        ItemStack itemStack1 = new ItemStack((item1));

        //NBTHelper.initNBTTagCompound(itemStack1);
        itemStack1=AE2CreativeCell.SetThaumcraft(itemStack1);*/





        proxy.registerKeyBindings();

        //GameRegistry.registerItem(itemStack1.getItem(),"Item");

        //ModItems.init();

        //ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {


        LogHelper.info("Initialization Complete!");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete!");
    }

    @EventHandler
    public void ServerStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new com.beepbeat.AE2XTender.XPDRCommand());
    }

    @EventHandler
    public void firstStart(FMLServerStartedEvent event)
    {

    }

}
