package com.arash.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.arash.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    double Res;
    double temp1;
    double temp2;

    TextView res;
    String operator = "";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding;
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        res = findViewById(R.id.number);
        binding.clear.setOnClickListener(view1 -> {
            binding.number.setText("0");
            Res = 0;
            temp1 = 0;
            temp2 = 0;
            operator = "";
        });
        binding.dot.setOnClickListener(view12 -> {
            if(!res.getText().toString().contains(".")){
                res.setText(res.getText().toString().trim()+".");
            }
            else {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        binding.zero.setOnClickListener(this);
        binding.one.setOnClickListener(this);
        binding.two.setOnClickListener(this);
        binding.three.setOnClickListener(this);
        binding.four.setOnClickListener(this);
        binding.five.setOnClickListener(this);
        binding.six.setOnClickListener(this);
        binding.seven.setOnClickListener(this);
        binding.eight.setOnClickListener(this);
        binding.nine.setOnClickListener(this);
        binding.plus.setOnClickListener(this);
        binding.radical.setOnClickListener(view13 -> {
            Double z= Double.parseDouble(res.getText().toString());
            if (z>0){
                double root = Math.sqrt(z);
                res.setText(Double.toString(Math.round(root*10000.0)/10000.0));
            }
            else if (z==0){
                res.setText("0");
            }
            else {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        binding.pow.setOnClickListener(view14 -> {
            Double z= Double.parseDouble(res.getText().toString().trim());
            double pow = Math.pow(z,2);
            res.setText(Double.toString(Math.round(pow*10000.0)/10000.0));

        });
        binding.plus.setOnClickListener(view15 -> {
            if (operator.equals("")){
                temp1 = Double.parseDouble(res.getText().toString().trim());
                res.setText("0");
                operator = operator + "+";
            }
            else{
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        binding.minus.setOnClickListener(view16 -> {
            if (operator.equals("")){
                temp1 = Double.parseDouble(res.getText().toString().trim());
                res.setText("0");
                operator = operator + "-";
            }
            else{
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        binding.division.setOnClickListener(view17 -> {
            if (operator.equals("")){
                temp1 = Double.parseDouble(res.getText().toString().trim());
                res.setText("0");
                operator = operator + "/";
            }
            else{
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        binding.mul.setOnClickListener(view19 -> {
            if (operator.equals("")){
                temp1 = Double.parseDouble(res.getText().toString().trim());
                res.setText("0");
                operator = operator + "*";
            }
            else{
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
        binding.res.setOnClickListener(view18 -> {
            temp2 = Double.parseDouble(res.getText().toString().trim());
            switch (operator) {
                case "+":
                    res.setText(Double.toString((temp1 + temp2)));
                    operator = "";
                    break;
                case "-":
                    res.setText(Double.toString(temp1 - temp2));
                    operator = "";
                    break;
                case "*":
                    res.setText(Double.toString(temp1 * temp2));
                    operator = "";
                    break;
                case "/":
                    if (temp1 == 0) {
                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    } else {
                        res.setText(Double.toString(Math.round((temp1 / temp2) * 10000.0) / 10000.0));
                        operator = "";
                    }
                    break;
            }
        });
    }
    @Override
    public void onClick(View view) {
        if(res.getText().length()<=9){
            setresText(((TextView)view).getText());
        }
        else{
            Toast.makeText(this, "invalid input", Toast.LENGTH_SHORT).show();
        }
    }

    private void setresText(CharSequence text) {
            if (res.getText().toString().trim().equals("0")) {
                res.setText(text);

            } else {
                res.setText(String.format("%s%s",res.getText().toString().trim(), text));
            }
    }
}