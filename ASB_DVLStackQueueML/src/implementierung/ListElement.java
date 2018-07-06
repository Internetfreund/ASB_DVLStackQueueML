package implementierung;

import schnittstellen.IListElement;
import schnittstellen.IValueElement;

/**
 * Musterloesung der Klasse <code>ListElement. Ein Listenelement
 * enthaelt den Wert des Elementes, ein Objekt vom Typ
 * <code>IValueElement</code> sowie einen Verweis auf den Vorgaenger und 
 * Nachfolger in der Liste.
 */
public class ListElement implements IListElement
{
    // Objektattribute
    private IValueElement valueElement;

    private IListElement vorgaenger;

    private IListElement nachfolger;

    /**
     * Liefert das Werte-Objekt des Listenelements.
     * 
     * @return Den Wert.
     */
    public IValueElement getValueElement()
    {
        return valueElement;
    }

    /**
     * Setzt einen neuen Wert des Elementes.
     * 
     * @param value
     *            Der neue Wert.
     */
    public void setValueElement(IValueElement value)
    {
        valueElement = value == null ? new ValueElement() : value;
    }

    /**
     * Liefert den Vorgaenger des Listenelements.
     * 
     * @return Den Elementvorgaenger.
     */
    public IListElement getPredecessor()
    {
        return vorgaenger;
    }

    /**
     * Setzt einen neuen Vorgaenger.
     * 
     * @param predecessor
     *            Der neue Vorgaenger.
     */
    public void setPredecessor(IListElement predecessor)
    {
        this.vorgaenger = predecessor;
    }

    /**
     * Liefert den Nachfolger des Listenelements.
     * 
     * @return Den Elementnachfolger.
     */
    public IListElement getSuccessor()
    {
        return nachfolger;
    }

    /**
     * Setzt einen neuen Nachfolger.
     * 
     * @param successor
     *            Der neue Nachfolger.
     */
    public void setSuccessor(IListElement successor)
    {
        this.nachfolger = successor;
    }

    /**
     * Konstruktor zur Wert-Initialisierung.
     * 
     * @param value
     *            Der Initialwert.
     */
    public ListElement(IValueElement value)
    {
        setValueElement(value);
    }
}
