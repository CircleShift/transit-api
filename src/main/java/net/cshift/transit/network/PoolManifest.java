package net.cshift.transit.network;

/**
 * @author Kyle Gunger
 * @apiNote A channel manifest represents a set of possible data/resource pools that another node can request a channel to.
 */
public interface PoolManifest {
    
    /** Represents the number of pools that the node has access to for the specified resource.
     * @apiNote A "pool" in this context represents an independant network of resources.
     * Pool zero should be the default group that simple nodes will attempt to connect to.
     * @param group The TypeGroup that the pool belongs to
     */
    public int poolCount(String group);

    /** The ID of the pool.  The INode will use this in a connection attempt with the other INode.
     * 
     * @param group The TypeGroup the pool belongs to
     * @param pool Array-like index for pool (gotten from poolCount)
     */
    public int poolID(String group, int pool);

    /** If the mod supports named pools, the names can be querried through this function.
     *
     * @param group The TypeGroup the pool belongs to
     * @param pool Array-like index for pool (gotten from poolCount)
     */
    public String poolName(String group, int pool);

    /** If the mod supports pool descriptions, they can be accessed by this method.
     * 
     * @param group The TypeGroup the pool belongs to
     * @param pool Array-like index for pool (gotten from poolCount)
    */
    public String poolDescription(String group, int pool);
}
