package implementierung;

import schnittstellen.*;

/**
 * Musterloesung der Klasse <code>Queue</code>. 
 * Eine Queue instantiiert eine Liste und implementiert die 
 * geforderten Methoden, sodass das Queue-Verhalten umgesetzt wird.
 * 
 */
public class Queue implements IQueue
{
    // Objektattribute und Default-Kapazitaet
    private static final int MAX_SIZE = 7;

    private IList list;

   /**
     * Standard-Konstruktor.
     */
    public Queue()
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
     * Testet, ob die Schlange leer ist.
     * 
     * @return <code>true</code>, falls die Schlange keine Elemente enthaelt.
     */
    public boolean isEmpty()
    {
        return getSize() == 0;
    }

    /**
     * Kapazit&auml;ts-Test der Schlange.
     * 
     * @return <code>true</code>, falls die Schlange voll ist.
     */
    public boolean isFull()
    {
        return getSize() == MAX_SIZE;
    }

    /**
     * Liefert die aktuelle Anzahl der Schlangenelemente.
     * 
     * @return Die Queue-Size.
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
     * Rueckgabe des ersten Elementes bei einer nicht leeren Schlange.
     * 
     * @return <code>int</code>-Wert des ersten Elements.
     */
    public int front()
    {
        return isEmpty() ? -1 : list.getElementAt(1).getValue();
    }

    /**
     * Einen Wert hinten an die Schlange anstellen, falls noch Platz ist.
     * 
     * @param value
     *            Der <code>int</code>-Wert, der angestellt werden soll.
     */
    public void enqueue(int value)
    {
        if (!isFull() && value >= 0)
        {
            list.insertAtTheEnd(new ValueElement("Element" + value, value));
        }
    }

    /**
     * Entnahme und Loeschung des ersten Elements der Schlange.
     * 
     * @return Den <code>int</code>-Wert des ersten Elements oder -1 
     *  bei einer leeren Schlange.
     */
    public int dequeue()
    {
        if (isEmpty())
        {
            return -1;
        }
        int res = list.getElementAt(1).getValue();
        list.deleteFirstOf(list.getElementAt(1));
        return res;
    }
}
