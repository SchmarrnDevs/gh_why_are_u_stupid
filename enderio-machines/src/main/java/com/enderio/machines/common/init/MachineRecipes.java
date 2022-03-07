package com.enderio.machines.common.init;

import com.enderio.machines.EIOMachines;
import com.enderio.machines.common.recipe.AlloySmeltingRecipe;
import com.enderio.machines.common.recipe.EnchanterRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MachineRecipes {

    public static void register(IEventBus bus) {
        Serializer.register(bus);
    }

    public static class Serializer {
        private Serializer() {}

        public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER_REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, EIOMachines.MODID);

        public static final RegistryObject<EnchanterRecipe.Serializer> ENCHANTING = RECIPE_SERIALIZER_REGISTRY.register("enchanting", EnchanterRecipe.Serializer::new);
        public static final RegistryObject<AlloySmeltingRecipe.Serializer> ALLOY_SMELTING = RECIPE_SERIALIZER_REGISTRY.register("alloy_smelting", AlloySmeltingRecipe.Serializer::new);

        public static void register(IEventBus bus) {
            RECIPE_SERIALIZER_REGISTRY.register(bus);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Types {
        private Types() {}

        public static RecipeType<EnchanterRecipe> ENCHANTING;
        public static RecipeType<AlloySmeltingRecipe> ALLOY_SMELTING;

        @SubscribeEvent
        public static void onRecipeSerializerRegistry(RegistryEvent.Register<RecipeSerializer<?>> event) {
            ENCHANTING = RecipeType.register(EIOMachines.MODID + ":enchanting");
            ALLOY_SMELTING = RecipeType.register(EIOMachines.MODID + ":alloy_smelting");
        }
    }
}
