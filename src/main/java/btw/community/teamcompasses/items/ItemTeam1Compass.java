package btw.community.teamcompasses.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.IconRegister;
import net.minecraft.src.Item;
import btw.community.teamcompasses.manager.TeamBaseManager;
import net.minecraft.src.*;

import java.util.List;

public class ItemTeam1Compass extends Item {
    public ItemTeam1Compass(int itemID) {
        super(itemID);
        setUnlocalizedName("itemTeamCompass1");
        setCreativeTab(CreativeTabs.tabTools);
    }

    @Override
    public void registerIcons(IconRegister register) {
        this.itemIcon = register.registerIcon("compass");
    }

    @Override
    public void onUpdate(ItemStack stack, World world, EntityPlayer entity, int iInventorySlot, boolean bIsHandHeldItem) {
        if (world.isRemote) {
            return;
        }
        ChunkCoordinates baseLocation = TeamBaseManager.getInstance().getTeamBaseLocation(1);

        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (baseLocation != null) {
            stack.getTagCompound().setBoolean("hasTarget", true);
            stack.getTagCompound().setInteger("targetX", baseLocation.posX);
            stack.getTagCompound().setInteger("targetY", baseLocation.posY);
            stack.getTagCompound().setInteger("targetZ", baseLocation.posZ);
        } else {
            stack.getTagCompound().setBoolean("hasTarget", false);
        }
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (par2EntityPlayer != null) {
            super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
        }

        par3List.add("Points to Team 1 base");
    }
}