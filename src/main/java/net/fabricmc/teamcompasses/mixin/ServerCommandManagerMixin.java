package net.fabricmc.teamcompasses.mixin;

import btw.community.teamcompasses.commands.SetBaseCommand;
import net.minecraft.src.CommandHandler;
import net.minecraft.src.ServerCommandManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerCommandManager.class)
public abstract class ServerCommandManagerMixin extends CommandHandler {

    // Ta metoda "wstrzykuje" nasz kod na końcu konstruktora ServerCommandManager,
    // co jest idealnym momentem na rejestrację komend.
    @Inject(method = "<init>", at = @At("RETURN"))
    public void registerCustomCommands(CallbackInfo ci) {
        System.out.println("[TeamCompasses] Rejestrowanie komend...");
        registerCommand(new SetBaseCommand());
    }
}