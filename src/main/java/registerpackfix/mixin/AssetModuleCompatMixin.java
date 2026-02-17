package registerpackfix.mixin;

import com.hypixel.hytale.common.plugin.PluginManifest;
import com.hypixel.hytale.server.core.asset.AssetModule;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.nio.file.Path;

/**
 * The 2026.02.17 Hytale Server update changed
 * {@code AssetModule.registerPack(String, Path, PluginManifest)} to
 * {@code AssetModule.registerPack(String, Path, PluginManifest, boolean)}.
 *
 * This mixin re-adds the old 3-argument overload so that plugins compiled
 * against the previous server version (e.g. AdminPortals) continue to work
 * without needing a rebuild.
 */
@Mixin(AssetModule.class)
public abstract class AssetModuleCompatMixin {

    @Shadow
    public abstract void registerPack(String name, Path path, PluginManifest manifest, boolean flag);

    public void registerPack(String name, Path path, PluginManifest manifest) {
        registerPack(name, path, manifest, false);
    }
}
