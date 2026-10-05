# Changelog

## 1.0.2
- Fabric support for Minecraft 26.2. The open screen now lives on `Gui`, so toggle presses are still ignored while a screen is open.

## 1.0.1
- Fix the Controls option not appearing (or crashing) on 1.20.6 and NeoForge.
- Fix translations not loading on Minecraft 26.x (new pack-format scheme).
- License is GPL-3.0; correct icon; no Discord link.
- Supported range is now 1.20.6 - 26.1.2 (Fabric + NeoForge).

## 1.0.0
- Initial release.
- Adds a `Tablist: Hold / Toggle` option to the Controls settings screen.
- Hold = vanilla (show while held); Toggle = press to flip the player list on/off.
- Mode is persisted to `config/tablisttoggle.properties`; the shown state resets to hidden on world/server join.
