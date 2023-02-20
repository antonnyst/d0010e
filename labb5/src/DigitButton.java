public class DigitButton extends CalculatorButton {

    public DigitButton(String string, Situation situation) {
        super(string, situation);
    }

    @Override
    public void transition() {
        this.situation.display.setText(this.toString());
        System.out.println("hej" + this.toString());
    }

}
