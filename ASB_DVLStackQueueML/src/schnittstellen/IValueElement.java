package schnittstellen;

/**
 * Schnittstellendefinition f&uuml;r ein Listen-Werte-Element.
 */
public interface IValueElement
{
    /**
     * Stringrepr&auml;sentation
     * 
     * @return Das Werte-Element als String.
     */
    public String getName();

    /**
     * Name-Setter
     * 
     * @param name
     *            Der neue Name.
     */
    public void setName(String name);

    /**
     * Value-Getter
     * 
     * @return Den Elementwert.
     */
    public int getValue();

    /**
     * Value-Setter
     * 
     * @param value
     *            Den neuen Elementwert.
     */
    public void setValue(int value);
}
