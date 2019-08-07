package com.example.restaurantrecieve_r1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.restaurantrecieve_r1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        String[] itemName;
        String[] itemPrice;
        String[] itemQty;
        String[] cardInfo;

        String deliveryCharge;
        String orderTotal;
        String Total;
        String subtotal;
        String tax;
*/

        String[] viewNames = {"confirmMsg1"};
        int[] viewID = {0, 0, 0}; // List of names of created Views
        createViews(viewID);

        final TextView orderData = (TextView) findViewById((viewID[0]));
        orderData.setText(String.valueOf(viewID[0]));
        orderData.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        Button sendOrderBtn = (Button) findViewById((viewID[1]));

        final Bundle b = this.getIntent().getExtras();

        if( b != null )
        {
//        String[][] orderList =b.getStringArrayList("orderList");

            String[] itemName = b.getStringArray("itemName");

            String[] itemPrice = b.getStringArray("itemPrice");
            String[] itemQty = b.getStringArray("itemQty");
            String[] cardInfo = b.getStringArray("cardInfo");

            String deliveryCharge = b.getString("deliveryCharge");
            String orderTotal = b.getString("orderTotal");
            String Total = b.getString("Total");
            String subtotal = b.getString("subtotal");
            String tax = b.getString("tax");


            orderData.setText("");


            for (int i = 0; i < itemName.length; i++) {
                if (itemName[i] != null) {
                    orderData.append(itemName[i] + "  $" + itemPrice[i] + " Quantity: "
                            + itemQty[i] + " sub-total: $"
                            + (Float.valueOf(itemPrice[i]) * Float.valueOf(itemQty[i]))
                            + "\n");
                }
            }
            orderData.append("\n");
            orderData.append("Order Total: $" + orderTotal + "\n");
            orderData.append("Tax: $" + tax + "\n");
            orderData.append("Delivery Charge: $" + deliveryCharge + "\n");
            orderData.append("Total: $" + Total + "\n");
            orderData.append("\n" + "Card No:" + cardInfo[0] + "\n");
            orderData.append("Card Date: " + cardInfo[1] + "\n");
            orderData.append("Verify: " + cardInfo[2] + "\n");
        }
    }

    public void createViews(int[] viewID) {

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        // Create a TextView programmatically.
        TextView tv = new TextView(getApplicationContext());

        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
        lp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
//        tv.setX(100);
//        tv.setY(y + 50);


        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);
        // Set text to display in TextView
        tv.setText(" show me ");
        tv.setId(tv.generateViewId());
        viewID[0] = tv.getId();
        // tv.setText(Integer.valueOf(viewNames[0]));
        // Set a text color for TextView text
        tv.setTextColor(Color.parseColor("#000000"));
        // Add newly created TextView to parent view group (RelativeLayout)


        rl.addView(tv);

// rules for submit button
        RelativeLayout.LayoutParams rLParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rLParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 1);
        rLParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        Button senddata = new Button(getApplicationContext());
        senddata.setText("Order");
//        senddata.setId("select1());
        senddata.setId(tv.generateViewId());

        senddata.setId(senddata.generateViewId());
        viewID[1] = senddata.getId();
        //      Integer id3 = senddata.getId();
//        intArray[item.length][0] = id3;
//        slct.setText(id3.toString());
        //senddata.setX(x);
        //senddata.setY(y);
        rl.addView(senddata, rLParams);


    }

}

