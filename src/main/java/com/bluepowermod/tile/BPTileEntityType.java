package com.bluepowermod.tile;

import com.bluepowermod.reference.ContainerNames;
import com.bluepowermod.tile.tier1.*;
import com.bluepowermod.tile.tier2.TileCircuitTable;
import com.bluepowermod.tile.tier2.TileRegulator;
import com.bluepowermod.tile.tier2.TileRetriever;
import com.bluepowermod.tile.tier2.TileSortingMachine;
import com.bluepowermod.tile.tier3.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class BPTileEntityType {

    @ObjectHolder(ContainerNames.ALLOY_FURNACE)
    public static TileEntityType<TileAlloyFurnace> ALLOY_FURNACE;

    @ObjectHolder(ContainerNames.BUFFER)
    public static TileEntityType<TileBuffer> BUFFER;

    @ObjectHolder(ContainerNames.SORTING_MACHINE)
    public static TileEntityType<TileSortingMachine> SORTING_MACHINE;

    @ObjectHolder(ContainerNames.CPU)
    public static TileEntityType<TileCPU> CPU;

    @ObjectHolder(ContainerNames.MONITOR)
    public static TileEntityType<TileMonitor> MONITOR;

    @ObjectHolder(ContainerNames.DISK_DRIVE)
    public static TileEntityType<TileDiskDrive> DISK_DRIVE;

    @ObjectHolder(ContainerNames.IO_EXPANDER)
    public static TileEntityType<TileIOExpander> IO_EXPANDER;

    @ObjectHolder(ContainerNames.KINETIC_GENERATOR)
    public static TileEntityType<TileKinectGenerator> KINETIC_GENERATOR;

    @ObjectHolder(ContainerNames.DEPLOYER)
    public static TileEntityType<TileDeployer> DEPLOYER;

    @ObjectHolder(ContainerNames.RELAY)
    public static TileEntityType<TileRelay> RELAY;

    @ObjectHolder(ContainerNames.EJECTOR)
    public static TileEntityType<TileEjector> EJECTOR;

    @ObjectHolder(ContainerNames.FILTER)
    public static TileEntityType<TileFilter> FILTER;

    @ObjectHolder(ContainerNames.RETRIEVER)
    public static TileEntityType<TileRetriever> RETRIEVER;

    @ObjectHolder(ContainerNames.REGULATOR)
    public static TileEntityType<TileRegulator> REGULATOR;

    @ObjectHolder(ContainerNames.ITEM_DETECTOR)
    public static TileEntityType<TileItemDetector> ITEM_DETECTOR;

    @ObjectHolder(ContainerNames.PROJECT_TABLE)
    public static TileEntityType<TileProjectTable> PROJECT_TABLE;

    @ObjectHolder(ContainerNames.CIRCUIT_TABLE)
    public static TileEntityType<TileCircuitTable> CIRCUIT_TABLE;

    @ObjectHolder(ContainerNames.MANAGER)
    public static TileEntityType<TileManager> MANAGER;

    @ObjectHolder(ContainerNames.CIRCUITDATABASE_MAIN)
    public static TileEntityType<TileCircuitDatabase> CIRCUITDATABASE;

}
