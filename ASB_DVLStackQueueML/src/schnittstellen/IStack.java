package schnittstellen;

/**
 * Schnittstellendefinition f&uuml;r einen Stack.
 * 
 */
public interface IStack
{
    /**
     * Listen-Getter
     * 
     * @return Die verwendete Datenstruktur.
     */
    public IList getDVL();

    /**
     * Test, ob Liste leer ist.
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
     * Top-Getter / -Remover
     * 
     * @return Das oberste Element.
     */
    public int pop();

    /**
     * Top-Setter
     * 
     * @param value
     *            Neues oberes Element.
     */
    public void push(int value);

    /**
     * Top-Getter
     * 
     * @return as oberste Element.
     */
    public int top();
}
