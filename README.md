# TransitAPI
Transit is an attempt to provide simple uniform helpers for converting and transfering abstract types in Minecraft.

Transit makes no assumptions about what you transfer or how you transfer it, It only provides basic types for those that need it, and a network based API for compatibility.

## A note on convention
When working with blocks, the convention is such:
1. The BlockEntity will impliment the INode/IAcceptorNode/IProviderNode interfaces.
2. The Placed block will ask the blocks around it to become a provider and or an acceptor, not the other way around.

(These conventions assume a server-side approach to your mod's pipes implementation)

### Note from the author
I won't try to update the requirements for the API too much, so it should keep consistant across MC versions.  However, when a common requirement is determined, I will update the API.  This can be determined by the major version of the mod.

API updates/upgrades will only happen on Minecraft version increases (i.e. 1.16 -> 1.17, but not 1.16.4 -> 1.16.5) so all versions of the mod will work with other mods for the same MC version.

First few changes may come quickly as the API stabilizes, but by version 3 or 4 I think there will be a lasting API.

Release Candadites or Beta versions may or may not reflect the release API.

## License
This mod is available under the MIT licence.
