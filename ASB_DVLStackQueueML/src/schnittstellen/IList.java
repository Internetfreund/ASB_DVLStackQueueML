package schnittstellen;

/**
 * Schnittstellendefinition f&uuml;r eine Liste.
 * 
 */
public interface IList
{
    /**
     * Head-Getter
     * 
     * @return Das Kopfelement.
     */
    public IListElement getHead();

    /**
     * Append-Operation.
     * 
     * @param value
     *            Einzuf&uuml;gender Wert.
     */
    public void insertAtTheEnd(IValueElement value);

    /**
     * Einf&uuml; an beliebiger Position
     * 
     * @param pos
     *            Einf&uuml;geposition.
     * @param value
     *            Einzuf&uuml;gender Wert.
     */
    public void insertAtPos(int pos, IValueElement value);

    /**
     * Elementgetter mit Positionsangabe.
     * 
     * @param position
     *            Anfrageposition.
     * @return Wert an Anfrageposition.
     */
    public IValueElement getElementAt(int position);

    /**
     * Position eines Wertes.
     * 
     * @param value
     *            Ein beliebiger Wert.
     * @return Position dieses Wertes.
     */
    public int getFirstPosOf(IValueElement value);

    /**
     * L&ouml;schoperation auf erstes Werteauftreten.
     * 
     * @param value
     *            Zu l&ouml;schender Wert.
     */
    public void deleteFirstOf(IValueElement value);

    /**
     * L&ouml;schoperation auf alle Werteauftreten.
     * 
     * @param value
     *            Zu l&ouml;schender Wert.
     */
    public void deleteAllOf(IValueElement value);

    /**
     * Membertest.
     * 
     * @param value
     *            Zu pr&uuml;fender Wert.
     * @return true oder false.
     */
    public boolean member(IValueElement value);

    /**
     * Listenspiegelung.
     */
    public void reverse();

    /**
     * Stringrepr&auml;sentation.
     * 
     * @return String-Objekt.
     */
    public String toString();
}
