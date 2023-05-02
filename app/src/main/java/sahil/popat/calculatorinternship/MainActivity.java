package sahil.popat.calculatorinternship;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentNumber = "";
    private String operation = "";
    private double firstNumber = 0;
    private double secondNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.displayTextView);

        Button button00 = findViewById(R.id.button00);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonModule = findViewById(R.id.buttonModule);
        Button buttonEquals = findViewById(R.id.buttonEquals);

        button00.setOnClickListener(v -> numberClicked("00"));
        button0.setOnClickListener(v -> numberClicked("0"));
        button1.setOnClickListener(v -> numberClicked("1"));
        button2.setOnClickListener(v -> numberClicked("2"));
        button3.setOnClickListener(v -> numberClicked("3"));
        button4.setOnClickListener(v -> numberClicked("4"));
        button5.setOnClickListener(v -> numberClicked("5"));
        button6.setOnClickListener(v -> numberClicked("6"));
        button7.setOnClickListener(v -> numberClicked("7"));
        button8.setOnClickListener(v -> numberClicked("8"));
        button9.setOnClickListener(v -> numberClicked("9"));
        buttonDot.setOnClickListener(v -> numberClicked("."));

        buttonPlus.setOnClickListener(v -> operationClicked("+"));
        buttonMinus.setOnClickListener(v -> operationClicked("-"));
        buttonMultiply.setOnClickListener(v -> operationClicked("*"));
        buttonDivide.setOnClickListener(v -> operationClicked("/"));
        buttonModule.setOnClickListener(v -> operationClicked("%"));

        buttonEquals.setOnClickListener(v -> equalsClicked());

        buttonBack.setOnClickListener(v -> clearClicked());

        buttonClear.setOnClickListener(v -> clearClicked());
    }
    private void numberClicked(String number) {
        currentNumber += number;
        resultTextView.setText(currentNumber);
    }
    private void operationClicked(String operation) {
        if (currentNumber.isEmpty()) { return; }
        this.operation = operation;
        firstNumber = Double.parseDouble(currentNumber);
        currentNumber = "";
    }
    private void equalsClicked() {
        if (currentNumber.isEmpty()) { return; }
        secondNumber = Double.parseDouble(currentNumber);

        switch (operation) {
            case "+":
                firstNumber += secondNumber;
                break;
            case "-":
                firstNumber -= secondNumber;
                break;
            case "*":
                firstNumber *= secondNumber;
                break;
            case "/":
                firstNumber /= secondNumber;
                break;
            case "%":
                firstNumber %= secondNumber;
                break;
        }
        currentNumber = String.valueOf(firstNumber);
        resultTextView.setText(currentNumber);
    }
    private void clearClicked() {
        currentNumber = "";
        operation = "";
        firstNumber = 0;
        secondNumber = 0;
        resultTextView.setText("0");
    }
}