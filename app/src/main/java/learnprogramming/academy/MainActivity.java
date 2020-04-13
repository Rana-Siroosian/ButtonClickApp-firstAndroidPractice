package learnprogramming.academy;
/**
 *
 * @author >>RanaSiroosian<<
 */

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button button;
    private TextView textView;
    private int numTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        //make the textView scroll
        textView.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numTimesClicked = numTimesClicked +1;
                String result = "The button got tapped " + numTimesClicked + " time";
                   if(numTimesClicked != 1){
                       result += "s";
                   }
                   result = result + "\n";
                    //append adds a line of text in our view
                    textView.append(result);



            }
        };

        button.setOnClickListener(ourOnClickListener);
    }
}
