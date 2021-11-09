package com.enderio.machines.common.block;

import com.enderio.base.common.item.EIOCreativeTabs;
import com.enderio.machines.EIOMachines;
import com.enderio.machines.common.blockentity.MachineBlockEntities;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.NonNullLazyValue;
import com.tterrag.registrate.util.entry.BlockEntry;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MachineBlocks {
    private static final Registrate REGISTRATE = EIOMachines.registrate();

    public static final BlockEntry<MachineBlock> SIMPLE_POWERED_FURNACE = REGISTRATE
        .block("simple_powered_furnace", props -> new MachineBlock(props, MachineBlockEntities.SMELTER))
        .item()
        .group(new NonNullLazyValue<>(() -> EIOCreativeTabs.MACHINES))
        .build()
        .register();
    public static final BlockEntry<MachineBlock> FLUID_TANK = REGISTRATE
        .block("fluid_tank", props -> new MachineBlock(props, MachineBlockEntities.FLUID_TANK))
        .item()
        .group(new NonNullLazyValue<>(() -> EIOCreativeTabs.MACHINES))
        .build()
        .register();
    public static void register() {}
}
