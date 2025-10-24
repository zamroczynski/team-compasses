package net.fabricmc.teamcompasses.mixin;

import btw.community.teamcompasses.TeamCompassesAddon;
import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TextureCompass.class)
public class TextureCompassMixin {

    @Inject(method = "computeCompassAngle(DDDZLnet/minecraft/src/EntityPlayer;)D", at = @At("HEAD"), cancellable = true)
    private void onComputeCompassAngle(double dSourceX, double dSourceZ, double dSourceYaw, boolean bIsInFrame, EntityPlayer player, CallbackInfoReturnable<Double> cireturn) {

        if (player == null) return;
        ItemStack currentItem = player.getCurrentEquippedItem();
        if (currentItem == null) return;

        int itemID = currentItem.getItem().itemID;

        if (itemID == TeamCompassesAddon.teamCompass1.itemID) {
            if (currentItem.hasTagCompound()) {
                NBTTagCompound nbt = currentItem.getTagCompound();
                if (nbt.getBoolean("hasTarget")) {
                    int targetX = nbt.getInteger("targetX");
                    int targetZ = nbt.getInteger("targetZ");
                    double dDeltaX = (double)targetX + 0.5D - dSourceX;
                    double dDeltaZ = (double)targetZ + 0.5D - dSourceZ;
                    dSourceYaw %= 360.0D;
                    double angle = -((dSourceYaw - 90.0D) * Math.PI / 180.0D - Math.atan2(dDeltaZ, dDeltaX));
                    cireturn.setReturnValue(angle);
                }
            }
        } else if (itemID == TeamCompassesAddon.teamCompass2.itemID) {
            if (currentItem.hasTagCompound()) {
                NBTTagCompound nbt = currentItem.getTagCompound();
                if (nbt.getBoolean("hasTarget")) {
                    int targetX = nbt.getInteger("targetX");
                    int targetZ = nbt.getInteger("targetZ");
                    double dDeltaX = (double)targetX + 0.5D - dSourceX;
                    double dDeltaZ = (double)targetZ + 0.5D - dSourceZ;
                    dSourceYaw %= 360.0D;
                    double angle = -((dSourceYaw - 90.0D) * Math.PI / 180.0D - Math.atan2(dDeltaZ, dDeltaX));
                    cireturn.setReturnValue(angle);
                }
            }
        }
    }
}