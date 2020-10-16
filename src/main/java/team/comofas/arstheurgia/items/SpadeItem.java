package team.comofas.arstheurgia.items;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.comofas.arstheurgia.blocks.FallingArcheologicalBlock;
import team.comofas.arstheurgia.registry.ArsItems;

public class SpadeItem extends ShovelItem {

    public SpadeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient) {
            PlayerEntity player = (PlayerEntity) miner;
            stack.damage(1, player.getRandom(), (ServerPlayerEntity) player);
            if (FallingArcheologicalBlock.isNatural(state)) {
                if (player.getRandom().nextDouble()>0.3) {
                    player.inventory.insertStack(new ItemStack(ArsItems.DICTIONARY));
                } else if (player.getRandom().nextDouble()>0.7) {
                    player.inventory.insertStack(new ItemStack(ArsItems.TABLE));
                }
            }
        }
        return true;
    }
}
