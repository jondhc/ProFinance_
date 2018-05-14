public class ConcreteIterator implements Iterator {

    ConcreteAggregate myList;
    Movimiento current;

    public ConcreteIterator(ConcreteAggregate anObject) {
        myList = anObject;
        current = myList.head;
    } //end ConcreteIterator

    public Object first() {
        if (myList.head != null) {
            return myList.head;
        } //end if
        else {
            return null;
        } //end else
    } //end first

    public Object next() {
        Object nextObject = current.next;
        current = current.next;
        return nextObject;
    } //end next

    public Object currentItem() {
        Movimiento current = myList.head;
        while (current.next != null) {
            current = current.next;
        } //end if
        return current;
    } //end currentItem

    public boolean isDone() {
        while (current.next != null) {
            return true;
        } //end while
        return false;
    } //end isDone

    public int Size() {
        int size = 0;
        Movimiento element;
        element = myList.head;
        if (element != null) {
            size = 1;
            while (element.next != null) {
                size += 1;
                element = element.next;
            } //end while
        } //end if
        else {
            size = 0;
        } //end else
        return size;
    } //end Size

} //end ConcreteIterator
