package net.cshift.transit.type;

import net.minecraft.item.*;

/** Units of fluid.
 * @author Kyle Gunger
 */
public class TItem {
    private Item item;
    private Number count;

    /** Constructor.
     *  Since a bucket of fluid is the same as a block of a fluid, mb can be called millibuckets or milliblocks.
     * 
     * @param i Fluid stored (Water/Lava/etc.)
     * @param c Item countie
     */
    public TItem(Item i, Number c) {
        item = i;
        count = c;
    }

    /** Get the fluid stored.
     */
    public Item getItem() {
        return item;
    }

    /** Get the millibuckets stored.
     */
    public Number getCount() {
        return count;
    }
}
