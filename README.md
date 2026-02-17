# RegisterPack-Fix-20260217

The 2026.02.17 server update changed the signature of `AssetModule.registerPack` from 3 to 4 parameters, breaking any mod compiled against the old version (e.g. AdminPortals).

This is a Hyxin mixin earlyplugin that re-adds the old 3-argument overload so those mods keep working without needing a rebuild.

## what changed

```
// old (before 2026.02.17)
registerPack(String name, Path path, PluginManifest manifest)

// new (2026.02.17+)
registerPack(String name, Path path, PluginManifest manifest, boolean flag)
```

The mixin adds the old method back and delegates to the new one with `false` as the default.

## install

1. download the jar from [releases](https://github.com/VarNotUsed/Hytale-RegisterPack-Fix-20260217/releases)
2. grab [Hyxin](https://www.curseforge.com/hytale/mods/hyxin) and put it in your `earlyplugins` folder
3. drop `RegisterPack-Fix-20260217-1.0.0.jar` into the same `earlyplugins` folder
4. start your server

## build from source

```
gradlew mixinJar
```

output goes to `build/libs/`.

requires the hytale server jar installed at the default location (`%APPDATA%/Hytale/install/release/package/game/latest/Server/HytaleServer.jar`).
