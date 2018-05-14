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

} //end ConcreteAggregate
