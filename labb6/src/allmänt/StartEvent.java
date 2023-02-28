package allmänt;

public class StartEvent extends Event {
    public StartEvent(State state, EventQueue queue) {
        super(state, queue, 0);
    }

    @Override
    public void runEvent() {
        super.runEvent();
    }
}
