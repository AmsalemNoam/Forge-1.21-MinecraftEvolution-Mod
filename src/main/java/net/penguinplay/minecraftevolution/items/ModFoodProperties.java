package net.penguinplay.minecraftevolution.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties  LIGHT_BERRY = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.8F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 150),0.05F)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 250, 0),0.5F)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0),1)
            .alwaysEdible()
            .build();

    public static final FoodProperties  DARK_BERRY = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.8F)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, 150),0.05F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 0),1)
            .alwaysEdible()
            .build();

}
