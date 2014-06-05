package net.quetzi.bluepower.items;

import net.minecraft.item.ItemAxe;
import net.quetzi.bluepower.init.CustomTabs;
import net.quetzi.bluepower.references.Refs;

public class ItemGemAxe extends ItemAxe {
    public ItemGemAxe(ToolMaterial material, String name) {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CustomTabs.tabBluePowerTools);
        this.setTextureName(Refs.MODID + ":" + name);
    }

}