package com.confluence.confluence.modules.kolras.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class KolrasToolTier {
    public static final Tier MONTHLY_BLADE = new Tier() {
        @Override public int getUses() {return 1200;} // durability
        @Override public float getSpeed() {return 10;} // mining speed
        @Override public float getAttackDamageBonus() {return 10;} // attack damage of sword
        @Override public TagKey<Block> getIncorrectBlocksForDrops() {return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;} // Mining level, this means it is on the same level as a diamond tool
        @Override public int getEnchantmentValue() {return 10;} // enchantability
        @Override public Ingredient getRepairIngredient() {return null;} // item used to repair the item in an anvil
    };

    public static void init() {
    }
}
