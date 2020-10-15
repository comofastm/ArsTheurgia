package team.comofas.arstheurgia.items;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.player.data.EvilManager;
import team.comofas.arstheurgia.registry.ArsItems;


public class FilledWaterskinItem extends Item {
    public FilledWaterskinItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)user;
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (user instanceof PlayerEntity && !((PlayerEntity)user).abilities.creativeMode) {
            stack.decrement(1);
        }

        if (!world.isClient && user instanceof PlayerEntity) {

            PlayerEntity player = (PlayerEntity) user;

            if (world.getTime() - PlayerComponents.RITUALTIME.get(player).getInt("samas") < 1200) {

                EvilManager evilManager = PlayerComponents.EVIL.get(player);

                if (evilManager.getEvil() < 10) {
                    evilManager.setEvil(0);
                } else {
                    evilManager.setEvil(evilManager.getEvil()-10);
                }
                player.sendMessage(new TranslatableText("rituals.remove_evil.text"), true);


            }

        }


        return stack.isEmpty() ? new ItemStack(ArsItems.WATERSKIN) : stack;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

}
