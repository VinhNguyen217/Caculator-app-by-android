package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnDelAll;
    private Button btnDelInTurn;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnMinus;
    private Button btnAdd;
    private Button btnDot;
    private Button btnDivise;
    private Button btnEqual;
    private Button btnZero;
    private Button btnMultiply;
    private TextView tvInput;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInit();
    }

    /**
     * Ánh xạ
     */
    public void getInit() {
        int[] idButton = {R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine, R.id.btnZero,
                R.id.btnAdd, R.id.btnMinus, R.id.btnDevise, R.id.btnMultiply, R.id.btnDelInTurn, R.id.btnDelAll, R.id.btnDot, R.id.btnEqual};
        for (int id : idButton) {
            View v = (View) findViewById(id);
            v.setOnClickListener(this);
        }
        tvInput = (TextView) findViewById(R.id.tvInput);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvInput.setOnClickListener(this);
        tvResult.setOnClickListener(this);
    }

    /**
     * Xét sự kiện
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOne:
                tvInput.append("1");
                Execute();
                break;
            case R.id.btnTwo:
                tvInput.append("2");
                Execute();
                break;
            case R.id.btnThree:
                tvInput.append("3");
                Execute();
                break;
            case R.id.btnFour:
                tvInput.append("4");
                Execute();
                break;
            case R.id.btnFive:
                tvInput.append("5");
                Execute();
                break;
            case R.id.btnSix:
                tvInput.append("6");
                Execute();
                break;
            case R.id.btnSeven:
                tvInput.append("7");
                Execute();
                break;
            case R.id.btnEight:
                tvInput.append("8");
                Execute();
                break;
            case R.id.btnNine:
                tvInput.append("9");
                Execute();
                break;
            case R.id.btnZero:
                tvInput.append("0");
                Execute();
                break;
            case R.id.btnAdd:
                if (isNumber(tvInput.getText().toString()))
                    tvInput.append("+");
                break;
            case R.id.btnMinus:
                if (isNumber(tvInput.getText().toString()))
                    tvInput.append("-");
                break;
            case R.id.btnMultiply:
                if (isNumber(tvInput.getText().toString()))
                    tvInput.append("*");
                break;
            case R.id.btnDevise:
                if (isNumber(tvInput.getText().toString()))
                    tvInput.append("/");
                break;
            case R.id.btnDot:
                if (isNumber(tvInput.getText().toString())) {
                    tvInput.append(".");
                }
                break;
            case R.id.btnDelAll:
                tvInput.setText("");
                tvResult.setText("");
                break;
            case R.id.btnDelInTurn:
                if (tvInput.getText().toString().length() > 0) {
                    String textBegin = tvInput.getText().toString();
                    String textAfterDel = textBegin.substring(0, textBegin.length() - 1);
                    tvInput.setText(textAfterDel);
                    Execute();
                }
                break;
            case R.id.btnEqual:
                tvInput.setText(tvResult.getText().toString());
                tvResult.setText("");
                break;
        }
    }

    /**
     * Thực hiện phép cộng
     *
     * @param s
     * @return
     */
    public String resultAddition(String s) {
        String[] array = s.split("\\+");
        float result = Float.parseFloat(array[0]) + Float.parseFloat(array[1]);
        String resultString = String.valueOf(result);
        if (resultString.charAt(resultString.length() - 1) == '0')
            return (String.valueOf((int) result));
        else return String.valueOf(result);
    }

    /**
     * Thực hành phép trừ
     *
     * @param s
     * @return
     */
    public String resultSubtraction(String s) {
        String[] array = s.split("-");
        float result = Float.parseFloat(array[0]) - Float.parseFloat(array[1]);
        String resultString = String.valueOf(result);
        if (resultString.charAt(resultString.length() - 1) == '0')
            return (String.valueOf((int) result));
        else return String.valueOf(result);
    }

    /**
     * Thực hành phép nhân
     *
     * @param s
     * @return
     */
    public String resultMultiply(String s) {
        String[] array = s.split("\\*");
        float result = Float.parseFloat(array[0]) * Float.parseFloat(array[1]);
        String resultString = String.valueOf(result);
        if (resultString.charAt(resultString.length() - 1) == '0')
            return (String.valueOf((int) result));
        else return String.valueOf(result);
    }

    /**
     * Thực hành phép chia
     *
     * @param s
     * @return
     */
    public String resultDevise(String s) {
        String[] array = s.split("/");
        float result = Float.parseFloat(array[0]) / Float.parseFloat(array[1]);
        String resultString = String.valueOf(result);
        if (resultString.charAt(resultString.length() - 1) == '0')
            return (String.valueOf((int) result));
        else return String.valueOf(result);
    }

    /**
     * Kiểm tra 1 chuỗi có phải chuỗi số hay không
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Thực thi và hiển thị kết quả trên màn hình
     */
    public void Execute() {
        String s = tvInput.getText().toString();
        if (isNumber(s)) {
            float x = Float.parseFloat(s);          //Remove zero after comma
            String resultString = String.valueOf(x);
            if (resultString.charAt(resultString.length() - 1) == '0')
                tvResult.setText(String.valueOf((int) x));
            else tvResult.setText(String.valueOf(x));
        } else if (s.matches("-?\\d+(\\.\\d+)?\\++-?\\d+(\\.\\d+)?"))
            tvResult.setText(resultAddition(s));
        else if (s.matches("-?\\d+(\\.\\d+)?-+-?\\d+(\\.\\d+)?"))
            tvResult.setText(resultSubtraction(s));
        else if (s.matches("-?\\d+(\\.\\d+)?\\*+-?\\d+(\\.\\d+)?"))
            tvResult.setText(resultMultiply(s));
        else if (s.matches("-?\\d+(\\.\\d+)?/+-?\\d+(\\.\\d+)?"))
            tvResult.setText(resultDevise(s));
        else if (s.equals(""))
            tvResult.setText("");
        else
            tvResult.setText("MATH ERROR");
    }
}