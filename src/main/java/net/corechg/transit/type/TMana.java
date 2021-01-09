package net.corechg.transit.type;

/** Units of mana.
 * @author Kyle Gunger
 */
public class TMana {
    private String type;
    private Number count;

    /** Constructor
     * 
     * @param t Type of mana (Fire/Water/Dark/Light/etc.) leave empty string for an untyped mana system.
     * @param ct Count of mana
     */
    public TMana(String t, Number ct) {
        type = t;
        count = ct;
    }

    /** Get the mana type.
     */
    public String getType() {
        return type;
    }

    /** Get the mana stored.
     */
    public Number getCount() {
        return count;
    }
}
