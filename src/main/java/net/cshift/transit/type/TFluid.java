package net.cshift.transit.type;

import net.minecraft.fluid.*;

/** Units of fluid.
 * @author Kyle Gunger
 */
public class TFluid {
    private Fluid fluid;
    private Number mb;

    /** Constructor.
     *  Since a bucket of fluid is the same as a block of a fluid, mb can be called millibuckets or milliblocks.
     * 
     * @param f Fluid stored (Water/Lava/etc.)
     * @param mB Count of fluid (mB)
     */
    public TFluid(Fluid f, Number mB) {
        fluid = f;
        mb = mB;
    }

    /** Get the fluid stored.
     */
    public Fluid getFluid() {
        return fluid;
    }

    /** Get the millibuckets stored.
     */
    public Number getMilliBuckets() {
        return mb;
    }
}
