public interface Aggregate {
    Iterator createIterator();

    void add(Movimiento anObject);
} //end Aggregate
