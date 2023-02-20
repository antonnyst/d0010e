import java.awt.Color;
import java.util.function.IntBinaryOperator;

public class BinOpButton extends CalculatorButton {

    private IntBinaryOperator op;

    public BinOpButton(String label, Situation situation, IntBinaryOperator op) {
        super(label, situation);
        this.op = op;
    }

    @Override
    public void transition() {
        switch(this.situation.state) {
            case HasResult:
                this.situation.state = State.OpReady;
                this.setColor(Color.RED);
                this.situation.binaryOperator = this;
                this.situation.leftOperand = this.situation.getDisplay();
                break;
            case Input1:
                this.setColor(Color.RED);
                this.situation.state = State.OpReady;
                this.situation.binaryOperator = this;
                break;
            case Input2:
                // Do nothing2
                break;
            case OpReady:
                this.situation.binaryOperator.setColor(Color.WHITE);
                this.situation.binaryOperator = this;
                this.setColor(Color.RED);
                break;
            default:
                break;

        }
    }

    public int result(int a, int b) {
        return this.op.applyAsInt(a, b);
    }

}
