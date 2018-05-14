public class Memento {

    Aggregate state;

    public Memento(Aggregate aState) {
        state = aState;
    } //end Memento

    public Aggregate getState() {
        return state;
    } //end getState

    public void setstate(Aggregate aState) {
        state = aState;
    } //end setState

} //end Memento