package schnittstellen;

/**
 * Schnittstellendefinition f&uuml;r ein Listenelement.
 * 
 */
public interface IListElement
{
    /**
     * Value-Getter
     * 
     * @return Den Wert des Elements.
     */
    public IValueElement getValueElement();

    /**
     * Value-Setter
     * 
     * @param value
     *            Der neue Wert.
     */
    public void setValueElement(IValueElement value);

    /**
     * Vorg&auml;nger-Getter
     * 
     * @return Den Vorg&auml;nger des Elementes.
     */
    public IListElement getPredecessor();

    /**
     * Vorg&auml;nger-Setter
     * 
     * @param predecessor
     *            Der neue Vorg&auml;nger.
     */
    public void setPredecessor(IListElement predecessor);

    /**
     * Nachfolger-Getter
     * 
     * @return Den Nachfolger des Elements.
     */
    public IListElement getSuccessor();

    /**
     * Nachfolger-Setter
     * 
     * @param successor
     *            Der neue Nachfolger.
     */
    public void setSuccessor(IListElement successor);
}