package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView input, output, operators;
    Button one, two, three, four, five, six;
    Button seven, eight, nine, zero, allclear, delete;
    Button plus, substract, multiply, divide, percentage,equal;
    Double num1 , num2;
    boolean isDot = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operators=findViewById(R.id.operators);
        input=findViewById(R.id.input);
        output=findViewById(R.id.output);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        allclear=findViewById(R.id.allclear);
        delete=findViewById(R.id.delete);
        percentage=findViewById(R.id.percentage);
        divide=findViewById(R.id.divide);
        multiply=findViewById(R.id.multiply);
        substract=findViewById(R.id.subsrtact);
        plus=findViewById(R.id.plus);
        equal=findViewById(R.id.equal);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().toString().equals("0"))
                {
                    input.setText("1");
                }else{
                    input.append("1");
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().toString().equals("0"))
                {
                    input.setText("2");
                }else{
                    input.append("2");
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().toString().equals("0"))
                {
                    input.setText("3");
                }else{
                    input.append("3");
                }            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().toString().equals("0"))
                {
                    input.setText("4");
                }else{
                    input.append("4");
                }            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().toString().equals("0"))
                {
                    input.setText("5");
                }else{
                    input.append("5");
                }            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().toString().equals("0"))
                {
                    input.setText("6");
                }else{
                    input.append("6");
                }            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().toString().equals("0"))
                {
                    input.setText("7");
                }else{
                    input.append("7");
                }            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().toString().equals("0"))
                {
                    input.setText("8");
                }else{
                    input.append("8");
                }            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input.getText().toString().equals("0"))
                {
                    input.setText("9");
                }else{
                    input.append("9");
                }            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input.getText().toString().equals("0"))
                {
                    input.setText("0");
                }else{
                    input.append("0");
                }            }
        });

        allclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("0");
                operators.setText("");
                output.setText("0");
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = input.getText().toString();
                if(str.length()==1)
                {
                    input.setText("0");
                    output.setText("0");
                }else
                {
                    str= str.substring(0, str.length()-1);
                    input.setText(str);
                }
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().toString().equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
                }
                else {

                          num1 = Double.parseDouble(input.getText().toString());
                          input.setText("0");
                          operators.setText("+");

                }
            }
        });

        substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().toString().equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
                }
                else {

                    num1 = Double.parseDouble(input.getText().toString());
                    input.setText("0");
                    operators.setText("-");


                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().toString().equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
                }
                else {

                    num1 = Double.parseDouble(input.getText().toString());
                    input.setText("0");
                    operators.setText("×");


                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().toString().equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Please Enter Value", Toast.LENGTH_SHORT).show();
                }
                else {

                    num1 = Double.parseDouble(input.getText().toString());
                    input.setText("0");
                    operators.setText("/");



                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num2= Double.valueOf(input.getText().toString());
              //  if(operators.getText().toString().equals("×")) {getResult(num1,num2,"*");}
                   getResult(num1,num2,operators.getText().toString());
            }
        });
    }

    private  void getResult(double a, double b, String operator)
    {
        switch (operator)
        {

            case "+" :

                output.setText(String.valueOf(a+b));
                input.setText("0");

                break;
            case  "-" :

                output.setText(String.valueOf(a-b));
                input.setText("0");

                break;
            case "×" :

                output.setText(String.valueOf(a*b));
                input.setText("0");

                break;
            case "/" :
                if(num2 == 0)
                {
                    output.setText("null");
                    input.setText("0");

                }
                else
                output.setText(String.valueOf(a/b));
                input.setText("0");

                break;

            case  "%" :
                output.setText(String.valueOf((a*b)/100));
                input.setText("0");
        }

    }
}
