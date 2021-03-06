/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int noofcoffee = 0;
    TextView quantityTextView, priceTextView, priceTextViewS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        priceTextView = (TextView) findViewById(R.id.price_text_view);

    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        noofcoffee = 1 + noofcoffee;
        display(noofcoffee);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        noofcoffee = noofcoffee - 1;
        display(noofcoffee);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        Resources res = getResources();
        String priceMessage = res.getString(R.string.Output, noofcoffee*10);

        //String priceMessage = "Total: $" + (noofcoffee*10) + "\nThank You!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        //TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        //TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
       /** TextView textView = (TextView) findViewById(R.id.price_text_view);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon, 0, 0, 0);*/
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        //TextView priceTextViewS = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}