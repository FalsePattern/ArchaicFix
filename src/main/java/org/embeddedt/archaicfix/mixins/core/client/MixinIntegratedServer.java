package org.embeddedt.archaicfix.mixins.core.client;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.server.integrated.IntegratedServer;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IntegratedServer.class)
public class MixinIntegratedServer {
    @Redirect(method = "tick", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/client/settings/GameSettings;renderDistanceChunks:I"))
    private int getRealRenderDistance(GameSettings settings) {
        return Math.max(settings.renderDistanceChunks, 8);
    }
}