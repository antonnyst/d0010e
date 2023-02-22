// Anton Nystrom Malcolm Ovin
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
                // Gå till OpReady och tänd operatorn
                this.situation.state = State.OpReady;
                this.setColor(CalculatorButton.HIGHLIGHT_COLOR);
                // Samt sätt vald operator till denna 
                this.situation.binaryOperator = this;
                break;
            case Input1:
                // Gå till OpReady och tänd operatorn
                this.situation.state = State.OpReady;
                this.setColor(CalculatorButton.HIGHLIGHT_COLOR);
                // Samt sätt vald operator till denna
                this.situation.binaryOperator = this;
                break;
            case Input2:
                // Gör inget
                break;
            case OpReady:
                // Släck tidigare vald operator
                this.situation.binaryOperator.setColor(CalculatorButton.DEFAULT_COLOR);
                // Sätt vald operator till denna
                this.situation.binaryOperator = this;
                // Tänd denna operator
                this.setColor(CalculatorButton.HIGHLIGHT_COLOR);
                break;
            default:
                break;
        }
    }

    public int result(int a, int b) {
        return this.op.applyAsInt(a, b);
    }
}
