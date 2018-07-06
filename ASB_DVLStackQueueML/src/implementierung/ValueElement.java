package implementierung;

import schnittstellen.IValueElement;

/**
 * Musterl&ouml;sung der Klasse <code>ValueElement</code> der
 * ASB-Programmieraufgabe <i>DVL, Stack und Queue</i>. Ein ValueElement (Der
 * Wert eines Listenelements) h&auml;t Informationen &uuml;ber den Namen und den
 * <code>int</code>-Wert des Elements.
 */
public class ValueElement implements IValueElement
{
    // Objektattribute
    private String name;

    private int value;

    /**
     * Liefert den aktuellen Namen des Elements.
     * 
     * @return Den Elementnamen.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Setzt einen neuen Namen.
     * 
     * @param name
     *            Der neue Name.
     */
    public void setName(String name)
    {
        this.name = name == null ? "unknown" : name;
    }

    /**
     * Liefert den Wert des Elements.
     * 
     * @return Wert
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Setzt einen neuen Wert.
     * 
     * @param value
     *            Der neue Wert.
     */
    public void setValue(int value)
    {
        this.value = value;
    }

    /**
     * Allgemeiner Konstruktor zur Initialisierung von Namen und
     * <code>int</code>-Wert.
     * 
     * @param name
     *            Name des Elements.
     * @param value
     *            Wert des Elements.
     */
    public ValueElement(String name, int value)
    {
        this.setName(name);
        this.setValue(value);
    }

    /**
     * Standard-Konstruktor
     */
    public ValueElement()
    {
        this("head", 0);
    }

    /**
     * Ausgabe einer Stringrepr&auml;sentation des Elements.
     * 
     * @return Eine Stringrepr&auml;sentation.
     */
    public String toString()
    {
        return "Name:" + name + " Wert:" + value;
    }
}
