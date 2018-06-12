/*
 * This file is part of Blue Power. Blue Power is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. Blue Power is
 * distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along
 * with Blue Power. If not, see <http://www.gnu.org/licenses/>
 */
package com.bluepowermod.block.machine;

import com.bluepowermod.block.BlockContainerBase;
import com.bluepowermod.client.render.ICustomModelBlock;
import com.bluepowermod.init.BPCreativeTabs;
import com.bluepowermod.init.BPItems;
import com.bluepowermod.reference.GuiIDs;
import com.bluepowermod.reference.Refs;
import com.bluepowermod.tile.tier3.TileEngine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

;import javax.annotation.Nullable;

/**
 *
 * @author TheFjong
 *
 */
public class BlockEngine extends BlockContainerBase {

    public static final PropertyBool ACTIVE = PropertyBool.create("active");
    public static final PropertyBool GEAR = PropertyBool.create("gear");
    public static final PropertyBool GLIDER = PropertyBool.create("glider");
    public static final PropertyEnum<EnumFacing> FACING = PropertyEnum.create("facing", EnumFacing.class);

    public BlockEngine() {

        super(Material.IRON, TileEngine.class);
        setCreativeTab(BPCreativeTabs.machines);
        setUnlocalizedName(Refs.ENGINE_NAME);
        setDefaultState(blockState.getBaseState().withProperty(ACTIVE, false).withProperty(GEAR, false).withProperty(GLIDER, false).withProperty(FACING, EnumFacing.DOWN));
        setRegistryName(Refs.MODID, Refs.ENGINE_NAME);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ACTIVE, GEAR, GLIDER, FACING);
    }
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(ACTIVE) ? 0 : 1;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(ACTIVE, meta == 1);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return super.getActualState(state, worldIn, pos).withProperty(FACING, ((TileEngine)worldIn.getTileEntity(pos)).getOrientation());
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("cast")
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack iStack) {
        if (world.getTileEntity(pos) instanceof TileEngine) {

            int direction = 0;
            int facing;

            if (player.rotationPitch > 45) {

                facing = 5;
            } else if (player.rotationPitch < -45) {

                facing = 4;
            } else {

                facing = MathHelper.floor(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
            }

            if (facing == 0) {

                direction = EnumFacing.SOUTH.ordinal();
            } else if (facing == 1) {

                direction = EnumFacing.WEST.ordinal();
            } else if (facing == 2) {

                direction = EnumFacing.NORTH.ordinal();
            } else if (facing == 3) {

                direction = EnumFacing.EAST.ordinal();
            } else if (facing == 4) {

                direction = EnumFacing.UP.ordinal();
            } else if (facing == 5) {

                direction = EnumFacing.DOWN.ordinal();
            }
            TileEngine tile = (TileEngine) world.getTileEntity(pos);
            tile.setOrientation(EnumFacing.getFront(direction));
        }
    }

    @SuppressWarnings("cast")
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing efacing, float hitX, float hitY, float hitZ) {
        if (!player.inventory.getCurrentItem().isEmpty()) {
            Item item = player.inventory.getCurrentItem().getItem();
            if (item == BPItems.screwdriver) {
                if (!world.isRemote) {
                    int direction = 0;
                    int facing = 0;

                    if (player.rotationPitch > 45) {
                        facing = 5;
                    } else if (player.rotationPitch < -45) {
                        facing = 4;
                    } else {
                        facing = MathHelper.floor(player.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
                    }

                    TileEngine engine = (TileEngine) world.getTileEntity(pos);

                    if (facing == 0) {
                        if (player.isSneaking()) {
                            direction = EnumFacing.NORTH.ordinal();
                        }else {
                            direction = EnumFacing.SOUTH.ordinal();
                        }
                    } else if (facing == 1) {
                        if (player.isSneaking()) {
                            direction = EnumFacing.EAST.ordinal();
                        }else {
                            direction = EnumFacing.WEST.ordinal();
                        }
                    } else if (facing == 2) {
                        if (player.isSneaking()) {
                            direction = EnumFacing.SOUTH.ordinal();
                        }else {
                            direction = EnumFacing.NORTH.ordinal();
                        }
                    } else if (facing == 3) {
                        if (player.isSneaking()){
                            direction = EnumFacing.WEST.ordinal();
                        }else {
                            direction = EnumFacing.EAST.ordinal();
                        }
                    } else if (facing == 4) {
                        if (player.isSneaking()) {
                            direction = EnumFacing.DOWN.ordinal();
                        }else {
                            direction = EnumFacing.UP.ordinal();
                        }
                    } else if (facing == 5) {
                        if (player.isSneaking()) {
                            direction = EnumFacing.UP.ordinal();
                        }else {
                            direction = EnumFacing.DOWN.ordinal();
                        }
                    }

                    engine.setOrientation(EnumFacing.getFront(direction));
                    world.notifyNeighborsOfStateChange(pos, this, true);
                }
            }
        }

        return super.onBlockActivated(world, pos, state, player, hand, efacing, hitX, hitY, hitZ);
    }


    /**
     * Method to be overwritten that returns a GUI ID
     *
     * @return
     */
    @Override
    public GuiIDs getGuiID() {

        return GuiIDs.INVALID;
    }

    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, @Nullable EnumFacing side) {
        return true;
    }

}
