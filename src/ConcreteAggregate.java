public class ConcreteAggregate implements Aggregate {
    public Movimiento head;

    public ConcreteAggregate() {
        head = null;
    } //end ConcreteAggregate

    public void add(Movimiento anObject) {
        Movimiento aNode;
        if (head == null) {
            head = anObject;
        } //end if
        else {
            aNode = head;
            while (aNode.next != null) {
                aNode = aNode.next;
            } //end while
            aNode.next = anObject;
        } //end else
    } //end add

    public Iterator createIterator() {
        return new ConcreteIterator(this);
    } //end createIterator

    public String toString() {
        Movimiento current = head;
        String movimientos = "";
        if (current != null) {
            while (current.next != null) {
                movimientos += current.toString();
                current = current.next;
            } //end while
            movimientos += current.toString();
        } //end if
        return movimientos;
    } //end toString

} //end ConcreteAggregate
