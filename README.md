# Tablist Toggle

A tiny client-side mod that adds a **`Tablist: HELD / TOGGLE`** switch to the
**Controls** settings screen (right next to the vanilla *Toggle Sneak* / *Toggle Sprint*
options).

- **HELD** – vanilla behaviour: the player list shows only while the key is held.
- **TOGGLE** – pressing the player-list key flips the list on/off until pressed again.

The chosen mode is saved to `config/tablisttoggle.properties` and persists across
restarts and across every world/server. The *shown* state in TOGGLE mode is intentionally
**not** persisted: the tab list always starts hidden when you join a world or server.

## Supported versions / loaders

Built from a single source tree with [Stonecutter](https://stonecutter.kikugie.dev/).
Current matrix (Forge is intentionally dropped in favour of NeoForge):

| Minecraft | Fabric | NeoForge |
|-----------|:------:|:--------:|
| 1.20.2    |   ✅   |    —     |
| 1.20.4    |   ✅   |    —     |
| 1.20.6    |   ✅   |    ✅    |
| 1.21.1    |   ✅   |    ✅    |
| 1.21.7    |   ✅   |    ✅    |
| 26.1.2    |   ✅   |    ✅    |

NeoForge is offered from 1.20.6 up (its 1.20.2/1.20.4 line predates the API the modern
NeoForge MDG plugin builds against, so those two are Fabric-only).

> Roadmap: continue backporting toward older "major" versions (1.20.1, 1.19.x, 1.18.x,
> 1.16.x, …, 1.8.8). The Controls-screen option uses the `OptionInstance` API; pre-1.20.2
> lacks `ControlsScreen#addOptions`, and pre-~1.20 lacks `OptionInstance` entirely (the old
> `Option`/`CycleOption` system), so those eras need Stonecutter-guarded variants.

## Building

**JDK:** Gradle/Stonecutter must run on **JDK 21+**. Each Minecraft version compiles with the
JDK it needs via a Gradle toolchain — 1.21.x uses Java 21, and **MC 26.x needs Java 25**, which
is auto-provisioned on first build (foojay). Note: a `org.gradle.java.home` entry in
`~/.gradle/gradle.properties` overrides `JAVA_HOME`; it must point to a JDK 21+.

The active version is controlled by `.sc_active_version`. Switch with the Stonecutter
tasks, or build a specific node directly:

```bash
# build one node
./gradlew ":1.21.7-fabric:build"
./gradlew ":1.21.7-neoforge:build"

# build the whole matrix (Fabric + NeoForge for every version)
./gradlew ":1.21.1-fabric:build" ":1.21.7-fabric:build" ":26.1.2-fabric:build" \
          ":1.21.1-neoforge:build" ":1.21.7-neoforge:build" ":26.1.2-neoforge:build"

# collect a node's jars under build/libs/<version>/
./gradlew ":1.21.7-fabric:buildAndCollect"
```

Run the active version in dev:

```bash
./gradlew runActiveClient
```

Output jars land in each node's `versions/<node>/build/libs/` (and, via
`buildAndCollect`, in `build/libs/<version>/`).

## How it works

| Piece | File |
|-------|------|
| Override the tab-list "is the key down?" check in TOGGLE mode, and flip on key press | `mixin/KeyMappingMixin` |
| Reset to hidden on world/server join | `mixin/MinecraftMixin` |
| Add the `Tablist: HELD/TOGGLE` option to the Controls screen | `mixin/ControlsScreenMixin` + `TablistToggleOptions` |
| Persisted mode (HELD/TOGGLE) | `TablistToggleConfig` + `TablistToggleState` |

Project skeleton is based on
[rotgruengelb/stonecutter-mod-template](https://github.com/rotgruengelb/stonecutter-mod-template);
`fabric.mod.json` / `neoforge.mods.toml` are generated at build time from
`stonecutter.properties.toml`.
