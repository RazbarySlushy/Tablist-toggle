# Tablist Toggle

A tiny, no-dependency client mod that lets you **toggle** the player list (the tab list)
instead of having to hold the key the whole time.

## Where the idea came from

I was playing survival with some friends, and one of them had rebound **Tab** to a
different action. The problem: out of pure habit he kept *mashing Tab* every few seconds,
because that's the key your hand reaches for when you want to see who's online — except now
it did something else entirely.

That's what this mod fixes. Put the player-list on a key you actually have free, flip it to
**Toggle**, and now a single press keeps the tab list open — no more holding anything, and
your Tab key is free for whatever you rebound it to. (And yes, it's equally great for those
creatures who need to see who's online **ALL THE TIME**.)

## What it does

You'll find the setting under **Options → Controls** (the same page as *Toggle Sprint* /
*Toggle Sneak*), shown as a single button:

> **Tablist: Hold / Toggle**

- **Hold** — vanilla behaviour: the list shows only while the key is held.
- **Toggle** — press the player-list key once to show it, press again to hide it.

The mode is saved and persists across restarts and across every world and server. The list
itself always starts **hidden** when you join a world or server — only the Hold/Toggle
*mode* is remembered, never the on/off state.

## No dependencies

Tablist Toggle needs **nothing but the mod loader**. No Fabric API, no libraries, no extra
downloads. Drop the jar in your `mods` folder and you're done.

## Supported versions

Built from one source tree, so every version below ships the exact same feature.

| Minecraft | Fabric | NeoForge |
|-----------|:------:|:--------:|
| 1.20.6    |   ✅    |    ✅    |
| 1.21.1    |   ✅    |    ✅    |
| 1.21.7    |   ✅    |    ✅    |
| 26.1.2    |   ✅    |    ✅    |
| 26.2      |   ✅    |          |

1.20.6 is the oldest supported version: from there up the Controls screen exposes a clean
options list to hook into, whereas 1.20.4 and below build the options as individual buttons
(no list), which makes a tidy injection impractical.

## Usage

1. Install [Fabric](https://fabricmc.net/) or [NeoForge](https://neoforged.net/) for your
   Minecraft version.
2. Put `tablisttoggle-*.jar` in your `mods` folder.
3. In game: **Options → Controls**, set **Tablist** to **Toggle**, and (optionally) rebind
   the player-list key to whatever you like.

## Building from source

Gradle/Stonecutter must run on **JDK 21+** (MC 26.x auto-provisions JDK 25 via a toolchain).

```bash
# one version
./gradlew ":1.21.7-fabric:build"

# the whole matrix
./gradlew ":1.20.1-fabric:build" ":1.20.2-fabric:build" ":1.20.4-fabric:build" \
          ":1.20.6-fabric:build" ":1.20.6-neoforge:build" \
          ":1.21.1-fabric:build" ":1.21.1-neoforge:build" \
          ":1.21.7-fabric:build" ":1.21.7-neoforge:build" \
          ":26.1.2-fabric:build" ":26.1.2-neoforge:build" \
          ":26.2-fabric:build"
```

Jars land in `versions/<version>-<loader>/build/libs/`. The project uses
[Stonecutter](https://stonecutter.kikugie.dev/) to target many Minecraft versions and both
loaders from a single codebase.

## Credits

Huge shoutout to **Malenya** for inspiring me to actually build this. 💛
