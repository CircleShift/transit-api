package net.cshift.api.transit.network;

/**
 * @author Kyle Gunger
 * @apiNote A pool manifest represents a set of possible data/resource pools that another node can request a channel to.
 */
public abstract class PoolManifest {
    
    /** Represents the number of pools that the node has access to.
     * @apiNote A "pool" in this context represents an independent network of resources.
     * Each network in the pool may represent a different TypeGroup.
     * Pool zero should be the default group that simple nodes will attempt to connect to.
     * @param group The TypeGroup that the pool belongs to
     */
    public abstract int poolCount();

    /** If the mod supports named pools, the names can be queried through this function.
     *
     * @param group The TypeGroup the pool belongs to
     * @param pool Array-like index for pool (gotten from poolCount)
     */
    public String poolName(int pool) {
        return "";
    }
    
    /** Returns true if the pool with the given id supports the given group
     * 
     * @param pool The pool ID to query
     * @param group The TypeGroup to query
     * @return {@code true} if the pool supports the specified group, {@code false} otherwise
     */
    public abstract boolean poolProvides(int pool, String group);

    /** If the mod supports pool descriptions, they can be accessed by this method.
     * 
     * @param group The TypeGroup the pool belongs to
     * @param pool Array-like index for pool (gotten from poolCount)
    */
    public String poolDescription(int pool) {
        return "";
    }
}
