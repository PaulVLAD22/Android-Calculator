package io.github.paulvlad22.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // widgets
    private Button zero,one,two,three,four,five,six,seven,eight,nine,add,sub,mul,div,equal,clear;
    private TextView info,result;
    // variables for logic
    private final char ADD = '+';
    private final char SUB = '-';
    private final char MULTI = '*';
    private final char DIV = '/';
    private final char EQUAL = 0;
    private double val1 = Double.NaN; // no value
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widgetsRead();

        // setting up button functions to Display Number In TextView
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });

        // Calculate result on action type button click and TextView editing

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = SUB;
                result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = ADD;
                result.setText(String.valueOf(val1) + "+");
                info.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = MULTI;
                result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = DIV;
                result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                ACTION = EQUAL;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(String.valueOf(val1));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

    }

    private void widgetsRead(){
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        mul = (Button)findViewById(R.id.btnmul);
        div = (Button)findViewById(R.id.btndivide);
        equal = (Button)findViewById(R.id.btnequal);
        info = (TextView)findViewById(R.id.tvControl);
        result = (TextView)findViewById(R.id.tvResult);
        clear = (Button)findViewById(R.id.btnclear);
    }

    private void calculate(){
        // if we already introduced another value before and just PRESSED A ACTION TYPE BUTTON
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch(ACTION){
                case ADD:
                    val1 = val1 + val2;
                    break;
                case SUB:
                    val1 = val1 - val2;
                    break;
                case MULTI:
                    val1 = val1 * val2;
                    break;
                case DIV:
                    val1 = val1 / val2;
                    break;
                case EQUAL:
                    break;
            }
        }
        else{
            // if we're introducing the first value
            val1 = Double.parseDouble(info.getText().toString());
        }
    }

}