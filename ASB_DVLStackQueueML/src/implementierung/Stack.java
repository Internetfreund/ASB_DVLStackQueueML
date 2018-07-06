package implementierung;

import schnittstellen.*;

/**
 * Musterloesung der Klasse <code>Stack</code>.
 * Ein Stack (Kellerspeicher) instantiiert eine Liste und implementiert 
 * die geforderten Methoden, sodass das Keller-Verhalten umgesetzt wird.
 * 
 */
public class Stack implements IStack
{
    // Objektattribute und Default-Kapazitaet
    private final static int MAX_SIZE = 7;

    private IList list;

    /**
     * Standard-Konstruktor.
     */
    public Stack()
    {
        list = new List();
    }

    /**
     * Liefert die Listen-Datenstruktur.
     * 
     * @return Die verwendete Liste.
     */
    public IList getDVL()
    {
        return list;
    }

    /**
     * Testet, ob der Stack leer ist.
     * 
     * @return <code>true</code>, falls der Stack keine Elemente enthaelt.
     */
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    /**
     * Kapazitaets-Test des Stack.
     * 
     * @return <code>true</code>, falls der Stack <i>voll</i> ist.
     */
    public boolean isFull()
    {
        return getSize() == MAX_SIZE;
    }

    /**
     * Liefert die aktuelle Anzahl der Stackelemente.
     * 
     * @return Die Stack-Size.
     */
    public int getSize()
    {
        int size = 0;
        IListElement current = list.getHead().getSuccessor();
        while (current != null)
        {
            ++size;
            current = current.getSuccessor();
        }
        return size;
    }

    /**
     * Entnahme und Loeschung des letzten Elements des Stack.
     * 
     * @return Den <code>int</code>-Wert des letzten Elements oder -1 
     * bei einem leeren Stack.
     * 
     */
    public int pop()
    {
        if (isEmpty())
        {
            return -1;
        }
        int res = list.getElementAt(1).getValue();
        list.deleteFirstOf(list.getElementAt(1));
       
        return res;
    }

    /**
     * Einen Wert als obersten Stapel auf den Stack ablegen, falls noch Platz
     * ist. Wegen deleteFirstOf() einfuegen am Kopf.
     * 
     * @param value
     *            Der <code>int</code>-Wert, der aufgelegt werden soll.
     */
    public void push(int value)
    {
        if (!isFull() && value >= 0)
        {
            list.insertAtPos(1, new ValueElement("Element" + getSize(), value));
        }
    }

    /**
     * Liefert das oberste Stack-Element, falls der Stack nicht leer ist.
     * 
     * @return Das oberste Stack-Element.
     */
    public int top()
    {
        return isEmpty() ? -1 : list.getElementAt(1).getValue();
    }
}
