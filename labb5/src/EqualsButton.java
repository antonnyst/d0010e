// Anton Nystrom Malcolm Ovin
import java.awt.Color;

public class EqualsButton extends CalculatorButton {

    public EqualsButton(String label, Situation situation) {
        super(label, situation);
    }

    @Override
    public void transition() {
        switch(this.situation.state) {
            case HasResult:
                // Do nothing
                break;
            case Input1:
                // Do nothing
                break;
            case Input2:
                this.situation.state = State.HasResult;
                this.situation.binaryOperator.setColor(Color.WHITE);
                this.situation.setDisplay(
                    this.situation.binaryOperator.result(
                        this.situation.leftOperand, 
                        this.situation.getDisplay()
                    )
                );
                break;
            case OpReady:
                // Do nothing
                break;
            default:
                break;

        }
    }
    
}
