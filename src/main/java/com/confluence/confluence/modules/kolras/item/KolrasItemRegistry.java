package com.confluence.confluence.modules.kolras.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KolrasItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "kolras");

    public static final RegistryObject<Item> DECEMBER_SWORD = ITEMS.register("december_sword",
            () -> new SwordItem(KolrasToolTier.MONTHLY_BLADE, new Item.Properties()
                    .stacksTo(1).fireResistant().rarity(Rarity.EPIC)));


}
