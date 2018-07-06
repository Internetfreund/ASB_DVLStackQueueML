package implementierung;

import schnittstellen.*;

/**
 * Musterloesung der Klasse List der ASB-Programmieraufgabe.
 *
 */
public class List implements IList
{
    // Objektattribut fuer den Listenkopf
    private IListElement kopf;

    /**
     * Der Standard-Konstruktor instantiiert ein <code>ValueElement</code> und
     * ein <code>ListElement</code> zur Repraesentation des Kopfes.
     */
    public List()
    {
        kopf = new ListElement(new ValueElement("Kopf", 0));
    }

    /**
     * Liefert das aktuelle Kopfelement.
     * 
     * @return Den Listenkopf.
     */
    public IListElement getHead()
    {
        return kopf;
    }

    /**
     * Anfuegen eines neuen Elementes mit dem uebergebenen Wert am Ende
     * der Liste. Es sind 2 Faelle zu unterscheiden: 
     * - leere Liste: Das neue Element ist Nachfolger von kopf.
     * - gefuellte Liste: Der Vorgaenger des neuen Elements wird der 
     *   Vorgaenger von kopf.
     * 
     * @param value
     *            Wert des anzufuegenden Elements.
     */
    public void insertAtTheEnd(IValueElement value)
    {
        IListElement neu = new ListElement(value);
        neu.setPredecessor(kopf.getPredecessor() == null ? kopf : kopf.getPredecessor());
        (kopf.getPredecessor() == null ? kopf : kopf.getPredecessor()).setSuccessor(neu);
        kopf.setPredecessor(neu);
    }

    /**
     * Fuegt ein Element an der uebergebenen Position ein. Unterscheidung: 
     * - Das neue Element wird am Listenende angefuegt 
     * - an der gewuenschten Position eingefuegt.
     * 
     * @param pos
     *            Die Einfuegeposition.
     * @param value
     *            Wert des einzufuegenden Elements.
     */
    public void insertAtPos(int pos, IValueElement value)
    {
        int i = 1;
        IListElement element = kopf;
        pos = pos < 1 ? 1 : pos;
        IListElement neu = new ListElement(value);

        while(element.getSuccessor() != null && i < pos) 
        {
            element = element.getSuccessor();
            ++i;
        }
        neu.setPredecessor(element);
        if (kopf.getPredecessor() == null || kopf.getPredecessor() == element)
        {
            kopf.setPredecessor(neu);
        }
        else
        {
            element.getSuccessor().setPredecessor(neu);
            neu.setSuccessor(element.getSuccessor());
        }
        element.setSuccessor(neu);
    }

    /**
     * Liefert das Element, welches sich an der Stelle <code>position</code> in
     * der Liste befindet oder <code>null</code>. Der Dummy steht an Position 0.
     * 
     * @param position
     *            Die Elementposition.
     * @return Das Element an &uuml;bergebener Position, falls vorhanden.
     */
    public IValueElement getElementAt(int position)
    {
        if (position < 1)
        {
            return null;
        }
        int i = 1;
        for (IListElement tmp = kopf.getSuccessor(); tmp != null; tmp = tmp.getSuccessor(), i++)
        {
            if (i == position)
            {
                return tmp.getValueElement();
            }
        }
        return null;
    }

    /**
     * Liefert die erste Position an der sich der uebergebene Wert vom Typ
     * <code>IValueElement</code> befindet und -1, falls sieser Wert nicht in
     * der Liste vorkommt.
     * 
     * @param value
     *            Zu suchender Wert.
     * @return Position des zu suchenden Wertes.
     */
    public int getFirstPosOf(IValueElement value)
    {
        int i = 1;
        for (IListElement tmp = kopf.getSuccessor(); tmp != null; tmp = tmp.getSuccessor(), i++)
        {
            if (tmp.getValueElement() == value)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Entfernt das erste gefundene Listenelement, welches dem Parameter
     * entspricht (Referenzvergleich).
     * 
     * @param value
     *            Zu loeschendes <code>IValueElement</code>.
     */
    public void deleteFirstOf(IValueElement value)
    {
        for (IListElement tmp = kopf.getSuccessor(); tmp != null; tmp = tmp.getSuccessor())
        {
            if (tmp.getValueElement() == value)
            {
                tmp.getPredecessor().setSuccessor(tmp.getSuccessor());
                if (tmp.getSuccessor() == null)
                {
                    // letztes Element
                    kopf.setPredecessor(tmp.getPredecessor() == kopf ? null : tmp.getPredecessor());
                }
                else
                {
                    tmp.getSuccessor().setPredecessor(tmp.getPredecessor());
                }
                return;
            }
        }
    }

    /**
     * Entfernt alle gefundenen Listenelemente, welche dem Parameter entsprechen
     * (Referenzvergleich).
     * 
     * @param value
     *            Zu loeschendes <code>IValueElement</code>.
     */
    public void deleteAllOf(IValueElement value)
    {
        for (IListElement tmp = kopf.getSuccessor(); tmp != null; tmp = tmp.getSuccessor())
        {
            deleteFirstOf(value);
        }
    }

    /**
     * ueberueft, ob das Element in der Liste enthalten ist.
     * 
     * @param value
     *            Zu suchender Wert.
     * @return <code>true</code>, falls der Wert in der Liste gefunden wird.
     */
    public boolean member(IValueElement value)
    {
        return this.getFirstPosOf(value) != -1;
    }

    /**
     * Spiegeln der Liste. Es werden nur die Elementevorgaenger und -nachfolger
     * miteinander vertauscht. Zu beachten ist, dass der Vorgaenger von Kopf nun
     * auf das 1. Listenelement verweist.
     */
    public void reverse()
    {
        if (kopf.getSuccessor() != null)
        {
            for (IListElement current = kopf;;)
            {
                IListElement next = current.getSuccessor();
                IListElement tmp = current.getPredecessor();
                current.setPredecessor(current.getSuccessor());
                current.setSuccessor(tmp);
                if (next == null)
                {
                    current.setPredecessor(kopf);
                    kopf.getPredecessor().setSuccessor(null);
                    return;
                }
                current = next;
            }
        }
    }

    /**
     * Ausgabe einer Stringrepr&auml;sentation der kompletten Liste.
     * 
     * @return Eine Stringrepr&auml;sentation.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (IListElement tmp = kopf.getSuccessor(); tmp != null; tmp = tmp.getSuccessor())
        {
            sb.append(tmp.getValueElement());
        }
        return sb.toString();
    }
}
