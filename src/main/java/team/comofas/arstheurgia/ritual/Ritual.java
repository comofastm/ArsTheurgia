package team.comofas.arstheurgia.ritual;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import team.comofas.arstheurgia.items.OpenableTablet;
import team.comofas.arstheurgia.ritual.rituals.CreeperSummon;
import team.comofas.arstheurgia.ritual.utils.RitualUtils;

import java.util.ArrayList;
import java.util.List;

import static team.comofas.arstheurgia.registry.ArsItems.registerItem;

// Isso demonstra como vai ser implementando o check pra validar um ritual com blocos ao redor, depois criar funções pra quadrados
// e simetria de dobra de ordem n dentro do circulo, assim por tudo isso numa classe válida de ritual e eventualmente estágios.
public class Ritual {

    public Item writtenClayTablet;
    public Item tabletPart;
    public Item cookedClayTablet;

    public static List<Item> allTabletParts = new ArrayList<>();


    public void registerItems(String name) {
        writtenClayTablet = new Item(new FabricItemSettings().group(ItemGroup.MISC));
        tabletPart = new Item(new FabricItemSettings().group(ItemGroup.MISC));
        cookedClayTablet = new OpenableTablet(new FabricItemSettings().group(ItemGroup.MISC));

        allTabletParts.add(tabletPart);

        registerItem(writtenClayTablet, "written_clay_tablet_" + name);
        registerItem(tabletPart, "tablet_part_" + name);
        registerItem(cookedClayTablet, "cooked_clay_tablet_" + name);
    }

    public static void callRitual(Ritual rt, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        rt.onCall(state, world, pos, player, hand, hit);
    }

    public void onCall(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) { }
}
