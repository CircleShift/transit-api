package net.transit.type;

import net.minecraft.fluid.Fluid;

/** Units of fluid.
 * @author Kyle Gunger
 */
public class TFluid {
    private Fluid fluid;
    private Number millibuckets;

    /** Constructor
     * 
     * @param f Fluid stored (Water/Lava/etc.)
     * @param ct Count of fluid (mB)
     */
    public TFluid(Fluid f, Number mb) {
        fluid = f;
        millibuckets = mb;
    }

    /** Get the fluid stored.
     */
    public Fluid getFluid() {
        return fluid;
    }

    /** Get the millibuckets stored.
     */
    public Number getMilliBuckets() {
        return millibuckets;
    }
}