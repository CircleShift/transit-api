package net.cshift.transit.type;

import net.minecraft.item.*;

/** Item storage
 * @author Kyle Gunger
 */
public class TItem {
    private Item item;
    private Number count;

    /** Constructor.
     * 
     * @param i Item stored
     * @param c Item count
     */
    public TItem(Item i, Number c) {
        item = i;
        count = c;
    }

    /** Get the item stored.
     */
    public Item getItem() {
        return item;
    }

    /** Get the item count.
     */
    public Number getCount() {
        return count;
    }
}
