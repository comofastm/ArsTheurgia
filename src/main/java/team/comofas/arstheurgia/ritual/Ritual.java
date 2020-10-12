package team.comofas.arstheurgia.ritual;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import team.comofas.arstheurgia.items.OpenableTablet;
import team.comofas.arstheurgia.player.PlayerComponents;
import team.comofas.arstheurgia.registry.ArsSounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static team.comofas.arstheurgia.registry.ArsItems.registerItem;

// Isso demonstra como vai ser implementando o check pra validar um ritual com blocos ao redor, depois criar funções pra quadrados
// e simetria de dobra de ordem n dentro do circulo, assim por tudo isso numa classe válida de ritual e eventualmente estágios.
public class Ritual {

    public Item writtenClayTablet;
    public Item tabletPart;
    public Item cookedClayTablet;

    public static List<Item> allTabletParts = new ArrayList<>();
    public static Map<String, Ritual> ritualsByName = new HashMap<>();


    public Map<Block, List<BlockPos>> validBlocks = new HashMap<>();
    public String ritualName;
    public int cooldown;
    public int oldTime;

    protected boolean isValid = false;
    protected BlockState state;
    protected PlayerEntity player;
    protected BlockHitResult hit;
    protected List<BlockEntity> ritualBlocks = new ArrayList<>();


    public Ritual(String name, int cooldown) {
        this.ritualName = name;
        this.cooldown = cooldown;
        ritualsByName.put(name, this);
    }


    public void registerItems() {
        writtenClayTablet = new Item(new FabricItemSettings().group(ItemGroup.MISC));
        tabletPart = new Item(new FabricItemSettings().group(ItemGroup.MISC));
        cookedClayTablet = new OpenableTablet(new FabricItemSettings().group(ItemGroup.MISC), this.ritualName);

        allTabletParts.add(tabletPart);

        registerItem(writtenClayTablet, "written_clay_tablet_" + this.ritualName);
        registerItem(tabletPart, "tablet_part_" + this.ritualName);
        registerItem(cookedClayTablet, "cooked_clay_tablet_" + this.ritualName);
    }

    public void onCooldownFail() {
        player.getEntityWorld().playSound(null, hit.getBlockPos(), ArsSounds.RITUAL_FAIL, SoundCategory.AMBIENT, 1f, 1f);
    }

    public boolean checkRitual() { return true; }

    public void fromUse(BlockState state, PlayerEntity player, BlockHitResult hit) {
        this.player = player;
        this.state = state;
        this.hit = hit;
    }

    public static boolean callRitual(Ritual rt, BlockState state, PlayerEntity player, Hand hand, BlockHitResult hit) {
        rt.oldTime = PlayerComponents.RITUALTIME.get(player).getInt(rt.ritualName);
        rt.fromUse(state, player, hit);
        BlockPos pos = hit.getBlockPos();
        World world = player.getEntityWorld();
        System.out.println("bb");
        boolean check = rt.checkRitual();

        if (check) {
            if (world.getTime() - rt.oldTime > rt.cooldown) {
                rt.onCall(hand);
                PlayerComponents.RITUALTIME.get(player).setInt(rt.ritualName);
            } else {
                rt.onCooldownFail();
            }
        }
        return check;
    }

    public void onCall(Hand hand) { }
}
