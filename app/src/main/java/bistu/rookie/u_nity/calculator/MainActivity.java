package bistu.rookie.u_nity.calculator;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int DEFAULT_FRACTIONDIGITS = 6;
    NumberFormat nf = NumberFormat.getNumberInstance();

    enum OperatorEnum {
        op_plus, op_substract, op_multiply, op_divide, op_none;
    }

    OperatorEnum operateor = OperatorEnum.op_none;

    double[] number = new double[3];
    int currentNumber = 0;
    double result = 0;
    int poweredNumber = 0;
    int sign = 1;

    int digit1 = 0;
    int digit2 = 0;
    int currentIntegerDigit = 0;
    int currentFractionDigit = 0;

    boolean isEditIntegerPart = true;
    boolean hasChosenOperator = false;
    boolean hasEdited = false;
    boolean isPowering = false;
    boolean isMinus = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nf.setMaximumFractionDigits(DEFAULT_FRACTIONDIGITS);

        final TextView display = (TextView) findViewById(R.id.Display);

        Button zero = (Button) findViewById(R.id.Zero);
        Button one = (Button) findViewById(R.id.One);
        Button two = (Button) findViewById(R.id.Two);
        Button three = (Button) findViewById(R.id.Three);
        Button four = (Button) findViewById(R.id.Four);
        Button five = (Button) findViewById(R.id.Five);
        Button six = (Button) findViewById(R.id.Six);
        Button seven = (Button) findViewById(R.id.Seven);
        Button eight = (Button) findViewById(R.id.Eight);
        Button nine = (Button) findViewById(R.id.Nine);

        Button minus = (Button) findViewById(R.id.Minus);
        final Button clear = (Button) findViewById(R.id.Clear);
        Button plus = (Button) findViewById(R.id.Plus);
        Button substract = (Button) findViewById(R.id.Subtract);
        Button multiply = (Button) findViewById(R.id.Multiply);
        Button divide = (Button) findViewById(R.id.Divide);
        Button equal = (Button) findViewById(R.id.Equal);
        Button decimal = (Button) findViewById(R.id.Decimal);

        Button sin = (Button) findViewById(R.id.Sin);
        Button cos = (Button) findViewById(R.id.Cos);
        Button power = (Button) findViewById(R.id.Power);

        Button bin = (Button) findViewById(R.id.Bin);
        Button oct = (Button) findViewById(R.id.Oct);
        Button hex = (Button) findViewById(R.id.Hex);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIntegerDigit != 0 && isEditIntegerPart) {
                    inputIntegerPart(0);
                } else if (!isEditIntegerPart) {
                    inputFractionPart(0);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(1);
                } else {
                    inputFractionPart(1);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(2);
                } else {
                    inputFractionPart(2);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(3);
                } else {
                    inputFractionPart(3);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(4);
                } else {
                    inputFractionPart(4);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(5);
                } else {
                    inputFractionPart(5);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(6);
                } else {
                    inputFractionPart(6);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(7);
                } else {
                    inputFractionPart(7);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(8);
                } else {
                    inputFractionPart(8);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditIntegerPart) {
                    inputIntegerPart(9);
                } else {
                    inputFractionPart(9);
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEditIntegerPart = false;
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isMinus) {
                    number[currentNumber] *= -1;
                    isMinus = true;
                    sign = -1;
                } else {
                    number[currentNumber] *= -1;
                    isMinus = false;
                    sign = 1;
                }
                display.setText(nf.format(number[currentNumber]));
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNumber == 0) {
                    hasEdited = false;
                }
                if (hasEdited && currentNumber == 1) {
                    operate();
                    display.setText(nf.format(number[0]));
                }
                if (hasChosenOperator) {
                    operateor = OperatorEnum.op_plus;
                } else {
                    hasChosenOperator = true;
                    operateor = OperatorEnum.op_plus;
                    changeCurrentNumber();
                    resetEdit();
                }
            }
        });

        substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNumber == 0) {
                    hasEdited = false;
                }
                if (hasEdited && currentNumber == 1) {
                    operate();
                    display.setText(nf.format(number[0]));
                }
                if (hasChosenOperator) {
                    operateor = OperatorEnum.op_substract;
                } else {
                    hasChosenOperator = true;
                    operateor = OperatorEnum.op_substract;
                    changeCurrentNumber();
                    resetEdit();
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNumber == 0) {
                    hasEdited = false;
                }
                if (hasEdited && currentNumber == 1) {
                    operate();
                    display.setText(nf.format(number[0]));
                }
                if (hasChosenOperator) {
                    operateor = OperatorEnum.op_multiply;
                } else {
                    hasChosenOperator = true;
                    operateor = OperatorEnum.op_multiply;
                    changeCurrentNumber();
                    resetEdit();
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNumber == 0) {
                    hasEdited = false;
                }
                if (hasEdited && currentNumber == 1) {
                    operate();
                    display.setText(nf.format(number[0]));
                }
                if (hasChosenOperator) {
                    operateor = OperatorEnum.op_divide;
                } else {
                    hasChosenOperator = true;
                    operateor = OperatorEnum.op_divide;
                    changeCurrentNumber();
                    resetEdit();
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPowering) {
                    number[poweredNumber] = Math.pow(number[poweredNumber], number[currentNumber]);
                    currentNumber = poweredNumber;
                    number[2] = 0;
                    display.setText(nf.format(number[currentNumber]));
                    isPowering = false;
                }
                operate();
                display.setText(nf.format(number[0]));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll();
                display.setText(nf.format(number[currentNumber]));
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number[currentNumber] = Math.sin(Math.toRadians(number[currentNumber]));
                display.setText(nf.format(number[currentNumber]));
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number[currentNumber] = Math.cos(Math.toRadians(number[currentNumber]));
                display.setText(nf.format(number[currentNumber]));
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPowering = true;
                poweredNumber = currentNumber;
                currentNumber = 2;
                display.setText(nf.format(number[currentNumber]));
            }
        });

        bin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(Integer.toBinaryString((int) number[currentNumber]));
            }
        });

        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(Integer.toOctalString((int) number[currentNumber]));
            }
        });

        hex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(Integer.toHexString((int) number[currentNumber]));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Menu_Help:
                Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Menu_Exit:
                this.finish();
                break;
        }
        return false;
    }

    void inputIntegerPart(int num) {
        number[currentNumber] = number[currentNumber] * 10 + num * sign;
        currentIntegerDigit++;
        if (!hasEdited)
            hasEdited = true;
    }

    void inputFractionPart(double num) {
        currentFractionDigit++;
        number[currentNumber] += sign * num * Math.pow(0.1, currentFractionDigit);
        nf.setMinimumFractionDigits(currentFractionDigit);
        if (!hasEdited)
            hasEdited = true;
    }

    void changeCurrentNumber() {
        currentNumber = 1;
    }

    void operate() {
        nf.setMinimumFractionDigits(0);
        switch (operateor) {
            case op_plus:
                result = number[0] + number[1];
                break;
            case op_substract:
                result = number[0] - number[1];
                break;
            case op_multiply:
                result = number[0] * number[1];
                break;
            case op_divide:
                if (number[1] == 0) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                    resetAll();
                    return;
                }
                result = number[0] / number[1];
                break;
            case op_none:
                return;
        }
        resetEdit();
        number[0] = result;
    }

    void resetEdit() {
        number[1] = 0;
        currentNumber = 1;
        currentIntegerDigit = 0;
        currentFractionDigit = 0;
        sign = 1;
        isEditIntegerPart = true;
        hasEdited = false;
        isMinus = false;
        nf.setMinimumFractionDigits(currentFractionDigit);
    }

    void resetAll() {
        operateor = OperatorEnum.op_none;

        number[0] = 0;
        number[1] = 0;
        currentNumber = 0;
        sign = 1;

        currentIntegerDigit = 0;
        currentFractionDigit = 0;

        isEditIntegerPart = true;
        hasChosenOperator = false;
        hasEdited = false;
        isPowering = false;
        isMinus = false;
        nf.setMinimumFractionDigits(currentFractionDigit);
    }

}
