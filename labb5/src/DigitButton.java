public class DigitButton extends CalculatorButton {

    public DigitButton(String string, Situation situation) {
        super(string, situation);
    }

    @Override
    public void transition() {
        switch(this.situation.state) {
            case HasResult:
                this.situation.state = State.Input1;
                this.situation.setDisplay(Integer.parseInt(this.label));
                break;
            case Input1:
                int value1 = this.situation.getDisplay();    
                value1 = value1 * 10 + Integer.parseInt(this.label);
                this.situation.setDisplay(value1);
                break;
            case Input2:
                int value2 = this.situation.getDisplay();    
                value2 = value2 * 10 + Integer.parseInt(this.label);
                this.situation.setDisplay(value2);
                break;
            case OpReady:
                this.situation.leftOperand = this.situation.getDisplay();
                this.situation.state = State.Input2;
                this.situation.setDisplay(Integer.parseInt(this.label));
                break;
            default:
                break;

        }
    }
}
