package com.beepbeat.AE2XTender;

import appeng.api.config.FuzzyMode;
import appeng.api.implementations.items.IStorageCell;
import appeng.api.implementations.tiles.IChestOrDrive;
import appeng.api.storage.*;
import appeng.api.storage.data.IAEItemStack;
import appeng.core.features.AEFeature;
import appeng.items.AEBaseItem;
import appeng.items.contents.CellConfig;
import appeng.items.storage.ItemCreativeStorageCell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.EnumSet;


public  class ThaumCraftCell extends AEBaseItem implements ICellWorkbenchItem {
    ItemStack is = new ItemStack(new ItemCreativeStorageCell());
    //ItemStack is2 = new ItemStack(new ThaumCraftCell());

    public ThaumCraftCell() {
        super( ItemCreativeStorageCell.class );
        this.setFeature( EnumSet.of( AEFeature.StorageCells, AEFeature.Creative ) );
        this.setMaxStackSize( 1 );


    }

    @Override
    public boolean isEditable(ItemStack is)
    {
        return true;
    }

    @Override
    public IInventory getUpgradesInventory(ItemStack is)
    {
        return null;
    }

    @Override
    public IInventory getConfigInventory(ItemStack is)
    {
        return new CellConfig( is );
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack is)
    {
        return FuzzyMode.IGNORE_ALL;
    }

    @Override
    public void setFuzzyMode(ItemStack is, FuzzyMode fzMode)
    {

    }
}
