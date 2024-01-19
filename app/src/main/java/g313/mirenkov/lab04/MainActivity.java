package g313.mirenkov.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    CheckBox[] products = new CheckBox[4];
    EditText[] amounts = new EditText[4];
    EditText[] prices = new EditText[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products[0] = findViewById(R.id.apples);
        products[1] = findViewById(R.id.strawberries);
        products[2] = findViewById(R.id.blueberries);
        products[3] = findViewById(R.id.potatoes);
        amounts[0] = findViewById(R.id.apples_amount);
        amounts[1] = findViewById(R.id.strawberries_amount);
        amounts[2] = findViewById(R.id.blueberries_amount);
        amounts[3] = findViewById(R.id.potatoes_amount);
        prices[0] = findViewById(R.id.apples_price);
        prices[1] = findViewById(R.id.strawberries_price);
        prices[2] = findViewById(R.id.blueberries_price);
        prices[3] = findViewById(R.id.potatoes_price);
    }

    @SuppressLint("DefaultLocale")
    public void on_calculate(View v){
        String text = "";
        try {
            double sum = 0.0;
            for(int i = 0; i < 4; i++)
            {
                if (!products[i].isChecked()) continue;
                int amount = Integer.parseInt(amounts[i].getText().toString());
                double price = Double.parseDouble(prices[i].getText().toString());
                if (price <= 0 || amount <= 0) throw new Exception();
                double semisum = amount * price;
                sum += amount * price;
                text = String.format("Step %d: %d x %s = %d x %.2f = %.2f\n",
                        i+1, amount, products[i].getText().toString(), amount, price, semisum);
                Toast.makeText(this, text, Toast.LENGTH_LONG).show();
            }
            text += String.format("Total sum: %.2f", sum);
        }
        catch(Exception e)
        {
            text = "Ошибка: Одно или несколько из введённых значений пустые или нулевые.";
        }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}