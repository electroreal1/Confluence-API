package com.confluence.confluence.modules.kolras.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;
import java.util.Map;

public class KolrasToolTiers {
    private static final Map<ResourceLocation, Tier> REGISTERED = new LinkedHashMap<>();
    public static void register(ResourceLocation id, Tier tier) {
        REGISTERED.put(id, tier);
    }

    public static Tier get(ResourceLocation id) {
        return REGISTERED.get(id);
    }

    public static Map<ResourceLocation, Tier> all() {
        return REGISTERED;
    }

    public KolrasToolTiers() {
    }

    public static final ResourceLocation MONTHLY_BLADE_ID = ResourceLocation.fromNamespaceAndPath("kolras", "monthly_blade");
    public static final Tier MONTHLY_BLADE = new Tier() {

        @Override
        public int getUses() {
            return 0;
        }

        @Override
        public float getSpeed() {
            return 10.0f;
        }

        @Override
        public float getAttackDamageBonus() {
            return 20;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return null;
        }

        @Override
        public int getEnchantmentValue() {
            return 0;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.BEDROCK);
        }
    };

    public static void init() {
        register(MONTHLY_BLADE_ID, MONTHLY_BLADE);
    }

}
