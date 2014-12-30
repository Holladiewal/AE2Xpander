package com.beepbeat.AE2XTender.creativetab;

import com.beepbeat.AE2XTender.init.ModItems;
import com.beepbeat.AE2XTender.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabLMRB
{
    public static final CreativeTabs AE2XTNDR_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {

        @Override
        public Item getTabIconItem() {
            return null;
        }
    };
}
