package schnittstellen;

/**
 * Schnittstellendefinition f&uuml;r eine Liste.
 * 
 */
public interface IQueue
{
    /**
     * Listen-Getter
     * 
     * @return Die verwendete Datenstruktur.
     */
    public IList getDVL();

    /**
     * Leerheitstest
     * 
     * @return <code>true</code> oder <code>false</code>
     */
    public boolean isEmpty();

    /**
     * Kapazit&auml;ts-Test
     * 
     * @return <code>true</code> oder <code>false</code>
     */
    public boolean isFull();

    /**
     * Size-Getter
     * 
     * @return Aktuelle Queue-Size.
     */
    public int getSize();

    /**
     * Front-Getter
     * 
     * @return Das erste Element.
     */
    public int front();

    /**
     * Back-Setter
     * 
     * @param value
     *            Neuer Wert zum Anstellen.
     */
    public void enqueue(int value);

    /**
     * Front-Getter / -Remover
     * 
     * @return Das erste Element.
     */
    public int dequeue();
}
