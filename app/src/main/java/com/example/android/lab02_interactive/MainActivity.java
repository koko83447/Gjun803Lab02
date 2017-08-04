package com.example.android.lab02_interactive;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int mQuantity = 0;
    private int mPrice = 5;
    private StringBuilder mTotalPriceMessage = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
//    public void submitOrder(View view){
//        displayTotalPrice();
//    }

    private void displayTotalPrice(){
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        int len = mTotalPriceMessage.length();
//        String myString = NumberFormat.getCurrencyInstance().format(total);
//        String message = myString + (mQuantity == 0?"\nFree" : "\nThank you");
//        priceTextView.setText(message);

        CheckBox checkBox = (CheckBox)findViewById(R.id.toppings_checkbox);
        boolean 是否要泡菜 = checkBox.isChecked();
        mTotalPriceMessage.delete(0, len);
        mTotalPriceMessage
                .append("客戶：")
                .append("孫悟空")
                .append("\n")
                .append("商品：")
                .append("臭豆腐")
                .append("\n")
                .append("是否要加泡菜？")
                .append(是否要泡菜)
                .append(mQuantity == 0?"\n免費試吃" :
                                "\n數量："+mQuantity+
                                "\n單價："+mPrice+
                                "\n總金額："+"NT$"+total+ "\n感謝購買");

        priceTextView.setText(mTotalPriceMessage);
    }

//    public void increment(View view) {
//        ++mQuantity;
//        displayQuantity();
//        resetTotalPrice();
//    }
//    public void decrement(View view) {
//        if (mQuantity > 0){
//            --mQuantity;
//            displayQuantity();
//        }
//        resetTotalPrice();
//    }

    private void resetTotalPrice() {
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText("");
    }
    private void displayQuantity(){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(mQuantity));
    }

//    public void clickToppings(View view) {
//        CheckBox checkBox = (CheckBox)findViewById(R.id.toppings_checkbox);
//
//        if (checkBox.isChecked()){
//            System.out.println("有勾");
//        }else {
//            System.out.println("沒有勾");
//        }
//    }

    public void myClick(View view) {
        System.out.println("click");
        int id = view.getId();
        switch (id){
            case R.id.toppings_checkbox:
//                clickToppings(view);
                CheckBox checkBox = (CheckBox)findViewById(R.id.toppings_checkbox);

                if (checkBox.isChecked()){
                    System.out.println("有勾");
                }else {
                    System.out.println("沒有勾");
                }
                break;
            case R.id.btn_inc:
//                increment(view);
                ++mQuantity;
                displayQuantity();
                resetTotalPrice();
                break;
            case R.id.btn_dec:
//                decrement(view);
                if (mQuantity > 0){
                    --mQuantity;
                    displayQuantity();
                }
                resetTotalPrice();
                break;
            case R.id.btn_order:
//                submitOrder(view);
                displayTotalPrice();
                break;
        }


    }
}
