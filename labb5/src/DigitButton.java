public class DigitButton extends CalculatorButton {

    public DigitButton(String string, Situation situation) {
        super(string, situation);
    }

    @Override
    public void transition() {

        System.out.println("hej");
    }

    @Override
    public void setColor() {

    }

    @Override
    public String toString() {
        return null;
    }

}
