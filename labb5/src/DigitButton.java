// Anton Nystrom Malcolm Ovin
public class DigitButton extends CalculatorButton {

    public DigitButton(String string, Situation situation) {
        super(string, situation);
    }

    @Override
    public void transition() {
        switch(this.situation.state) {
            case HasResult:
                // Gå till Input1 och sätt displayen till denna knapps värde
                this.situation.state = State.Input1;
                this.situation.setDisplay(Integer.parseInt(this.label));
                break;
            case Input1:
                // Lägg till en siffra på slutet av displayen
                int value1 = this.situation.getDisplay();    
                value1 = value1 * 10 + Integer.parseInt(this.label);
                this.situation.setDisplay(value1);
                break;
            case Input2:
                // Lägg till en siffra på slutet av displayen
                int value2 = this.situation.getDisplay();    
                value2 = value2 * 10 + Integer.parseInt(this.label);
                this.situation.setDisplay(value2);
                break;
            case OpReady:
                // Gå till Input2 och spara displayens värde
                this.situation.state = State.Input2;
                this.situation.leftOperand = this.situation.getDisplay();
                // Sedan sätt displayen till denna knapps värde
                this.situation.setDisplay(Integer.parseInt(this.label));
                break;
            default:
                break;
        }
    }
}
