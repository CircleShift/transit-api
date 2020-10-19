# TransitAPI
Transit is an attempt to provide simple uniform helpers for converting and transfering abstract types in Minecraft.

Transit makes no assumptions about what you transfer or how you transfer it, It only provides basic types for those that need it, and a network based API for compatibility.

## A note on convention
When working with blocks, the convention is such:
1. The BlockEntity will impliment the INode/IAcceptorNode/IProviderNode interfaces.
2. The Placed block will ask the blocks around it to become a provider and or an acceptor, not the other way around.


## License
This mod is available under the MIT licence going forward.
