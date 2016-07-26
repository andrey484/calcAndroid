package com.example.andrey.kal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.andrey.kal.Const.*;

public class MainActivity extends AppCompatActivity {

    private Button erase;
    private Button zero;
    private Button point;
    private Button mool;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button div;
    private Button four;
    private Button five;
    private Button six;
    private Button minus;
    private Button one;
    private Button two;
    private Button three;
    private Button plus;
    private Button equal;
    private TextView result;
    private boolean checkPoint = false;
    private String expressionString = "";

    private ArrayList<String> expression = new ArrayList<>();

    private final String[] constSymbol = new String[]{"+", "*", "/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        clickListener();
    }

    public void init() {
        erase = (Button) findViewById(R.id.erase);
        zero = (Button) findViewById(R.id.zero);
        point = (Button) findViewById(R.id.point);
        mool = (Button) findViewById(R.id.mool);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        div = (Button) findViewById(R.id.div);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        minus = (Button) findViewById(R.id.minus);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        plus = (Button) findViewById(R.id.plus);
        equal = (Button) findViewById(R.id.equal);
        result = (TextView) findViewById(R.id.result);
    }

    public void clickListener() {
        erase.setOnClickListener(v -> erase());
        zero.setOnClickListener(v -> textInput("0"));
        point.setOnClickListener(v -> textInput("."));
        mool.setOnClickListener(v -> textInput("*"));
        seven.setOnClickListener(v -> textInput("7"));
        eight.setOnClickListener(v -> textInput("8"));
        nine.setOnClickListener(v -> textInput("9"));
        div.setOnClickListener(v -> textInput("/"));
        four.setOnClickListener(v -> textInput("4"));
        five.setOnClickListener(v -> textInput("5"));
        six.setOnClickListener(v -> textInput("6"));
        minus.setOnClickListener(v -> textInput("-"));
        one.setOnClickListener(v -> textInput("1"));
        two.setOnClickListener(v -> textInput("2"));
        three.setOnClickListener(v -> textInput("3"));
        plus.setOnClickListener(v -> textInput("+"));
        equal.setOnClickListener(v -> equal());
    }

    public void erase() {
        expression.remove(expression.size() - 1);
    }

    public void equal() {
        parseSc();
    }



    public void textInput(String symbol) {

        expressionString = "";
                for (int i = 0; i < constSymbol.length; i++) {
                    if (symbol.equals(constSymbol[i])) {
                        if (expression.size() < 1) {
                            return;
                        } else {
                            if (check(expression.get(expression.size() - 1)) || expression.get(expression.size() - 1).equals(MINUS) ||expression.get(expression.size()-1).equals(POINT))
                                return;

                        }

                    }
                    if (symbol.equals(MINUS)) {
                        if (expression.size() == 0) {
                            expression.add(MINUS);
                            return;
                        }
                        try {
                            if (expression.get(expression.size() - 2).equals(MINUS) && expression.get(expression.size() - 1).equals(MINUS) || check(expression.get(expression.size() - 2))||expression.get(expression.size()-1).equals(POINT))
                                return;
                        } catch (Exception e) {

                        }
                    }
                }

                if(symbol.equals(POINT)){
                    if(expression.size()==0)
                        return;
                    else {
                        if(check(expression.get(expression.size()-1))||expression.get(expression.size()-1).equals(POINT)
                                ||expression.get(expression.size()-1).equals(MINUS))
                            return;
                    }
                }
                if(expression.size()>1){
                    if(expression.get(expression.size()-1).equals(MINUS)&&symbol.equals(MINUS)) {
                        expression.remove(expression.size() - 1);
                        symbol = PLUS;
                    }
                    if(expression.get(expression.size()-1).equals(PLUS)&&symbol.equals(MINUS)) {
                        expression.remove(expression.size() - 1);
                        symbol = MINUS;
                    }
                    if(expression.get(expression.size()-1).equals(MINUS)&&symbol.equals(PLUS)) {
                        expression.remove(expression.size() - 1);
                        symbol = MINUS;
                    }
                }
                expression.add(symbol);


        if (expression.size() != 0) {
            for (int i = 0; i < expression.size(); ++i)
                expressionString += expression.get(i);

        }

        result.setText(expressionString);
    }


    public boolean check(String symbol){
        for(int i =0;i<constSymbol.length;i++){
            if(symbol.equals(constSymbol[i]))
                return true;

        }
        return false;
    }

    private void parseSc() {
        for(int i = 0;i<expressionString.length();i++){
            
        }
    }

}
