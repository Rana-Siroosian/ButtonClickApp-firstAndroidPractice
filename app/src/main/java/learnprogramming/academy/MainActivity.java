package learnprogramming.academy;
/**
 * @author >>RanaSiroosian<<
 */

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
        userInput.setText("");
        //make the textView scroll
        textView.setMovementMethod(new ScrollingMovementMethod());
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = userInput.getText().toString();
                result += "\n";
                textView.append(result);
                userInput.setText("");

            }
        };

        button.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");
    }

    //added the Override methods to learn more about how the life cycle works on Android Studio
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");

    }

    @Override
    protected void onStop() {
        //this method can be used to cancel the data transfer over the internet
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");

    }

    @Override
    protected void onPause() {
        //this method would be a good place to save any data that the user wants to keep permanently
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");

    }

    @Override
    protected void onPostResume() {
        Log.d(TAG, "onPostResume: in");
        super.onPostResume();
        Log.d(TAG, "onPostResume: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
        //we can use the code on lines 89&90 below to get the information or we can use the code
        //on line 91 to make it short
        //String savedString = savedInstanceState.getString(TEXT_CONTENTS);
        //textView.setText(savedString);
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: out");

    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");

    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: in");
        super.onDestroy();
        Log.d(TAG, "onDestroy: out");

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        //we use TEXT_CONTENTS to assign an area in android somewhere in the bundle
        //to save the information and we need to go to onRestore to grab the information
        //from there
        outState.putString(TEXT_CONTENTS, textView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }
}
